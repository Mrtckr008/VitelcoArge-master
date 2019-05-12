package com.example.vitelcoarge.Volley;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.vitelcoarge.Local.LocalDatabase;
import com.example.vitelcoarge.Model.GetTokenResponseModel;
import com.example.vitelcoarge.Model.ImageModel;
import com.example.vitelcoarge.PostActivityAfterRecognition;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


@SuppressLint("Registered")
public class PostImageRecognitionActivity extends AppCompatActivity {
    public static JSONObject responseRecognition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PostImageVolley();
    }


    public void PostImageVolley() {
        Bitmap bitmap;
        Intent intent = getIntent();
        bitmap = (Bitmap) intent.getParcelableExtra("captureImage");
        ImageModel imageModel=new ImageModel();
        ImageModel.setImageBitmap(bitmap);
        Log.e("Set edildi..","..");

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final JSONObject jsonBodyObj = new JSONObject();
        String url = "http://imagereconginitonwebapi-dev.us-west-2.elasticbeanstalk.com/api/v1/Product/FindProduct";
        final String requestBody = jsonBodyObj.toString();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("Response", String.valueOf(response));

                responseRecognition=response;

                ResponseRecognitionJsonParse responseRecognitionJsonParse= new ResponseRecognitionJsonParse(String.valueOf(responseRecognition));

                Log.i("Response: ",responseRecognitionJsonParse.listOfAttributesId.get(0).toString());



                Intent intent=new Intent(PostImageRecognitionActivity.this, PostActivityAfterRecognition.class);
            //    intent.putExtra("reponseRecognition",response.toString());
                startActivity(intent);
                finish();

                //  Log.i("Responsee",bitmap.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse response = error.networkResponse;
                if (error instanceof ServerError && response != null) {
                    try {
                        String res = new String(response.data,
                                HttpHeaderParser.parseCharset(response.headers, "utf-8"));
                        JSONObject obj = new JSONObject(res);
                    } catch (UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Bearer "+ GetTokenResponseModel.getToken());
                return headers;
            }

            @Override
            public byte[] getBody() {
                try {
                    return requestBody == null ? null : requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s",
                            requestBody, "utf-8");
                    return null;
                }
            }
        };
        requestQueue.add(jsonObjectRequest);
        return;
    }
}