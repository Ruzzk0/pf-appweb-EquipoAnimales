/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Dell
 */
public class ImagenCRV {

    // Convertir un archivo de imagen a bytes
    public byte[] convertirImagenABytes(File archivoImagen, String formato) throws IOException {
        // Aseguramos que el formato sea válido
        if (!(formato.equalsIgnoreCase("png") || formato.equalsIgnoreCase("jpg") || formato.equalsIgnoreCase("jpeg"))) {
            throw new IllegalArgumentException("Formato de imagen no soportado: " + formato);
        }

        // Leer el archivo y convertirlo a BufferedImage
        BufferedImage bufferedImage = ImageIO.read(archivoImagen);
        if (bufferedImage == null) {
            throw new IOException("No se pudo leer la imagen desde el archivo.");
        }

        // Convertir la imagen en bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, formato, baos);
        baos.flush();
        return baos.toByteArray();
    }

    // Convertir un array de bytes a una imagen
    public BufferedImage convertirBytesAImagen(byte[] datos) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(datos);
        return ImageIO.read(bais);  // Regresa un BufferedImage
    }

    // Detectar el formato de la imagen a partir de un archivo
    public String detectarFormato(File archivoImagen) throws IOException {
        // Usamos ImageInputStream para leer el archivo
        ImageInputStream input = ImageIO.createImageInputStream(archivoImagen);

        if (input == null) {
            throw new IOException("No se pudo crear un flujo de entrada para los datos de la imagen.");
        }

        // Detectar el formato leyendo los lectores de la imagen
        Iterator<ImageReader> readers = ImageIO.getImageReaders(input);
        if (!readers.hasNext()) {
            throw new IOException("Formato de imagen no reconocido o datos inválidos.");
        }

        return readers.next().getFormatName().toLowerCase();  // Retorna el formato de la imagen
    }
    
     // Convertir un array de bytes a una cadena Base64
    public String convertirBytesAImagenBase64(byte[] datosImagen) {
        return Base64.getEncoder().encodeToString(datosImagen);
    }
}
