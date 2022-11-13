package com.example.crunchyandnetflix.Modelos;

import org.json.JSONArray;

public class SerieItem {

    Integer id;
    String serieName, imageUrl;
    String rating;
    String[] genres;

    public SerieItem(Integer id, String serieName, String imageUrl, String rating, String[] genres) {
        this.id = id;
        this.serieName = serieName;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.genres = genres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerieName() {
        return serieName;
    }

    public void setSerieName(String serieName) {
        this.serieName = serieName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }
}
