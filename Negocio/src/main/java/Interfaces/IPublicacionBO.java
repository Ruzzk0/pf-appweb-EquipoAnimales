/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import dto.PublicacionDTO;
import excepciones.BusinessException;


/**
 *
 * @author diana
 */
public interface IPublicacionBO {

    /**
     * Agrega una nueva publicación.
     * 
     * @param publicacionDTO Objeto de tipo PublicacionDTO que deseamos agregar.
     * @throws BusinessException Si ocurre un error al agregar la publicación.
     */
    public void agregar(PublicacionDTO publicacionDTO) throws BusinessException;

    /**
     * Busca una publicación por su ID.
     * 
     * @param id El identificador único de la publicación.
     * @return El objeto PublicacionDTO encontrado o null si no existe.
     * @throws BusinessException Si ocurre un error al buscar la publicación.
     */
    public PublicacionDTO buscarPorId(int id) throws BusinessException;

   
     /**
     * Método que permite eliminar una publicación por su ID.
     *
     * @param id Id de la publicación a eliminar.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
    public void eliminar(int id) throws BusinessException;
    
    /**
     * Método para actualizar una publicación existente.
     *
     * @param id Id de la publicación a actualizar.
     * @param publicacionDTO Los nuevos datos para la publicación.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
//     */
    public void actualizar(int id, PublicacionDTO publicacionDTO) throws BusinessException;
}

