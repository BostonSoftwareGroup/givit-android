package app.com.example.android.givit_android.utils;

import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtils {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static void doGetRequest(HttpUrl url, Map<String, String> headers, Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request.Builder requestBuilder = new Request.Builder().url(url);
        addHeaders(requestBuilder, headers);
        Request request = requestBuilder.build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void doPostRequest(HttpUrl url, Map<String, String> headers, String jsonBody, Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, jsonBody);
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .post(body);
        addHeaders(requestBuilder, headers);
        Request request = requestBuilder.build();
        Log.v("Http Request", request.toString());
        Log.v("Http Request", request.header("Authentication"));
        //Gson gson = new Gson();
        //String json = gson.
        Log.v("Http Request",request.body().toString());
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    private static void addHeaders(Request.Builder requestBuilder, Map<String, String> headers){
        for(Map.Entry<String, String> header : headers.entrySet()){
            requestBuilder.addHeader(header.getKey(),header.getValue());
        }
    }
}
