package com.churchapp.ikon.ikonchurch;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.churchapp.ikon.ikonchurch.Profile_Login;

public class Home extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void Change(View view){
        Intent i = null;
        switch (view.getId()){
            case R.id.ImageBttnProfile:
                if (Profile_Login.Logdedin){
                    i = new Intent( Home.this, ProfileTab.class);
                    startActivity(i);
                }

                else {
                    i= new Intent(Home.this, Profile_Login.class);
                    startActivity(i);
                }
                break;

            case R.id.imageButtnconnect:
                i = new Intent( Home.this, Connect.class );
                startActivity( i );
                break;

            case R.id.imageButtnGiving:
                i = new Intent( Home.this, Giving.class );
                startActivity( i );
                break;

            case R.id.imageButtnhome:
                i = new Intent( Home.this, Home.class );
                startActivity( i );
                break;

            case R.id.ImageBttnMedia:
                i = new Intent(Home.this, MediaTab.class);
                startActivity(i);
                break;
        }
    }
}
