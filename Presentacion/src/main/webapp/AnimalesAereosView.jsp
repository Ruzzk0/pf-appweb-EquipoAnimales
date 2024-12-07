<%-- 
    Document   : AnimalesAereosView
    Created on : 27 nov 2024, 19:10:42
    Author     : Ruzzky
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" %>
<%@ page import="java.util.List, java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ANIMALES AEREOS</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesAereos.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/registrarComentarios.js" defer></script>
</head>
<body>
    <header class="sticky-header">
        <a href="principalView.jsp" class="back-button">
            <span class="material-icons">arrow_back_ios</span>
        </a>
        <h1>ANIMALES AEREOS</h1>
        <a class="add-post-btn" href="NuevaPublicacionView.jsp">
            <span class="material-icons">arrow_back_ios</span>
        </a>
    </header>

    <div class="image-container">
        <img src="${pageContext.request.contextPath}/imagenesAnimalesA/Cielo.jpg" alt="ANIMALES AEREOS">
        <div class="transparent-box"></div>
    </div>

    <div class="postAnimales">
        <section id="postAnimales">
            <%
                class Animal {
                    String nombre, imagen, tamaño, caracteristicas, dieta, habitat;

                    public Animal(String nombre, String imagen, String tamaño, String caracteristicas, String dieta, String habitat) {
                        this.nombre = nombre;
                        this.imagen = imagen;
                        this.tamaño = tamaño;
                        this.caracteristicas = caracteristicas;
                        this.dieta = dieta;
                        this.habitat = habitat;
                    }
                }

                List<Animal> animales = new ArrayList<>();
                animales.add(new Animal("Aguila Real", "${pageContext.request.contextPath}/imagenesAnimalesA/aguila.jpg",
                        "70-100 cm de longitud; envergadura de 180-230 cm, peso entre 3-6 kg.",
                        "Gran agudeza visual, 8 veces más precisa que la humana. Plumaje marrón oscuro con toques dorados en la cabeza y cuello.",
                        "Carnívora, cazan mamíferos pequeños, aves y reptiles. También son carroñeros en ocasiones.",
                        "Regiones montañosas, praderas y acantilados, principalmente en el hemisferio norte."));
                animales.add(new Animal("Colibrí", "${pageContext.request.contextPath}/imagenesAnimalesA/colibri.jpg",
                        "Entre 6 y 12 cm; peso entre 2 y 20 gramos, según la especie.",
                        "Aletean entre 50 y 80 veces por segundo, lo que les permite mantenerse suspendidos en el aire. Su corazón puede latir más de 1,200 veces por minuto.",
                        "Se alimentan de néctar y pequeños insectos como mosquitos y arañas para obtener proteínas.",
                        "Bosques tropicales, zonas subtropicales y jardines; presentes principalmente en América."));
                animales.add(new Animal("Guacamayo azul y amarillo", "${pageContext.request.contextPath}/imagenesAnimalesA/guacamayo.jpg",
                        "76-86 cm de longitud; envergadura de 100-110 cm, peso alrededor de 1.3 kg.",
                        "Plumaje de colores intensos: cuerpo amarillo, alas y espalda azules, y una franja verde en la frente. Son aves inteligentes y sociales, capaces de imitar sonidos y palabras humanas.",
                        "Frutas, semillas, frutos secos y flores. Complementan su dieta con arcilla para neutralizar toxinas de algunos alimentos.",
                        "Selvas tropicales, manglares y zonas húmedas de América del Sur, especialmente en la cuenca del Amazonas."));
                animales.add(new Animal("Flamenco", "${pageContext.request.contextPath}/imagenesAnimalesA/flamenco.jpg",
                        "80-145 cm de altura; envergadura de hasta 165 cm, peso entre 2 y 4 kg.",
                        "Plumaje rosado, producto de los carotenoides presentes en su dieta. Pico curvado para filtrar alimentos del agua.",
                        "Omnívora, consume algas, camarones y pequeños crustáceos.",
                        "Lagunas salinas, humedales y lagos alcalinos."));
                animales.add(new Animal("Búho real", "${pageContext.request.contextPath}/imagenesAnimalesA/buho.jpg",
                        "60-75 cm de longitud; envergadura de hasta 190 cm, peso entre 2 y 4.5 kg.",
                        "Grandes ojos anaranjados y \"orejas\" formadas por mechones de plumas. Su vuelo es completamente silencioso gracias a la estructura especial de sus plumas.",
                        "Carnívora, se alimenta de roedores, conejos y aves pequeñas.",
                        "Bosques, montañas y zonas rurales de Europa y Asia."));
                animales.add(new Animal("Tucán toco", "${pageContext.request.contextPath}/imagenesAnimalesA/tucan.jpg",
                        "55-65 cm de longitud; pico de hasta 20 cm, su peso es alrededor de 500 gramos.",
                        "Pico grande de color naranja, ligero por su estructura hueca. Aves sociales que viven en grupos.",
                        "Omnívora; consumen frutas, insectos, pequeños reptiles y huevos.",
                        "Selvas tropicales de América del Sur."));

                for (Animal animal : animales) {
            %>
            <div class="card">
                <div class="card-actions">
                    <button class="edit-btn"><i class="fas fa-edit"></i></button>
                    <button class="add-comment-btn"><span class="material-icons">comment</span></button>
                    <button class="delete-btn"><i class="fas fa-trash"></i></button>
                </div>
                <div class="card-inner">
                    <div class="card-front">
                        <img src="<%= animal.imagen %>" alt="<%= animal.nombre %>">
                        <div class="card-title"><%= animal.nombre %></div>
                        <div class="card-controls">
                            <button class="comment-btn"><i class="fas fa-comment"></i> Comentarios</button>
                            <span class="comment-count">0 comentarios</span>
                        </div>
                        <div class="comments-section">
                            <div class="comments-list"></div>
                        </div>
                    </div>
                    <div class="card-back">
                        <h3><%= animal.nombre %></h3>
                        <p class="info-title">Tamaño</p>
                        <p class="info-text"><%= animal.tamaño %></p>
                        <p class="info-title">Características</p>
                        <p class="info-text"><%= animal.caracteristicas %></p>
                        <p class="info-title">Dieta</p>
                        <p class="info-text"><%= animal.dieta %></p>
                        <p class="info-title">Hábitat</p>
                        <p class="info-text"><%= animal.habitat %></p>
                    </div>
                </div>
            </div>
            <% } %>
        </section>
    </div>
</body>
</html>