/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
// Verificar si la sesión está activa cada vez que se cargue la página
window.addEventListener('load', function () {
    fetch(window.location.origin + '/checkSessionServlet', {method: 'GET'})
            .then(response => response.json())
            .then(data => {
                if (!data.isLoggedIn) {
                    // Si la sesión no está activa, redirigir al login
                    window.location.href = 'indexView.jsp';
                }
            })
            .catch(error => {
                console.error('Error al verificar la sesión:', error);
                // Como último recurso, redirigir al login
                window.location.href = 'indexView.jsp';
            });
});

