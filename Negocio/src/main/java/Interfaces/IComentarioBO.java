/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import dto.ComentarioDTO;
import excepciones.BusinessException;


/**
 *
 * @author diana
 */
public interface IComentarioBO {

    /**
     * Agrega un nuevo comentario.
     * 
     * @param comentarioDTO Objeto de tipo ComentarioDTO que se desea agregar.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
    public void agregar(ComentarioDTO comentarioDTO) throws BusinessException;

    /**
     * Busca un comentario por su ID.
     * 
     * @param id El identificador único del comentario.
     * @return El objeto ComentarioDTO encontrado o null si no existe.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
    public ComentarioDTO buscarPorId(int id) throws BusinessException;
    
    
}


 

