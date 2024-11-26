/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Daos.UsuarioDAO;
import Interfaces.IUsuarioBO;
import convertidores.UsuarioCVR;
import dto.UsuarioDTO;
import encriptacion.Encriptador;
import entidades.Usuario;
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
    private Encriptador enc;
    
    public UsuarioBO() {
        this.usuarioDAO = new UsuarioDAO();
        this.usuarioCVR = new UsuarioCVR();
        this.enc = Encriptador.getInstance();
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
            if(usuarioDTO.getContrasena().isBlank()){
                throw new DAOException("No ingreso contraseña");
            }
            
            if(usuarioDTO.getCorreo().isBlank() || usuarioDTO.getNombre().isBlank()){
                throw new DAOException("Faltan campos requeridos");
            }
            
            String contra = enc.encriptar(usuarioDTO.getContrasena());
            usuarioDTO.setContrasena(contra);
            this.usuarioDAO.agregar(usuarioCVR.convertir_Usuario_Sin_Id(usuarioDTO));
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
    
    @Override
    public UsuarioDTO buscarPorCorreo(UsuarioDTO dto) throws BusinessException {
        try {
            UsuarioDTO clon = dto;
            
            if (clon.getCorreo() == null || clon.getContrasena() == null
                    || clon.getCorreo().isBlank() || clon.getContrasena().isBlank()) {
                throw new DAOException();
            }
            String contrasena = enc.encriptar(clon.getContrasena());
            
            clon.setContrasena(contrasena);
            
            Usuario usuarioConvert = usuarioCVR.convertir_Usuario_Sin_Id(dto);
            Usuario usuarioBuscado = usuarioDAO.buscarPorCorreo(usuarioConvert);
            UsuarioDTO usuarioBuscadoDTO = usuarioCVR.convertir_DTO_Sin_Id(usuarioBuscado);            
            return usuarioBuscadoDTO;
            
        } catch (DAOException e) {
            throw new BusinessException();
        }
    }
    
}
