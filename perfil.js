window.onload = function () {
    const bandoSeleccionado = localStorage.getItem("bandoSeleccionado");
    const imagenPerfil = document.getElementById("imagenPerfil");

    if (bandoSeleccionado) {
        // Aplicar la clase correspondiente al borde
        if (bandoSeleccionado === "terrestre") {
            imagenPerfil.classList.add("borde-terrestre");
        } else if (bandoSeleccionado === "acuatico") {
            imagenPerfil.classList.add("borde-acuatico");
        } else if (bandoSeleccionado === "aereo") {
            imagenPerfil.classList.add("borde-aereo");
        }
        
        // Mostrar el bando seleccionado si deseas
        document.getElementById("nombre").textContent = `Bando: ${bandoSeleccionado}`;
    }
}