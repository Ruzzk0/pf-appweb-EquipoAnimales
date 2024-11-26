/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.Daos;

import entidades.Usuario;
import excepciones.DAOException;
import java.util.List;

/**
 *
 * @author diana
 */
public interface IUsuarioDAO  {
     /**
     * Agrega un nuevo usuario a la base de datos.
     * 
     * @param usuario El usuario a agregar.
     * @throws DAOException Si ocurre un error al agregar el usuario.
     */
    public void agregar(Usuario usuario) throws DAOException;

    /**
     * Busca un usuario por su ID.
     * 
     * @param id El identificador único del usuario.
     * @return El usuario encontrado o null si no existe.
     * @throws DAOException Si ocurre un error al buscar el usuario.
     */
    public Usuario buscarPorId(int id) throws DAOException;
    
    public Usuario buscarPorCorreo(Usuario usuario) throws DAOException;

    /**
     * Lista todos los usuarios almacenados en la base de datos.
     * 
     * @return Una lista de usuarios.
     * @throws DAOException Si ocurre un error al listar los usuarios.
     */
    public List<Usuario> listarTodos() throws DAOException;
}

