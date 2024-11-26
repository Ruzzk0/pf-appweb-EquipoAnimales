/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Daos.ComentarioDAO;
import Interfaces.IComentarioBO;
import convertidores.ComentarioCVR;
import dto.ComentarioDTO;
import entidades.Comentario;
import excepciones.BusinessException;
import excepciones.DAOException;
import interfaces.Daos.IComentarioDAO;
import java.util.List;

/**
 *
 * @author diana
 */
    public class ComentarioBO implements IComentarioBO{

  
    private final IComentarioDAO comentarioDAO; 
    private final ComentarioCVR comentarioCVR; 

    public ComentarioBO() {
        this.comentarioDAO = new ComentarioDAO();
        this.comentarioCVR = new ComentarioCVR();
    }

    /**
     * Método para agregar un nuevo comentario.
     *
     * @param comentarioDTO Objeto de tipo ComentarioDTO que se desea agregar.
     * @throws BusinessException Arroja una excepción si ocurre un error en la
     * operación.
     */
    @Override
    public void agregar(ComentarioDTO comentarioDTO) throws BusinessException {
        try {
            
            this.comentarioDAO.agregar(comentarioCVR.convertir_Comentario(comentarioDTO));
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    /**
     * Método que nos permite obtener un comentario buscándolo mediante su id.
     *
     * @param id Id del comentario a buscar.
     * @return Retorna un objeto de tipo ComentarioDTO.
     * @throws BusinessException Arroja una excepción si ocurre un error en la
     * operación.
     */
    @Override
    public ComentarioDTO buscarPorId(int id) throws BusinessException {
        try {
            return comentarioCVR.convertir_DTO(this.comentarioDAO.buscarPorId(id));
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }
     /**
     * Método que lista todos los comentarios asociados a una publicación.
     *
     * @param publicacionId ID de la publicación asociada.
     * @return Una lista de objetos ComentarioDTO relacionados con la publicación.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
 @Override
    public List<ComentarioDTO> listarPorPublicacion(int publicacionId) throws BusinessException {
        try {
            List<Comentario> comentarios = comentarioDAO.listarPorPublicacion(publicacionId);
            return comentarios.stream()
                .map(comentarioCVR::convertir_DTO)
                .toList();
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    /**
     * Método que elimina un comentario por su ID.
     *
     * @param id ID del comentario a eliminar.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
    @Override
    public void eliminar(int id) throws BusinessException {
        try {
            comentarioDAO.eliminar(id);
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
    



