package com.example.crunchyandnetflix.Modelos;

import org.json.JSONArray;

public class Data {
    int id;
    String name,rating,imageMedium,imageOriginal, descripcion, status, fechaEstreno, fechaFinalizacion, mediaTiempo;
    String[] genres;

    public Data(int id, String name, String[] genres, String rating, String imageMedium, String imageOriginal, String descripcion, String status, String mediaTiempo, String fechaEstreno, String fechaFinalizacion) {
        this.id = id;
        this.name = name;
        this.genres = genres;
        this.rating = rating;
        this.imageMedium = imageMedium;
        this.imageOriginal = imageOriginal;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
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

    public String getMediaTiempo() {
        return mediaTiempo;
    }

    public void setMediaTiempo(String mediaTiempo) {
        this.mediaTiempo = mediaTiempo;
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
