/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import dto.ComentarioDTO;
import entidades.Comentario;
import entidades.Publicacion;
import entidades.Usuario;
import java.time.LocalDateTime;

/**
 *
 * @author diana
 */
public class ComentarioCVR {

    public ComentarioCVR() {
    }

    public Comentario convertir_Comentario(ComentarioDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Comentario(
            dto.getId(),
            dto.getContenido(),
            dto.getFechaComentario(),
            dto.getAutor(),
            dto.getPublicacion()
        );
    }

    public ComentarioDTO convertir_DTO(Comentario entidad) {
        if (entidad == null) {
            return null;
        }

        ComentarioDTO dto = new ComentarioDTO(
                entidad.getContenido(), 
                entidad.getFechaComentario(), 
                entidad.getAutor(), 
                entidad.getPublicacion());

        return dto;
    }
}

