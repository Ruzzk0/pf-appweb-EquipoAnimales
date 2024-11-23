/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.Daos;

import entidades.Publicacion;
import excepciones.DAOException;
import java.util.List;

/**
 *
 * @author diana
 */
public interface IPublicacionDAO {
      /**
     * Agrega una nueva publicación a la base de datos.
     * 
     * @param publicacion La publicación a agregar.
     * @throws DAOException Si ocurre un error al agregar la publicación.
     */
    public void agregar(Publicacion publicacion) throws DAOException;

    /**
     * Busca una publicación por su ID.
     * 
     * @param id El identificador único de la publicación.
     * @return La publicación encontrada o null si no existe.
     * @throws DAOException Si ocurre un error al buscar la publicación.
     */
    public Publicacion buscarPorId(int id) throws DAOException;

    /**
     * Lista todas las publicaciones almacenadas en la base de datos.
     * 
     * @param usuarioId
     * @return Una lista de publicaciones.
     * @throws DAOException Si ocurre un error al listar las publicaciones.
     */
    public List<Publicacion> listarPorUsuario(int usuarioId) throws DAOException;
}

