/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author diana
 */
public class UsuarioDTO {
    private int id;
    private String nombre;
    private String correo;
    private String contrasena;
    private String pais;
    private String estado;
    private String ciudad;
    private String telefono;
    private String fechaNacimiento;
    private String genero;
    private String bando;
    private boolean administrador;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id, String nombre, String correo, String contrasena, boolean administrador) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.administrador = administrador;
    }


    public UsuarioDTO(String nombre, String correo, String contrasena, boolean administrador) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.administrador = administrador;
    }
    
    
    public UsuarioDTO(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public UsuarioDTO(int id, String nombre, String correo, String contrasena, String pais, String estado, String ciudad, String telefono, String fechaNacimiento, String genero, String bando, boolean administrador) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.pais = pais;
        this.estado = estado;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.bando = bando;
        this.administrador = administrador;
    }

    public UsuarioDTO(String nombre, String correo, String contrasena, String pais, String estado, String ciudad, String telefono, String fechaNacimiento, String genero, String bando, boolean administrador) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.pais = pais;
        this.estado = estado;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.bando = bando;
        this.administrador = administrador;
    }


    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UsuarioDTO{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", correo=").append(correo);
        sb.append(", contrasena=").append(contrasena);
        sb.append(", pais=").append(pais);
        sb.append(", estado=").append(estado);
        sb.append(", ciudad=").append(ciudad);
        sb.append(", telefono=").append(telefono);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", genero=").append(genero);
        sb.append(", bando=").append(bando);
        sb.append(", administrador=").append(administrador);
        sb.append('}');
        return sb.toString();
    }



    
}
