document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const email = document.getElementById('loginEmail').value;
    const password = document.getElementById('loginPassword').value;

    // Limpiar mensajes de error previos
    document.getElementById('loginEmailError').textContent = '';
    document.getElementById('loginPasswordError').textContent = '';

    // Obtener usuarios registrados desde el localStorage
    const usuarios = JSON.parse(localStorage.getItem('usuarios') || '[]');

    // Buscar usuario que coincida con el email y password
    const usuario = usuarios.find(u => u.email === email && u.password === password);

    if (usuario) {
        // Guardar información de sesión y redirigir (cambiado a sessionStorage)
        sessionStorage.setItem('usuarioActual', JSON.stringify(usuario));  // Modificación aquí
        alert('Inicio de sesión exitoso');
        window.location.href = 'principal.html'; // Redirigir a la página principal
    } else {
        // Mostrar mensaje de error si no coinciden
        document.getElementById('loginEmailError').textContent = 'Correo o contraseña incorrectos';
        document.getElementById('loginPasswordError').textContent = 'Correo o contraseña incorrectos';
    }
});

// Verificar si ya hay una sesión activa al cargar la página
window.addEventListener('load', function() {
    const usuarioActual = sessionStorage.getItem('usuarioActual');  // Modificación aquí
    if (usuarioActual) {
        window.location.href = 'principal.html';
    }
});