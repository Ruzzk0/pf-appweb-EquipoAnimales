/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import conexion.ConexionBD;
import entidades.Usuario;
import excepciones.DAOException;
import interfaces.Daos.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;

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
            List<Usuario> list = this.listarTodos();
            int id =0;
            if(list != null){
                id = list.getLast().getId();
                id ++;
            }
            
            usuario.setId(id);
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
     * @param usuario
     * @return El usuario encontrado o null si no existe.
     * @throws DAOException Si ocurre un error durante la búsqueda.
     */
    @Override
    public Usuario buscarPorCorreo(Usuario usuario) throws DAOException {
        try {
            String correo = usuario.getCorreo();
            String contrasena = usuario.getContrasena();
            return usuarioCollection.find( Filters.and(
                    Filters.eq("correo", correo),
                    Filters.eq("contrasena", contrasena)
            )).first();
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
            return null;
        }
    }

        /**
     * Actualiza un usuario existente en la base de datos.
     * 
     * @param id El identificador único del usuario a actualizar.
     * @param usuario Los datos actualizados del usuario.
     * @throws DAOException Si ocurre un error durante la operación o si no se encuentra el usuario.
     */
    @Override
    public void actualizar(int id, Usuario usuario) throws DAOException {
        try {
            Bson updates = Updates.combine(
                Updates.set("nombre", usuario.getNombre()),
                Updates.set("correo", usuario.getCorreo()),
                Updates.set("contrasena", usuario.getContrasena())
            );

            UpdateResult resultado = usuarioCollection.updateOne(Filters.eq("id", id), updates);

            if (resultado.getMatchedCount() == 0) {
                throw new DAOException("No se encontró ningún usuario con el ID especificado.");
            }
        } catch (Exception e) {
            throw new DAOException("Error al actualizar el usuario: " + e.getMessage(), e);
        }
    }

    /**
     * Elimina un usuario por su identificador único (ID).
     * 
     * @param id El identificador único del usuario a eliminar.
     * @throws DAOException Si ocurre un error durante la operación o si no se encuentra el usuario.
     */
    @Override
    public void eliminar(int id) throws DAOException {
        try {
            DeleteResult resultado = usuarioCollection.deleteOne(Filters.eq("id", id));
            if (resultado.getDeletedCount() == 0) {
                throw new DAOException("No se encontró ningún usuario con el ID especificado.");
            }
        } catch (Exception e) {
            throw new DAOException("Error al eliminar el usuario: " + e.getMessage(), e);
        }
    }
}

