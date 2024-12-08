<%-- 
    Document   : AnimalesMarView
    Created on : 27 nov 2024, 20:12:16
    Author     : Ruzzky
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
        <a href="principalView" class="back-button">
            <span class="material-icons">arrow_back_ios</span>
        </a>
        <h1>ANIMALES MARINOS</h1>
        <a class="add-post-btn" href="NuevaPublicacionView.jsp"><span class="material-icons">arrow_back_ios</span>
            Nueva Publicación
        </a>
    </header>

    <div class="image-container">
        <img src="${pageContext.request.contextPath}/imagenesAnimalesM/mar.jpg" alt="Animales Marinos">
        <div class="transparent-box"></div>
    </div>

    <div class="postAnimales">
        <section id="postAnimales">
            <!-- Ballena Jorobada -->
            <div class="card">
                <div class="card-actions">
                    <button class="edit-btn"><i class="fas fa-edit"></i></button>
                    <button class="add-comment-btn" id="addCommentBtn">
                        <span class="material-icons">comment</span>
                    </button>
                    <button class="delete-btn"><i class="fas fa-trash"></i></button>
                </div>
                <div class="card-inner">
                    <div class="card-front">
                        <img src="${pageContext.request.contextPath}/imagenesAnimalesM/ballena.jpg" alt="Ballena Jorobada">
                        <div class="card-title">Ballena Jorobada</div>
                        <div class="card-controls">
                            <button class="comment-btn" id="showCommentsBtn"><i class="fas fa-comment"></i> Comentarios</button>
                            <span class="comment-count">0 comentarios</span>
                        </div>
                        <div class="comments-section">
                            <div class="comments-list"></div>
                        </div>
                    </div>
                    <div class="card-back">
                        <h3>Ballena Jorobada</h3>
                        <p class="info-title">Tamaño</p>
                        <p class="info-text">Entre 12 y 16 metros de largo, con un peso de hasta 30 toneladas.</p>
                        <p class="info-title">Caracteristicas</p>
                        <p class="info-text">Reconocida por sus largas aletas pectorales y su capacidad para realizar
                            saltos acrobáticos.
                            Su canto complejo y prolongado se usa en la comunicación y es especialmente conocido en los
                            machos.</p>
                        <p class="info-title">Alimentación</p>
                        <p class="info-text">Krill, pequeños peces y plancton.</p>
                        <p class="info-title">Hábitat</p>
                        <p class="info-text">Océanos de todo el mundo, migran entre aguas tropicales y polares.</p>
                    </div>
               
                    <!-- Modal de Comentarios -->
                    <div id="commentModal" class="modal">
                        <div class="modal-content">
                            <span class="close">&times;</span>
                            <h2>Agregar Comentario</h2>
                            <textarea id="commentText" placeholder="Escribe tu comentario aquí..."></textarea>
                            <button id="submitComment">Enviar Comentario</button>
                        </div>
                    </div>        
                </div>
            </div>

            <!-- Pulpo Azul -->
            <div class="card">
                <div class="card-actions">
                    <button class="edit-btn"><i class="fas fa-edit"></i></button>
                    <button class="add-comment-btn" id="addCommentBtn">
                        <span class="material-icons">comment</span>
                    </button>
                    <button class="delete-btn"><i class="fas fa-trash"></i></button>
                </div>
                <div class="card-inner">
                    <div class="card-front">
                        <img src="${pageContext.request.contextPath}/imagenesAnimalesM/puploAzul.avif" alt="Pulpo Azul">
                        <div class="card-title">Pulpo Azul</div>
                        <div class="card-controls">
                            <button class="comment-btn" id="showCommentsBtn"><i class="fas fa-comment"></i> Comentarios</button>
                            <span class="comment-count">0 comentarios</span>
                        </div>
                        <div class="comments-section">
                            <div class="comments-list"></div>
                        </div>
                    </div>
                    <div class="card-back">
                        <h3>Pulpo Azul</h3>
                        <p class="info-title">Tamaño</p>
                        <p class="info-text">Aproximadamente 40-60 cm de longitud, incluyendo tentáculos.</p>
                        <p class="info-title">Caracteristicas</p>
                        <p class="info-text"> Conocido por su coloración azul vibrante en ciertas partes del cuerpo
                            y su capacidad de camuflaje para mezclarse con su entorno.</p>
                        <p class="info-title">Alimentación</p>
                        <p class="info-text">Cangrejos, langostas y moluscos.</p>
                        <p class="info-title">Hábitat</p>
                        <p class="info-text">Arrecifes de coral del Pacífico.</p>
                    </div>
                
                    <!-- Modal de Comentarios -->
                    <div id="commentModal" class="modal">
                        <div class="modal-content">
                            <span class="close">&times;</span>
                            <h2>Agregar Comentario</h2>
                            <textarea id="commentText" placeholder="Escribe tu comentario aquí..."></textarea>
                            <button id="submitComment">Enviar Comentario</button>
                        </div>
                    </div>        
                </div>
            </div>

            <!-- Tiburón Martillo -->
            <div class="card">
                <div class="card-actions">
                    <button class="edit-btn"><i class="fas fa-edit"></i></button>
                    <button class="add-comment-btn" id="addCommentBtn">
                        <span class="material-icons">comment</span>
                    </button>
                    <button class="delete-btn"><i class="fas fa-trash"></i></button>
                </div>
                <div class="card-inner">
                    <div class="card-front">
                        <img src="${pageContext.request.contextPath}/imagenesAnimalesM/tiburonMartillo.jpg" alt="Tiburón Martillo">
                        <div class="card-title">Tiburón Martillo</div>
                        <div class="card-controls">
                            <button class="comment-btn"><i class="fas fa-comment"></i> Comentarios</button>
                            <span class="comment-count">0 comentarios</span>
                        </div>
                        <div class="comments-section">
                            <div class="comments-list"></div>
                        </div>
                    </div>
                    <div class="card-back">
                        <h3>Tiburón Martillo</h3>
                        <p class="info-title">Tamaño</p>
                        <p class="info-text">Puede medir de 3 a 6 metros dependiendo de la especie.</p>
                        <p class="info-title">Caracteristicas</p>
                        <p class="info-text">Tiene una cabeza distintiva en forma de "T",
                            lo que le permite tener una visión panorámica para localizar a sus presas con facilidad.</p>
                        <p class="info-title">Alimentación</p>
                        <p class="info-text">Peces, calamares y otros tiburones pequeños.</p>
                        <p class="info-title">Hábitat</p>
                        <p class="info-text">Aguas tropicales y templadas alrededor del mundo.</p>
                    </div>
                
                    <!-- Modal de Comentarios -->
                    <div id="commentModal" class="modal">
                        <div class="modal-content">
                            <span class="close">&times;</span>
                            <h2>Agregar Comentario</h2>
                            <textarea id="commentText" placeholder="Escribe tu comentario aquí..."></textarea>
                            <button id="submitComment">Enviar Comentario</button>
                        </div>
                    </div>        
                </div>
            </div>

            <!-- Manta Raya -->
            <div class="card">
                <div class="card-actions">
                    <button class="edit-btn"><i class="fas fa-edit"></i></button>
                    <button class="add-comment-btn" id="addCommentBtn">
                        <span class="material-icons">comment</span>
                    </button>
                    <button class="delete-btn"><i class="fas fa-trash"></i></button>
                </div>
                <div class="card-inner">
                    <div class="card-front">
                        <img src="${pageContext.request.contextPath}/imagenesAnimalesM/mantaRaya.jpg" alt="Manta Raya">
                        <div class="card-title">Manta Raya</div>
                        <div class="card-controls">
                            <button class="comment-btn"><i class="fas fa-comment"></i> Comentarios</button>
                            <span class="comment-count">0 comentarios</span>
                        </div>
                        <div class="comments-section">
                            <div class="comments-list"></div>
                        </div>
                    </div>
                    <div class="card-back">
                        <h3>Manta Raya</h3>
                        <p class="info-title">Tamaño</p>
                        <p class="info-text">Entre 5 y 7 metros de ancho, con un peso de hasta 1,300 kg.</p>
                        <p class="info-title">Caracteristicas</p>
                        <p class="info-text">Son conocidas por sus aletas pectorales que parecen "alas" y su comportamiento de nado elegante y en círculos. 
                            Son inofensivas para los humanos y no poseen aguijón venenoso.</p>
                        <p class="info-title">Alimentación</p>
                        <p class="info-text">Plancton y pequeños peces.</p>
                        <p class="info-title">Hábitat</p>
                        <p class="info-text">Aguas tropicales y subtropicales.</p>
                    </div>
                
                    <!-- Modal de Comentarios -->
                    <div id="commentModal" class="modal">
                        <div class="modal-content">
                            <span class="close">&times;</span>
                            <h2>Agregar Comentario</h2>
                            <textarea id="commentText" placeholder="Escribe tu comentario aquí..."></textarea>
                            <button id="submitComment">Enviar Comentario</button>
                        </div>
                    </div>        
                </div>
            </div>

            <!-- Delfín Nariz de Botella -->
            <div class="card">
                <div class="card-actions">
                    <button class="edit-btn"><i class="fas fa-edit"></i></button>
                    <button class="add-comment-btn" id="addCommentBtn">
                        <span class="material-icons">comment</span>
                    </button>
                    <button class="delete-btn"><i class="fas fa-trash"></i></button>
                </div>
                <div class="card-inner">
                    <div class="card-front">
                        <img src="${pageContext.request.contextPath}/imagenesAnimalesM/delfinBotella.jpg" alt="Delfín Nariz de Botella">
                        <div class="card-title">Delfín Nariz de Botella</div>
                        <div class="card-controls">
                            <button class="comment-btn" id="showCommentsBtn"><i class="fas fa-comment"></i> Comentarios</button>
                            <span class="comment-count">0 comentarios</span>
                        </div>
                        <div class="comments-section">
                            <div class="comments-list"></div>
                        </div>
                    </div>
                    <div class="card-back">
                        <h3>Delfín Nariz de Botella</h3>
                        <p class="info-title">Tamaño</p>
                        <p class="info-text">Entre 2 y 4 metros de largo y un peso de hasta 650 kg.</p>
                        <p class="info-title">Caracteristicas</p>
                        <p class="info-text">Muy inteligente y sociable, con una excelente capacidad de comunicación mediante sonidos, gestos y ecolocación.</p>
                        <p class="info-title">Alimentación</p>
                        <p class="info-text">Peces, calamares y crustáceos.</p>
                        <p class="info-title">Hábitat</p>
                        <p class="info-text">Océanos templados y tropicales de todo el mundo.</p>
                    </div>
               
                    <!-- Modal de Comentarios -->
                    <div id="commentModal" class="modal">
                        <div class="modal-content">
                            <span class="close">&times;</span>
                            <h2>Agregar Comentario</h2>
                            <textarea id="commentText" placeholder="Escribe tu comentario aquí..."></textarea>
                            <button id="submitComment">Enviar Comentario</button>
                        </div>
                    </div>        
                </div>
            </div>
