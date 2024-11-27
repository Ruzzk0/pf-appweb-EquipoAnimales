/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.webapps.register.mvc;

import BO.UsuarioBO;
import Interfaces.IUsuarioBO;
import dto.UsuarioDTO;
import excepciones.BusinessException;
import java.io.IOException;
import java.io.PrintWriter;
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
        request.setCharacterEncoding("UTF-8");
        System.out.println("gola");

        // 1. Obtener datos del formulario
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String contrasena = request.getParameter("password");
        String pais = request.getParameter("pais");
        String estado = request.getParameter("estado");
        String ciudad = request.getParameter("ciudad");
        String telefono = request.getParameter("telefono");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String genero = request.getParameter("genero");
        String bando = request.getParameter("bando");

        // 2. Validar datos (ejemplo básico)
        if (nombre == null || nombre.trim().isEmpty()
                || email == null || email.trim().isEmpty()
                || contrasena == null || contrasena.trim().isEmpty()
                || bando == null || bando.trim().isEmpty()) {
            // Redirigir a una página de error
            request.setAttribute("error", "Por favor completa todos los campos obligatorios.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        try {
            // 3. Crear objeto UsuarioDTO
            UsuarioDTO usuarioNuevo = new UsuarioDTO(
                    nombre, email, contrasena, bando, ciudad, estado, pais, genero, telefono, fechaNacimiento
            );

            usuarioBO.agregar(usuarioNuevo);

            // 5. Redirigir a la página de éxito
            request.setAttribute("mensaje", "¡Registro exitoso! Bienvenido a Animal Social.");
            request.getRequestDispatcher("indexView.jsp").forward(request, response);
        } catch (BusinessException ex) {
            // 6. Manejo de errores y redirección
            request.setAttribute("error", "Hubo un problema al registrar al usuario: " + ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
