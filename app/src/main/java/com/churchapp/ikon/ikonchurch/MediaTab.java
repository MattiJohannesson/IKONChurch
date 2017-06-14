package com.churchapp.ikon.ikonchurch;

import android.app.Activity;
import android.content.Intent;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.s3.AmazonS3Client;
import com.churchapp.ikon.ikonchurch.Media_AddSeries;
import com.churchapp.ikon.ikonchurch.amazonaws.mobile.content.TransferHelper;
import com.churchapp.ikon.ikonchurch.amazonaws.models.nosql.SermonDB;
import com.churchapp.ikon.ikonchurch.amazonaws.models.nosql.VideosDO;
import java.io.*;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

import static android.os.FileObserver.CREATE;
import static com.churchapp.ikon.ikonchurch.amazonaws.mobile.AWSConfiguration.AMAZON_COGNITO_IDENTITY_POOL_ID;

public class MediaTab extends Activity {

    int APPLICATION_CONTEXT = 1;
    boolean isVisable;
    LinearLayout OptBar;
    ArrayAdapter<Sermon> SermonAdapter;
    ListView SermonListView;
    Media_AddSeries SeriesAdd;
    SermonDB SDB = new SermonDB();
    CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider( getApplicationContext(), "us-east-1:e717b72c-1df0-4190-a789-e0ce9881320e", Regions.US_EAST_1 );
    AmazonDynamoDBClient DBClient =new AmazonDynamoDBClient( credentialsProvider );
    AmazonS3Client S3Client = new AmazonS3Client( credentialsProvider );
    DynamoDBMapper mapper = new DynamoDBMapper( DBClient );
    TransferUtility transferUtility = new TransferUtility( S3Client, getApplicationContext());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_media_tab );

        SeriesAdd = new Media_AddSeries();
        SermonListView = (ListView) findViewById( R.id.ListViewSermon );

        OptBar = (LinearLayout) findViewById( R.id.LinearLayoutOptionsBar );
        if (OptBar.getVisibility() == View.VISIBLE) {
            isVisable = false;
            OptBar.setVisibility( View.INVISIBLE );
        } else {
            isVisable = true;
        }

        Thread myThread = new Thread( runnable );
        myThread.start();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i<15;i++){
                if (i < SDB.gettotalItems()){
                    LoadSermon(i+"");
                }
            }
        }
    };

    public void LoadSermon(String sermonID){
        SermonDB SermonSelect = mapper.load(SermonDB.class, sermonID);
        File file = null;
        TransferObserver observer =transferUtility.download("ikonapp-data", SermonSelect.getThumbId(),file);
        ImageView image = null;
        Bitmap bm = BitmapFactory.decodeFile( file.getAbsolutePath() );
        image.setImageBitmap( bm );
        Sermon sermon = new Sermon(SermonSelect.getId(),image,SermonSelect.getTitle(),SermonSelect.getDescription(),SermonSelect.getHex());
    }

    public void OptionBar(View view) {
        if (!isVisable) {
            OptBar.setVisibility( View.VISIBLE );
            isVisable = true;
        } else {
            OptBar.setVisibility( View.INVISIBLE );
            isVisable = false;
        }
    }

    public void AddPreach(View view) {
        if (view.getId() == R.id.buttonAddNewPreach) {
            Intent i = new Intent( MediaTab.this, MediaAdd.class );
            startActivity( i );
        } else {
            return;
        }
    }

    public void AddSermon(View view) {
        if (view.getId() == R.id.buttonAddNewSermon) {
            Intent i = new Intent( MediaTab.this, Media_AddSeries.class );
            startActivity( i );
        } else {
            return;
        }
    }

}
