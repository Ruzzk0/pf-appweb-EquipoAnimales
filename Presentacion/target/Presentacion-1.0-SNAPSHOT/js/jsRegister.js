/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
document.getElementById('registroForm').addEventListener('submit', function (event) {
    event.preventDefault();

    let errores = false;

    const nombre = document.getElementById('nombre').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const fechaNacimiento = document.getElementById('fechaNacimiento').value;
    const telefono = document.getElementById('telefono').value;

    // Aquí puedes incluir validaciones si es necesario
    if (nombre.trim() === '' || email.trim() === '' || password.trim() === '' || telefono.trim() === '') {
        alert('Todos los campos son obligatorios');
        errores = true;
    }

    if (!errores) {
        const datos = {
            nombre,
            email,
            password,
            fechaNacimiento,
            telefono
        };

        fetch(window.location.origin + '/Presentacion/registerController', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        })
                .then(response => response.json())
                .then(data => {
                    if (data.success) {
                        alert('Registro exitoso');
                        document.getElementById('registroForm').reset(); // Limpiar el formulario
                        window.location.href = 'indexView.jsp'; // Redirigir a la página de inicio
                    } else {
                        alert('Error al registrar al usuario: ' + data.message);
                    }
                })
                .catch(error => {
                    console.error('Error al enviar los datos:', error);
                    alert('Hubo un problema al registrar al usuario.');
                });
    }
});


