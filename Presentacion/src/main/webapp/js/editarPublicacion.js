/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
document.getElementById('btnEditarPublicacion').addEventListener("click", function(event) {
    event.preventDefault(); 

    // Captura los valores de cada campo
    const idPublicacion = document.getElementById("idPublicacion").value; 
    const nombre = document.getElementById("nombreAnimalPost").value;
    const tamaño = document.getElementById("tamañoAnimalPost").value;
    const caracteristicas = document.getElementById("caracteristicasAnimalPost").value;
    const dieta = document.getElementById("dietaAnimalPost").value;
    const habitad = document.getElementById("habitadAnimalPost").value;
    const imagen = document.getElementById("imagenPost").files[0]; 

    // Validación
    if (!idPublicacion || !nombre || !tamaño || !caracteristicas || !dieta || !habitad) {
        alert("Por favor, completa todos los campos requeridos.");
        return; // Detiene el flujo si algún campo está vacío
    }

    // Guarda los datos editados en un objeto
    const updatedAnimalData = {
        id: idPublicacion, 
        nombre: nombre,
        tamaño: tamaño,
        caracteristicas: caracteristicas,
        dieta: dieta,
        habitad: habitad,
        imagen: imagen
    };

    console.log("Datos de la publicación editada:", updatedAnimalData);

    // Redirige a la página principal
    window.location.href = 'principal.html';
});



