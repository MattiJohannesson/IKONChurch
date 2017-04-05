package com.churchapp.ikon.ikonchurch;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MediaTab extends Activity {

    boolean isVisable;
    LinearLayout OptBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_tab);

        OptBar = (LinearLayout) findViewById(R.id.LinearLayoutOptionsBar);
        if (OptBar.getVisibility() == View.VISIBLE){
            isVisable = false;
            OptBar.setVisibility(View.INVISIBLE);
        }
        else{
            isVisable = true;
        }
    }

    public void OptionBar(View view){
        if (!isVisable){
        OptBar.setVisibility(View.VISIBLE);
            isVisable = true;
    }
    else{
            OptBar.setVisibility(View.INVISIBLE);
            isVisable = false;
        }
    }

    public void AddPreach(View view){
            if (view.getId() == R.id.buttonAddNewPreach){
                Intent i = new Intent(MediaTab.this, MediaAdd.class);
                startActivity(i);
            }
            else {
                return;
            }
    }

    public void AddSermon(View view){
        if (view.getId() == R.id.buttonAddNewSermon){
            Intent i = new Intent(MediaTab.this, Media_AddSeries.class);
            startActivity(i);
        }
        else{
            return;
        }
    }

}
