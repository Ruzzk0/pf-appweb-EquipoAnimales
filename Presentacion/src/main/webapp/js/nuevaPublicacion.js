document.getElementById('formPublicar').addEventListener('submit', async function (event) {
    event.preventDefault();

    const formData = new FormData(this);

    try {
        const response = await fetch(this.action, {
            method: 'POST',
            body: formData
        });

        const responseText = await response.text(); // Leer como texto en lugar de JSON
        console.log('Respuesta del servidor:', responseText);

        const jsonData = JSON.parse(responseText); // Intentar parsear a JSON
        alert(jsonData.message);

        if (jsonData.success) {
            this.reset();                
            window.location.href = 'principalView.jsp'; // Redirigir a la página de inicio
            
        }
    } catch (error) {
        console.error('Error al enviar los datos:', error);
        alert('Ocurrió un problema al procesar la publicación.');
    }
});