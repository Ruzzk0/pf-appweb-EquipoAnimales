/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.Daos;

import entidades.Publicacion;
import excepciones.DAOException;

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
    public Publicacion buscarPorId(long id) throws DAOException;
    
    public Publicacion buscar_Publicacion_Sin_Id(Publicacion publicacion) throws DAOException;
    
    /**
     * Elimina una publicación por su identificador único (ID).
     * 
     * @param id El identificador único de la publicación a eliminar.
     * @throws DAOException Si ocurre un error durante la operación o si la publicación no existe.
     */
    public void eliminar(long id) throws DAOException;
    
    /**
     * Actualiza una publicación existente en la base de datos.
     * 
     * @param id El identificador único de la publicación a actualizar.
     * @param publicacion Los datos actualizados de la publicación.
     * @throws DAOException Si ocurre un error durante la operación o si la publicación no existe.
     */
   
    public void actualizar(long id, Publicacion publicacion) throws DAOException;
    

}

