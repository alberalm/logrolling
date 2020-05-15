package com.logrolling.client.web;

import android.renderscript.ScriptGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.logrolling.client.data.Settings;
import com.logrolling.client.exceptions.RequestException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class WebServiceClient {



    public String formCompleteURL(String relativeURL) {
        return Settings.getBaseURL() + relativeURL;
    }

    public <InputObject> void request(
            int method,
            String relativeURL,
            InputObject input,
            final ResponseListener responseListener,
            final String authenticationToken,
            final ErrorListener errorListener
    ) {

        String jsonString = null;
        if(input != null) {
            GsonBuilder builder = new GsonBuilder();
            builder.serializeNulls();
            Gson gson = builder.create();

            jsonString = gson.toJson(input);
        }

        final String responseBody = jsonString;

        StringRequest request = new StringRequest(
                method,
                formCompleteURL(relativeURL),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String str) {
                        if(responseListener != null) {
                            responseListener.onResponse(str);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (errorListener != null) {
                            errorListener.onError(new RequestException(error));
                        }
                    }
                }){

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {

                    //Set header params
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("User-Agent", "Logrolling");
                    params.put("Content-Type", "application/json");

                    if(authenticationToken != null) {
                        params.put("token", authenticationToken);
                    }

                    return params;
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        if(responseBody == null) {
                            return new byte[]{};
                        } else {
                            return responseBody.getBytes("utf-8");
                        }
                    } catch (UnsupportedEncodingException e) {
                        VolleyLog.wtf("Unsopported encoding exception when sending request");
                        return null;
                    }
                }

        };
        WebRequestQueue.getInstance().addToRequestQueue(request);
    }

     public <InputObject> void getRequest(
            String relativeURL,
            InputObject input,
            final ResponseListener responseListener,
            final String authenticationToken,
            final ErrorListener errorListener
    ) {
        request(Request.Method.GET, relativeURL, input, responseListener, authenticationToken, errorListener);
     }

     public <InputObject> void postRequest(
            String relativeURL,
            InputObject input,
            final ResponseListener responseListener,
            final String authenticationToken,
            final ErrorListener errorListener
    ) {
        request(Request.Method.POST, relativeURL, input, responseListener, authenticationToken, errorListener);
     }

     public <InputObject> void deleteRequest(
            String relativeURL,
            InputObject input,
            final ResponseListener responseListener,
            final String authenticationToken,
            final ErrorListener errorListener
    ) {
        request(Request.Method.DELETE, relativeURL, input, responseListener, authenticationToken, errorListener);
     }

     public <InputObject> void putRequest(
            String relativeURL,
            InputObject input,
            final ResponseListener responseListener,
            final String authenticationToken,
            final ErrorListener errorListener
    ) {
        request(Request.Method.PUT, relativeURL, input, responseListener, authenticationToken, errorListener);
     }

}
