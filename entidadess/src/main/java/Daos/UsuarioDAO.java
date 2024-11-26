/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import conexion.ConexionBD;
import entidades.Usuario;
import excepciones.DAOException;
import interfaces.Daos.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diana
 */

/**
 * Clase que implementa la interfaz IUsuarioDAO para gestionar las operaciones
 * CRUD relacionadas con los usuarios en una base de datos MongoDB.
 */
public class UsuarioDAO implements IUsuarioDAO {
    private final MongoCollection<Usuario> usuarioCollection;

    /**
     * Constructor por defecto.
     * Inicializa la conexión a la colección "Usuarios" en la base de datos.
     */
    public UsuarioDAO() {
        this.usuarioCollection = ConexionBD.getInstance().getDatabase()
            .getCollection("Usuarios", Usuario.class);
    }

    /**
     * Agrega un nuevo usuario a la base de datos.
     * 
     * @throws DAOException Si ocurre un error durante la operación de inserción.
     */
    @Override
    public void agregar(Usuario usuario) throws DAOException {
        try {
            usuarioCollection.insertOne(usuario);
        } catch (Exception e) {
            throw new DAOException("Error al agregar el usuario: " + e.getMessage(), e);
        }
    }

   
    
    /**
     * Busca un usuario por su identificador único (ID).
     * 
     * @param id El identificador único del usuario.
     * @return El usuario encontrado o null si no existe.
     * @throws DAOException Si ocurre un error durante la búsqueda.
     */
    @Override
    public Usuario buscarPorId(int id) throws DAOException {
        try {
            return usuarioCollection.find(Filters.eq("id", id)).first();
        } catch (Exception e) {
            throw new DAOException("Error al buscar el usuario por ID: " + e.getMessage(), e);
        }
    }

     /**
     * Busca un usuario por su dirección de correo electrónico.
     * 
     * @param correo El correo electrónico del usuario.
     * @return El usuario encontrado o null si no existe.
     * @throws DAOException Si ocurre un error durante la búsqueda.
     */
    public Usuario buscarPorCorreo(String correo) throws DAOException {
        try {
            return usuarioCollection.find(Filters.eq("correo", correo)).first();
        } catch (Exception e) {
            throw new DAOException("Error al buscar el usuario por correo: " + e.getMessage(), e);
        }
    }

    /**
     * Lista todos los usuarios almacenados en la base de datos.
     * 
     * @return Una lista de todos los usuarios en la colección.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    @Override
    public List<Usuario> listarTodos() throws DAOException {
        try {
            List<Usuario> usuarios = new ArrayList<>();
            MongoCursor<Usuario> cursor = usuarioCollection.find().iterator();
            while (cursor.hasNext()) {
                usuarios.add(cursor.next());
            }
            cursor.close();
            return usuarios;
        } catch (Exception e) {
            throw new DAOException("Error al listar todos los usuarios: " + e.getMessage(), e);
        }
    }

    
}
