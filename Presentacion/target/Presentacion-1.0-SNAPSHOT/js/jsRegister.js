document.getElementById('registroForm').addEventListener('submit', async function (event) {
    event.preventDefault();

    let errores = false;

    // Definir los campos
    const campos = {
        id:0,
        nombre: document.getElementById('nombre'),
        email: document.getElementById('email'),
        password: document.getElementById('password'),
        telefono: document.getElementById('telefono'),
        pais: document.getElementById('pais'),
        estado: document.getElementById('estado'),
        ciudad: document.getElementById('ciudad'),
        fechaNacimiento: document.getElementById('fechaNacimiento'),
        genero: document.querySelector('input[name="genero"]:checked'), // Para los radio buttons
        bando: document.getElementById('bando')
    };

    // Verifica que los campos no estén vacíos
    for (const key in campos) {
        const campo = campos[key];
        if (!campo || (campo.value.trim() === '' || (campo.type === 'radio' && !campo.checked))) {
            alert(`El campo ${key} es obligatorio.`);
            errores = true;
            break;
        }
    }

    // Validación de la contraseña
    if (campos.password && campos.password.value.length < 8) {
        alert('La contraseña debe tener al menos 8 caracteres.');
        errores = true;
    }

    // Si no hay errores, enviar los datos
    if (!errores) {
        const datos = {
            nombre: campos.nombre.value,
            correo: campos.email.value,
            contrasena: campos.password.value,
            pais: campos.pais.value,
            estado: campos.estado.value,
            ciudad: campos.ciudad.value,
            telefono: campos.telefono.value,
            fechaNacimiento: campos.fechaNacimiento.value,
            genero: campos.genero ? campos.genero.value : '',
            bando: campos.bando.value,
            rol: 'visitante' // Agregar el rol aquí
        };

        try {
            const response = await fetch(window.location.origin + '/Presentacion/registerController', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(datos)
            });

            const jsonData = await response.json(); // Obtener respuesta como JSON

            if (jsonData.success) {
                alert('Registro exitoso');
                document.getElementById('registroForm').reset(); // Limpiar el formulario
                window.location.href = 'indexView.jsp'; // Redirigir a la página de inicio
            } else {
                alert('Error al registrar al usuario: ' + jsonData.message);
            }

        } catch (error) {
            console.error('Error al enviar los datos:', error);
            alert('Hubo un problema al registrar al usuario.');
        }
    }
});document.getElementById('registroForm').addEventListener('submit', async function (event) {
    event.preventDefault();

    let errores = false;

    // Definir los campos
    const campos = {
        nombre: document.getElementById('nombre'),
        email: document.getElementById('email'),
        password: document.getElementById('password'),
        telefono: document.getElementById('telefono'),
        pais: document.getElementById('pais'),
        estado: document.getElementById('estado'),
        ciudad: document.getElementById('ciudad'),
        fechaNacimiento: document.getElementById('fechaNacimiento'),
        genero: document.querySelector('input[name="genero"]:checked'), // Para los radio buttons
        bando: document.getElementById('bando')
    };

    // Verifica que los campos no estén vacíos
    for (const key in campos) {
        const campo = campos[key];
        if (!campo || (campo.value.trim() === '' || (campo.type === 'radio' && !campo.checked))) {
            alert(`El campo ${key} es obligatorio.`);
            errores = true;
            break;
        }
    }

    // Validación de la contraseña
    if (campos.password && campos.password.value.length < 8) {
        alert('La contraseña debe tener al menos 8 caracteres.');
        errores = true;
    }

    // Si no hay errores, enviar los datos
    if (!errores) {
        const datos = {
            nombre: campos.nombre.value,
            correo: campos.email.value,
            contrasena: campos.password.value,
            pais: campos.pais.value,
            estado: campos.estado.value,
            ciudad: campos.ciudad.value,
            telefono: campos.telefono.value,
            fechaNacimiento: campos.fechaNacimiento.value,
            genero: campos.genero ? campos.genero.value : '',
            bando: campos.bando.value,
            administrador: false
        };

        try {
            const response = await fetch(window.location.origin + '/Presentacion/registerController', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(datos)
            });

            const jsonData = await response.json(); // Obtener respuesta como JSON

            if (jsonData.success) {
                alert('Registro exitoso');
                document.getElementById('registroForm').reset(); // Limpiar el formulario
                window.location.href = 'indexView.jsp'; // Redirigir a la página de inicio
            } else {
                alert('Error al registrar al usuario: ' + jsonData.message);
            }

        } catch (error) {
            console.error('Error al enviar los datos:', error);
            alert('Hubo un problema al registrar al usuario.');
        }
    }
});