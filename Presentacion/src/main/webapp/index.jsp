<%-- 
    Document   : index
    Created on : 23 nov 2024, 13:24:44
    Author     : gamaliel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css"/>
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
        <title>AnimalSocial</title>
    </head>
    
    <body>
        <header>
            <div class="bienvenida" id="texto-bienvenida">
                <h1 title="bienvenida">AnimalSocial</h1>
            </div>
        </header>

        <section class="section" id="login-section">
            <h4>Inicio de Sesión</h4>

            <form id="loginForm">
                <div class="form-group">
                    <i class="uil uil-at"></i>
                    <input type="email" id="loginEmail" placeholder="Correo Electrónico" required>
                    <span class="error-message" id="loginEmailError"></span>
                </div>

                <div class="form-group">
                    <i class="uil uil-lock-alt"></i>
                    <input type="password" id="loginPassword" placeholder="Contraseña" required>
                    <span class="error-message" id="loginPasswordError"></span>
                </div>

                <p><a href="recuperarContraseña.html" class="link">¿Olvidaste tu contraseña?</a></p>

                <button type="submit" class="btn btn-primary">Iniciar Sesión</button>

                <p class="text-center mt-3">
                    ¿Aún no tienes cuenta? <a href="registro.jsp" class="link">Regístrate aquí</a>
                </p>
            </form>
        </section>
    </body>
</html>
