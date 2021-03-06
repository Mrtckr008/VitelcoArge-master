package com.example.vitelcoarge.Volley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.Toast;

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
import com.example.vitelcoarge.Model.LoginModel;
import com.example.vitelcoarge.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class PostSubmitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postSubmitVolley();
    }

    public void postSubmitVolley() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final JSONObject jsonBodyObj = new JSONObject();
        String url = "http://imagereconginitonwebapi-dev.us-west-2.elasticbeanstalk.com/api/v1/Token/GetToken";
        try{
            jsonBodyObj.put("ProductId", 2);
            jsonBodyObj.put("Cost",0);
            jsonBodyObj.put("SerialNumber","ABXDGFR");
            jsonBodyObj.put("AttributeId",4);
        }catch (JSONException e){
            e.printStackTrace();
        }
        final String requestBody = jsonBodyObj.toString();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                url, null, new Response.Listener<JSONObject>(){
            @Override    public void onResponse(JSONObject response) {
                Log.i("Response",String.valueOf(response));


              ResponseSubmitProductJsonParse responseSubmitProductJsonParse=new ResponseSubmitProductJsonParse(response.toString());

                      Log.i("son: ",response.toString());

                Toast.makeText(getApplicationContext(), Html.fromHtml("<b>Submit is successful!</b>"), Toast.LENGTH_LONG).show();





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
}
