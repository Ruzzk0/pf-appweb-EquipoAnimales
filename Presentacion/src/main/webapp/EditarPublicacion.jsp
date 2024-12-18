<%-- 
    Document   : EditarPublicacion
    Created on : 28 nov 2024, 8:40:29 p.m.
    Author     : diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Publicación</title>
    <link rel="stylesheet" href="stylesP.css">
</head>
<body>
    <div class="form-container">
        <h2>Editar Publicación</h2>
        <form id="editForm">
            <label for="idPublicacion">ID Publicación</label>
            <input type="text" id="idPublicacion" name="idPublicacion" placeholder="Ingrese el ID de la publicación" required>

            <label for="nombreAnimalPost">Nombre</label>
            <input type="text" id="nombreAnimalPost" name="nombreAnimalPost" placeholder="Ingrese el nombre" required>

            <label for="tamañoAnimalPost">Tamaño</label>
            <textarea id="tamañoAnimalPost" name="tamañoAnimalPost" rows="2" placeholder="Ingrese el tamaño del animal"></textarea>

            <label for="caracteristicasAnimalPost">Características</label>
            <textarea id="caracteristicasAnimalPost" name="caracteristicasAnimalPost" rows="3" placeholder="Ingrese las características"></textarea>

            <label for="dietaAnimalPost">Dieta</label>
            <textarea id="dietaAnimalPost" name="dietaAnimalPost" rows="2" placeholder="Ingrese la dieta del animal"></textarea>

            <label for="habitadAnimalPost">Hábitat</label>
            <textarea id="habitadAnimalPost" name="habitadAnimalPost" rows="2" placeholder="Ingrese el hábitat"></textarea>

            <label for="imagenPost">Cambiar Imagen</label>
            <input type="file" id="imagenPost" name="imagenPost" accept="image/*">

            <button type="button" id="btnEditarPublicacion">Guardar Cambios</button>
        </form>
    </div>

    <script src="editarPublicacion.js"></script>
</body>
</html>
