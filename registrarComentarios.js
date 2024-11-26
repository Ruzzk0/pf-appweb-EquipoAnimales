
// Espera a que el DOM esté completamente cargado
document.addEventListener("DOMContentLoaded", function () {
    // Selecciona todas las tarjetas
    const cards = document.querySelectorAll('.card');

    // Itera sobre cada tarjeta para agregar la funcionalidad de comentarios, edición y eliminación
    cards.forEach((card, index) => {
        const modal = card.querySelector('.modal');
        const commentText = card.querySelector('#commentText');
        const commentBtn = card.querySelector('.add-comment-btn');
        const commentsList = card.querySelector('.comments-list');
        const commentCount = card.querySelector('.comment-count');
        const deleteBtn = card.querySelector('.delete-btn');
        const editBtn = card.querySelector('.edit-btn');

        // Cargar comentarios desde localStorage al inicio para cada tarjeta
        loadComments(card, index);

        // Muestra el modal al hacer clic en el botón de comentar
        commentBtn.addEventListener('click', () => {
            modal.style.display = "block"; // Muestra el modal
        });

        // Cerrar el modal al hacer clic en la "X"
        card.querySelector('.close').addEventListener('click', () => {
            modal.style.display = "none";
        });

        // Cerrar el modal si se hace clic fuera de él
        window.addEventListener('click', (event) => {
            if (event.target === modal) {
                modal.style.display = "none";
            }
        });

        // Maneja el evento de envío de comentario
        card.querySelector('#submitComment').addEventListener('click', (e) => {
            e.preventDefault();
            const comment = commentText.value.trim();

            if (comment !== '') {
                // Crea un nuevo elemento de comentario
                const commentItem = document.createElement('div');
                commentItem.classList.add('comment-item');
                commentItem.textContent = comment;

                // Agrega el nuevo comentario a la lista de comentarios
                commentsList.appendChild(commentItem);

                // Actualiza el contador de comentarios
                updateCommentCount(commentsList, commentCount);

                // Guarda el comentario en localStorage
                saveComment(card, index, comment);

                // Limpia el textarea y cierra el modal
                commentText.value = '';
                modal.style.display = "none";
            } else {
                alert('Por favor, escribe un comentario antes de enviar.');
            }
        });

        // Maneja el evento de eliminación de tarjetas
        deleteBtn.addEventListener('click', () => {
            if (confirm('¿Estás seguro de que deseas eliminar esta tarjeta?')) {
                card.remove();
                // También puedes borrar los comentarios de localStorage si es necesario
                localStorage.removeItem(`card-comments-${index}`);
            }
        });

        // Maneja el evento de edición de tarjetas (sin funcionalidad aún)
        editBtn.addEventListener('click', () => {
            alert('Funcionalidad de edición no implementada.');
        });
    });

    // Función para actualizar el contador de comentarios
    function updateCommentCount(commentsList, commentCountElement) {
        const currentCount = commentsList.children.length;
        commentCountElement.textContent = `${currentCount} comentario${currentCount !== 1 ? 's' : ''}`;
    }

    // Función para guardar comentarios en localStorage
    function saveComment(card, cardIndex, comment) {
        let comments = JSON.parse(localStorage.getItem(`card-comments-${cardIndex}`)) || [];
        comments.push(comment);
        localStorage.setItem(`card-comments-${cardIndex}`, JSON.stringify(comments));
    }

    // Función para cargar comentarios desde localStorage
    function loadComments(card, cardIndex) {
        const commentsList = card.querySelector('.comments-list');
        const commentCount = card.querySelector('.comment-count');
        let comments = JSON.parse(localStorage.getItem(`card-comments-${cardIndex}`)) || [];
        comments.forEach(comment => {
            const commentItem = document.createElement('div');
            commentItem.classList.add('comment-item');
            commentItem.textContent = comment;
            commentsList.appendChild(commentItem);
        });
        updateCommentCount(commentsList, commentCount);
    }
});
