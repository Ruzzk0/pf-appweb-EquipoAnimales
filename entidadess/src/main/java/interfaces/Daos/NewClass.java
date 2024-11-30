/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces.Daos;

import Daos.UsuarioDAO;
import entidades.Usuario;
import excepciones.DAOException;

/**
 *
 * @author Dell
 */
public class NewClass {
    public static void main(String[] args) throws DAOException {
        UsuarioDAO d = new UsuarioDAO();
        Usuario usuario = new Usuario("kk@gmail.com", "szbseCaWX7X3K41fMZR1eA==");
        Usuario usuario2 = d.buscarPorCorreo(usuario);
        System.out.println(usuario2);
        usuario2.toString();
        
    }
}
