/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Daos.UsuarioDAO;
import Interfaces.IUsuarioBO;
import convertidores.UsuarioCVR;
import dto.UsuarioDTO;
import excepciones.BusinessException;
import excepciones.DAOException;
import interfaces.Daos.IUsuarioDAO;
/**
 *
 * @author diana
 */
public class UsuarioBO implements IUsuarioBO {

    
    private final IUsuarioDAO usuarioDAO; 
    private final UsuarioCVR usuarioCVR; 

    public UsuarioBO() {
        this.usuarioDAO = new UsuarioDAO();
        this.usuarioCVR = new UsuarioCVR();
    }

    /**
     * Método para agregar un nuevo usuario.
     *
     * @param usuarioDTO Objeto de tipo UsuarioDTO que se desea agregar.
     * @throws BusinessException Arroja una excepción si ocurre un error en la
     * operación.
     */
    @Override
    public void agregar(UsuarioDTO usuarioDTO) throws BusinessException {
        try {
           
            this.usuarioDAO.agregar(usuarioCVR.convertir_Usuario(usuarioDTO));
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    /**
     * Método que nos permite obtener un usuario buscándolo mediante su id.
     *
     * @param id Id del usuario a buscar.
     * @return Retorna un objeto de tipo UsuarioDTO.
     * @throws BusinessException Arroja una excepción si ocurre un error en la
     * operación.
     */
    @Override
    public UsuarioDTO buscarPorId(int id) throws BusinessException {
        try {
            return usuarioCVR.convertir_DTO(this.usuarioDAO.buscarPorId(id));
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    
}
