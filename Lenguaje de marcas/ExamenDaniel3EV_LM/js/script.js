fetch("./xml/diosesgriegos.xml").then((response) => response.text())
    .then((xml) => {
        const dioses = new DOMParser().parseFromString(xml, "application/xml").querySelectorAll("dios");
        for (let i in dioses) {
            let dios = dioses[i];
            let nombre = dios.querySelector("nombre").textContent;
            let imagen = dios.querySelector("imagen").textContent;
            let valor = dios.querySelector("valor").textContent;
            document.getElementById('dioses').innerHTML += `<div id="${nombre.toLowerCase()}"><h1>${nombre}</h1><img src="img/${imagen}" alt="${nombre}"></img><h2>${valor}</h2><input type="checkbox" onchange='mostrarPuntos();' id="${nombre}" name="${nombre}" value="${valor};${nombre}"></div>`
        }
    })
function mostrarPuntos() {
    let seleccionados = [];
    let sumapuntos = 0;
    let mensaje = document.getElementById('mensaje');
    let inputs = document.querySelectorAll("#dioses input[type=checkbox]");
    
    /*Recorrer todos los checkbox y comprobar si estan seleccionados para guardar el nombre y sumar sus puntos*/
    for (let i = 0; i < inputs.length; i++) {
        let input = inputs[i];
        if (input.checked) {
            let datos = input.value.split(";");
            sumapuntos = sumapuntos + parseInt(datos[0])
            seleccionados.push(datos[1]);
        }
    }
    if (seleccionados.length > 4) /*Mensaje de error si supera los 4 dioses*/ {
        mensaje.innerHTML = "Solo se pueden seleccionar 4 dioses"
        mensaje.classList.add("fondonegro")
    } else if (sumapuntos > 300) /*Mensaje de error si supera los 300 puntos*/ {
        mensaje.innerHTML = "No tienes tantos puntos"
        mensaje.classList.add("fondonegro")
    }
    else if (seleccionados.length > 0) /*Mostrar puntos y seleccionados, si los hay*/ {
        mensaje.classList.remove("fondonegro")
        mensaje.innerHTML = `${seleccionados.join(", ")} | ${sumapuntos}`
    } else  /*Resetear mensaje*/ {
        mensaje.innerHTML = `| 0`;
        mensaje.classList.remove("fondonegro")
    }
}
