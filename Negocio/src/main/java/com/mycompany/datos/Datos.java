/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.datos;

import Daos.ComentarioDAO;
import Daos.PublicacionDAO;
import Daos.UsuarioDAO;
import conexion.ConexionBD;
import entidades.Comentario;
import entidades.Publicacion;
import entidades.Usuario;
import excepciones.DAOException;
import java.util.List;

/**
 *
 * @author diana
 */
public class Datos {

    
    public static void main(String[] args) {
        // Inicializar conexión a MongoDB
        ConexionBD conexion = ConexionBD.getInstance();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PublicacionDAO publicacionDAO = new PublicacionDAO();
        ComentarioDAO comentarioDAO = new ComentarioDAO();

        try {
            // Crear y agregar un usuario
            Usuario usuario = new Usuario();
            usuario.setId(1);
            usuario.setNombre("Juan Pérez");
            usuario.setCorreo("juan.perez@example.com");
            usuario.setVisitante("visitante");
            usuarioDAO.agregar(usuario);
            System.out.println("Usuario agregado: " + usuario);

            // Crear y agregar una publicación
            Publicacion publicacion = new Publicacion();
            publicacion.setId(1);
            publicacion.setContenido("Este es el contenido de la primera publicación.");
            publicacion.setAutor(usuario); 
            publicacionDAO.agregar(publicacion);
            System.out.println("Publicación agregada: " + publicacion);

            // Crear y agregar un comentario
            Comentario comentario = new Comentario();
            comentario.setId(1);
            comentario.setContenido("Este es un comentario sobre la publicación.");
            comentario.setAutor(usuario); 
            comentario.setPublicacion(publicacion); 
            comentarioDAO.agregar(comentario);
            System.out.println("Comentario agregado: " + comentario);

            // Buscar publicación por ID
            Publicacion publicacionEncontrada = publicacionDAO.buscarPorId(1);
            System.out.println("Publicación encontrada: " + publicacionEncontrada);

            // Listar publicaciones de un usuario
//            List<Publicacion> publicaciones = publicacionDAO.listarPorUsuario(1);
            System.out.println("Publicaciones del usuario:");
//            publicaciones.forEach(System.out::println);

            // Listar comentarios de una publicación
            List<Comentario> comentarios = comentarioDAO.listarPorPublicacion(1);
            System.out.println("Comentarios de la publicación:");
            comentarios.forEach(System.out::println);

        } catch (DAOException e) {
            System.err.println("Error al realizar operación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
        
  
    

