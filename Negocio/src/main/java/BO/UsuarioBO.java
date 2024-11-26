/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import excepciones.DAOException;

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

    @Override
    public List<UsuarioDTO> listaPaginada(int offset, int limit) throws BusinessException {
        try {
            List<Usuario> lista = usuarioDAO.listaPaginada(offset, limit);
            List<UsuarioDTO> listaDTO = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(usuarioCVR.convertir_DTO(lista.get(i)));
            }
            return listaDTO;
        } catch (DAOException ex) {
            throw new BusinessException(ex.getMessage());
        }
    }

    @Override
    public UsuarioDTO buscarPorCorreo(String correo) throws BusinessException {
        try {
            return usuarioCVR.convertir_DTO(this.usuarioDAO.buscarPorCorreo(correo));
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
