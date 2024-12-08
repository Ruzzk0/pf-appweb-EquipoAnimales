document.getElementById('submitCommentBtn').addEventListener('click', function() {
    const commentText = document.getElementById('commentText').value;  // Asegúrate de que el ID sea el correcto
    
    if (commentText.trim() !== "") {
        // Crear un objeto JSON con el comentario
        const commentData = {
            comment: commentText
        };

        // Llamada al servlet para enviar el comentario como JSON
        fetch(window.location.origin + '/Presentacion/registrarComentariosController', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(commentData) // Convertimos el objeto a JSON
        })
        .then(response => response.json())
        .then(data => {
            // Aquí puedes agregar el comentario en la sección de comentarios de la página
            const commentList = document.querySelector('.comments-list');
            const newComment = document.createElement('p');
            newComment.textContent = data.comment; // Suponiendo que el servlet devuelve el comentario
            commentList.appendChild(newComment);
        })
        .catch(error => console.error('Error:', error));
    } else {
        alert("Por favor, escribe un comentario.");
    }
});