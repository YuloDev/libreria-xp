package org.example;


import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws LibroNoDisponible {
        ArrayList<Libro> carrito = new ArrayList<Libro>();
        List<Libro> libros = Libro.obtenerLibros();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    for (Libro libro : libros) {
                        System.out.println("Titulo:" + libro.getTitulo() + " Estado:" + libro.getEstadoLibro() + "\n");
                    }

                    break;
                case 2:
                    int contador = 1;

                    for (Libro libro : libros) {
                        System.out.println(contador + " Titulo:" + libro.getTitulo() + " Estado:" + libro.getEstadoLibro() + "\n");
                        contador += 1;
                    }
                    System.out.println("Seleccione una opción");
                    opcion = scanner.nextInt();
                    try {
                        Libro libro = libros.get(opcion);
                        libro.reservar();
                        libro.actualizarEstado(new Reservado());
                        libros.set(opcion, libro);
                        carrito.add(libro);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    int contador1 = 1;
                    for (Libro item : carrito) {
                        System.out.println( contador1 +" Titulo:" + item.getTitulo() + " Estado:" + item.getEstadoLibro() + "\n");
                    }
                    contador1+=1;
                    break;
                case 4:

                    int contador2 = 1;
                    for (Libro item : carrito) {
                        System.out.println( contador2 +" Titulo:" + item.getTitulo() + " Estado:" + item.getEstadoLibro() + "\n");
                    }
                    contador2+=1;
                    System.out.println("Seleccione una opción");
                    opcion = scanner.nextInt();
                    try {
                        Libro libro = libros.get(opcion);
                        libro.actualizarEstado(new Disponible());
                        for (int i = 0; i < libros.size() ; i++) {
                            if (libros.get(i) == libro){
                                libros.set(i, libro);
                            }
                        }

                        carrito.remove(libro);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    if (carrito.isEmpty()){
                        break;
                    }
                    break;
                case 5:
                    System.out.println("Gracias por utilizar el programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }

            System.out.println();

        } while (opcion != 5);

        scanner.close();
    }


    public static void mostrarMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1. Consultar libros");
        System.out.println("2. Solicitar libro");
        System.out.println("3. Renovar préstamo");
        System.out.println("4. Cancelar prestamo");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");

    }

}
