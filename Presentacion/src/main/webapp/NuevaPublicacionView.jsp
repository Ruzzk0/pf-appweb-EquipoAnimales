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
    <title>Crear Nueva Publicación</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesNuevaPublicacion.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <header class="sticky-header">
        <a href="principalView.jsp" class="back-button">
            <span class="material-icons">arrow_back_ios</span>
        </a>
        <h1>ANIMAL SOCIAL</h1>
    </header>
    
    <div class="nueva-publicacion-container">
        <div class="card nueva-publicacion-card">
            <form id="formPublicar" action="NuevaPublicacionServlet" method="post" enctype="multipart/form-data" class="formularioPublicacion">
                <div class="card-header">
                    <h2>Crear Nueva Publicación</h2>
                </div>
                
                <div class="card-body">
                    <div class="form-group imagen-upload">
                        <label for="imagenPost" class="imagen-label">
                            <input type="file" id="imagenPost" name="imagen" accept="image/*" class="imagen-input">
                            <div class="imagen-preview">
                                <i class="fas fa-image"></i>
                                <span>Subir Imagen</span>
                            </div>
                        </label>
                    </div>

                    <div class="form-group">
                        <label for="nombreAnimalPost">Nombre del Animal</label>
                        <input id="nombreAnimalPost" name="nombre" type="text" placeholder="Ingresa el nombre del animal" required>
                    </div>

                    <div class="form-group">
                        <label for="tamañoAnimalPost">Tamaño del Animal</label>
                        <textarea id="tamañoAnimalPost" name="tamaño" placeholder="Describe el tamaño del animal" required></textarea>
                    </div>

                    <div class="form-group">
                        <label for="caracteristicasAnimalPost">Características</label>
                        <textarea id="caracteristicasAnimalPost" name="caracteristicas" placeholder="Describe las características del animal" required></textarea>
                    </div>

                    <div class="form-group">
                        <label for="dietaAnimalPost">Dieta</label>
                        <textarea id="dietaAnimalPost" name="dieta" placeholder="Describe la dieta del animal" required></textarea>
                    </div>

                    <div class="form-group">
                        <label for="habitadAnimalPost">Hábitat</label>
                        <textarea id="habitadAnimalPost" name="habitat" placeholder="Describe el hábitat del animal" required></textarea>
                    </div>
                </div>

                <div class="card-footer">
                    <button type="submit" id="btnPublicar" class="btn-publicar">
                        <i class="fas fa-plus"></i> Publicar
                    </button>
                </div>
            </form>
        </div>
    </div>

    <script src="nuevaPublicacionView.js"></script>
    <script>
        document.getElementById('imagenPost').addEventListener('change', function(event) {
            const file = event.target.files[0];
            const previewContainer = document.querySelector('.imagen-preview');
            
            if (file) {
                const reader = new FileReader();
                reader.onload = function(e) {
                    previewContainer.innerHTML = `<img src="${e.target.result}" alt="Vista previa de imagen" class="preview-image">`;
                };
                reader.readAsDataURL(file);
            }
        });
    </script>
</body>
</html>
