document.getElementById('btnPublicar').addEventListener("click", function(event) {
    event.preventDefault(); // Evita el envío del formulario para procesarlo en el frontend

    // Captura los valores de cada campo
    const nombre = document.getElementById("nombreAnimalPost").value;
    const tamaño = document.getElementById("tamañoAnimalPost").value;
    const caracteristicas = document.getElementById("caracteristicasAnimalPost").value;
    const dieta = document.getElementById("dietaAnimalPost").value;
    const habitad = document.getElementById("habitadAnimalPost").value;
    const imagen = document.getElementById("imagenPost").files[0]; // Captura el archivo de imagen

    if (!nombre || !tamaño || !caracteristicas || !dieta || !habitad) {
        alert("Por favor, completa todos los campos requeridos.");
        return; // Detiene el flujo si algún campo está vacío
    }


    // Guarda los datos en un objeto
    const animalData = {
        nombre: nombre,
        tamaño: tamaño,
        caracteristicas: caracteristicas,
        dieta: dieta,
        habitad: habitad,
        imagen: imagen
    };

    window.location.href = '../html/principal.html';
    // Aquí puedes hacer lo que necesites con los datos, como enviarlos a un servidor
});