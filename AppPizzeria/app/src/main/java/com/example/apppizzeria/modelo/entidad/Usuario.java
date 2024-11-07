package com.example.apppizzeria.modelo.entidad;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre;
    private String password;
    private String direccion;
    private  Pizza pizza;

    public Usuario(String direccion, String nombre, String password) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.password = password;
    }

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "direccion='" + direccion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", pizza=" + pizza +
                '}';
    }
}
