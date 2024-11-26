/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import dto.ComentarioDTO;
import entidades.Comentario;
import entidades.Publicacion;
import entidades.Usuario;

/**
 *
 * @author diana
 */
public class ComentarioCVR {

    private UsuarioCVR usuarioCVR;
    private PublicacionCVR publicacionCVR;

    public ComentarioCVR() {
        this.usuarioCVR = new UsuarioCVR();
        this.publicacionCVR = new PublicacionCVR();
    }

    public Comentario convertir_Comentario(ComentarioDTO dto) {
        if (dto == null) {
            return null;
        }

        Usuario autor = null;
        if (dto.getAutor() != null) {
            autor = usuarioCVR.convertir_Usuario(dto.getAutor());
        }

        Publicacion publicacion = null;
        if (dto.getPublicacion() != null) {
            publicacion = publicacionCVR.convertir_Publicacion(dto.getPublicacion());
        }

        return new Comentario(
            dto.getId(),
            dto.getContenido(),
            dto.getFechaComentario(),
            autor,
            publicacion
        );
    }

    public ComentarioDTO convertir_DTO(Comentario entidad) {
        if (entidad == null) {
            return null;
        }

        ComentarioDTO dto = new ComentarioDTO();
        dto.setId(entidad.getId());
        dto.setContenido(entidad.getContenido());
        dto.setFechaComentario(entidad.getFechaComentario());

        if (entidad.getAutor() != null) {
            dto.setAutor(usuarioCVR.convertir_DTO(entidad.getAutor()));
        }

        if (entidad.getPublicacion() != null) {
            dto.setPublicacion(publicacionCVR.convertir_DTO(entidad.getPublicacion()));
        }

        return dto;
    }
}

