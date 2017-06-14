package com.churchapp.ikon.ikonchurch;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.media.audiofx.AudioEffect;
import android.net.Uri;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.churchapp.ikon.ikonchurch.HexConverter;
import com.churchapp.ikon.ikonchurch.amazonaws.mobile.AWSConfiguration;
import com.churchapp.ikon.ikonchurch.amazonaws.models.nosql.SermonDB;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Media_AddSeries extends Activity {

    CognitoCachingCredentialsProvider provider =  new CognitoCachingCredentialsProvider( getApplicationContext(), "us-east-1:e717b72c-1df0-4190-a789-e0ce9881320e", Regions.US_EAST_1 );
    AmazonS3 S3 = new AmazonS3Client( provider );
    TransferUtility transferUtility = new TransferUtility( S3, getApplicationContext() );
    private HexConverter Hex;
    private static final int PICK_IMAGE = 1;
    public ImageView Thumbnail;
    public EditText Title, Description;
    private String ID;
    public Uri ThumbUri;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media__add_series);

        Thumbnail = (ImageView) findViewById(R.id.imageViewThumbnail);
        Title = (EditText) findViewById(R.id.editTextSermonTitle);
        
//      Description = (EditText) findViewById(R.id.editTextSermonDescription);
    }

    public void AddImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent.createChooser(intent, "Select Thumbnail"), PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) return;
        if (null == data) return;
        Uri originalUri = null;
        if (requestCode == PICK_IMAGE) {
            originalUri = data.getData();
        }

        Thumbnail.setImageURI(originalUri);
    }

    public void AddSermon(){
        AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(provider.getCredentials() );
        ddbClient.setRegion( Region.getRegion( AWSConfiguration.AMAZON_DYNAMODB_REGION ) );

        SermonDB sdb = new SermonDB();
        sdb.setTitle( Title.toString() );
        sdb.setDescription( Description.toString() );
        sdb.setHex( Hex.FromDECtoHEX( sdb.gettotalItems()+ 1 ) );
        sdb.setThumbId( Hex.FromDECtoHEX( sdb.gettotalItems() + 1 ) );

        TransferObserver observer = transferUtility.upload("ikonapp-data",sdb.getThumbId(), );
    }

    public void submit(View view){
        AddSermon();
    }
}

