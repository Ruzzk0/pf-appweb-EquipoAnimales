/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.webapps.register.mvc;

/**
 *
 * @author gamaliel
 */
public class registerModel {
    private String nombre;
    private String email;
    private String password;
    private String pais;
    private String estado;
    private String ciudad;
    private String telefono;
    private String fechaNacimiento;
    private String genero;
    private String bando;

    public registerModel(String nombre, String email, String password, String pais, String estado, String ciudad, String telefono, String fechaNacimiento, String genero, String bando) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.pais = pais;
        this.estado = estado;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.bando = bando;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getBando() {
        return bando;
    }

    public void setBando(String bando) {
        this.bando = bando;
    }
}
