// Espera a que el DOM esté completamente cargado
document.addEventListener("DOMContentLoaded", function () {
    const card = document.querySelector('.card');
    const modal = document.getElementById('commentModal');
    const commentText = document.getElementById('commentText');
    const commentBtn = card.querySelector('.add-comment-btn');
    const commentsList = card.querySelector('.comments-list');
    const commentCount = card.querySelector('.comment-count');
    const deleteBtn = card.querySelector('.delete-btn');
    const editBtn = card.querySelector('.edit-btn');

    // Cargar comentarios desde localStorage al inicio
    loadComments();

    // Muestra el modal al hacer clic en el botón de comentar
    commentBtn.addEventListener('click', () => {
        modal.style.display = "block"; // Muestra el modal
    });

    // Cerrar el modal al hacer clic en la "X"
    document.querySelector('.close').addEventListener('click', () => {
        modal.style.display = "none";
    });

    // Cerrar el modal si se hace clic fuera de él
    window.addEventListener('click', (event) => {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    });

    // Maneja el evento de envío de comentario
    document.getElementById('submitComment').addEventListener('click', (e) => {
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
            updateCommentCount(commentsList);

            // Guarda el comentario en localStorage
            saveComment(comment);

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
            localStorage.removeItem(card.id); // Asumiendo que cada tarjeta tiene un id único
        }
    });

    // Maneja el evento de edición de tarjetas (sin funcionalidad aún)
    editBtn.addEventListener('click', () => {
        alert('Funcionalidad de edición no implementada.');
    });

    // Función para actualizar el contador de comentarios
    function updateCommentCount(commentsList) {
        const currentCount = commentsList.children.length;
        commentCount.textContent = `${currentCount} comentario${currentCount !== 1 ? 's' : ''}`;
    }

    // Función para guardar comentarios en localStorage
    function saveComment(comment) {
        let comments = JSON.parse(localStorage.getItem(card.id)) || [];
        comments.push(comment);
        localStorage.setItem(card.id, JSON.stringify(comments));
    }

    // Función para cargar comentarios desde localStorage
    function loadComments() {
        let comments = JSON.parse(localStorage.getItem(card.id)) || [];
        comments.forEach(comment => {
            const commentItem = document.createElement('div');
            commentItem.classList.add('comment-item');
            commentItem.textContent = comment;
            commentsList.appendChild(commentItem);
        });
        updateCommentCount(commentsList);
    }
});
