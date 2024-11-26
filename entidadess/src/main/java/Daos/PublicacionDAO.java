/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import conexion.ConexionBD;
import entidades.Publicacion;
import entidades.Usuario;
import excepciones.DAOException;
import interfaces.Daos.IPublicacionDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diana
 */

/**
 * Clase que implementa la interfaz IPublicacionDAO para realizar operaciones CRUD 
 * en la colección de publicaciones dentro de una base de datos MongoDB.
 * Utiliza una colección MongoCollection para almacenar y recuperar datos.
 */
public class PublicacionDAO implements IPublicacionDAO {
    private final MongoCollection<Publicacion> publicacionCollection;
    private final UsuarioDAO usuarioDAO;

    
      /**
     * Constructor por defecto.
     * Inicializa la conexión con la colección "Publicaciones" y 
     * crea una instancia de UsuarioDAO para manejar usuarios relacionados.
     */
    public PublicacionDAO() {
        this.usuarioDAO = new UsuarioDAO();
        this.publicacionCollection = ConexionBD.getInstance().getDatabase()
            .getCollection("Publicaciones", Publicacion.class);
    }

    /**
     * Agrega una nueva publicación a la base de datos.
     * 
     * @param publicacion La publicación que se desea agregar.
     * @throws DAOException Si ocurre un error durante la operación, como que el autor no exista.
     */
    @Override
    public void agregar(Publicacion publicacion) throws DAOException {
        try {
            Usuario autor = usuarioDAO.buscarPorId(publicacion.getAutor().getId());
            if (autor == null) {
                throw new DAOException("No se encontró el autor de la publicación.");
            }

            publicacion.setAutor(autor);
            publicacionCollection.insertOne(publicacion);
        } catch (Exception e) {
            throw new DAOException("Error al agregar la publicación: " + e.getMessage(), e);
        }
    }
    
    /**
     * Busca una publicación por su identificador único (ID).
     * 
     * @param id El identificador único de la publicación.
     * @return La publicación encontrada o null si no existe.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    @Override
    public Publicacion buscarPorId(int id) throws DAOException {
        try {
            return publicacionCollection.find(Filters.eq("id", id)).first();
        } catch (Exception e) {
            throw new DAOException("Error al buscar la publicación por ID: " + e.getMessage(), e);
        }
    }

     /**
     * Lista todas las publicaciones asociadas a un usuario específico.
     * 
     * @param usuarioId El identificador único del usuario (autor) de las publicaciones.
     * @return Una lista de publicaciones asociadas al usuario.
     * @throws DAOException Si ocurre un error durante la operación.
     */
   

   
}

