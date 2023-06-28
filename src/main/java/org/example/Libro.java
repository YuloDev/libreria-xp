package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Libro {
    private String titulo;
    private String catalogo;
    private String autor;
    private int id;
    private EstadoLibro estadoLibro;
    private static SessionFactory sessionFactory = DbConfig.getSessionFactory();
    ;


    public Libro() {
        this.estadoLibro = new Disponible();
    }

    public Libro(String titulo) {
        this.titulo = titulo;
        this.estadoLibro = new Disponible();
    }

    public void actualizarEstado(EstadoLibro nuevoEstado) {
        this.estadoLibro = nuevoEstado;
    }

    public void reservar() throws LibroNoDisponible {
        if (estadoLibro instanceof Reservado) {
            throw new LibroNoDisponible("No se puede reservar un libro ya reservado");
        }
        if (estadoLibro instanceof Ocupado) {
            throw new LibroNoDisponible("No se puede reservar un libro ocupado");
        }
        estadoLibro.reservar();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EstadoLibro getEstadoLibro() {
        return estadoLibro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Libro that = (Libro) o;

        if (id != that.id) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (catalogo != null ? !catalogo.equals(that.catalogo) : that.catalogo != null) return false;
        if (autor != null ? !autor.equals(that.autor) : that.autor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = titulo != null ? titulo.hashCode() : 0;
        result = 31 * result + (catalogo != null ? catalogo.hashCode() : 0);
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    public static List<Libro> obtenerLibros() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Libro ";
            return session.createQuery(hql, Libro.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", catalogo='" + catalogo + '\'' +
                ", autor='" + autor + '\'' +
                ", estadoLibro=" + estadoLibro +
                '}';
    }
}
