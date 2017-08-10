package com.churchapp.ikon.ikonchurch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void SignUp(View view){
        UploadProf();

        Intent i = new Intent(Sign_up.this, ProfileTab.class);
        startActivity(i);
    }

    public void UploadProf(){

    }
}