<!-- Caballito de Mar -->
<div class="card">
    <div class="card-actions">
        <button class="edit-btn"><i class="fas fa-edit"></i></button>
        <button class="add-comment-btn" id="addCommentBtn">
            <span class="material-icons">comment</span>
        </button>
        <button class="delete-btn"><i class="fas fa-trash"></i></button>
    </div>
    <div class="card-inner">
        <div class="card-front">
            <img src="${pageContext.request.contextPath}/imagenesAnimalesM/CaballoMar.avif" alt="Caballito de Mar">
            <div class="card-title">Caballito de Mar</div>
            <div class="card-controls">
                <button class="comment-btn" id="showCommentsBtn"><i class="fas fa-comment"></i> Comentarios</button>
                <span class="comment-count">0 comentarios</span>
            </div>
            <div class="comments-section">
                <div class="comments-list"></div>
            </div>
        </div>
        <div class="card-back">
            <h3>Caballito de Mar</h3>
            <p class="info-title">Tamaño</p>
            <p class="info-text">Entre 1 y 30 cm de altura, dependiendo de la especie.</p>
            <p class="info-title">Caracteristicas</p>
            <p class="info-text">Su cuerpo tiene forma de "S" y no tienen escamas. El macho es quien lleva los huevos hasta que nacen.</p>
            <p class="info-title">Alimentación</p>
            <p class="info-text">Pequeños crustáceos y plancton.</p>
            <p class="info-title">Hábitat</p>
            <p class="info-text">Aguas costeras tropicales y templadas.</p>
        </div>
   
        <!-- Modal de Comentarios -->
        <div id="commentModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <h2>Agregar Comentario</h2>
                <textarea id="commentText" placeholder="Escribe tu comentario aquí..."></textarea>
                <button id="submitComment">Enviar Comentario</button>
            </div>
        </div>        
    </div>
</div>

        </section>
    </div>
    <script src="${pageContext.request.contextPath}/js/registrarComentarios.js"></script>
</body>
</html>                    