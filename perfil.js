let currentImage = null;
let currentBorderClass = null;
let isEditMode = false;

// Activar/desactivar el modo de edición
function toggleEditMode() {
    isEditMode = !isEditMode;
    document.getElementById('fileInput').classList.toggle('hidden', !isEditMode);
    document.getElementById('colorOptions').classList.toggle('hidden', !isEditMode);
    document.getElementById('editProfileButton').classList.toggle('hidden', isEditMode);
    document.getElementById('saveChangesButton').classList.toggle('hidden', !isEditMode);
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
