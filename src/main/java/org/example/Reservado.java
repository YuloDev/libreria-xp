package org.example;

public class Reservado implements EstadoLibro {
    @Override
    public void reservar() {
        System.out.println("Libro no disponible");
    }
}
