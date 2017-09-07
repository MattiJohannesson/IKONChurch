package com.churchapp.ikon.ikonchurch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Connect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_connect );
    }

    public void Change(View view){
        Intent i = null;
        switch (view.getId()){
            case R.id.imageButtnProfile:
                if (Profile_Login.Logdedin){
                    i = new Intent( Connect.this, ProfileTab.class);
                    startActivity(i);
                }

                else {
                    i= new Intent(Connect.this, Profile_Login.class);
                    startActivity(i);
                }
                break;

            case R.id.imageButtnconnect:
                i = new Intent( Connect.this, Connect.class );
                startActivity( i );
                break;

            case R.id.imageButtnGiving:
                i = new Intent( Connect.this, Giving.class );
                startActivity( i );
                break;

            case R.id.imageButtnhome:
                i = new Intent( Connect.this, Home.class );
                startActivity( i );
                break;

            case R.id.ImageBttnMedia:
                i = new Intent(Connect.this, MediaTab.class);
                startActivity(i);
                break;
        }
    }
}
