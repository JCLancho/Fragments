package com.example.fragments;

public class Carrera {

    private String edicion;
    private int cartel;

    public Carrera(String edicion, int cartel) {
        this.edicion = edicion;
        this.cartel = cartel;
    }

    public String getEdicion() {
        return edicion;
    }

    public int getCartel() {
        return cartel;
    }


}