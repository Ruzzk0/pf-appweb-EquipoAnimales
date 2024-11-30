/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


document.getElementById('loginForm').addEventListener('submit', async function (event) {
    event.preventDefault(); // Evita que el formulario se envíe de forma predeterminada

    let errores = false;

    // Definir los campos
    const campos = {
        correo: document.getElementById('email').value.trim(),
        contrasena: document.getElementById('password').value.trim()
    };

    // Verifica que los campos no estén vacíos
    for (const key in campos) {
        const campo = campos[key];
        if (!campo) {
            alert(`El campo ${key} es obligatorio.`);
            errores = true;
            break;
        }
    }

    // Limpiar mensajes de error previos
    document.getElementById('loginEmailError').textContent = '';
    document.getElementById('loginPasswordError').textContent = '';

    // Validar correo electrónico
    if (!campos.correo) {
        document.getElementById('loginEmailError').textContent = 'El correo electrónico es obligatorio.';
        errores = true;
    } else if (!/\S+@\S+\.\S+/.test(campos.correo)) {
        document.getElementById('loginEmailError').textContent = 'Por favor, ingresa un correo válido.';
        errores = true;
    }

    // Validar contraseña
    if (!campos.contrasena) {
        document.getElementById('loginPasswordError').textContent = 'La contraseña es obligatoria.';
        errores = true;
    }

    // Si hay errores, no continuar
    if (errores) {
        return;
    }

    // Si no hay errores, preparar los datos para enviar
    const datos = {
        correo: campos.correo,
        contrasena: campos.contrasena
    };

    console.log(datos); // Verificar que los datos estén correctamente formados

    try {
        const response = await fetch(window.location.origin + '/Presentacion/indexController', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });

        const jsonData = await response.json(); // Parsear la respuesta como JSON

        if (jsonData.success) {
            alert('Inicio de sesión exitoso. Bienvenido a AnimalSocial');
            document.getElementById('loginForm').reset(); // Limpiar el formulario
            console.log('Redirigiendo a La red social');
            window.location.href = 'principalView.jsp'; // Redirigir a la vista del dashboard
        } else {
            alert('Error al iniciar sesión: ' + jsonData.message);
        }
    } catch (error) {
        console.error('Error al enviar los datos:', error);
        alert('Hubo un problema al iniciar sesión. Por favor, intenta más tarde.');
    }
});

