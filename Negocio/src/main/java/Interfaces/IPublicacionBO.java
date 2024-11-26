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

   
}

