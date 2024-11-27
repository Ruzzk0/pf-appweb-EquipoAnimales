<%-- 
    Document   : index
    Created on : 23 nov 2024, 13:24:44
    Author     : gamaliel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>AnimalSocial - Inicio de Sesión</title>
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
        <script src="${pageContext.request.contextPath}/js/login.js" defer></script>
    </head>
    <body>
        <header>
            <div class="bienvenida" id="texto-bienvenida">
                <h1 title="bienvenida">AnimalSocial</h1>
            </div>
        </header>

        <section class="section" id="login-section">
            <h4>Inicio de Sesión</h4>
            
            <form id="loginForm" action="${pageContext.request.contextPath}/indexController" method="post">
                <div class="form-group">
                    <i class="uil uil-at"></i>
                    <input type="email" id="loginEmail" name="email" placeholder="Correo Electrónico" required>
                    <span class="error-message" id="loginEmailError"></span>
                </div>
                
                <div class="form-group">
                    <i class="uil uil-lock-alt"></i>
                    <input type="password" id="loginPassword" name="password" placeholder="Contraseña" required>
                    <span class="error-message" id="loginPasswordError"></span>
                </div>

                <p><a href="recuperarContraseña.html" class="link">¿Olvidaste tu contraseña?</a></p>

                <button type="submit" class="btn btn-primary">Iniciar Sesión</button>

                <p class="text-center mt-3">
                    ¿Aún no tienes cuenta? <a href="registerView.jsp" class="link">Regístrate aquí</a>
                </p>
            </form>

            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger">${errorMessage}</div>
            </c:if>
        </section>
    </body>
</html>
