package com.churchapp.ikon.ikonchurch;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.util.TimeUnit;
import android.media.Image;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;

public class ProfileTab extends Activity {

    int NextBttn =0;
    ImageView ImChanger;
    List<RadioButton> bttns= new ArrayList<RadioButton>(  );
    RadioButton Bttn1,Bttn2,Bttn3,Bttn4,Bttn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_profile_tab );

        SetVariables();
        ImageController();

        if (true){
            try {
                java.util.concurrent.TimeUnit.SECONDS.sleep(5);
                Log.e( "Sleep", "I'm asleep" );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public void ImageController(){
        if (true){

       if (NextBttn !=5) {
            NextBttn++;
        }
        else {
           NextBttn = 1;
       }

       LoadNext(NextBttn);
            try {
                java.util.concurrent.TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void LoadNext(int i) {
        Bitmap bm;
        BttnsOff( i );

        switch (i) {
                case 1:
                    bm = BitmapFactory.decodeFile( "res/drawable/im1" );
                    ImChanger.setImageBitmap( bm );
                    break;

                case 2:
                    bm = BitmapFactory.decodeFile( "res/drawable/im2" );
                    ImChanger.setImageBitmap( bm );
                    break;

                case 3:
                     bm = BitmapFactory.decodeFile( "res/drawable/im3" );
                    ImChanger.setImageBitmap( bm );
                    break;

                case 4:
                    bm = BitmapFactory.decodeFile( "res/drawable/im4" );
                    ImChanger.setImageBitmap( bm );
                    break;

                case 5:
                    bm = BitmapFactory.decodeFile( "res/drawable/im5" );
                    ImChanger.setImageBitmap( bm );
                    break;
            }

    }

    public void BttnsOff(int _bttnnum){
        for (int i =1;i<bttns.size();i++){
            RadioButton Temp = bttns.get( i );
            if (i != _bttnnum){
            Temp.setChecked( false );
            }
            else{
                Temp.setChecked( true );
            }
        }

    }

    public void SetVariables(){
        ImChanger = (ImageView) findViewById( R.id.imageviewChanger);
        bttns.add( 0,Bttn1 = (RadioButton)findViewById( R.id.radioButtonMovImage1 ) );
        bttns.add( 1,Bttn2 = (RadioButton)findViewById( R.id.radioButtonMovImage2 ) );
        bttns.add( 2,Bttn3 = (RadioButton)findViewById( R.id.radioButtonMovImage3 ) );
        bttns.add( 3,Bttn4 = (RadioButton)findViewById( R.id.radioButtonMovImage4 ) );
        bttns.add( 4,Bttn5 = (RadioButton)findViewById( R.id.radioButtonMovImage5 ) );
    }

    public void Change(View view){
        Intent i = null;
        switch (view.getId()){
            case R.id.ImageButtonProfile:
                if (Profile_Login.Logdedin){
                    i = new Intent( ProfileTab.this, ProfileTab.class);
                    startActivity(i);
                }

                else {
                    i= new Intent(ProfileTab.this, Profile_Login.class);
                    startActivity(i);
                }
                break;

            case R.id.imageButtnconnect:
                i = new Intent( ProfileTab.this, Connect.class );
                startActivity( i );
                break;

            case R.id.imageButtnhome:
                i = new Intent( ProfileTab.this, Home.class );
                startActivity( i );
                break;

            case R.id.imageButtnGiving:
                i = new Intent( ProfileTab.this, Giving.class );
                startActivity( i );
                break;

            case R.id.ImageBttnMedia:
                i = new Intent(ProfileTab.this, MediaTab.class);
                startActivity(i);
                break;
        }
    }
}
