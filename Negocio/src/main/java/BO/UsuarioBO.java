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
import java.util.List;

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
    
    /**
     * Método que permite buscar un usuario por su correo y contraseña.
     *
     * @param dto Objeto UsuarioDTO con el correo y contraseña.
     * @return Objeto UsuarioDTO con los datos del usuario encontrado.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
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
    
    /**
     * Método que permite actualizar un usuario existente.
     *
     * @param id         ID del usuario a actualizar.
     * @param usuarioDTO Datos actualizados del usuario.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
    @Override
    public void actualizar(int id, UsuarioDTO usuarioDTO) throws BusinessException {
        try {
            if (usuarioDTO.getCorreo().isBlank() || usuarioDTO.getNombre().isBlank()) {
                throw new BusinessException("Faltan campos requeridos.");
            }

            String contrasena = enc.encriptar(usuarioDTO.getContrasena());
            usuarioDTO.setContrasena(contrasena);

            Usuario usuarioActualizado = usuarioCVR.convertir_Usuario(usuarioDTO);
            this.usuarioDAO.actualizar(id, usuarioActualizado);
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    /**
     * Método para eliminar un usuario por su ID.
     *
     * @param id ID del usuario a eliminar.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
    @Override
    public void eliminar(int id) throws BusinessException {
        try {
            this.usuarioDAO.eliminar(id);
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    
    /**
     * Método para listar todos los usuarios.
     *
     * @return Lista de objetos UsuarioDTO.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
    @Override
    public List<UsuarioDTO> listarTodos() throws BusinessException {
        try {
            List<Usuario> usuarios = usuarioDAO.listarTodos();
            List<UsuarioDTO> usuariosDTO = new ArrayList<>();

            for (Usuario usuario : usuarios) {
                usuariosDTO.add(usuarioCVR.convertir_DTO(usuario));
            }

            return usuariosDTO;
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
    

