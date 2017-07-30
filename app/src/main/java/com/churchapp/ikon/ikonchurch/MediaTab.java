package com.churchapp.ikon.ikonchurch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.document.Table;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.services.s3.AmazonS3Client;
import com.churchapp.ikon.ikonchurch.amazonaws.models.nosql.SermonDB;

import java.io.*;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MediaTab extends Activity {

    boolean isVisable;
    LinearLayout OptBar;
    ArrayAdapter<Sermon> SermonAdapter;
    ListView SermonListView;
    Media_AddSeries SeriesAdd;
    SermonDB SDB = new SermonDB();
    CognitoCachingCredentialsProvider credentialsProvider;
    AmazonDynamoDBClient DBClient;
    AmazonS3Client S3Client ;
    DynamoDBMapper mapper;
    TransferUtility transferUtility;
    TableDescription tableDescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_media_tab );
        credentialsProvider = new CognitoCachingCredentialsProvider(
                getApplicationContext(),
                "us-east-1:e717b72c-1df0-4190-a789-e0ce9881320e", // Identity Pool ID
                Regions.US_EAST_1 // Region
        );

        DBClient =new AmazonDynamoDBClient( credentialsProvider);
        S3Client = new AmazonS3Client( credentialsProvider );
        mapper = new DynamoDBMapper( DBClient );
        transferUtility = new TransferUtility( S3Client, getApplicationContext());

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
            TableDescription tableDescription = DBClient.describeTable("ikonapp-mobilehub-1505785601-Sermons").getTable();

            for (int i = 1; i<15;i++){
                if (i < tableDescription.getItemCount().intValue()){
                    LoadSermon(i +"");
                }
                else return;
            }
        }
    };


    public void LoadSermon(String sermonID){
        SermonDB SermonSelect = mapper.load(SermonDB.class, sermonID);
        File file = null;
        TransferObserver observer = transferUtility.download("ikonapp-data", SermonSelect.getThumbId(),file);
        ImageView image = null;
        Bitmap bm = BitmapFactory.decodeFile( file.getAbsolutePath() );
        image.setImageBitmap( bm );
        Sermon sermon = new Sermon(SermonSelect.getId(),image,SermonSelect.getSermonTitle(),SermonSelect.getDescription(),SermonSelect.getHex());
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
