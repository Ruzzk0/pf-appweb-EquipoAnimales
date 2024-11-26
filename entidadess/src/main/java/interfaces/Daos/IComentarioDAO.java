/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.Daos;

import entidades.Comentario;
import excepciones.DAOException;
import java.util.List;

/**
 *
 * @author diana
 */
public interface IComentarioDAO {
     /**
     * Agrega un nuevo comentario a la base de datos.
     * 
     * @param comentario El comentario a agregar.
     * @throws DAOException Si ocurre un error al agregar el comentario.
     */
    public void agregar(Comentario comentario) throws DAOException;

    /**
     * Busca un comentario por su ID.
     * 
     * @param id El identificador único del comentario.
     * @return El comentario encontrado o null si no existe.
     * @throws DAOException Si ocurre un error al buscar el comentario.
     */
    public Comentario buscarPorId(int id) throws DAOException;

    /**
     * Lista todos los comentarios asociados a una publicación específica.
     * 
     * @param publicacionId El ID de la publicación.
     * @return Una lista de comentarios relacionados con la publicación.
     * @throws DAOException Si ocurre un error al listar los comentarios.
     */
    public List<Comentario> listarPorPublicacion(int publicacionId) throws DAOException;
    
    /**
    * Elimina un comentario de la base de datos según su identificador único (ID).
    * 
    * @param id El identificador único del comentario a eliminar.
    * @throws DAOException Si ocurre un error durante la operación.
    */

   public void eliminar(int id) throws DAOException;
}

