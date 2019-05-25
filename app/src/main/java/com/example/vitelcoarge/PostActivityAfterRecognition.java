package com.example.vitelcoarge;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
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

import static com.example.vitelcoarge.Model.GetRecognitionResponseModel.attributesValue;
import static com.example.vitelcoarge.Model.GetRecognitionResponseModel.getAttributesName;
import static com.example.vitelcoarge.Model.GetRecognitionResponseModel.getProductName;

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
        horizontalScrollAttributesType.setVisibility(View.INVISIBLE);

        attributesName.setVisibility(View.INVISIBLE);

        item1=findViewById(R.id.item1);
        item1.setVisibility(View.INVISIBLE);
        item2=findViewById(R.id.item2);
        item2.setVisibility(View.INVISIBLE);
        item3=findViewById(R.id.item3);
        item3.setVisibility(View.INVISIBLE);
        item4=findViewById(R.id.item4);
        item4.setVisibility(View.INVISIBLE);



       item1.setText(GetRecognitionResponseModel.getAttributesName().get(0));
       item1.setVisibility(View.VISIBLE);
 //      item2.setText(getProductName().get(1));
     //  item2.setVisibility(View.VISIBLE);
     //  item3.setText(getProductName().get(2));
     //  item3.setVisibility(View.VISIBLE);



/*        Button myButton = new Button(this);
        myButton.setText("Push Me");

        ConstraintLayout ll = (ConstraintLayout)findViewById(R.id.post_activity);
        ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        ll.addView(myButton, lp);
*/



    }

    public void postApi(View view) {
    }

    @SuppressLint("SetTextI18n")
    public void selectedItem1(View view) {
        horizontalScrollAttributesType.setVisibility(View.VISIBLE);
        attributesName.setVisibility(View.VISIBLE);
        attributesName.setText(getAttributesName().get(0)+": ");
        radioItem1.setText(attributesValue.get(0));
        radioItem2.setText(attributesValue.get(1));
        radioItem3.setText(attributesValue.get(2));
        radioItem4.setVisibility(View.INVISIBLE);
        item1.setBackgroundColor(Color.parseColor("#5D96F3"));

       // radioItem1.setText(GetRecognitionResponseModel.attributesValue.get(0));

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
}
