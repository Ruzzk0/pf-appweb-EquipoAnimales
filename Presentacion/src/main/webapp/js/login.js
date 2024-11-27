/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.addEventListener('DOMContentLoaded', function () {
    // Si ya está logueado, redirigir a principalView.jsp
    if (sessionStorage.getItem('isLoggedIn')) {
        window.location.href = 'principalView.jsp';
    }

    // Manejar el formulario de login
    const loginForm = document.getElementById('loginForm');
    if (loginForm) {
        loginForm.addEventListener('submit', function (e) {
            e.preventDefault();

            const email = document.getElementById('loginEmail').value;
            const password = document.getElementById('loginPassword').value;

            // Validaciones
            if (email && password) {
                // Guardar estado de login
                sessionStorage.setItem('isLoggedIn', 'true');
                sessionStorage.setItem('userEmail', email);

                // Redirigir a la página principal
                window.location.href = 'principalView.jsp';
            } else {
                // Mostrar errores si los campos están vacíos
                if (!email) {
                    document.getElementById('loginEmailError').textContent = 
                        'El correo es requerido';
                }
                if (!password) {
                    document.getElementById('loginPasswordError').textContent = 
                        'La contraseña es requerida';
                }
            }
        });
    }

    // Limpiar mensajes de error cuando el usuario escriba
    const inputs = document.querySelectorAll('input');
    inputs.forEach(input => {
        input.addEventListener('input', function () {
            const errorElement = document.getElementById(this.id + 'Error');
            if (errorElement) {
                errorElement.textContent = '';
            }
        });
    });
});

