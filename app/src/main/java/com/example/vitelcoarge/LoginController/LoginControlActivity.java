package com.example.vitelcoarge.LoginController;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.vitelcoarge.MainActivity;
import com.example.vitelcoarge.Volley.PostTokenActivity;

public class LoginControlActivity extends AppCompatActivity {
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    EditText name,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkUserActive();
    }


    public void checkUserActive(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String tokenValue= preferences.getString("savedToken", "-1");

        if(tokenValue.equals("-1")){
            Intent intent = new Intent(getApplicationContext(), PostTokenActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

}



