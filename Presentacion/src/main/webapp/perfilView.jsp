<%-- 
    Document   : perfilView
    Created on : 26 nov 2024, 23:28:37
    Author     : Ruzzky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Perfil</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesPerfil.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn-uicons.flaticon.com/2.6.0/uicons-bold-rounded/css/uicons-bold-rounded.css">
        <link rel="stylesheet" href="https://cdn-uicons.flaticon.com/2.6.0/uicons-solid-straight/css/uicons-solid-straight.css">
    </head>
    <body>
        <header class="sticky-header">
            <a href="${pageContext.request.contextPath}/principalView.jsp" class="back-button">
                <span class="material-icons">arrow_back_ios</span>
            </a>
            <h1>ANIMAL SOCIAL</h1>
        </header>

        <div class="cuerpo">
            <label id="textoPerfil">PERFIL</label>
            <div id="logo">
                <div class="imagen-container">
                    <img src="${pageContext.request.contextPath}/imagenesPerfil/dog.jpg" 
                         alt="Perfil" class="imagen-perfil" id="imagenPerfil">
                    <label for="fileInput" class="camera-icon">
                        <i class="fi fi-br-camera"></i>
                    </label>
                    <input type="file" id="fileInput" accept="image/*" class="hidden">
                </div>
                <div class="profile-info">
                    <label id="nombre">Nombre del usuario</label>
                    <label id="representa">Me representa...</label>
                    
                    <div id="colorOptions" class="hidden">
                        <button class="bando-terrestre" onclick="handleTeamChange('terrestre')">Bando Terrestre</button>
                        <button class="bando-acuatico" onclick="handleTeamChange('acuatico')">Bando Acuático</button>
                        <button class="bando-aereo" onclick="handleTeamChange('aereo')">Bando Aéreo</button>
                    </div>
                    
                    <button id="editProfileButton" onclick="toggleEditMode()">Editar Perfil</button>
                    <button id="saveChangesButton" class="hidden" onclick="saveChanges()">Guardar Cambios</button>
                </div>
            </div>
        </div>
        
        <!-- Script para el manejo del perfil -->
        <script src="${pageContext.request.contextPath}/js/perfil.js"></script>
    </body>
</html>
