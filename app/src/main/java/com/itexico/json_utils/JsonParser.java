package com.itexico.json_utils;

import android.content.Context;

import com.itexico.androidcourse.R;
import com.itexico.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by darkgeat on 10/03/2017.
 */

public class JsonParser {

    public static ArrayList<Movie> getMovies(Context context, String JSONStr){
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(JSONStr);
            JSONArray arrayMovies = object.getJSONArray(context.getString(R.string.results_json_param));
            for (int i = 0 ; i < arrayMovies.length() ; i++){
                JSONObject movieObject = arrayMovies.getJSONObject(i);
                int id = movieObject.getInt(context.getString(R.string.id_json_param));
                String title = movieObject.getString(context.getString(R.string.title_json_param));
                String poster = movieObject.getString(context.getString(R.string.poster_path_json_param));
                poster = context.getString(R.string.base_path_image_url) + "w185/" + poster;
                Movie movie = new Movie(id,title,poster);
                movies.add(movie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
