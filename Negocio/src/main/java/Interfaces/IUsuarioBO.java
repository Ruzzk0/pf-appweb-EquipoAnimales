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
    public UsuarioDTO buscarPorId(int id) throws BusinessException;
    
    public UsuarioDTO buscarPorCorreo(UsuarioDTO usuarioDTO) throws BusinessException;

}

