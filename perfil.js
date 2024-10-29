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

function saveChanges() {
    // Aquí podrías agregar lógica para guardar los cambios
    alert('Cambios guardados.');
}

function handleTeamChange(team) {
    // Lógica para manejar el cambio de equipo
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

// Guardar cambios en local
function saveChanges() {
    if (currentImage) {
        localStorage.setItem('profileImage', currentImage);
    }
    if (currentBorderClass) {
        localStorage.setItem('borderClass', currentBorderClass);
    }
    toggleEditMode();
}

// Cambiar borde según el bando
function handleTeamChange(team) {
    const imagenPerfil = document.getElementById('imagenPerfil');
    imagenPerfil.classList.remove('borde-terrestre', 'borde-acuatico', 'borde-aereo');
    
    const newBorderClass = `borde-${team}`;
    imagenPerfil.classList.add(newBorderClass);
    currentBorderClass = newBorderClass;
}

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
