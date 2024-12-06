/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
window.addEventListener('popstate', function (event) {
    // Cuando el usuario intenta regresar, invalida la sesión y redirige
    fetch(window.location.origin + '/logoutController', {
        method: 'GET'
    }).then(() => {
        // Redirigir al inicio de sesión
        window.location.href = 'indexView.jsp';
    }).catch(error => {
        console.error('Error al procesar el cierre de sesión:', error);
    });
});

