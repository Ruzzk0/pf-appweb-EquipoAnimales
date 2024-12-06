/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Daos.PublicacionDAO;
import Daos.UsuarioDAO;
import Interfaces.IPublicacionBO;
import convertidores.PublicacionCVR;
import dto.PublicacionDTO;
import entidades.Publicacion;
import entidades.Usuario;
import excepciones.BusinessException;
import excepciones.DAOException;
import interfaces.Daos.IPublicacionDAO;
import interfaces.Daos.IUsuarioDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author diana
 */
   public class PublicacionBO implements IPublicacionBO {

  
    private final IPublicacionDAO publicacionDAO; 
    private final IUsuarioDAO usuarioDAO; 
    private final PublicacionCVR publicacionCVR; 

    public PublicacionBO() {
        this.publicacionDAO = new PublicacionDAO();
        this.usuarioDAO = new UsuarioDAO();
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
            Publicacion publi = publicacionCVR.convertir_Publicacion(publicacionDTO);
            publicacionDAO.agregar(publi);
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(PublicacionBO.class.getName()).log(Level.SEVERE, null, ex);
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
    public PublicacionDTO buscarPorId(long id) throws BusinessException {
        try {
            return publicacionCVR.convertir_DTO(this.publicacionDAO.buscarPorId(id));
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

     /**
     * Método que permite eliminar una publicación por su ID.
     *
     * @param id Id de la publicación a eliminar.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
    @Override
    public void eliminar(long id) throws BusinessException {
        try {
            this.publicacionDAO.eliminar(id);
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    /**
     * Método para actualizar una publicación existente.
     *
     * @param id Id de la publicación a actualizar.
     * @param publicacionDTO Los nuevos datos para la publicación.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
    @Override
    public void actualizar(long id, PublicacionDTO publicacionDTO) throws BusinessException {
        try {
            Usuario usuario = usuarioDAO.buscarPorId(publicacionDTO.getAutor());
            Publicacion publicacion = publicacionCVR.convertir_Publicacion(publicacionDTO);
            Publicacion existente = publicacionDAO.buscarPorId(id);
            if(existente != null && usuario !=null){
                if(usuario.getId() == existente.getAutor() || usuario.isAdministrador()){
                    this.publicacionDAO.actualizar(id, publicacion);
                }
                
            }
            
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(PublicacionBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
   

 

