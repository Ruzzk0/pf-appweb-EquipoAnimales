/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import conexion.ConexionBD;
import entidades.Comentario;
import entidades.Publicacion;
import entidades.Usuario;
import excepciones.DAOException;
import interfaces.Daos.IComentarioDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diana
 */

/**
 * Clase que implementa la interfaz IComentarioDAO para gestionar las operaciones
 * CRUD relacionadas con los comentarios en una base de datos MongoDB.
 * Maneja las relaciones con las colecciones de usuarios y publicaciones.
 */
public class ComentarioDAO implements IComentarioDAO {
    
     private final MongoCollection<Comentario> comentarioCollection;
    private final UsuarioDAO usuarioDAO;
    private final PublicacionDAO publicacionDAO;

     /**
     * Constructor por defecto.
     * Inicializa las colecciones y los DAOs necesarios para las relaciones.
     */
    public ComentarioDAO() {
        this.usuarioDAO = new UsuarioDAO();
        this.publicacionDAO = new PublicacionDAO();
        this.comentarioCollection = ConexionBD.getInstance().getDatabase()
            .getCollection("Comentarios", Comentario.class);
    }

     /**
     * Agrega un nuevo comentario a la base de datos.
     * 
     * @param comentario El comentario a agregar.
     * @throws DAOException Si ocurre un error durante la operación, como si el autor o la publicación no existen.
     */
     @Override
    public void agregar(Comentario comentario) throws DAOException {
        try {
            // Verificar que el autor exista y sea un visitante
            Usuario autor = usuarioDAO.buscarPorId(comentario.getAutor().getId());
            if (autor == null) {
                throw new DAOException("No se encontró el autor del comentario.");
            }
            if (!"visitante".equalsIgnoreCase(autor.getVisitante())) {
                throw new DAOException("El autor del comentario debe ser un visitante.");
            }

            // Verificar que la publicación exista
            Publicacion publicacion = publicacionDAO.buscarPorId(comentario.getPublicacion().getId());
            if (publicacion == null) {
                throw new DAOException("No se encontró la publicación asociada al comentario.");
            }

            // Asignar relaciones validadas y guardar el comentario
            comentario.setAutor(autor);
            comentario.setPublicacion(publicacion);
            comentarioCollection.insertOne(comentario);
        } catch (Exception e) {
            throw new DAOException("Error al agregar el comentario: " + e.getMessage(), e);
        }
    }


     /**
     * Busca un comentario por su identificador único (ID).
     * 
     * @param id El identificador único del comentario.
     * @return El comentario encontrado o null si no existe.
     * @throws DAOException Si ocurre un error durante la operación.
     */
     @Override
    public Comentario buscarPorId(int id) throws DAOException {
        try {
            return comentarioCollection.find(Filters.eq("id", id)).first();
        } catch (Exception e) {
            throw new DAOException("Error al buscar el comentario por ID: " + e.getMessage(), e);
        }
    }

    /**
     * Lista todos los comentarios asociados a una publicación específica.
     * 
     * @param publicacionId El identificador único de la publicación.
     * @return Una lista de comentarios asociados a la publicación.
     * @throws DAOException Si ocurre un error durante la operación.
     */
     @Override
    public List<Comentario> listarPorPublicacion(int publicacionId) throws DAOException {
        try {
            List<Comentario> comentarios = new ArrayList<>();
            MongoCursor<Comentario> cursor = comentarioCollection.find(
                Filters.eq("publicacion.id", publicacionId)).iterator();
            while (cursor.hasNext()) {
                comentarios.add(cursor.next());
            }
            cursor.close();
            return comentarios;
        } catch (Exception e) {
            throw new DAOException("Error al listar comentarios por publicación: " + e.getMessage(), e);
        }
    }
}


