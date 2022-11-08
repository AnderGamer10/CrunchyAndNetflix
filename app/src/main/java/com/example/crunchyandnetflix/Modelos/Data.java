package com.example.crunchyandnetflix.Modelos;

import org.json.JSONArray;

public class Data {
    int id;
    String name;
    JSONArray genres;
    String rating;
    String imageMedium;
    String imageOriginal;
    String descripcion;

    public Data(int id, String name, JSONArray genres, String rating, String imageMedium, String imageOriginal, String descripcion) {
        this.id = id;
        this.name = name;
        this.genres = genres;
        this.rating = rating;
        this.imageMedium = imageMedium;
        this.imageOriginal = imageOriginal;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JSONArray getGenres() {
        return genres;
    }

    public void setGenres(JSONArray genres) {
        this.genres = genres;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImageMedium() {
        return imageMedium;
    }

    public void setImageMedium(String imageMedium) {
        this.imageMedium = imageMedium;
    }

    public String getImageOriginal() {
        return imageOriginal;
    }

    public void setImageOriginal(String imageOriginal) {
        this.imageOriginal = imageOriginal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
