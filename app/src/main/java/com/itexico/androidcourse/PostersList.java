package com.itexico.androidcourse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ListView;

import com.itexico.adapters.MoviesAdapter;
import com.itexico.interfaces.NetworkResponseListener;
import com.itexico.json_utils.JsonParser;
import com.itexico.models.Movie;
import com.itexico.network.NetworkConnection;

import java.util.ArrayList;

/**
 * Created by darkgeat on 10/03/2017.
 */

public class PostersList extends AppCompatActivity implements NetworkResponseListener{

    private GridView list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poster_list);

        list = (GridView) findViewById(R.id.listMovies);

        NetworkConnection connection = new NetworkConnection(this,this);
        connection.execute();
    }

    @Override
    public void OnSuccessfullyResponse(String response) {
        ArrayList<Movie> movies = JsonParser.getMovies(this,response);
        MoviesAdapter adapter = new MoviesAdapter(this,movies);
        list.setAdapter(adapter);
    }

    @Override
    public void OnFailedResponse() {

    }
}
