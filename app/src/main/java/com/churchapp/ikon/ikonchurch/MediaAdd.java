package com.churchapp.ikon.ikonchurch;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.SyncStateContract.Constants;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MediaAdd extends Activity {

    VideoView Preach;
    private int Position = 0;
    private MediaController mediaController;
    EditText VideoURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_add);
        Preach = (VideoView) findViewById(R.id.videoViewPreach);

        // Set the media controller buttons
        if (mediaController == null) {
            mediaController = new MediaController(MediaAdd.this);

            // Set the videoView that acts as the anchor for the MediaController.
            mediaController.setAnchorView(Preach);


            // Set MediaController for VideoView
            Preach.setMediaController(mediaController);
        }


        try {
            // ID of video file.
            int id = this.getRawResIdByName("Respawn Inbox! - Happy Memory Day feat. Deanna Russo.mp4");
            Preach.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
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

    // Find ID corresponding to the name of the resource (in the directory raw).
    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
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
