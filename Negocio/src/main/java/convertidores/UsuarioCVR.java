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
        int id = -1;
        
        if (dto == null) {
            return null;
        }
        
        if(dto.getId() >=0){
            id = dto.getId();
        }
        
        Usuario usuario = new Usuario(id,
            dto.getNombre(),
            dto.getCorreo(),
            dto.getContrasena(),
            dto.getAdministrador(),
            dto.getVisitante());

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
            dto.getAdministrador(),
            dto.getVisitante());

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
            entidad.getAdministrador(),
            entidad.getVisitante()
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
            entidad.getAdministrador(),
            entidad.getVisitante()
        );

        return usuarioDTO;
    }
}
  

