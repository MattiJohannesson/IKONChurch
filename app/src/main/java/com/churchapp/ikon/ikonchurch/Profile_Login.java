package com.churchapp.ikon.ikonchurch;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class Profile_Login extends Activity {

    String username, password;
    public static boolean Logdedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_login);

        username = findViewById(R.id.Username_editText).toString();
        password = findViewById(R.id.Password_editText).toString();
    }



    public boolean Correct(){
        return true;
    }

    public void SignUp(View view){
        Intent i = null;
        switch (view.getId()){
            case R.id.SignUp_button:
                i = new Intent(Profile_Login.this, Sign_up.class);
                startActivity(i);
                break;

            case R.id.Login_button:
                if (Correct())
                    i = new Intent( Profile_Login.this, ProfileTab.class );
                startActivity( i );
                break;

//            case R.id.imageButtnconnect:
//                i = new Intent( Profile_Login.this, Connect.class );
//                startActivity( i );
//                break;
//
//            case R.id.imageButtnGiving:
//                i = new Intent( Profile_Login.this, Giving.class );
//                startActivity( i );
//                break;

            case R.id.imageButtnhome:
                i = new Intent( Profile_Login.this, Home.class );
                startActivity( i );
                break;

            case R.id.imageButtnProfile:
                i = new Intent( Profile_Login.this, ProfileTab.class );
                startActivity( i );
                break;

            case R.id.ImageBttnMedia:
                i = new Intent(Profile_Login.this, MediaTab.class);
                startActivity(i);
                break;
        }
    }

}
