/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDateTime;

/**
 *
 * @author diana
 */
public class ComentarioDTO {
       
    private long id;
    private String contenido;
    private LocalDateTime fechaComentario;
    private long autor;
    private long publicacion;

    public ComentarioDTO() {
    }

    public ComentarioDTO(long id, String contenido, LocalDateTime fechaComentario, long autor, long publicacion) {
        this.id = id;
        this.contenido = contenido;
        this.fechaComentario = fechaComentario;
        this.autor = autor;
        this.publicacion = publicacion;
    }

    public ComentarioDTO(String contenido, LocalDateTime fechaComentario, long autor, long publicacion) {
        this.contenido = contenido;
        this.fechaComentario = fechaComentario;
        this.autor = autor;
        this.publicacion = publicacion;
    }
    

    public long getId() {
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

    public long getAutor() {
        return autor;
    }

    public void setAutor(long autor) {
        this.autor = autor;
    }

    public long getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(long publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public String toString() {
        return "ComentarioDTO{" + "id=" + id + ", contenido=" + contenido + ", fechaComentario=" + fechaComentario + ", autor=" + autor + ", publicacion=" + publicacion + '}';
    }
    
    
}
