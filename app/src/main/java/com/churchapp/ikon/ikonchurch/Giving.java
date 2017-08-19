package com.churchapp.ikon.ikonchurch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Giving extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_giving );
    }

    public void Change(View view){
        Intent i = null;
        switch (view.getId()){
            case R.id.ImageButtonProfile:
                if (Profile_Login.Logdedin){
                    i = new Intent( Giving.this, ProfileTab.class);
                    startActivity(i);
                }

                else {
                    i= new Intent(Giving.this, Profile_Login.class);
                    startActivity(i);
                }
                break;

            case R.id.imageButtnconnect:
                i = new Intent( Giving.this, Connect.class );
                startActivity( i );
                break;

            case R.id.imageButtnhome:
                i = new Intent( Giving.this, Home.class );
                startActivity( i );
                break;

            case R.id.imageButtnGiving:
                i = new Intent( Giving.this, Giving.class );
                startActivity( i );
                break;

            case R.id.imageButtnProfile:
                i = new Intent( Giving.this, ProfileTab.class );
                startActivity( i );
                break;

            case R.id.ImageBttnMedia:
                i = new Intent(Giving.this, MediaTab.class);
                startActivity(i);
                break;
        }
    }
}
