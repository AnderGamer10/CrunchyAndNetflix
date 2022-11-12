package com.example.crunchyandnetflix.Modelos;

public class SerieItem {

    Integer id;
    String serieName, imageUrl;
    String rating;

    public SerieItem(Integer id, String serieName, String imageUrl, String rating) {
        this.id = id;
        this.serieName = serieName;
        this.imageUrl = imageUrl;
        this.rating = rating;
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
}
