package org.example;

public class Ocupado implements EstadoLibro {
    @Override
    public void reservar() {
        System.out.println("Libro no disponible");
    }
}
