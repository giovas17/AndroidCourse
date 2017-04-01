package com.itexico.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itexico.adapters.MoviesAdapter;
import com.itexico.androidcourse.R;
import com.itexico.interfaces.NetworkConnectionInterface;
import com.itexico.json_utils.JsonParser;
import com.itexico.models.Movie;
import com.itexico.network.NetworkConnection;

import java.util.ArrayList;

/**
 * Created by darkgeat on 01/04/2017.
 */

public class Main extends Fragment implements NetworkConnectionInterface{

    private RecyclerView lista;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewFragment = inflater.inflate(R.layout.fragment_main,container,false);
        lista = (RecyclerView) viewFragment.findViewById(R.id.listaPeliculas);

        lista.setLayoutManager(new GridLayoutManager(getContext(),2));
        lista.setHasFixedSize(true);

        NetworkConnection connection = new NetworkConnection(getContext(), this);
        connection.execute("popular");
        return viewFragment;
    }

    @Override
    public void OnSuccessfullyResponse(String response) {
        ArrayList<Movie> peliculas = JsonParser.getMovies(getContext(),response);
        MoviesAdapter adapter = new MoviesAdapter(getContext(),peliculas);
        lista.setAdapter(adapter);
    }

    @Override
    public void OnFailedResponse() {

    }
}
