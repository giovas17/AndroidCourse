package com.itexico.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itexico.androidcourse.R;
import com.itexico.interfaces.NetworkConnectionInterface;
import com.itexico.models.Movie;
import com.itexico.network.NetworkConnection;
import com.squareup.picasso.Picasso;

/**
 * Created by darkgeat on 01/04/2017.
 */

public class Detail extends Fragment{

    private final String TAG = Detail.class.getSimpleName();
    private Movie pelicula;
    private NetworkConnection connection;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pelicula = getActivity().getIntent().getParcelableExtra("PeliculaSeleccionada");
        connection = new NetworkConnection(getContext(), new NetworkConnectionInterface() {
            @Override
            public void OnSuccessfullyResponse(String response) {
                //TODO: que parcear los datos de esta llamada y mandar a llamar a los reviews
                connection = new NetworkConnection(getContext(),new NetworkConnectionInterface(){
                    @Override
                    public void OnSuccessfullyResponse(String response) {
                        //TODO:Leer y parsear datos de la segunda llamada.
                        updateUI();
                    }

                    @Override
                    public void OnFailedResponse() {

                    }
                });
                connection.execute(getString(R.string.endpoint_reviews,String.valueOf(pelicula.getId())));
            }

            @Override
            public void OnFailedResponse() {

            }
        });
        connection.execute(getString(R.string.endpoint_videos,String.valueOf(pelicula.getId())));
    }

    private void updateUI() {
        //TODO:la actualizacion de la UI conforme a lo que se lea de las llamadas
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewDetail = inflater.inflate(R.layout.fragment_detail,container,false);
        Log.d(TAG,"Nombre de la Pelicula:" + pelicula.getTitle());

        TextView title = (TextView) viewDetail.findViewById(R.id.titleMovie);
        ImageView image = (ImageView) viewDetail.findViewById(R.id.posterMovie);

        title.setText(pelicula.getTitle());
        Picasso.with(getContext())
                .load(pelicula.getPosterPath())
                .into(image);

        return  viewDetail;
    }
}
