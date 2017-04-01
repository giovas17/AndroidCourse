package com.itexico.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.itexico.androidcourse.Detail;
import com.itexico.androidcourse.R;
import com.itexico.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Movie> movies;

    public MoviesAdapter(Context c, ArrayList<Movie> movies){
        this.context=c;
        this.movies=movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);
        ViewHolder holder = new ViewHolder(view);
        view.setTag(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Picasso.with(context).load(movies.get(position).getPosterPath()).into(holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Detail.class);
                intent.putExtra("PeliculaSeleccionada",movies.get(position));
                context.startActivity(intent);
            }
        });

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
