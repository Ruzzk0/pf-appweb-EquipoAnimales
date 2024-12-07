/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
document.getElementById('imagenPost').addEventListener('change', function (event) {
    const file = event.target.files[0];
    const previewContainer = document.querySelector('.imagen-preview');

    if (file) {
        const reader = new FileReader();
        reader.onload = function (e) {
            previewContainer.innerHTML = `<img src="${e.target.result}" alt="Vista previa de imagen" class="preview-image">`;
        };
        reader.readAsDataURL(file);
    }
});

