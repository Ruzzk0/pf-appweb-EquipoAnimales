/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import conexion.ConexionBD;
import entidades.Publicacion;
import entidades.Usuario;
import excepciones.DAOException;
import interfaces.Daos.IPublicacionDAO;
import org.bson.conversions.Bson;


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
            Usuario autor = usuarioDAO.buscarPorId(publicacion.getAutor());
            if (autor == null) {
                throw new DAOException("No se encontró el autor de la publicación.");
            }

            publicacion.setAutor(autor.getId());
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
     * Elimina una publicación por su identificador único (ID).
     * 
     * @param id El identificador único de la publicación a eliminar.
     * @throws DAOException Si ocurre un error durante la operación o si la publicación no existe.
     */
    @Override
    public void eliminar(int id) throws DAOException {
    try {
        DeleteResult resultado = publicacionCollection.deleteOne(Filters.eq("id", id));
        if (resultado.getDeletedCount() == 0) {
            throw new DAOException("No se encontró ninguna publicación con el ID especificado.");
        }
    } catch (Exception e) {
        throw new DAOException("Error al eliminar la publicación: " + e.getMessage(), e);
    }
}
       
        /**
     * Actualiza una publicación existente en la base de datos.
     * 
     * @param id El identificador único de la publicación a actualizar.
     * @param publicacion Los datos actualizados de la publicación.
     * @throws DAOException Si ocurre un error durante la operación o si la publicación no existe.
     */
    @Override
    public void actualizar(int id, Publicacion publicacion) throws DAOException {
    try {
        
        Publicacion publicacionExistente = buscarPorId(id);
        if (publicacionExistente == null) {
            throw new DAOException("No se encontró ninguna publicación con el ID especificado.");
        }

        Usuario autor = usuarioDAO.buscarPorId(publicacion.getAutor());
        if (autor == null) {
            throw new DAOException("No se encontró el autor de la publicación.");
        }

        Bson updates = Updates.combine(
            Updates.set("contenido", publicacion.getContenido()),
            Updates.set("autor", autor)
        );

        UpdateResult resultado = publicacionCollection.updateOne(Filters.eq("id", id), updates);

        if (resultado.getMatchedCount() == 0) {
            throw new DAOException("No se pudo actualizar la publicación. Verifica el ID.");
        }
    } catch (Exception e) {
        throw new DAOException("Error al actualizar la publicación: " + e.getMessage(), e);
    }
}


   
}

