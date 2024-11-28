<%-- 
    Document   : NuevaPublicacionView
    Created on : 27 nov 2024, 21:39:33
    Author     : Ruzzky
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Publicación</title>
    <link rel="stylesheet" href="stylesNuevaPublicacion.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<body>
    <header class="sticky-header">
        <a href="principal.jsp" class="back-button">
            <span class="material-icons">arrow_back_ios</span>
        </a>
        <h1>ANIMAL SOCIAL</h1>
    </header>
    
    <div class="title">
        <h2>¿Qué quieres publicar?</h2>
    </div>

    <div class="form-container">
        <!-- Cambia el action al servlet que recibirá los datos -->
        <form id="formPublicar" action="NuevaPublicacionServlet" method="post" enctype="multipart/form-data" class="formularioPublicacion">
            <div class="form-group">
                <label for="nombreAnimalPost">Nombre del animal:</label>
                <input id="nombreAnimalPost" name="nombre" type="text" placeholder="Ingresa el nombre del animal" required>
            </div>
            <div class="form-group">
                <label for="tamañoAnimalPost">Tamaño del animal:</label>
                <textarea id="tamañoAnimalPost" name="tamaño" placeholder="Ingresa el tamaño del animal" required></textarea>
            </div>
            <div class="form-group">
                <label for="caracteristicasAnimalPost">Características del animal:</label>
                <textarea id="caracteristicasAnimalPost" name="caracteristicas" placeholder="Ingresa las características del animal" required></textarea>
            </div>
            <div class="form-group">
                <label for="dietaAnimalPost">Dieta del animal:</label>
                <textarea id="dietaAnimalPost" name="dieta" placeholder="Ingresa la dieta del animal" required></textarea>
            </div>
            <div class="form-group">
                <label for="habitadAnimalPost">Hábitat del animal:</label>
                <textarea id="habitadAnimalPost" name="habitat" placeholder="Ingresa el hábitat del animal" required></textarea>
            </div>
            <div class="form-group">
                <label for="imagenPost">Imagen del animal:</label>
                <input type="file" id="imagenPost" name="imagen" accept="image/*">
            </div>
            <button type="submit" id="btnPublicar">Publicar</button>
        </form>
    </div>

    <script src="nuevaPublicacion.js"></script>
</body>

</html>
