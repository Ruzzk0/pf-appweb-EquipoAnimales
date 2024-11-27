<%-- 
    Página JSP: principal.jsp
    Creado el: 26 nov 2024
    Autor: Ruzzky
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    // Verificar si el usuario está logueado
    String isLoggedIn = (String) session.getAttribute("isLoggedIn");
    if (isLoggedIn == null || !isLoggedIn.equals("true")) {
        response.sendRedirect("index.jsp");
        return;
    }

    String userEmail = (String) session.getAttribute("userEmail");
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Bienvenido AnimalSocial</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <link rel="stylesheet" href="stylesPrincipal.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=arrow_back_ios" />
        <script src="scripts/principal.js" defer></script>
    </head>

    <body>
        <a href="index.jsp" class="back-button">
            <span class="material-symbols-outlined">
                arrow_back_ios
            </span>
        </a>
        <a href="perfil.jsp" class="profile-button">👤</a>
        <h1>AnimalSocial</h1>
        
        <div class="estrella impar primera"></div>
        <div class="estrella par segunda"></div>
        <div class="estrella impar tercera"></div>
        <div class="estrella par cuarta"></div>
        <div class="estrella impar quinta"></div>
        <div class="estrella par sexta"></div>
        <div class="estrella impar septima"></div>
        <div class="estrella par octava"></div>

        <div class="nubes">
            <a href="AnimalesTerrestres.jsp" class="punto-interes punto-verde"></a>
            <a href="AnimalesMar.jsp" class="punto-interes punto-azul"></a>
            <a href="AnimalesAereos.jsp" class="punto-interes punto-gris"></a>
            <img src="img/nubes.png" alt="nubes">
            <div class="tierra"></div>
        </div>
    </body>
</html>
