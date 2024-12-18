/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.DeleteResult;
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
 * Clase que implementa la interfaz IComentarioDAO para gestionar las
 * operaciones CRUD relacionadas con los comentarios en una base de datos
 * MongoDB. Maneja las relaciones con las colecciones de usuarios y
 * publicaciones.
 */
public class ComentarioDAO implements IComentarioDAO {

    private final MongoCollection<Comentario> comentarioCollection;
    private final UsuarioDAO usuarioDAO;
    private final PublicacionDAO publicacionDAO;

    /**
     * Constructor por defecto. Inicializa las colecciones y los DAOs necesarios
     * para las relaciones.
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
     * @throws DAOException Si ocurre un error durante la operación, como si el
     * autor o la publicación no existen.
     */
    @Override
    public void agregar(Comentario comentario) throws DAOException {
        try {
            Usuario autor = usuarioDAO.buscarPorId(comentario.getAutor());
            if (autor == null) {
                throw new DAOException("No se encontró el autor del comentario.");
            }

            // Verificar que la publicación exista
            Publicacion publicacion = publicacionDAO.buscarPorId(comentario.getPublicacion());
            if (publicacion == null) {
                throw new DAOException("No se encontró la publicación asociada al comentario.");
            }
            
            Comentario ultimo = this.buscarUltimo_Comentario_Publicacion(comentario.getPublicacion());
            long id = 0;
            if (ultimo != null) {
                id = ultimo.getId();
                id++;
            }

            // Asignar relaciones validadas y guardar el comentario
            comentario.setId(id);
            comentario.setAutor(autor.getId());
            comentario.setPublicacion(publicacion.getId());
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
    public Comentario buscarPorId(long id) throws DAOException {
        try {
            return comentarioCollection.find(Filters.eq("id", id)).first();
        } catch (Exception e) {
            throw new DAOException("Error al buscar el comentario por ID: " + e.getMessage(), e);
        }
    }

    private Comentario buscarUltimo_Comentario_Publicacion(long publicacion) throws DAOException {
        try {
            // Buscar los comentarios de la publicación específica, ordenarlos por id en orden descendente
            Comentario ultimoComentario = comentarioCollection.find(Filters.eq("publicacionId", publicacion))
                    .sort(Sorts.descending("id"))
                    .first();

            if (ultimoComentario == null) {
                throw new DAOException("No se encontraron comentarios para la publicación con ID: " + publicacion);
            }

            // Aquí podrías devolver el comentario o la publicación, dependiendo de tu lógica
            return ultimoComentario;
        } catch (Exception e) {
            throw new DAOException("Error al buscar la última publicación: " + e.getMessage(), e);
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
    public List<Comentario> listarPorPublicacion(long publicacionId) throws DAOException {
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

    /**
     * Elimina un comentario de la base de datos según su identificador único
     * (ID).
     *
     * @param id El identificador único del comentario a eliminar.
     * @throws DAOException Si ocurre un error durante la operación.
     */

    @Override
    public void eliminar(long id) throws DAOException {
        try {
            DeleteResult resultado = comentarioCollection.deleteOne(Filters.eq("id", id));
            if (resultado.getDeletedCount() == 0) {
                throw new DAOException("No se encontró el comentario con el ID especificado.");
            }
        } catch (Exception e) {
            throw new DAOException("Error al eliminar el comentario: " + e.getMessage(), e);
        }
    }

}
