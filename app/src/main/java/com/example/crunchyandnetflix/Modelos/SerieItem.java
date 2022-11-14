package com.example.crunchyandnetflix.Modelos;

import org.json.JSONArray;

public class SerieItem {

    int id;
    String serieName, imageUrl,descripcion, status, fechaEstreno, fechaFinalizacion, mediaTiempo;
    String rating;
    String[] genres;

    public SerieItem(int id, String serieName, String imageUrl, String rating, String[] genres,String descripcion, String status, String mediaTiempo, String fechaEstreno, String fechaFinalizacion) {
        this.id = id;
        this.serieName = serieName;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.genres = genres;
        this.descripcion = descripcion;
        this.status = status;
        this.mediaTiempo = mediaTiempo;
        this.fechaEstreno = fechaEstreno;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getMediaTiempo() {
        return mediaTiempo;
    }

    public void setMediaTiempo(String mediaTiempo) {
        this.mediaTiempo = mediaTiempo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
}
