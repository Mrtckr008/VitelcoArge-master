package com.example.vitelcoarge;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.vitelcoarge.Model.GetRecognitionResponseModel;
import com.example.vitelcoarge.Model.ImageModel;
import com.example.vitelcoarge.Volley.PostImageRecognitionActivity;

import java.io.IOException;

import static com.example.vitelcoarge.Model.GetRecognitionResponseModel.attributesValue;
import static com.example.vitelcoarge.Model.GetRecognitionResponseModel.getAttributesName;
import static com.example.vitelcoarge.Model.GetRecognitionResponseModel.getProductName;
import static com.example.vitelcoarge.Model.GetRecognitionResponseModel.productId;
import static com.example.vitelcoarge.Model.GetRecognitionResponseModel.productName;

public class PostActivityAfterRecognition extends AppCompatActivity {

    Button item1,item2,item3,item4;
    RadioButton radioItem1,radioItem2,radioItem3,radioItem4;
    HorizontalScrollView horizontalScrollAttributesName,horizontalScrollAttributesType;
    ImageView imageCapture;
    TextView attributesName;

   @SuppressLint("ResourceType")
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        imageCapture=findViewById(R.id.imageView5);

        imageCapture.setImageBitmap(ImageModel.getImageBitmap());
        attributesName=findViewById(R.id.attributesName);
        radioItem1=findViewById(R.id.radioItem1);
        radioItem2=findViewById(R.id.radioItem2);
        radioItem3=findViewById(R.id.radioItem3);
        radioItem4=findViewById(R.id.radioItem4);

        horizontalScrollAttributesName=findViewById(R.id.horizontalScrollView3);
     // horizontalScrollAttributes.setVisibility(View.INVISIBLE);


        horizontalScrollAttributesType=findViewById(R.id.horizontalScrollView4);
        //horizontalScrollAttributesType.setVisibility(View.INVISIBLE);

        attributesName.setVisibility(View.INVISIBLE);

        item1=findViewById(R.id.item1);
        item1.setVisibility(View.INVISIBLE);
        item2=findViewById(R.id.item2);
        item2.setVisibility(View.INVISIBLE);
        item3=findViewById(R.id.item3);
        item3.setVisibility(View.INVISIBLE);
        item4=findViewById(R.id.item4);
        item4.setVisibility(View.INVISIBLE);


        if(productName.size()==1){
            item1.setText(GetRecognitionResponseModel.getProductName().get(0));
            item1.setVisibility(View.VISIBLE);
        }
        else if(productName.size()==2){
            item1.setText(GetRecognitionResponseModel.getProductName().get(0));
            item1.setVisibility(View.VISIBLE);
            item2.setText(GetRecognitionResponseModel.getProductName().get(1));
            item2.setVisibility(View.VISIBLE);
        }
       else if(productName.size()==3){
            item1.setText(GetRecognitionResponseModel.getProductName().get(0));
            item1.setVisibility(View.VISIBLE);
            item2.setText(GetRecognitionResponseModel.getProductName().get(1));
            item2.setVisibility(View.VISIBLE);
            item3.setText(GetRecognitionResponseModel.getProductName().get(2));
            item3.setVisibility(View.VISIBLE);
       }
       else if(productName.size()==4){
           item1.setText(GetRecognitionResponseModel.getProductName().get(0));
           item1.setVisibility(View.VISIBLE);
           item2.setText(GetRecognitionResponseModel.getProductName().get(1));
           item2.setVisibility(View.VISIBLE);
           item3.setText(GetRecognitionResponseModel.getProductName().get(2));
           item3.setVisibility(View.VISIBLE);
           item4.setText(GetRecognitionResponseModel.getProductName().get(3));
           item4.setVisibility(View.VISIBLE);
       }
       else{}

       if(getAttributesName().size()==1){
           radioItem1.setText(attributesValue.get(0));
           radioItem2.setVisibility(View.INVISIBLE);
           radioItem3.setVisibility(View.INVISIBLE);
           radioItem4.setVisibility(View.INVISIBLE);
       }
       else if(getAttributesName().size()==2){
           radioItem1.setText(attributesValue.get(0));
           radioItem2.setText(attributesValue.get(1));
           radioItem3.setVisibility(View.INVISIBLE);
           radioItem4.setVisibility(View.INVISIBLE);
       }
       else if(getAttributesName().size()==3){
           radioItem1.setText(attributesValue.get(0));
           radioItem2.setText(attributesValue.get(1));
           radioItem3.setText(attributesValue.get(2));
           radioItem4.setVisibility(View.INVISIBLE);
       }
       else if(getAttributesName().size()==4){
           radioItem1.setText(attributesValue.get(0));
           radioItem2.setText(attributesValue.get(1));
           radioItem3.setText(attributesValue.get(2));
           radioItem4.setText(attributesValue.get(3));
       }



      // item3.setText(GetRecognitionResponseModel.getAttributesName().get(2));
      // item3.setVisibility(View.VISIBLE);

       horizontalScrollAttributesType.setVisibility(View.VISIBLE);
       attributesName.setVisibility(View.VISIBLE);
      // attributesName.setText(getAttributesName().get(0)+": ");
       radioItem1.setText(attributesValue.get(0));

       radioItem2.setText(attributesValue.get(1));
       radioItem3.setVisibility(View.INVISIBLE);
       radioItem4.setVisibility(View.INVISIBLE);
       item1.setBackgroundColor(Color.parseColor("#5D96F3"));
       item1.setSelected(true);
       radioItem1.setChecked(true);




    }

    public void postApi(View view) {

    }

    @SuppressLint("SetTextI18n")
    public void selectedItem1(View view) {



    }

    public void selectedItem2(View view) {
        horizontalScrollAttributesType.setVisibility(View.VISIBLE);
    }

    public void selectedItem3(View view) {
        horizontalScrollAttributesType.setVisibility(View.VISIBLE);
    }

    public void selectedItem4(View view) {
        horizontalScrollAttributesType.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                //  resim seçildiğinde yapılacaklar
                Bitmap bitmapFromCamera = (Bitmap) data.getExtras().get("data");
                Intent intentFromCamera =new Intent(this, PostImageRecognitionActivity.class);
                ImageModel.setImageBitmap(bitmapFromCamera);
                startActivity(intentFromCamera);
                finish();
            }
        }
        if(requestCode==200){
            if(resultCode==RESULT_OK) {
                Uri pickedImage = data.getData();
                // Let's read picked image path using content resolver
                try {
                    Bitmap bitmapFromPicked = MediaStore.Images.Media.getBitmap(this.getContentResolver(), pickedImage);
                    Log.i("Bitmap on pick:", bitmapFromPicked.toString());
                    ImageModel.setImageBitmap(bitmapFromPicked);
                    Intent intentFromGallery = new Intent(this, PostImageRecognitionActivity.class);
                    startActivity(intentFromGallery);
                    finish();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void useGallery(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 200);
    }

    public void takePicture(View view) {
        if (checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            System.out.println();
        }
        else{
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 100);
        }}
}
