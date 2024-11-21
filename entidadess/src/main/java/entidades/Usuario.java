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
    public Usuario(int id, String nombre, String correo, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
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
   /**
     * Método toString.
     * Retorna una representación en texto de los atributos del usuario.
     * @return 
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", contrasena=" + contrasena + '}';
    }
   
    

}
