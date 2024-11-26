<%-- 
    Document   : registro
    Created on : 23 nov 2024, 13:44:02
    Author     : gamaliel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Registro</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylesRegistro.css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/jsCountries.js"></script>
    </head>
    <body>   

        <header class="sticky-header">
            <a href="indexView.jsp" class="back-button">
                <span class="material-icons">arrow_back_ios</span>
            </a>
            <h1>ANIMAL SOCIAL</h1>
        </header>


        <section class="section" id="register-section">
            <h4 title="texto-Registro">Registrarse</h4>
            <form id="registroForm"  action="${pageContext.request.contextPath}/register" method="post">
                <div class="form-group">
                    <input type="text" placeholder="Nombre Completo" id="nombre" required>
                    <i class="uil uil-user"></i>
                    <span class="error-message" id="nombreError"></span>
                </div>
                <div class="form-group">
                    <input type="email" placeholder="Correo Electrónico" id="email" required>
                    <i class="uil uil-at"></i>
                    <span class="error-message" id="emailError"></span>
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Contraseña (mín. 8 caracteres, mayúscula, minúscula)" id="password" required>
                    <i class="uil uil-lock-alt"></i>
                    <span class="error-message" id="passwordError"></span>
                </div>
                <div class="form-group">
                    <select id="pais" required>
                        <option value="">Selecciona tu país</option>
                    </select>
                    <i class="uil uil-globe"></i>
                    <span class="error-message" id="paisError"></span>
                </div>
                <div class="form-group">
                    <select id="estado" required>
                        <option value="">Selecciona tu estado</option>
                    </select>
                    <i class="uil uil-map-pin"></i>
                    <span class="error-message" id="estadoError"></span>
                </div>
                <div class="form-group">
                    <select id="ciudad" required>
                        <option value="">Selecciona tu ciudad</option>
                    </select>
                    <i class="uil uil-city"></i>
                    <span class="error-message" id="ciudadError"></span>
                </div>
                <div class="form-group">
                    <input type="tel" placeholder="Teléfono" id="telefono" required>
                    <i class="uil uil-phone"></i>
                    <span class="error-message" id="telefonoError"></span>
                </div>
                <div class="form-group">
                    <input type="date" placeholder="Fecha de Nacimiento" id="fechaNacimiento" required>
                    <i class="uil uil-calendar-alt"></i>
                    <span class="error-message" id="fechaNacimientoError"></span>
                </div>
                <div class="radio-group">
                    <label><input type="radio" name="genero" value="hombre" required> Hombre</label>
                    <label><input type="radio" name="genero" value="mujer" required> Mujer</label>
                    <label><input type="radio" name="genero" value="no-binario" required> No binario</label>
                    <span class="error-message" id="generoError"></span>
                </div>
                <div class="form-group">
                    <select id="bando" required>
                        <option value="">Selecciona tu bando</option>
                        <option value="terrestre">Animales Terrestres</option>
                        <option value="marino">Animales Marinos</option>
                        <option value="aereo">Animales Aéreos</option>
                    </select>
                    <i class="uil uil-users-alt"></i>
                    <span class="error-message" id="bandoError"></span>
                </div>

                <button type="submit" class="btn btn-success" id="btnRegistro">Registrarse</button>
            </form>
        </section>
    </body>
</html>
