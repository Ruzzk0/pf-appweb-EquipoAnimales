/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.awt.Image;
import java.io.File;
import java.time.LocalDateTime;

/**
 *
 * @author diana
 */
public class PublicacionDTO {
    private long id;
    private File imagen;
    private String nombreAnimal;
    private String tamanoAnimal;
    private String caracteristicas;
    private String dieta;
    private String habitat;
    private LocalDateTime fechaPublicacion;
    private long autor;   
    private String ima;   

    public PublicacionDTO() {
    }

    public PublicacionDTO(long id, File imagen, String nombreAnimal, String tamanoAnimal, String caracteristicas, String dieta, String habitat, LocalDateTime fechaPublicacion, long autor) {
        this.id = id;
        this.imagen = imagen;
        this.nombreAnimal = nombreAnimal;
        this.tamanoAnimal = tamanoAnimal;
        this.caracteristicas = caracteristicas;
        this.dieta = dieta;
        this.habitat = habitat;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
    }

    public PublicacionDTO(File imagen, String nombreAnimal, String tamanoAnimal, String caracteristicas, String dieta, String habitat, LocalDateTime fechaPublicacion, long autor) {
        this.imagen = imagen;
        this.nombreAnimal = nombreAnimal;
        this.tamanoAnimal = tamanoAnimal;
        this.caracteristicas = caracteristicas;
        this.dieta = dieta;
        this.habitat = habitat;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
    }

    public PublicacionDTO(String nombreAnimal, String tamanoAnimal, String caracteristicas, String dieta, String habitat, long autor) {
        this.nombreAnimal = nombreAnimal;
        this.tamanoAnimal = tamanoAnimal;
        this.caracteristicas = caracteristicas;
        this.dieta = dieta;
        this.habitat = habitat;
        this.autor = autor;
    }

    public PublicacionDTO(File imagen, String nombreAnimal, String tamanoAnimal, String caracteristicas, String dieta, String habitat, long autor) {
        this.imagen = imagen;
        this.nombreAnimal = nombreAnimal;
        this.tamanoAnimal = tamanoAnimal;
        this.caracteristicas = caracteristicas;
        this.dieta = dieta;
        this.habitat = habitat;
        this.autor = autor;
    }

    public PublicacionDTO(String nombreAnimal, String tamanoAnimal, String caracteristicas, String dieta, String habitat, long autor, String ima) {
        this.nombreAnimal = nombreAnimal;
        this.tamanoAnimal = tamanoAnimal;
        this.caracteristicas = caracteristicas;
        this.dieta = dieta;
        this.habitat = habitat;
        this.autor = autor;
        this.ima = ima;
    }
    
    
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public File getImagen() {
        return imagen;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public String getTamanoAnimal() {
        return tamanoAnimal;
    }

    public void setTamanoAnimal(String tamanoAnimal) {
        this.tamanoAnimal = tamanoAnimal;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
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

    @Override
    public String toString() {
        return "PublicacionDTO{" + "id=" + id + ", imagen=" + imagen + ", nombreAnimal=" + nombreAnimal + ", tamanoAnimal=" + tamanoAnimal + ", caracteristicas=" + caracteristicas + ", dieta=" + dieta + ", habitat=" + habitat + ", fechaPublicacion=" + fechaPublicacion + ", autor=" + autor + '}';
    }
}
