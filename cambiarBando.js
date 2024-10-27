function cambiarBandoColor() {
    const selectedValue = document.getElementById("bando").value;
    const imagenPerfil = document.getElementById("imagenPerfil");

    // Remueve todas las clases de borde existentes
    imagenPerfil.classList.remove("borde-terrestre", "borde-acuatico", "borde-aereo");

    // Añade la clase correspondiente según la selección
    if (selectedValue === "terrestre") {
        imagenPerfil.classList.add("borde-terrestre");
    } else if (selectedValue === "acuatico") {
        imagenPerfil.classList.add("borde-acuatico");
    } else if (selectedValue === "aereo") {
        imagenPerfil.classList.add("borde-aereo");
    }

    // Guardar el valor en localStorage
    localStorage.setItem("bandoSeleccionado", selectedValue);
}

function verPerfil() {
    // Redirigir a la página de perfil
    window.location.href = 'perfil.html'; // Asegúrate de que este sea el nombre correcto del archivo
}