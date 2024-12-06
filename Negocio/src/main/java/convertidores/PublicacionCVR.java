/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import dto.PublicacionDTO;
import dto.UsuarioDTO;
import entidades.Publicacion;
import entidades.Usuario;

/**
 *
 * @author diana
 */
public class PublicacionCVR {

    private final UsuarioCVR usuarioCVR;

    public PublicacionCVR() {
        this.usuarioCVR = new UsuarioCVR();
    }

    /**
     * Convierte un PublicacionDTO en una entidad Publicacion.
     * 
     * @param dto Objeto PublicacionDTO a convertir.
     * @return Entidad Publicacion convertida.
     */
    public Publicacion convertir_Publicacion(PublicacionDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Publicacion(
            dto.getId(),
            dto.getContenido(),
            dto.getFechaPublicacion(),
            dto.getAutor()
        );
    }

    /**
     * Convierte una entidad Publicacion en un PublicacionDTO.
     * 
     * @param entidad Entidad Publicacion a convertir.
     * @return Objeto PublicacionDTO convertido.
     */
    public PublicacionDTO convertir_DTO(Publicacion entidad) {
        if (entidad == null) {
            return null;
        }

        return new PublicacionDTO(
            entidad.getId(),
            entidad.getContenido(),
            entidad.getFechaPublicacion(),
            entidad.getAutor()
        );
    }
}
