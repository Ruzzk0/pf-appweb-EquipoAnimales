/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



const GestorBando = {
    // Cambia el borde del perfil según el bando seleccionado
    cambiarBandoColor: function (bando) {
        const imagenPerfil = document.getElementById("imagenPerfil");

        // Remueve todas las clases de borde existentes
        imagenPerfil.classList.remove("borde-terrestre", "borde-acuatico", "borde-aereo");

        // Añade la clase correspondiente según el bando seleccionado
        if (bando === "terrestre") {
            imagenPerfil.classList.add("borde-terrestre");
        } else if (bando === "acuatico") {
            imagenPerfil.classList.add("borde-acuatico");
        } else if (bando === "aereo") {
            imagenPerfil.classList.add("borde-aereo");
        }

        // Guarda el bando seleccionado local
        localStorage.setItem("bandoSeleccionado", bando);
    },

    // Obtiene el bando seleccionado desde local
    obtenerBandoSeleccionado: function () {
        return localStorage.getItem("bandoSeleccionado");
    },

    // Muestra la información del perfil con el bando aplicado
    mostrarPerfil: function () {
        const bando = this.obtenerBandoSeleccionado();
        const imagenPerfil = document.getElementById("imagenPerfil");

        if (bando) {
            this.cambiarBandoColor(bando);  
            document.getElementById("nombre").textContent = `Bando: ${bando}`;
        }
    },

    // Redirige a una página específica
    redirigir: function (pagina) {
        window.location.href = pagina;
    }
    };
