package com.itexico.androidcourse;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.itexico.adapters.MoviesAdapter;
import com.itexico.interfaces.NetworkConnectionInterface;
import com.itexico.json_utils.JsonParser;
import com.itexico.models.Movie;
import com.itexico.network.NetworkConnection;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NetworkConnectionInterface {
    private final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (RecyclerView) findViewById(R.id.listaPeliculas);

        lista.setLayoutManager(new GridLayoutManager(this,2));
        lista.setHasFixedSize(true);

        NetworkConnection connection = new NetworkConnection(this, this);
        connection.execute();


    }

    @Override
    public void OnSuccessfullyResponse(String response) {
        ArrayList<Movie> peliculas = JsonParser.getMovies(this,response);
        MoviesAdapter adapter = new MoviesAdapter(this,peliculas);
        lista.setAdapter(adapter);
    }

    @Override
    public void OnFailedResponse() {

    }
}
