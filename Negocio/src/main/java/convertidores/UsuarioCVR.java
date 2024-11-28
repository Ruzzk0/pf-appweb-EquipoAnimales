/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import dto.UsuarioDTO;
import entidades.Usuario;

/**
 *
 * @author diana
 */

  public class UsuarioCVR {

    /**
     * Convierte un UsuarioDTO en una entidad Usuario.
     * 
     * @param dto Objeto UsuarioDTO a convertir.
     * @return Entidad Usuario convertida.
     */
    public Usuario convertir_Usuario(UsuarioDTO dto) {
        if (dto == null) {
            return null;
        }

        int id = dto.getId() >= 0 ? dto.getId() : -1; // Asegura un ID válido solo si está configurado.

        Usuario usuario = new Usuario(
                id,
                dto.getNombre(),
                dto.getCorreo(),
                dto.getContrasena(),
                dto.getBando(),
                dto.getCiudad(),
                dto.getEstado(),
                dto.getFechaNacimiento(),
                dto.getGenero(),
                dto.getTelefono(),
                dto.getPais(),
                dto.isAdministrador()
        );
        return usuario;
    }
    
    public Usuario convertir_Usuario_Sin_Id(UsuarioDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Usuario usuario = new Usuario(
                dto.getNombre(),
                dto.getCorreo(),
                dto.getContrasena(),
                dto.getBando(),
                dto.getCiudad(),
                dto.getEstado(),
                dto.getFechaNacimiento(),
                dto.getGenero(),
                dto.getTelefono(),
                dto.getPais(),
                dto.isAdministrador());

        return usuario;
    }

    /**
     * Convierte una entidad Usuario en un UsuarioDTO.
     * 
     * @param entidad Entidad Usuario a convertir.
     * @return Objeto UsuarioDTO convertido.
     */
    public UsuarioDTO convertir_DTO(Usuario entidad) {
        int id = -1;
        if (entidad == null) {
            return null;
        }
        
        if(entidad.getId() >= 0){
            id = entidad.getId();
        }
        
        UsuarioDTO usuarioDTO =new UsuarioDTO(
            id,
            entidad.getNombre(),
            entidad.getCorreo(),
            entidad.getContrasena(),
                entidad.getBando(),
                entidad.getCiudad(),
                entidad.getEstado(),
                entidad.getFechaNacimiento(),
                entidad.getGenero(),
                entidad.getTelefono(),
                entidad.getPais(),
            entidad.isAdministrador()
        );

        return usuarioDTO;
    }
    
    public UsuarioDTO convertir_DTO_Sin_Id(Usuario entidad) {
        if (entidad == null) {
            return null;
        }
        
        UsuarioDTO usuarioDTO =new UsuarioDTO(
            entidad.getNombre(),
            entidad.getCorreo(),
            entidad.getContrasena(),
            entidad.isAdministrador()
        );

        return usuarioDTO;
    }
}
  

