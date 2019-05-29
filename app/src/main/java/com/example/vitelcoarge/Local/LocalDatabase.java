package com.example.vitelcoarge.Local;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.vitelcoarge.LoginController.LoginActivity;
import com.example.vitelcoarge.Model.GetTokenResponseModel;

public class LocalDatabase extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        String tokenValue = extras.getString("tokenValue");

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("savedToken", tokenValue).apply();
        editor.commit();

        Log.i("savedTokenn:", tokenValue);

        Intent intent = new Intent(LocalDatabase.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


}
