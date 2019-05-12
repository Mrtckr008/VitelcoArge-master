package com.example.vitelcoarge.Volley;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.example.vitelcoarge.MainActivity;
import com.example.vitelcoarge.Model.GetTokenResponseModel;
import com.example.vitelcoarge.Model.LoginModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class PostTokenActivity extends AppCompatActivity implements IPostApi {
public static JSONObject responseStaticApi;
public String token;
GetTokenResponseModel getResponseModel=new GetTokenResponseModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PostTokenVolley();
    }

    @Override
    public void PostTokenVolley() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final JSONObject jsonBodyObj = new JSONObject();
        String url = "http://imagereconginitonwebapi-dev.us-west-2.elasticbeanstalk.com/api/v1/Token/GetToken";
        try{
            jsonBodyObj.put("username", LoginModel.getUsername());
            jsonBodyObj.put("password",LoginModel.getPassword());
        }catch (JSONException e){
            e.printStackTrace();
        }
        final String requestBody = jsonBodyObj.toString();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                url, null, new Response.Listener<JSONObject>(){
            @Override    public void onResponse(JSONObject response) {
                Log.i("Response",String.valueOf(response));
                responseStaticApi=response;

                ResponseTokenJsonParse responseJsonParse=new ResponseTokenJsonParse(String.valueOf(responseStaticApi));

         //       Log.i("son: ",responseJsonParse.getToken());
                token=responseJsonParse.getToken();

                    Intent intent=new Intent(PostTokenActivity.this, LocalDatabase.class);
                intent.putExtra("tokenValue",token);
                startActivity(intent);
                finish();
            }
        }, new Response.ErrorListener() {
            @Override    public void onErrorResponse(VolleyError error) {
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
        }){
            @Override    public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
            @Override    public byte[] getBody() {
                try
                {
                    return requestBody == null ? null : requestBody.getBytes("utf-8");
                }
                catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s",
                            requestBody, "utf-8");
                    return null;
                }
            }
        };
        requestQueue.add(jsonObjectRequest);
        return;
    }

    @Override
    public void saveToken(String token) {
             SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.vitelcoarge.LoginController", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("token",getResponseModel.getToken()).apply();
        editor.commit();

        Log.i("get calisiyor",token);//token null geliyor!

        Intent intent =new Intent(PostTokenActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
