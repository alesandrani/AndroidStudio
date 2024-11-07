package com.example.apppizzeria.modelo.entidad;

import java.io.Serializable;
import java.util.List;

public class Pizza implements Serializable {
    private String tamano;
    private List<String> ingredientes;
    private double precio;

    public Pizza(List<String> ingredientes, double precio, String tamano) {
        this.ingredientes = ingredientes;
        this.precio = precio;
        this.tamano = tamano;
    }

    public Pizza(double precio) {
        this.precio = precio;
    }



    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "ingredientes=" + ingredientes +
                ", tamano='" + tamano + '\'' +
                ", precio=" + precio +
                '}';
    }


    }

