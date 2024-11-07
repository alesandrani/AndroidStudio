package com.example.apppizzeria.modelo.negocio;

import com.example.apppizzeria.modelo.entidad.Pizza;

import java.util.List;

public class GestorPizza {

    public Pizza crearPizza(String tamano, List<String> ingredientes) {
        double precio = calcularPrecio(tamano, ingredientes);
        return new Pizza(ingredientes, precio, tamano);
    }

    private double calcularPrecio(String tamano, List<String> ingredientes) {
        double precioBase;

        switch (tamano.toLowerCase()) {
            case "pequeña":
                precioBase = 10.00;
                break;
            case "mediana":
                precioBase = 15.00;
                break;
            case "grande":
                precioBase = 20.00;
                break;
            default:
                precioBase = 15.00; // Por defecto, mediana

            }

        double precioIngredientes = ingredientes.size() * 1.00;
        return precioBase + precioIngredientes;
        }



    }