/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import dto.PublicacionDTO;
import dto.UsuarioDTO;
import entidades.Publicacion;
import entidades.Usuario;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;

/**
 *
 * @author diana
 */
public class PublicacionCVR {

    private final UsuarioCVR usuarioCVR;
    private final ImagenCRV imagenCVR;

    public PublicacionCVR() {
        this.usuarioCVR = new UsuarioCVR();
        this.imagenCVR = new ImagenCRV();
    }

    /**
     * Convierte un PublicacionDTO en una entidad Publicacion.
     *
     * @param dto Objeto PublicacionDTO a convertir.
     * @return Entidad Publicacion convertida.
     */
    public Publicacion convertir_Publicacion(PublicacionDTO dto) throws IOException {
        if (dto == null) {
            return null;
        }

        String formato = imagenCVR.detectarFormato(dto.getImagen());

        byte[] imagen = imagenCVR.convertirImagenABytes(dto.getImagen(), formato);

        Publicacion publi = new Publicacion(
                imagen,
                formato,
                dto.getNombreAnimal(),
                dto.getTamanoAnimal(),
                dto.getCaracteristicas(),
                dto.getDieta(),
                dto.getHabitat(),
                dto.getAutor()
        );

        return publi;
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
        
        String imagen = imagenCVR.convertirBytesAImagenBase64(entidad.getImagen());

        PublicacionDTO publi = new PublicacionDTO( 
                entidad.getNombreAnimal(), 
                entidad.getTamanoAnimal(), 
                entidad.getCaracteristicas(), 
                entidad.getDieta(), 
                entidad.getHabitat(), 
                entidad.getAutor(),
                imagen
        );

        return publi;
    }
}
