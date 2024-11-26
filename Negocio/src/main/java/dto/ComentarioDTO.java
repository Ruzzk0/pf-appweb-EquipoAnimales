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
       
    private int id;
    private String contenido;
    private LocalDateTime fechaComentario;
    private UsuarioDTO autor;
    private PublicacionDTO publicacion;

    public ComentarioDTO() {
    }

    public ComentarioDTO(int id, String contenido, LocalDateTime fechaComentario, UsuarioDTO autor, PublicacionDTO publicacion) {
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

    public UsuarioDTO getAutor() {
        return autor;
    }

    public void setAutor(UsuarioDTO autor) {
        this.autor = autor;
    }

    public PublicacionDTO getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(PublicacionDTO publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public String toString() {
        return "ComentarioDTO{" + "id=" + id + ", contenido=" + contenido + ", fechaComentario=" + fechaComentario + ", autor=" + autor + ", publicacion=" + publicacion + '}';
    }
    
    
}
