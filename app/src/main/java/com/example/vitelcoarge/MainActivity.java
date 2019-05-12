package com.example.vitelcoarge;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.vitelcoarge.Volley.PostImageRecognitionActivity;

public class MainActivity extends AppCompatActivity {
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            ConstraintLayout constraintLayout = findViewById(R.id.main_layout);
            Snackbar.make(constraintLayout, "Please grant the permission for the camera.", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Grant Permission!", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            requestPermissions(new String[]{Manifest.permission.CAMERA},
                                              MY_CAMERA_REQUEST_CODE);
                        }
                    } )
                    .show();
        }
    }
    public void openCamera(View view) {
        if (checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            System.out.println();
        }
        else{
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 100);
    }}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
              //  resim seçildiğinde yapılacaklar
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                Intent intent =new Intent(this, PostImageRecognitionActivity.class);
                intent.putExtra("captureImage",photo);
                startActivity(intent);
                finish();
            }
        }
    }
}
