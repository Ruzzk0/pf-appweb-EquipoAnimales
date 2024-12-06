/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import dto.ComentarioDTO;
import excepciones.BusinessException;
import java.util.List;


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
    public ComentarioDTO buscarPorId(long id) throws BusinessException;
   
    /**
     * Método que lista todos los comentarios asociados a una publicación.
     *
     * @param publicacionId ID de la publicación asociada.
     * @return Una lista de objetos ComentarioDTO relacionados con la publicación.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
    public List<ComentarioDTO> listarPorPublicacion(long publicacionId) throws BusinessException;
    
     /**
     * Método que elimina un comentario por su ID.
     *
     * @param id ID del comentario a eliminar.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
    public void eliminar(long id) throws BusinessException;
    
}


 

