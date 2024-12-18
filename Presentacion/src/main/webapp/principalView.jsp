<%-- 
    Página JSP: principal.jsp
    Creado el: 26 nov 2024
    Autor: Ruzzky
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<%
    // Verificar si el usuario está logueado mediante la sesión del servidor
    Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
    if (isLoggedIn == null || !isLoggedIn) {
        response.sendRedirect("indexView.jsp");
        return;
    }

    // Obtener el correo del usuario desde la sesión
    String userEmail = (String) session.getAttribute("userEmail");
%>
<%--
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Bienvenido AnimalSocial</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <link rel="stylesheet" href="stylesPrincipal.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=arrow_back_ios" />
        <script src="${pageContext.request.contextPath}/js/principal.js" defer></script>
        <script src="${pageContext.request.contextPath}/js/deslogueo.js" defer></script>
        
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
--%>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Bienvenido AnimalSocial</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesPrincipal.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=arrow_back_ios" />
    <script src="${pageContext.request.contextPath}/js/principal.js" defer></script>
    <script src="${pageContext.request.contextPath}/js/deslogueo.js" defer></script>
</head>
<body>
    
    <a href="indexView.jsp" class="back-button">
            <span class="material-symbols-outlined">
                arrow_back_ios
            </span>
        </a>
        <a href="perfilView.jsp" class="profile-button">👤</a>
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
            <a href="AnimalesTerrestresView.jsp" class="punto-interes punto-verde"></a>
            <a href="AnimalesMarView.jsp" class="punto-interes punto-azul"></a>
            <a href="AnimalesAereosView.jsp" class="punto-interes punto-gris"></a>
            <img src="${pageContext.request.contextPath}/imgs/nubes.png" alt="nubes">
            <div class="tierra"></div>
    </div>

</body>
</html>
