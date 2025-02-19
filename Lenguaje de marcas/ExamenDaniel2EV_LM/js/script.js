
function calcularPrecio() {
    let form = document.forms["preparadosdonatoformulario"];
    let precio = 0;
    let preciop = document.getElementById("total");
    /* Checkboxes*/
    let Alcachofas = form["alcachofas"].checked;
    let Marmitako = form["marmitako"].checked;
    let Cardo = form["cardo"].checked;
    /* Inputs de cantidades*/
    let Alcachofas_Cantidad_Form = form["alcachofas_cantidad"];
    let Marmitako_Cantidad_Form = form["marmitako_cantidad"];
    let Cardo_Cantidad_Form = form["cardo_cantidad"];
    /* Valor de las cantidades*/
    let Alcachofas_Cantidad = parseInt(Alcachofas_Cantidad_Form.value);
    let Marmitako_Cantidad = parseInt(Marmitako_Cantidad_Form.value);
    let Cardo_Cantidad = parseInt(Cardo_Cantidad_Form.value);
    /*Desactivar/activar cantidad segun checkbox*/
    Alcachofas_Cantidad_Form.disabled = !Alcachofas;
    Marmitako_Cantidad_Form.disabled = !Marmitako;
    Cardo_Cantidad_Form.disabled = !Cardo;
    /*Sumar precio si esta activado*/
    if (Alcachofas == true) {
        precio = precio + (15 * Alcachofas_Cantidad)
    }
    if (Marmitako == true) {
        precio = precio + (14 * Marmitako_Cantidad)
    }
    if (Cardo == true) {
        precio = precio + (12 * Cardo_Cantidad)
    }
    /*Mostrar precio actualizado*/
    preciop.innerHTML = "Total pedido: " + precio + "€"
    return precio;
}
function BorrarDatos() {
    let form = document.forms["preparadosdonatoformulario"];
    /*Desactivar checkboxes*/
    form["alcachofas"].checked = false;
    form["marmitako"].checked = false;
    form["cardo"].checked = false;
    /*Cambiar cantidades a 0*/
    form["alcachofas_cantidad"].value = 0;
    form["marmitako_cantidad"].value = 0;
    form["cardo_cantidad"].value = 0;
    /*Vaciar campos*/
    form["nombre"].value = "";
    form["telefono"].value = "";
    form["email"].value = "";
    calcularPrecio();
}
function validarDatos() {
    let form = document.forms["preparadosdonatoformulario"];
    /*Datos a validar*/
    let Nombre = form["nombre"].value.trim();
    let Telefono = form["telefono"].value.trim();
    let precio = calcularPrecio()
    /*Todos los mensajes de error*/
    let mensajeError = [];
    if (Nombre.length == 0) {
        mensajeError.push("Nombre no puede estar vacio");
    }
    if (Telefono.length == 0) {
        mensajeError.push("Telefono no puede estar vacio");
    }
    if (precio == 0) {
        mensajeError.push("El precio de los productos no puede ser 0€")
    }
    /*Si hay errores, muestra todos los errores en un mensaje. Si todo esta correcto, muestra el precio*/
    if (mensajeError.length != 0) {
        alert(" - " + mensajeError.join("\n - "))
    } else {
        alert("Pedido realizado por un importe de " + precio + "€")
    }
    /*Si hay errores, devuelve false. Si todo esta correcto,devuelve true*/
    return mensajeError.length == 0;
}