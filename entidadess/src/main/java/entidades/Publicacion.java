/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDateTime;

/**
 *
 * @author diana
 */
public class Publicacion {
    
    private int id;
    private String contenido;
    private LocalDateTime fechaPublicacion;
    private long autor;

    /**
     * Constructor vacío.
     * Permite crear una instancia de Publicacion sin inicializar atributos.
     */
    public Publicacion() {
    }

     /**
     * Constructor con parámetros.
     * @param id Identificador único de la publicación.
     * @param contenido Texto o contenido de la publicación.
     * @param fechaPublicacion Fecha y hora en que se realizó la publicación.
     * @param autor Usuario que creó la publicación.
     */
    public Publicacion(int id, String contenido, LocalDateTime fechaPublicacion, long autor) {
        this.id = id;
        this.contenido = contenido;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public long getAutor() {
        return autor;
    }

    public void setAutor(long autor) {
        this.autor = autor;
    }

    /**
     * Método toString.
     * Retorna una representación en texto de los atributos de la publicación.
     * @return 
     */
    @Override
    public String toString() {
        return "Publicacion{" + "id=" + id + ", contenido=" + contenido + ", fechaPublicacion=" + fechaPublicacion + ", autor=" + autor + '}';
    }
    
    
}
