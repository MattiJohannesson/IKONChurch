package com.churchapp.ikon.ikonchurch;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.churchapp.ikon.ikonchurch.amazonaws.mobile.AWSConfiguration;
import com.churchapp.ikon.ikonchurch.amazonaws.models.nosql.VideosDO;
import com.amazonaws.regions.Region;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import java.net.URI;


public class MediaAdd extends Activity {

    CognitoCachingCredentialsProvider provider = new CognitoCachingCredentialsProvider( getApplicationContext(), "us-east-1:e717b72c-1df0-4190-a789-e0ce9881320e", Regions.US_EAST_1  );
    int PICK_VIDEO = 1;
    int PICK_IMAGE = 1;
    private int Position = 0;
    private MediaController mediaController;
    private ImageView VidThumb;
    EditText VideoURL;
    private String _description, _title, _tags, _Videolink, _thumbLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_add);
        VidThumb = (ImageView) findViewById(R.id.imageViewVidThumbnail);
        VideoURL = (EditText) findViewById( R.id.editTextVideoUrl);

    }

    public void ShowVid(View view){

    }

    public void AddThumbnail(View view){
        Intent intent = new Intent();
        intent.setType("Image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent.createChooser(intent, "Select Thumbnail"), PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) return;
        if (null == data) return;
        Uri originalUri = null;

        if (requestCode == PICK_IMAGE){
            originalUri = data.getData();
            VidThumb.setImageURI(originalUri);
        }
    }

    public void Submit(){
        AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(provider.getCredentials());
        ddbClient.setRegion(Region.getRegion(AWSConfiguration.AMAZON_DYNAMODB_REGION));

        VideosDO viddb = new VideosDO();
        viddb.setUserId(provider.getCachedIdentityId());
        viddb.setDescription(_description);
        viddb.setTags(_tags);
        viddb.setTitle(_title);
        viddb.setVideoLink(_Videolink);
        viddb.setThumbnailLink(_thumbLink);
    }

}
