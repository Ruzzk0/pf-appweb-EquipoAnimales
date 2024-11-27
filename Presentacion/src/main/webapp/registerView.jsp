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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro - Animal Social</title>
    
    <!-- CSS Stylesheet -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylesRegistro.css">
    
    <!-- Icon Fonts -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    
    <!-- JavaScript Files -->
    <script src="${pageContext.request.contextPath}/js/jsCountries.js" defer></script>
    <script src="${pageContext.request.contextPath}/js/jsRegister.js" defer></script>
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
        <form id="registroForm" action="${pageContext.request.contextPath}/registerController" method="POST">
            <div class="form-group">
                <input type="text" placeholder="Nombre Completo" id="nombre" name="nombre" required>
                <i class="uil uil-user"></i>
                <span class="error-message" id="nombreError"></span>
            </div>
            
            <div class="form-group">
                <input type="email" placeholder="Correo Electrónico" id="email" name="email" required>
                <i class="uil uil-at"></i>
                <span class="error-message" id="emailError"></span>
            </div>
            
            <div class="form-group">
                <input type="password" placeholder="Contraseña (mín. 8 caracteres, mayúscula, minúscula)" id="password" name="password" required>
                <i class="uil uil-lock-alt"></i>
                <span class="error-message" id="passwordError"></span>
            </div>
            
            <div class="form-group">
                <select id="pais" name="pais" required>
                    <option value="">Selecciona tu país</option>
                </select>
                <i class="uil uil-globe"></i>
                <span class="error-message" id="paisError"></span>
            </div>
            
            <div class="form-group">
                <select id="estado" name="estado" required>
                    <option value="">Selecciona tu estado</option>
                </select>
                <i class="uil uil-map-pin"></i>
                <span class="error-message" id="estadoError"></span>
            </div>
            
            <div class="form-group">
                <select id="ciudad" name="ciudad" required>
                    <option value="">Selecciona tu ciudad</option>
                </select>
                <i class="uil uil-city"></i>
                <span class="error-message" id="ciudadError"></span>
            </div>
            
            <div class="form-group">
                <input type="tel" placeholder="Teléfono" id="telefono" name="telefono" required>
                <i class="uil uil-phone"></i>
                <span class="error-message" id="telefonoError"></span>
            </div>
            
            <div class="form-group">
                <input type="date" placeholder="Fecha de Nacimiento" id="fechaNacimiento" name="fechaNacimiento" required>
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
                <select id="bando" name="bando" required>
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