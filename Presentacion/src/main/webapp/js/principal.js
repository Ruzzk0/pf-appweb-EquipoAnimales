document.addEventListener('DOMContentLoaded', function () {
    // Configurar el botón de regresar para cerrar sesión
    const backButton = document.querySelector('.back-button');
    if (backButton) {
        backButton.addEventListener('click', function (e) {
            e.preventDefault();
            // Limpiar la sesión en el servidor
            fetch('deslogueo.jsp', { method: 'GET' })
                .then(() => window.location.href = 'indexView.jsp');
        });
    }

    // Configuración del botón de perfil
    const profileButton = document.querySelector('.profile-button');
    if (profileButton) {
        profileButton.addEventListener('click', function (e) {
            if (!'<%= userEmail %>') {
                e.preventDefault();
                window.location.href = 'indexView.jsp';
            }
        });
    }

    // Animación de los puntos de interés
    const puntos = document.querySelectorAll('.punto-interes');

    function parpadearPuntos() {
        puntos.forEach(punto => {
            if (!punto.matches(':hover')) {
                punto.style.animation = 'parpadeo 3s infinite';
            }
        });
    }

    parpadearPuntos();

    puntos.forEach(punto => {
        punto.addEventListener('mouseenter', function () {
            this.style.animation = 'none';
            this.style.opacity = '1';
        });

        punto.addEventListener('mouseleave', function () {
            this.style.animation = 'parpadeo 3s infinite';
        });
    });
});


//        document.addEventListener('DOMContentLoaded', function() {
//            const puntos = document.querySelectorAll('.punto-interes');
//            
//            // Función para hacer parpadear los puntos
//            function parpadearPuntos() {
//                puntos.forEach(punto => {
//                    if (!punto.matches(':hover')) {
//                        punto.style.animation = 'parpadeo 3s infinite';
//                    }
//                });
//            }
//            
//            // Iniciar el parpadeo
//            parpadearPuntos();
//            
//            // Eventos para cada punto
//            puntos.forEach(punto => {
//                punto.addEventListener('mouseenter', function() {
//                    this.style.animation = 'none';
//                    this.style.opacity = '1';
//                });
//                
//                punto.addEventListener('mouseleave', function() {
//                    this.style.animation = 'parpadeo 3s infinite';
//                });
//            });
//
//    // Configuración del botón de perfil
//    const profileButton = document.querySelector('.profile-button');
//    if (profileButton) {
//        profileButton.addEventListener('click', function (e) {
//            if (!'<%= userEmail %>') {
//                e.preventDefault();
//                window.location.href = 'index.jsp';
//            }
//        });
//    }            
//            
//            
//        });