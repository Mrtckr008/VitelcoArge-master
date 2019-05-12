package com.example.vitelcoarge.UI;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.vitelcoarge.R;

@SuppressLint("Registered")
public class LoginActivityUI extends AppCompatActivity {

    private static final int MY_CAMERA_REQUEST_CODE = 100;
    @SuppressLint("StaticFieldLeak")
    static public EditText name,password;
    @SuppressLint("StaticFieldLeak")
    static public Button LogInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = findViewById(R.id.username);
        password = findViewById(R.id.password);
        LogInButton=findViewById(R.id.email_sign_in_button);
    }
}
