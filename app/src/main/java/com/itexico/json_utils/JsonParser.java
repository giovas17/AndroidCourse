package com.itexico.json_utils;

import android.content.Context;

import com.itexico.androidcourse.R;
import com.itexico.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {

    public static ArrayList<Movie> getMovies(Context context, String JSONStr){
        ArrayList<Movie> pelis = new ArrayList<>();

        try {
            JSONObject objetoPrincipal = new JSONObject(JSONStr);
            JSONArray arregloDePeliculas = objetoPrincipal.getJSONArray(context.getString(R.string.results_json_param));

            for (int i = 0; i<arregloDePeliculas.length();i++){
                JSONObject pelicula = arregloDePeliculas.getJSONObject(i);
                int id = pelicula.getInt(context.getString(R.string.id_json_param));
                String titulo = pelicula.getString(context.getString(R.string.title_json_param));
                String posterPath = pelicula.getString(context.getString(R.string.poster_path_json_param));
                posterPath = context.getString(R.string.base_path_image_url)+context.getString(R.string.image_size_default)+"/"+posterPath;

                Movie movie = new Movie(id,titulo,"",posterPath);
                pelis.add(movie);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return pelis;
    }




}
