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
public class Comentario {
    private int id;
    private String contenido;
    private LocalDateTime fechaComentario;
    private Usuario autor;
    private Publicacion publicacion;

    public Comentario() {
    }

    public Comentario(int id, String contenido, LocalDateTime fechaComentario, Usuario autor, Publicacion publicacion) {
        this.id = id;
        this.contenido = contenido;
        this.fechaComentario = fechaComentario;
        this.autor = autor;
        this.publicacion = publicacion;
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

    public LocalDateTime getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(LocalDateTime fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", contenido=" + contenido + ", fechaComentario=" + fechaComentario + ", autor=" + autor + ", publicacion=" + publicacion + '}';
    }
   
    
    
}
