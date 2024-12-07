/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.webapps.nuevaPublicacion.mvc;

import BO.PublicacionBO;
import Interfaces.IPublicacionBO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dto.PublicacionDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.time.LocalDateTime;

/**
 *
 * @author gamaliel
 */
@WebServlet(name = "NuevaPublicacionController", urlPatterns = {"/NuevaPublicacionController"})
public class NuevaPublicacionController extends HttpServlet {

        private final IPublicacionBO publicacionBO = new PublicacionBO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Crear el objeto JSON de respuesta
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("success", false);  // Default
            jsonResponse.addProperty("message", "Ocurrió un error inesperado");

            // Aquí iría el código de procesamiento de la publicación (por ejemplo, cargar datos, guardar, etc.)
            try {
                // Simulamos el procesamiento y enviamos éxito
                jsonResponse.addProperty("success", true);
                jsonResponse.addProperty("message", "¡Registro exitoso!");
            } catch (Exception e) {
                jsonResponse.addProperty("message", "Error al procesar la publicación: " + e.getMessage());
            }

            // Escribir la respuesta JSON
            Gson gson = new Gson();
            out.print(gson.toJson(jsonResponse));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        try {
            // Directorio temporal para guardar el archivo
            String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir(); // Crear el directorio si no existe
            }

            // Extraer la parte del archivo
            Part imagenPart = request.getPart("imagen");
            String fileName = imagenPart.getSubmittedFileName();
            String filePath = uploadPath + File.separator + fileName;

            if (imagenPart != null && imagenPart.getSize() > 0) {
                imagenPart.write(filePath); // Guardar el archivo en el servidor
            }

            // Extraer otros parámetros del formulario
            String nombreAnimal = request.getParameter("nombreAnimal");
            String tamanoAnimal = request.getParameter("tamanoAnimal");
            String caracteristicas = request.getParameter("caracteristicas");
            String dieta = request.getParameter("dieta");
            String habitat = request.getParameter("habitat");
            long autor = Long.parseLong(request.getParameter("autor"));
            LocalDateTime fechaPublicacion = LocalDateTime.now();

            // Crear DTO con los datos
            PublicacionDTO publicacionNueva = new PublicacionDTO();
            publicacionNueva.setNombreAnimal(nombreAnimal);
            publicacionNueva.setTamanoAnimal(tamanoAnimal);
            publicacionNueva.setCaracteristicas(caracteristicas);
            publicacionNueva.setDieta(dieta);
            publicacionNueva.setHabitat(habitat);
            publicacionNueva.setAutor(autor);
            publicacionNueva.setFechaPublicacion(fechaPublicacion);
            publicacionNueva.setImagen(new File(filePath)); // Guardamos el archivo como File o puede ser la ruta

            // Guardar la publicación en la capa BO
            publicacionBO.agregar(publicacionNueva);

            // Responder con éxito
            String jsonResponse = "{\"success\": true, \"message\": \"¡Registro exitoso!\"}";
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse);
        } catch (Exception e) {
            // Manejo de errores
            String jsonResponse = "{\"success\": false, \"message\": \"Error al registrar la publicación: " + e.getMessage() + "\"}";
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
