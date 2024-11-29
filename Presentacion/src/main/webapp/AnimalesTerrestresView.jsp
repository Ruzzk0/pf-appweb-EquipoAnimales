<%-- 
    Document   : AnimalesTerrestresView
    Created on : 27 nov 2024, 21:22:30
    Author     : Ruzzky
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ANIMALES TERRESTRES</title>
        <link rel="stylesheet" href="stylesTerrestres.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>

    <body>
        <header class="sticky-header">
            <a href="principalView.jsp" class="back-button">
                <span class="material-icons">arrow_back_ios</span>
            </a>
            <h1>ANIMALES TERRESTRES</h1>
            <a class="add-post-btn" href="NuevaPublicacion.jsp">
                <span class="material-icons">add</span> Nueva Publicación
            </a>
        </header>

        <div class="image-container">
            <img src="imagenesAnimalesT/leopardo.jpg" alt="Animales Terrestres">
            <div class="transparent-box"></div>
        </div>

        <div class="postAnimales">
            <section id="postAnimales">
                <!-- Listar animales desde una colección -->
                <c:forEach var="animal" items="${animalList}">
                    <div class="card">
                        <div class="card-actions">
                            <button class="edit-btn"><i class="fas fa-edit"></i></button>
                            <button class="add-comment-btn">
                                <span class="material-icons">comment</span>
                            </button>
                            <button class="delete-btn"><i class="fas fa-trash"></i></button>
                        </div>
                        <div class="card-inner">
                            <div class="card-front">
                                <img src="${animal.image}" alt="${animal.name}">
                                <div class="card-title">${animal.name}</div>
                                <div class="card-controls">
                                    <button class="comment-btn"><i class="fas fa-comment"></i> Comentarios</button>
                                    <span class="comment-count">${animal.comments.size()} comentarios</span>
                                </div>
                                <div class="comments-section">
                                    <div class="comments-list">
                                        <c:forEach var="comment" items="${animal.comments}">
                                            <p>${comment}</p>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="card-back">
                                <h3>${animal.name}</h3>
                                <p class="info-title">Tamaño</p>
                                <p class="info-text">${animal.size}</p>
                                <p class="info-title">Características</p>
                                <p class="info-text">${animal.characteristics}</p>
                                <p class="info-title">Dieta</p>
                                <p class="info-text">${animal.diet}</p>
                                <p class="info-title">Hábitat</p>
                                <p class="info-text">${animal.habitat}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </section>
        </div>

        <!-- Modal de Comentarios -->
        <div id="commentModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <h2>Agregar Comentario</h2>
                <form action="AddCommentServlet" method="post">
                    <textarea name="commentText" placeholder="Escribe tu comentario aquí..."></textarea>
                    <input type="hidden" name="animalId" value="${currentAnimalId}">
                    <button type="submit">Enviar Comentario</button>
                </form>
            </div>
        </div>

        <script src="registrarComentarios.js"></script>
    </body>
</html>
