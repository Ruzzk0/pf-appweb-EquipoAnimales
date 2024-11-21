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
     */
    public Usuario(int id, String nombre, String correo, String contrasena, String administrador, String visitante) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
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
