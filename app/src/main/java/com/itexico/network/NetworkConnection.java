package com.itexico.network;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.itexico.androidcourse.R;
import com.itexico.interfaces.NetworkResponseListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by darkgeat on 10/03/2017.
 */

public class NetworkConnection extends AsyncTask<Void,Void,Boolean> {

    private final String NETWORK_TAG = NetworkConnection.class.getSimpleName();
    private String responseJsonStr;
    private Context context;
    private NetworkResponseListener listener;

    public NetworkConnection(Context context, NetworkResponseListener listener){
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        Uri requestURL = null;
        final String BASE_URL = "http://api.themoviedb.org/3";
        final String MOVIE_PATH = "movie";
        final String POPULAR_PATH = "popular";
        final String API_KEY_PARAM = "api_key";

        //Construction of the URL
        requestURL = Uri.parse(BASE_URL).buildUpon()
                .appendPath(MOVIE_PATH)
                .appendPath(POPULAR_PATH)
                .appendQueryParameter(API_KEY_PARAM,context.getString(R.string.api_key_value))
                .build();
        Log.d(NETWORK_TAG,requestURL.toString());

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        try {
            //Final URL for request
            URL url = new URL(requestURL.toString());

            //Setting parameters to my connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            //Read the input stream into String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null){
                return false; //Nothing to do.
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null){
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0){
                return false; //Has no lines. String is empty
            }

            responseJsonStr = buffer.toString();
            Log.d(NETWORK_TAG, "Server Response: " + responseJsonStr);
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e(NETWORK_TAG,e.toString());
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(NETWORK_TAG,e.toString());
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (result){
            //I have information
            if (listener != null){
                listener.OnSuccessfullyResponse(responseJsonStr);
            }
        }else {
            //Something was wrong.
            if (listener != null){
                listener.OnFailedResponse();
            }
        }
    }
}
