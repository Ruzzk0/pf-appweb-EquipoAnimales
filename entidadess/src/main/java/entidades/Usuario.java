/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author diana
 */
public class Usuario {
    
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
    private String administrador;
    private String visitante;

    
    /**
     * Constructor vacío.
     * Permite crear una instancia de Usuario sin inicializar atributos.
     */
    public Usuario() {
    }
    /**
     * Constructor con parámetros.
     * @param id Identificador único del usuario.
     * @param nombre Nombre completo del usuario.
     * @param correo Correo electrónico del usuario.
     * @param contrasena Contraseña del usuario.
     * @param administrador
     * @param visitante
     */
    public Usuario(int id, String nombre, String correo, String contrasena, String administrador, String visitante) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.administrador = administrador;
        this.visitante = visitante;
    }
    
    public Usuario(String nombre, String correo, String contrasena, String administrador, String visitante) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.administrador = administrador;
        this.visitante = visitante;
    }
    
    public Usuario(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario(int id, String nombre, String correo, String contrasena, String pais, String estado, String ciudad, String telefono, String fechaNacimiento, String genero, String bando, String administrador, String visitante) {
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
        this.visitante = visitante;
    }

    public Usuario(String nombre, String correo, String contrasena, String pais, String estado, String ciudad, String telefono, String fechaNacimiento, String genero, String bando, String administrador, String visitante) {
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
        this.visitante = visitante;
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

    public String getAdministrador(){
     return administrador;
    }
    
    public void setAdministrador(String administrador){
       this.administrador = administrador;
    }
    
    public String getVisitante(){
     return administrador;
    }
    
    public void setVisitante(String visitante){
       this.visitante = visitante;
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
    
    
   /**
     * Método toString.
     * Retorna una representación en texto de los atributos del usuario.
     * @return 
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", contrasena=" + contrasena + ", administrador=" + administrador + ", visitante=" + visitante + '}';
    }
   
    

}
