/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.webapps.register.mvc;

import BO.UsuarioBO;
import Interfaces.IUsuarioBO;
import com.google.gson.Gson;
import dto.UsuarioDTO;
import java.io.IOException;
import java.io.InputStreamReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author gamaliel
 */
@WebServlet(name = "registerController", urlPatterns = {"/registerController"})
public class registerController extends HttpServlet {

    private final IUsuarioBO usuarioBO = new UsuarioBO();

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
     
        // Configurar la respuesta para que sea JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Leer el cuerpo de la solicitud
        InputStreamReader reader = new InputStreamReader(request.getInputStream());
        Gson gson = new Gson();
        
        // Convertir directamente el flujo a un objeto UsuarioDTO
        UsuarioDTO usuarioNuevo = gson.fromJson(reader, UsuarioDTO.class);

        // Validación simple
        if (usuarioNuevo.getNombre() == null || usuarioNuevo.getCorreo() == null || usuarioNuevo.getContrasena() == null) {
            String jsonResponse = "{\"success\": false, \"message\": \"Todos los campos son obligatorios.\"}";
            response.getWriter().write(jsonResponse);
            return;
        }
        
        try {
            // Guardar el usuario
            usuarioBO.agregar(usuarioNuevo);

            // Responder con éxito
            String jsonResponse = "{\"success\": true, \"message\": \"¡Registro exitoso! Bienvenido a Animal Social.\"}";
            response.getWriter().write(jsonResponse);
        } catch (Exception e) {
            // Manejo de errores
            String jsonResponse = "{\"success\": false, \"message\": \"Hubox2 un problema al registrar al usuario: " + e.getMessage() + "\"}";
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
