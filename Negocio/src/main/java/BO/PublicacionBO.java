/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Daos.PublicacionDAO;
import Interfaces.IPublicacionBO;
import convertidores.PublicacionCVR;
import dto.PublicacionDTO;
import excepciones.BusinessException;
import excepciones.DAOException;
import interfaces.Daos.IPublicacionDAO;


/**
 *
 * @author diana
 */
   public class PublicacionBO implements IPublicacionBO {

  
    private final IPublicacionDAO publicacionDAO; 
    private final PublicacionCVR publicacionCVR; 

    public PublicacionBO() {
        this.publicacionDAO = new PublicacionDAO();
        this.publicacionCVR = new PublicacionCVR();
    }

    /**
     * Método para agregar una nueva publicación.
     *
     * @param publicacionDTO Objeto de tipo PublicacionDTO que se desea agregar.
     * @throws BusinessException Arroja una excepción si ocurre un error en la
     * operación.
     */
    @Override
    public void agregar(PublicacionDTO publicacionDTO) throws BusinessException {
        try {
            
            this.publicacionDAO.agregar(publicacionCVR.convertir_Publicacion(publicacionDTO));
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    /**
     * Método que nos permite obtener una publicación buscándola mediante su id.
     *
     * @param id Id de la publicación a buscar.
     * @return Retorna un objeto de tipo PublicacionDTO.
     * @throws BusinessException Arroja una excepción si ocurre un error en la
     * operación.
     */
    @Override
    public PublicacionDTO buscarPorId(int id) throws BusinessException {
        try {
            return publicacionCVR.convertir_DTO(this.publicacionDAO.buscarPorId(id));
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    
   
}
 

