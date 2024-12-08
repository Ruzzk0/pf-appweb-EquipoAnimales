/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.webapps.comentarios;

import BO.ComentarioBO;
import Interfaces.IComentarioBO;
import com.google.gson.Gson;
import dto.ComentarioDTO;
import dto.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author gamaliel
 */
@WebServlet(name = "registrarComentariosController", urlPatterns = {"/registrarComentariosController"})
public class registrarComentariosController extends HttpServlet {

    private final IComentarioBO comentarioBO = new ComentarioBO();
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registrarComentariosController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registrarComentariosController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        // Establecer la codificación
        request.setCharacterEncoding("UTF-8");

        // Leer el cuerpo de la solicitud como JSON
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        // Usamos Gson para convertir el JSON en un objeto Java
        Gson gson = new Gson();
        ComentarioDTO comentarioNuevo = gson.fromJson(stringBuilder.toString(), ComentarioDTO.class);

        try {
            // Guardar el comentario
            comentarioBO.agregar(comentarioNuevo);

            // Responder con éxito
            String jsonResponse = "{\"success\": true, \"message\": \"¡Comentario registrado exitosamente!\"}";
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse);
        } catch (Exception e) {
            // Manejo de errores
            String jsonResponse = "{\"success\": false, \"message\": \"Hubo un problema al registrar el comentario: " + e.getMessage() + "\"}";
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
