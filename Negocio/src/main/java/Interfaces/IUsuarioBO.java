/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import dto.UsuarioDTO;
import excepciones.BusinessException;
import java.util.List;

/**
 *
 * @author diana
 */
public interface IUsuarioBO {

    /**
     * Agrega un nuevo usuario.
     * 
     * @param usuarioDTO Objeto de tipo UsuarioDTO que deseamos agregar.
     * @throws BusinessException Si ocurre un error al agregar el usuario.
     */
    public void agregar(UsuarioDTO usuarioDTO) throws BusinessException;

    /**
     * Busca un usuario por su ID.
     * 
     * @param id El identificador único del usuario.
     * @return El objeto UsuarioDTO encontrado o null si no existe.
     * @throws BusinessException Si ocurre un error al buscar el usuario.
     */
    public UsuarioDTO buscarPorId(long id) throws BusinessException;
    
    public UsuarioDTO buscarPorCorreo(UsuarioDTO usuarioDTO) throws BusinessException;
    
    /**
     * Método que permite actualizar un usuario existente.
     *
     * @param id         ID del usuario a actualizar.
     * @param usuarioDTO Datos actualizados del usuario.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
    public void actualizar(long id, UsuarioDTO usuarioDTO) throws BusinessException;
    
    /**
     * Método para eliminar un usuario por su ID.
     *
     * @param id ID del usuario a eliminar.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
    public void eliminar(long id) throws BusinessException;

     /**
     * Método para listar todos los usuarios.
     *
     * @return Lista de objetos UsuarioDTO.
     * @throws BusinessException Arroja una excepción si ocurre un error en la operación.
     */
    public List<UsuarioDTO> listarTodos() throws BusinessException;
}

