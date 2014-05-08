package com.mik9999.myapplication2.app;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by mik9999 on 2014-05-08.
 */
public class AsyncRequest extends AsyncTask<String, Void, String> {
    private OnTaskCompleted listener;

    public AsyncRequest(OnTaskCompleted a){
        this.listener = a;
    }

    @Override
    protected String doInBackground(String... urls) {
        try {
            HttpClient Client = new DefaultHttpClient();
                        HttpGet get = new HttpGet("http://google.pl");
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            return Client.execute(get, responseHandler);
        }catch (Exception ex){
           return ex.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String o){
        listener.onTaskCompleted(o);
    }
}
