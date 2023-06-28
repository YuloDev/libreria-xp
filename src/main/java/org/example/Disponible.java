package org.example;

public class Disponible implements EstadoLibro {
    @Override
    public void reservar() {
        System.out.println("Libro reservado");
    }
}
