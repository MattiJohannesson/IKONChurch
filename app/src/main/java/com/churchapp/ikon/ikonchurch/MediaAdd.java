package com.churchapp.ikon.ikonchurch;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.churchapp.ikon.ikonchurch.amazonaws.mobile.AWSConfiguration;
import com.churchapp.ikon.ikonchurch.amazonaws.models.nosql.VideosDO;
import com.amazonaws.regions.Region;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class MediaAdd extends Activity {

    int PICK_VIDEO = 1;
    int PICK_IMAGE = 1;
    VideoView Preach;
    private int Position = 0;
    private MediaController mediaController;
    private ImageView VidThumb;
    EditText VideoURL;
    private String _description, _title, _tags, _Videolink, _thumbLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_add);
        Preach = (VideoView) findViewById(R.id.videoViewPreach);
        VidThumb = (ImageView) findViewById(R.id.imageViewVidThumbnail);

        // Set the media controller buttons
        if (mediaController == null) {
            mediaController = new MediaController(MediaAdd.this);

            // Set the videoView that acts as the anchor for the MediaController.
            mediaController.setAnchorView(Preach);

            // Set MediaController for VideoView
            Preach.setMediaController(mediaController);
        }

        Preach.requestFocus();


        // When the video file ready for playback.
        Preach.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {


                Preach.seekTo(Position);
                if (Position == 0) {
                    Preach.start();
                }

                // When video Screen change size.
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        // Re-Set the videoView that acts as the anchor for the MediaController
                        mediaController.setAnchorView(Preach);
                    }
                });
            }
        });

    }

    public void ShowVid(View view){
        Preach.setVideoPath(VideoURL.getText().toString());
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

    public void Submit(String title, String Description, String tags, String videoLink, String thumbLink, CognitoCachingCredentialsProvider provider){
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

    // When you change direction of phone, this method will be called.
    // It store the state of video (Current position)
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // Store current position.
        savedInstanceState.putInt("CurrentPosition", Preach.getCurrentPosition());
        Preach.pause();
    }


    // After rotating the phone. This method is called.
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Get saved position.
        Position = savedInstanceState.getInt("CurrentPosition");
        Preach.seekTo(Position);
    }
}
