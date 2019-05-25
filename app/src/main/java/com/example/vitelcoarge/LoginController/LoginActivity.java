package com.example.vitelcoarge.LoginController;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vitelcoarge.MainActivity;
import com.example.vitelcoarge.Model.LoginModel;
import com.example.vitelcoarge.R;
import com.example.vitelcoarge.UI.LoginActivityUI;
import com.example.vitelcoarge.Volley.PostTokenActivity;

@SuppressWarnings("ALL")
public class LoginActivity extends AppCompatActivity {
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    EditText name,password;
    public Boolean connectionStatus;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name= findViewById(R.id.username);
        password=findViewById(R.id.password);
        button=LoginActivityUI.LogInButton;

        if (checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA},
                    MY_CAMERA_REQUEST_CODE);
        }


      //  Log.e("Connection status is",connectionStatus.toString());

            //Intent intent=new Intent(Settings.ACTION_WIRELESS_SETTINGS);
            //startActivity(intent);
            //finish();
        new CountDownTimer(100000,10000){
            @Override
            public void onTick(long millisUntilFinished) {
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                connectivityManager.getActiveNetworkInfo();

                NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
                connectionStatus=isOnline();
                if(connectionStatus==false){
                    ConstraintLayout constraintLayout = findViewById(R.id.login_layout);
                    Snackbar.make(constraintLayout, "Trying to connect...", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Check connection settings.", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent=new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                                    startActivity(intent);
                                }
                            } )
                            .show();
                }


            }

            @Override
            public void onFinish() {

            }
        }.start();





      checkUserActive();
    }



    public void checkUserActive(){

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String tokenValue= preferences.getString("savedToken", "-1");

        if(!tokenValue.equals("-1")){
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            connectivityManager.getActiveNetworkInfo();

            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            connectionStatus=isOnline();
            if(connectionStatus==false){
                new AlertDialog.Builder(this)
                        .setTitle("Connection Problem")
                        .setMessage("Want to check your internet connection?")

                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void logIn(View view) {


        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        connectivityManager.getActiveNetworkInfo();

        new CountDownTimer(100000,10000){
            @Override
            public void onTick(long millisUntilFinished) {
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                connectivityManager.getActiveNetworkInfo();

                NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
                connectionStatus=isOnline();
                if(connectionStatus==false){
                    ConstraintLayout constraintLayout = findViewById(R.id.login_layout);
                    Snackbar.make(constraintLayout, "Trying to connect...", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Check connection settings.", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent=new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                                    startActivity(intent);
                                }
                            } )
                            .show();
                }


            }

            @Override
            public void onFinish() {

            }
        }.start();




        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        connectionStatus=isOnline();
        if(connectionStatus==false){
            new AlertDialog.Builder(this)
                    .setTitle("Connection Problem")
                    .setMessage("Want to check your internet connection?")

                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent=new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("No", null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }

        else{
        if(name.getText().toString().equals("root-sa")&&password.getText().toString().equals("123")){

            Intent intent = new Intent(getApplicationContext(), PostTokenActivity.class);
            LoginModel.setUsername(name.getText().toString());
            LoginModel.setPassword(password.getText().toString());

            startActivity(intent);
            finish();
        }
        else if(!name.getText().toString().equals("root-sa")||!password.getText().toString().equals("123")){
            Toast.makeText(getApplicationContext(), Html.fromHtml("<b>Please check your user information!</b>"), Toast.LENGTH_LONG).show();
        }
    }}

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
