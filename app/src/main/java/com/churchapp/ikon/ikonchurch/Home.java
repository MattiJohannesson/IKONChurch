package com.churchapp.ikon.ikonchurch;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void ChangeActivity(View view){
        Intent i = null;
        switch (view.getId()){
            case R.id.ImageBttnMedia:
                i = new Intent(Home.this, MediaTab.class);
                startActivity(i);
                break;

            case R.id.ImageButtonProfile:
                i = new Intent( Home.this, ProfileTab.class );
                startActivity( i );
                break;
        }
    }
}
