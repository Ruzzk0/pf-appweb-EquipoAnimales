/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.webapps.index.mvc;

import BO.UsuarioBO;
import com.google.gson.Gson;
import dto.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.InputStreamReader;

/**
 *
 * @author gamaliel
 */
@WebServlet(name = "indexController", urlPatterns = {"/indexController"})
public class indexController extends HttpServlet {

    UsuarioBO usuarioBO = new UsuarioBO();

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
            out.println("<title>Servlet indexController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet indexController at " + request.getContextPath() + "</h1>");
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
        // Configurar la respuesta para que sea JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        UsuarioDTO usuarioNuevo;
        try {
            // Leer el cuerpo de la solicitud y convertir a UsuarioDTO
            InputStreamReader reader = new InputStreamReader(request.getInputStream());
            Gson gson = new Gson();
            usuarioNuevo = gson.fromJson(reader, UsuarioDTO.class);
        } catch (Exception e) {
            String jsonResponse = "{\"success\": false, \"message\": \"Entrada JSON mal formateada.\"}";
            response.getWriter().write(jsonResponse);
            return;
        }

        // Validar que los campos no estén vacíos o sean nulos
        if (usuarioNuevo.getCorreo() == null || usuarioNuevo.getCorreo().isBlank()
                || usuarioNuevo.getContrasena() == null || usuarioNuevo.getContrasena().isBlank()) {
            String jsonResponse = "{\"success\": false, \"message\": \"Todos los campos son obligatorios.\"}";
            response.getWriter().write(jsonResponse);
            return;
        }

        try {
            // Buscar al usuario
            UsuarioDTO us = usuarioBO.buscarPorCorreo(usuarioNuevo);

            if (us != null) {
                // Usuario encontrado
                HttpSession session = request.getSession();
                session.setAttribute("isLoggedIn", true);  // Establecer que el usuario está logueado
                session.setAttribute("userEmail", us.getCorreo());

                String jsonResponse = "{\"success\": true, \"message\": \"¡Inicio exitoso! Bienvenido a Animal Social.\"}";
                response.getWriter().write(jsonResponse);
            } else {
                // Usuario no encontrado
                String jsonResponse = "{\"success\": false, \"message\": \"Correo o contraseña incorrectos.\"}";
                response.getWriter().write(jsonResponse);
            }
        } catch (Exception e) {
            // Manejo de errores
            String jsonResponse = "{\"success\": false, \"message\": \"Hubo un problema al iniciar sesión: " + e.getMessage() + "\"}";
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
