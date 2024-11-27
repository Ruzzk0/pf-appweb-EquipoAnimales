<%-- 
    Document   : registro
    Created on : 23 nov 2024, 13:44:02
    Author     : gamaliel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro - Animal Social</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylesRegistro.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
</head>
<body>   
    <header class="sticky-header">
        <a href="indexView.jsp" class="back-button">
            <span class="material-icons">arrow_back_ios</span>
        </a>
        <h1>ANIMAL SOCIAL</h1>
    </header>

    <section class="section" id="register-section">
        <h4 title="texto-Registro">Registrarse</h4>
        <form id="registroForm" action="registerController" method="POST">
            <div class="form-group">
                <input type="text" placeholder="Nombre Completo" id="nombre" name="nombre" required>
                <i class="uil uil-user"></i>
                <span class="error-message" id="nombreError"></span>
            </div>
            <div class="form-group">
                <input type="email" placeholder="Correo Electrónico" id="email" name="email" required>
                <i class="uil uil-at"></i>
                <span class="error-message" id="emailError"></span>
            </div>
            <div class="form-group">
                <input type="password" placeholder="Contraseña (mín. 8 caracteres, mayúscula, minúscula)" id="password" name="password" required>
                <i class="uil uil-lock-alt"></i>
                <span class="error-message" id="passwordError"></span>
            </div>
            <div class="form-group">
                <select id="pais" name="pais" required>
                    <option value="">Selecciona tu país</option>
                </select>
                <i class="uil uil-globe"></i>
                <span class="error-message" id="paisError"></span>
            </div>
            <div class="form-group">
                <select id="estado" name="estado" required>
                    <option value="">Selecciona tu estado</option>
                </select>
                <i class="uil uil-map-pin"></i>
                <span class="error-message" id="estadoError"></span>
            </div>
            <div class="form-group">
                <select id="ciudad" name="ciudad" required>
                    <option value="">Selecciona tu ciudad</option>
                </select>
                <i class="uil uil-city"></i>
                <span class="error-message" id="ciudadError"></span>
            </div>
            <div class="form-group">
                <input type="tel" placeholder="Teléfono" id="telefono" name="telefono" required>
                <i class="uil uil-phone"></i>
                <span class="error-message" id="telefonoError"></span>
            </div>
            <div class="form-group">
                <input type="date" placeholder="Fecha de Nacimiento" id="fechaNacimiento" name="fechaNacimiento" required>
                <i class="uil uil-calendar-alt"></i>
                <span class="error-message" id="fechaNacimientoError"></span>
            </div>
            <div class="radio-group">
                <label><input type="radio" name="genero" value="hombre" required> Hombre</label>
                <label><input type="radio" name="genero" value="mujer" required> Mujer</label>
                <label><input type="radio" name="genero" value="no-binario" required> No binario</label>
                <span class="error-message" id="generoError"></span>
            </div>
            <div class="form-group">
                <select id="bando" name="bando" required>
                    <option value="">Selecciona tu bando</option>
                    <option value="terrestre">Animales Terrestres</option>
                    <option value="marino">Animales Marinos</option>
                    <option value="aereo">Animales Aéreos</option>
                </select>
                <i class="uil uil-users-alt"></i>
                <span class="error-message" id="bandoError"></span>
            </div>
        
            <button type="submit" class="btn btn-success" id="btnRegistro">Registrarse</button>
        </form>
    </section>

    <script>
    document.addEventListener('DOMContentLoaded', function() {
        const selectPais = document.getElementById('pais');
        const selectEstado = document.getElementById('estado');
        const selectCiudad = document.getElementById('ciudad');

        let authToken = null;

        // Function de acceso al token
        async function obtenerTokenAcceso() {
            try {
                const response = await fetch('https://www.universal-tutorial.com/api/getaccesstoken', {
                    method: 'GET',
                    headers: {
                        'Accept': 'application/json',
                        'api-token': 'Y_bti67DlEXJDglnuMpK899x-hM5pHS90PJ3yFvckCg7Zo5gDuNO3xdBAA9fkm-nXLc',
                        'user-email': 'momexej790@kazvi.com'
                    }
                });

                if (!response.ok) {
                    throw new Error('Error al obtener token de acceso');
                }

                const data = await response.json();
                authToken = data.auth_token;
                
                // Cargar países después de obtener el token
                cargarPaises();
            } catch (error) {
                console.error('Error:', error);
                alert('No se pudieron cargar los países. Intente más tarde.');
            }
        }

        // Función para cargar países
        async function cargarPaises() {
            if (!authToken) {
                await obtenerTokenAcceso();
                return;
            }

            try {
                const response = await fetch('https://www.universal-tutorial.com/api/countries/', {
                    method: 'GET',
                    headers: {
                        'Authorization': `Bearer ${authToken}`,
                        'Accept': 'application/json'
                    }
                });

                if (!response.ok) {
                    throw new Error('Error al cargar países');
                }

                const paises = await response.json();
                
                // Limpiar select de países
                selectPais.innerHTML = '<option value="">Selecciona tu país</option>';
                
                // Añadir países al select
                paises.forEach(pais => {
                    const option = document.createElement('option');
                    option.value = pais.country_short_name;
                    option.textContent = pais.country_name;
                    selectPais.appendChild(option);
                });
            } catch (error) {
                console.error('Error:', error);
                alert('No se pudieron cargar los países. Intente más tarde.');
            }
        }

        // Función para cargar estados
        async function cargarEstados(pais) {
            if (!authToken) {
                await obtenerTokenAcceso();
                return;
            }

            try {
                const response = await fetch(`https://www.universal-tutorial.com/api/states/${pais}`, {
                    method: 'GET',
                    headers: {
                        'Authorization': `Bearer ${authToken}`,
                        'Accept': 'application/json'
                    }
                });

                if (!response.ok) {
                    throw new Error('Error al cargar estados');
                }

                const estados = await response.json();
                
                // Limpiar select de estados
                selectEstado.innerHTML = '<option value="">Selecciona tu estado</option>';
                
                // Añadir estados al select
                estados.forEach(estado => {
                    const option = document.createElement('option');
                    option.value = estado.state_name;
                    option.textContent = estado.state_name;
                    selectEstado.appendChild(option);
                });
            } catch (error) {
                console.error('Error:', error);
                alert('No se pudieron cargar los estados. Intente más tarde.');
            }
        }

        // Función para cargar ciudades
        async function cargarCiudades(estado) {
            if (!authToken) {
                await obtenerTokenAcceso();
                return;
            }

            try {
                const response = await fetch(`https://www.universal-tutorial.com/api/cities/${estado}`, {
                    method: 'GET',
                    headers: {
                        'Authorization': `Bearer ${authToken}`,
                        'Accept': 'application/json'
                    }
                });

                if (!response.ok) {
                    throw new Error('Error al cargar ciudades');
                }

                const ciudades = await response.json();
                
                // Limpiar select de ciudades
                selectCiudad.innerHTML = '<option value="">Selecciona tu ciudad</option>';
                
                // Añadir ciudades al select
                ciudades.forEach(ciudad => {
                    const option = document.createElement('option');
                    option.value = ciudad.city_name;
                    option.textContent = ciudad.city_name;
                    selectCiudad.appendChild(option);
                });
            } catch (error) {
                console.error('Error:', error);
                alert('No se pudieron cargar las ciudades. Intente más tarde.');
            }
        }

        // Evento para cargar estados cuando se selecciona un país
        selectPais.addEventListener('change', function() {
            const paisSeleccionado = selectPais.options[selectPais.selectedIndex].textContent;
            selectEstado.innerHTML = '<option value="">Selecciona tu estado</option>';
            selectCiudad.innerHTML = '<option value="">Selecciona tu ciudad</option>';
            
            if (paisSeleccionado && paisSeleccionado !== 'Selecciona tu país') {
                cargarEstados(paisSeleccionado);
            }
        });

        // Evento para cargar ciudades cuando se selecciona un estado
        selectEstado.addEventListener('change', function() {
            const estadoSeleccionado = selectEstado.value;
            selectCiudad.innerHTML = '<option value="">Selecciona tu ciudad</option>';
            
            if (estadoSeleccionado && estadoSeleccionado !== 'Selecciona tu estado') {
                cargarCiudades(estadoSeleccionado);
            }
        });

        // Iniciar carga de países
        obtenerTokenAcceso();

        // Función para mostrar errores
        function mostrarError(elementId, mensaje) {
            const errorElement = document.getElementById(elementId + 'Error');
            if (errorElement) {
                errorElement.textContent = mensaje;
                errorElement.style.color = 'red';
            }
        }

        // Función para limpiar errores
        function limpiarError(elementId) {
            const errorElement = document.getElementById(elementId + 'Error');
            if (errorElement) {
                errorElement.textContent = '';
            }
        }

        // Función para validar email
        function validarEmail(email) {
            const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            return regex.test(email);
        }

        // Función para validar contraseña
        function validarPassword(password) {
            const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;
            return regex.test(password);
        }

        // Función para validar fecha de nacimiento
        function validarFechaNacimiento(fecha) {
            const hoy = new Date();
            const fechaNacimiento = new Date(fecha);
            const edad = hoy.getFullYear() - fechaNacimiento.getFullYear();
            return edad >= 10;
        }

        // Función para validar teléfono
        function validarTelefono(telefono) {
            const regex = /^[0-9]{10}$/;
            return regex.test(telefono);
        }

        // Manejador de envío del formulario
        document.getElementById('registroForm').addEventListener('submit', function(event) {
            event.preventDefault();
            
            let errores = false;

            const nombre = document.getElementById('nombre').value;
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            const pais = document.getElementById('pais').value;
            const estado = document.getElementById('estado').value;
            const ciudad = document.getElementById('ciudad').value;
            const fechaNacimiento = document.getElementById('fechaNacimiento').value;
            const telefono = document.getElementById('telefono').value;
            const genero = document.querySelector('input[name="genero"]:checked');
            const bando = document.getElementById('bando').value;

            limpiarError('nombre');
            limpiarError('email');
            limpiarError('password');
            limpiarError('pais');
            limpiarError('estado');
            limpiarError('ciudad');
            limpiarError('fechaNacimiento');
            limpiarError('telefono');
            limpiarError('genero');
            limpiarError('bando');

            if (nombre.trim() === '') {
                mostrarError('nombre', 'El nombre es obligatorio');
                errores = true;
            }
            if (!validarEmail(email)) {
                mostrarError('email', 'Correo electrónico no válido');
                errores = true;
            }
            if (!validarPassword(password)) {
                mostrarError('password', 'La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número');
                errores = true;
            }
            if (pais === '') {
                mostrarError('pais', 'Por favor selecciona un país');
                errores = true;
            }
            if (estado === '') {
                mostrarError('estado', 'Por favor selecciona un estado');
                errores = true;
            }
            if (ciudad === '') {
                mostrarError('ciudad', 'Por favor selecciona una ciudad');
                errores = true;
            }
            if (!validarFechaNacimiento(fechaNacimiento)) {
                mostrarError('fechaNacimiento', 'Debes ser mayor de 10 años');
                errores = true;
            }
            if (!validarTelefono(telefono)) {
                mostrarError('telefono', 'El teléfono debe tener 10 dígitos numéricos');
                errores = true;
            }
            if (!genero) {
                mostrarError('genero', 'Por favor selecciona un género');
                errores = true;
            }
            if (bando === '') {
                mostrarError('bando', 'Por favor selecciona un bando');
                errores = true;
            }

            if (!errores) {
                // Crear un objeto FormData para enviar los datos al servlet
                const formData = new FormData(document.getElementById('registroForm'));

                // Enviar los datos al servidor usando fetch
                fetch('registerController', {
                    method: 'POST',
                    body: formData
                })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Error en el registro');
                    }
                    return response.text(); // o response.json() dependiendo de la respuesta del servidor
                })
                .then(data => {
                    alert('Registro exitoso');
                    window.location.href = 'indexView.jsp'; // Redirigir a la página de inicio
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('Hubo un problema con el registro. Intente nuevamente.');
                });
            }
        });
    });
    </script>
</body>
</html>
