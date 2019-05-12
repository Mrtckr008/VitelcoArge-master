package com.example.vitelcoarge.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.example.vitelcoarge.LoginController.LoginActivity;
import com.example.vitelcoarge.LoginController.LoginControlActivity;
import com.example.vitelcoarge.R;

public class SplashActivity extends Activity {

    private static int gosterim_suresi = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);

                finish();
            }
        }, gosterim_suresi);
    }
}