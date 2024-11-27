/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


let currentImage = null;
let currentBorderClass = null;
let isEditMode = false;

// Activar/desactivar el modo de edición
function toggleEditMode() {
    const colorOptions = document.getElementById('colorOptions');
    const saveButton = document.getElementById('saveChangesButton');
    const editButton = document.getElementById('editProfileButton');

    if (colorOptions.classList.contains('hidden')) {
        colorOptions.classList.remove('hidden');
        saveButton.classList.remove('hidden');
        editButton.classList.add('hidden');
    } else {
        colorOptions.classList.add('hidden');
        saveButton.classList.add('hidden');
        editButton.classList.remove('hidden');
    }
}

// Guardar cambios
function saveChanges() {
    if (currentImage) {
        localStorage.setItem('profileImage', currentImage);
    }
    if (currentBorderClass) {
        localStorage.setItem('borderClass', currentBorderClass);
    }
    toggleEditMode();
    alert('Cambios guardados.');
}

// Cambiar equipo
function handleTeamChange(team) {
    const imagenPerfil = document.getElementById('imagenPerfil');
    imagenPerfil.classList.remove('borde-terrestre', 'borde-acuatico', 'borde-aereo');
    
    const newBorderClass = `borde-${team}`;
    imagenPerfil.classList.add(newBorderClass);
    currentBorderClass = newBorderClass;

    alert(`Has cambiado a: ${team}`);
}

// Cambiar imagen de perfil
document.getElementById('fileInput').addEventListener('change', function(e) {
    const file = e.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            currentImage = e.target.result;
            document.getElementById('imagenPerfil').src = currentImage;
        };
        reader.readAsDataURL(file);
    }
});

// Cargar datos guardados al iniciar la página
window.addEventListener('load', function() {
    const savedImage = localStorage.getItem('profileImage');
    if (savedImage) {
        document.getElementById('imagenPerfil').src = savedImage;
        currentImage = savedImage;
    }
    
    const savedBorderClass = localStorage.getItem('borderClass');
    if (savedBorderClass) {
        document.getElementById('imagenPerfil').classList.add(savedBorderClass);
        currentBorderClass = savedBorderClass;
    }
});
