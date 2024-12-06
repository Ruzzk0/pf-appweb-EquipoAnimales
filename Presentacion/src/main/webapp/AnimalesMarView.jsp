<%-- 
    Document   : AnimalesMarView
    Created on : 27 nov 2024, 20:12:16
    Author     : Ruzzky
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Animales Marinos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesMarinos.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<body>
    <header class="sticky-header">
        <a href="principalView.jsp" class="back-button">
            <span class="material-icons">arrow_back_ios</span>
        </a>
        <h1>ANIMALES MARINOS</h1>
        <a class="add-post-btn" href="NuevaPublicacionView.jsp"><span class="material-icons">add</span>
            Nueva Publicación
        </a>
    </header>

    <div class="image-container">
        <img src="${pageContext.request.contextPath}/imagenesAnimalesM/mar.jpg" alt="Animales Marinos">
        <div class="transparent-box"></div>
    </div>

    <div class="postAnimales">
        <section id="postAnimales">
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
                            <img src="<c:out value='${animal.image}' />" alt="<c:out value='${animal.name}' />">
                            <div class="card-title"><c:out value="${animal.name}" /></div>
                            <div class="card-controls">
                                <button class="comment-btn"><i class="fas fa-comment"></i> Comentarios</button>
                                <span class="comment-count"><c:out value="${animal.commentCount}" /> comentarios</span>
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
                            <h3><c:out value="${animal.name}" /></h3>
                            <p class="info-title">Tamaño</p>
                            <p class="info-text"><c:out value="${animal.size}" /></p>
                            <p class="info-title">Características</p>
                            <p class="info-text"><c:out value="${animal.characteristics}" /></p>
                            <p class="info-title">Alimentación</p>
                            <p class="info-text"><c:out value="${animal.food}" /></p>
                            <p class="info-title">Hábitat</p>
                            <p class="info-text"><c:out value="${animal.habitat}" /></p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </section>
    </div>
    <script src="registrarComentarios.js"></script>
</body>

</html>
