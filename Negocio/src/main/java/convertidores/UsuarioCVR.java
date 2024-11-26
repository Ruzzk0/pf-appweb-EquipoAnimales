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

        return new Usuario(
            dto.getId(),
            dto.getNombre(),
            dto.getCorreo(),
            dto.getContrasena(),
            dto.getAdministrador(),
            dto.getVisitante()
        );
    }

    /**
     * Convierte una entidad Usuario en un UsuarioDTO.
     * 
     * @param entidad Entidad Usuario a convertir.
     * @return Objeto UsuarioDTO convertido.
     */
    public UsuarioDTO convertir_DTO(Usuario entidad) {
        if (entidad == null) {
            return null;
        }

        return new UsuarioDTO(
            entidad.getId(),
            entidad.getNombre(),
            entidad.getCorreo(),
            entidad.getContrasena(),
            entidad.getAdministrador(),
            entidad.getVisitante()
        );
    }
}
  

