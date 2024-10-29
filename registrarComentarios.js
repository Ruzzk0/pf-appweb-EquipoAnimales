    document.addEventListener("DOMContentLoaded", function () {
    const modals = document.querySelectorAll('.modal'); // Selecciona todos los modales
    const commentBtns = document.querySelectorAll('.add-comment-btn'); // Selecciona todos los botones de comentario

    commentBtns.forEach((btn, index) => {
        btn.addEventListener('click', () => {
            modals[index].style.display = "block"; // Muestra el modal correspondiente
        });
    });

    // Cerrar el modal al hacer clic en la "X" para cada modal
    modals.forEach((modal) => {
        modal.querySelector('.close').addEventListener('click', () => {
            modal.style.display = "none";
        });
    });

    // Cerrar el modal si se hace clic fuera de él
    window.addEventListener('click', (event) => {
        modals.forEach((modal) => {
            if (event.target === modal) {
                modal.style.display = "none";
            }
        });
    });

    // Manejar el evento de envío de comentario para cada modal
    modals.forEach((modal, index) => {
        modal.querySelector('#submitComment').addEventListener('click', (e) => {
            e.preventDefault();
            const commentText = modal.querySelector('#commentText');
            const commentsList = document.querySelectorAll('.comments-list')[index];
            const commentCount = document.querySelectorAll('.comment-count')[index];

            const comment = commentText.value.trim();

            if (comment !== '') {
                const commentItem = document.createElement('div');
                commentItem.classList.add('comment-item');
                commentItem.textContent = comment;

                // Agregar nuevo comentario a la lista
                commentsList.appendChild(commentItem);
                const currentCount = parseInt(commentCount.textContent) || 0;
                commentCount.textContent = `${currentCount + 1} comentarios`;
                commentText.value = '';
                modal.style.display = "none"; // Cierra el modal
            } else {
                alert('Por favor, escribe un comentario antes de enviar.');
            }
        });
    });
});