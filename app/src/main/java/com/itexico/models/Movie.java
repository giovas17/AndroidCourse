package com.itexico.models;

/**
 * Created by darkgeat on 10/03/2017.
 */

public class Movie {
    private int id;
    private String title;
    private String poster;

    public Movie(int id, String title, String poster) {
        this.id = id;
        this.title = title;
        this.poster = poster;
    }

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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
