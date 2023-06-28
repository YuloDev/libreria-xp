package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConfig {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Cargar la configuración desde el archivo hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();

            // Crear la fábrica de sesiones
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            // Manejar cualquier excepción de inicialización
            System.err.println("Error al inicializar la fábrica de sesiones de Hibernate: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
