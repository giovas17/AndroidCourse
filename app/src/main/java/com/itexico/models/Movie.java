package com.itexico.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable{
    private int id;
    private String title,description,posterPath;


    public Movie(int id, String title, String description, String posterPath) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.posterPath = posterPath;
    }

    protected Movie(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        posterPath = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(posterPath);
    }
}
