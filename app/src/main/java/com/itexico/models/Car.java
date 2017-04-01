package com.itexico.models;

/**
 * Created by darkgeat on 09/03/2017.
 */

public class Car {
    private int image;
    private String title;
    private String description;

    public Car(){
        image = 0;
        title = "";
        description = "";
    }

    public Car(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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
}
