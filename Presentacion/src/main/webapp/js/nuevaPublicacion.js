document.getElementById('formPublicar').addEventListener('submit', async function (event) {
    event.preventDefault(); // Evita el envío normal del formulario

    const formData = new FormData();

    // Agregar los datos al FormData
    formData.append('nombreAnimal', document.getElementById('nombreAnimalPost').value);
    formData.append('tamanoAnimal', document.getElementById('tamanioAnimalPost').value);
    formData.append('caracteristicas', document.getElementById('caracteristicasAnimalPost').value);
    formData.append('dieta', document.getElementById('dietaAnimalPost').value);
    formData.append('habitat', document.getElementById('habitadAnimalPost').value);
    formData.append('imagen', document.getElementById('imagenPost').files[0]); // Archivo de imagen

    try {
        const response = await fetch(window.location.origin + '/Presentacion/NuevaPublicacionController', {
            method: 'POST',
            body: formData
        });

        if (response.ok) {
            const jsonData = await response.json();
            console.log(jsonData); // Depurar la respuesta
            if (jsonData.success) {
                alert(jsonData.message);
                console.log(document.getElementById('imagenPost').files[0]); // Verificar si el archivo se agrega correctamente

                // Opcional: Limpiar el formulario o hacer cualquier otra acción
                document.getElementById('formPublicar').reset();
            } else {
                alert('Error: ' + jsonData.message);
            }
        } else {
            console.error('Error en la respuesta del servidor:', response.status);
            alert('Ocurrió un problema con el servidor.');
        }
    } catch (error) {
        console.error('Error al enviar los datos:', error);
        alert('Ocurrió un problema al enviar los datos.');
    }
});
