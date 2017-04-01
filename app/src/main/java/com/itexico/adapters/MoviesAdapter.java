package com.itexico.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.itexico.androidcourse.R;
import com.itexico.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>{
    private Context c;
    private ArrayList<Movie> movies;

    public MoviesAdapter(Context c, ArrayList<Movie> movies){
        this.c=c;
        this.movies=movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.item_movie,parent,false);
        ViewHolder holder = new ViewHolder(view);
        view.setTag(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(c).load(movies.get(position).getPosterPath()).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        final ImageView image;

        public ViewHolder(View v){
            super(v);
            image = (ImageView) v.findViewById(R.id.imageMoviePoster);

        }
    }
}
