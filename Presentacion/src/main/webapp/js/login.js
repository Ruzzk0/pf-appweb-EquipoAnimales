/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
// */
//document.addEventListener('DOMContentLoaded', function () {
//    // Manejar el formulario de login
//    const loginForm = document.getElementById('loginForm');
//    if (loginForm) {
//        loginForm.addEventListener('submit', function (e) {
//            const email = document.getElementById('email').value;
//            const password = document.getElementById('password').value;
//
//            // Validaciones de campos vacíos
//            let valid = true;
//            if (!email) {
//                document.getElementById('loginEmailError').textContent = 'El correo es requerido';
//                valid = false;
//            }
//            if (!password) {
//                document.getElementById('loginPasswordError').textContent = 'La contraseña es requerida';
//                valid = false;
//            }
//
//            // Si hay errores, prevenir el envío
//            if (!valid) {
//                e.preventDefault();
//            }
//        });
//    }
//
//    // Limpiar mensajes de error cuando el usuario escriba
//    const inputs = document.querySelectorAll('input');
//    inputs.forEach(input => {
//        input.addEventListener('input', function () {
//            const errorElement = document.getElementById(this.id + 'Error');
//            if (errorElement) {
//                errorElement.textContent = '';
//            }
//        });
//    });
//});
