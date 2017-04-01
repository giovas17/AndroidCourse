package com.itexico.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.itexico.androidcourse.R;
import com.itexico.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by darkgeat on 10/03/2017.
 */

public class MoviesAdapter extends ArrayAdapter<Movie> {

    private ArrayList<Movie> data;
    private Context context;

    public MoviesAdapter(@NonNull Context context, ArrayList<Movie> movies) {
        super(context, R.layout.item_movie,movies);
        data = movies;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View viewParent = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);

        ImageView imagePoster = (ImageView)viewParent.findViewById(R.id.imageMovieItem);
        Picasso.with(context).load(data.get(position).getPoster()).into(imagePoster);

        return viewParent;
    }
}
