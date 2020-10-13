package com.coursera.petagrambit;

public class Mascota {



    private int id;
    private int urlImage;
    private String isFav;
    private String nombre;
    private int likes;

    public Mascota() {

    }
    public Mascota(int urlImage, String isFav, String nombre, int likes) {
        this.urlImage = urlImage;
        this.isFav = isFav;
        this.nombre = nombre;
        this.likes = likes;
    }

    public int getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(int urlImage) {
        this.urlImage = urlImage;
    }

    public String getFav() {
        return isFav;
    }

    public void setFav(String fav) {
        isFav = fav;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
