/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.webapps.index.mvc;

/**
 *
 * @author gamaliel
 */
public class indexModel {
    private String email;
    private String password;

    public indexModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Método para validar las credenciales (puedes mejorarlo según tu lógica)
    public boolean isValid() {
        // Aquí puedes agregar la lógica para validar el usuario, como consultar una base de datos
        return "usuario@example.com".equals(email) && "contraseña123".equals(password);
    }
}
