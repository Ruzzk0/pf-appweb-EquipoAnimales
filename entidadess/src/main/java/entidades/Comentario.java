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
    
    private long id;
    private String contenido;
    private LocalDateTime fechaComentario;
    private long autor;
    private long publicacion;

    
    /**
     * Constructor vacío.
     * Permite crear una instancia de Comentario sin inicializar atributos.
     */
    public Comentario() {
    }
    
    /**
     * Constructor con parámetros.
     * @param id Identificador único del comentario.
     * @param contenido Texto del comentario.
     * @param fechaComentario Fecha y hora en que se hizo el comentario.
     * @param autor Usuario que realizó el comentario.
     * @param publicacion Publicación asociada al comentario.
     */
    public Comentario(long id, String contenido, LocalDateTime fechaComentario, long autor, long publicacion) {
        this.id = id;
        this.contenido = contenido;
        this.fechaComentario = fechaComentario;
        this.autor = autor;
        this.publicacion = publicacion;
    }

    public Comentario(String contenido, long autor, long publicacion) {
        this.contenido = contenido;
        this.autor = autor;
        this.publicacion = publicacion;
    }

    public Comentario(String contenido, LocalDateTime fechaComentario, long autor, long publicacion) {
        this.contenido = contenido;
        this.fechaComentario = fechaComentario;
        this.autor = autor;
        this.publicacion = publicacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

     /**
     * Método toString.
     * Retorna una representación en texto de los atributos del comentario.
     * @return 
     */
    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", contenido=" + contenido + ", fechaComentario=" + fechaComentario + ", autor=" + autor + ", publicacion=" + publicacion + '}';
    }
   
    
    
}
