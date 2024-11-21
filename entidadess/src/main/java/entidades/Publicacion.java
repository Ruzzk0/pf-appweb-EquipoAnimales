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
    private Usuario autor;

    public Publicacion() {
    }

    public Publicacion(int id, String contenido, LocalDateTime fechaPublicacion, Usuario autor) {
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

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Publicacion{" + "id=" + id + ", contenido=" + contenido + ", fechaPublicacion=" + fechaPublicacion + ", autor=" + autor + '}';
    }
    
    
}
