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
}
