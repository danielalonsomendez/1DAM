
for (var i = 0; i < document.querySelectorAll(".desconectar").length; i++) {
    document.getElementsByClassName("desconectar")[i].addEventListener('click', desconectar, false);
}
function desconectar() {
    document.cookie = 'PHPSESSID=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    window.location.href = "/login.php";
}

function validarLogin() {
    let usuario = document.forms["login"]["usuario"].value;
    if (usuario == "") {
        alert("El campo usuario no puede estar vacío");
        return false;
    }
    let contrasena = document.forms["login"]["contrasena"].value;
    if (contrasena == "") {
        alert("El campo contraseña no puede estar vacío");
        return false;
    }
    return true;
}
function tipoEvento(radio) {
    document.getElementById("vuelos").style = (radio.value == "vuelo") ? "display: block" : "display: none";
    tipoVuelo()
    document.getElementById("alojamientos").style = (radio.value == "alojamientoRadio") ? "display: block" : "display: none";
    document.getElementById("otros").style = (radio.value == "otro") ? "display: block" : "display: none";
}
function tipoVuelo() {
    document.getElementById("vuelovuelta").style = (document.getElementById('ida-vuelta').checked == true && document.getElementById('vuelo').checked== true) ? "display: block" : "display: none";
}
function calcularDias() {
    if(document.getElementById("FechaInicio").value != "" && document.getElementById("FechaFin").value != "" ){
        const date1 = new Date(document.getElementById("FechaInicio").value);
        const date2 = new Date(document.getElementById("FechaFin").value);
        var diffDays = parseInt((date2 - date1) / (1000 * 60 * 60 * 24), 10)+1; 
        if (diffDays > 0) {
            document.getElementById("DuracionViaje").innerHTML = "Duración del viaje: " + diffDays + ((diffDays == 1) ? " día" : " días");
        } else {
            document.getElementById("DuracionViaje").innerHTML = "La FECHA FIN no puede ser antes que la FECHA INICIO"
        }
    }else {
        document.getElementById("DuracionViaje").innerHTML = ""
    }
}
function validarViaje() {
    let NombreViaje = document.forms["RegistrarViaje"]["NombreViaje"].value;
    let TipoViaje = document.forms["RegistrarViaje"]["TipoViaje"].value;
    let Pais = document.forms["RegistrarViaje"]["pais"].value;
    let FechaInicio = document.forms["RegistrarViaje"]["FechaInicio"].value;
    let FechaFin = document.forms["RegistrarViaje"]["FechaFin"].value;
    let Descripcion = document.forms["RegistrarViaje"]["DescripcionViaje"].value;
    let ServiciosNoIncluidos = document.forms["RegistrarViaje"]["ServiciosNoIncluidos"].value;

     mensajeError = [];
    if ((NombreViaje.length >= 1 || NombreViaje.length >= 30) == false) {
        mensajeError.push("Nombre no puede estar vacio");
    }
    if (TipoViaje.length == 0) {
        mensajeError.push("Tipo de viaje no puede estar vacio");
    }
    if (Pais.length == 0) {
        mensajeError.push("Pais no puede estar vacio");
    }
    if (FechaInicio.length == 0) {
        mensajeError.push("Fecha de inicio no puede estar vacio");
    }
    if (FechaFin.length == 0) {
        mensajeError.push("Fecha de fin no puede estar vacio");
    }
    if (FechaFin.length != 0 && FechaInicio.length != 0  &&((new Date(FechaInicio)<new Date(FechaFin) || new Date(FechaInicio)== new Date(FechaFin)) == false)) {
        mensajeError.push("Fecha fin no puede ser antes que fecha inicio");
    }
    if (Descripcion.length == 0) {
        mensajeError.push("Descripción no puede estar vacio");

    }
    if (ServiciosNoIncluidos.length == 0) {
        mensajeError.push("Servicios no incluidos no puede estar vacio");
    }
    if (mensajeError.length != 0) {
      alert("- " + mensajeError.join("\n - "))  
    }
    return mensajeError.length ==0;
}
function validarEvento() {
    // Atributos comunes de todos los eventos
    let NombreEvento =  document.forms["RegistrarEvento"]["nombre-evento"].value;
    let TipoEvento =  document.forms["RegistrarEvento"]["tipoEventoRadio"].value;
    let TipoVuelo =  document.forms["RegistrarEvento"]["tipoVueloRadio"].value;


    let Precio = 0;
    if (TipoEvento != null) {
        switch (TipoEvento) {
        case "alojamientoRadio":
            Precio =   document.forms["RegistrarEvento"]["PrecioAlojamiento"].value;
            break;
        case "vuelo":
            Precio = document.forms["RegistrarEvento"]["PrecioVuelo"].value;
            break;
        case "otro":
            Precio = document.forms["RegistrarEvento"]["PrecioOtros"].value;
            break;
        }
    }
    // Atributos ALOJAMIENTO
    let NombreHotel =  document.forms["RegistrarEvento"]["NombreHotel"].value;
    let FechaEntrada_Alojamiento = document.forms["RegistrarEvento"]["FechaEntrada"].value;
    let FechaSalida_Alojamiento = document.forms["RegistrarEvento"]["FechaSalida"].value;
    let Ciudad = document.forms["RegistrarEvento"]["Ciudad"].value;
    let TipoHabitacion = document.forms["RegistrarEvento"]["TipoHabitacion"].value;

    // Atributos OTROS
    let Fecha_Otros =document.forms["RegistrarEvento"]["FechaOtros"].value;
    let Descripcion = document.forms["RegistrarEvento"]["Descripción"].value;
    // Atributos VUELO
    let AeropuertoOrigen = document.forms["RegistrarEvento"]["aeropuertoOrigen"].value;
    let AeropuertoDestino = document.forms["RegistrarEvento"]["aeropuertoDestino"].value;
    // Atributos VUELO IDA
    let Aerolinea = document.forms["RegistrarEvento"]["aerolinea"].value;
    let CodigoVuelo =document.forms["RegistrarEvento"]["codigoVuelo"].value;
    let DuracionVuelo = document.forms["RegistrarEvento"]["DuracionVuelo"].value;
    let HoraSalida = document.forms["RegistrarEvento"]["HoraSalida"].value;
    let FechaSalida =document.forms["RegistrarEvento"]["fechaSalida"].value;
    // Atributos VUELO VUELTA
    let AerolineaVuelta = document.forms["RegistrarEvento"]["aerolineaVuelta"].value;
    let CodigoVueloVuelta = document.forms["RegistrarEvento"]["codigoVueloVuelta"].value;
    let HoraSalidaVuelta =document.forms["RegistrarEvento"]["horaSalidaVuelta"].value;
    let FechaSalidaVuelta = document.forms["RegistrarEvento"]["fechaSalidaVuelta"].value;
    let DuracionVueloVuelta = document.forms["RegistrarEvento"]["DuracionVueloVuelta"].value;
    
    mensajeError = [];
    if (NombreEvento.length < 1 || NombreEvento.length > 30) {
        mensajeError.push("El nombre del evento no puede estar vacío");
    }
    if (TipoEvento == null) {
        mensajeError.push("El tipo del Evento no puede estar vacío");
    } else {
        if (TipoEvento=="alojamientoRadio") {
            if (NombreHotel.length < 1 || NombreHotel.length > 30) {
                mensajeError.push("El nombre del hotel no puede estar vacío");
            }
            if (FechaEntrada_Alojamiento.length == 0) {
                mensajeError.push("La fecha de entrada al hotel no puede estar vacía");
            }
            if (FechaSalida_Alojamiento.length == 0) {
                mensajeError.push("La fecha de salida al hotel no puede estar vacío");
            }
            if (Ciudad.length == 0) {
                mensajeError.push("El nombre de la ciudad no puede estar vacío");
            }
            if (TipoHabitacion.length == 0) {
                mensajeError.push("El tipo de habitación no puede estar vacío");
            }
    
        }
        if (TipoEvento=="vuelo" || TipoVuelo=="ida-vuelta") {
            if (AeropuertoOrigen.length == 0) {
                mensajeError.push("El aeropuerto de origen no puede estar vacío");
            }
            if (AeropuertoDestino.length == 0) {
                mensajeError.push("El aeropuerto de destino no puede estar vacío");
            }
            if (Aerolinea.length == 0) {
                mensajeError.push("El nombre de la aerolinea no puede estar vacío");
            }
            if (CodigoVuelo.length == 0) {
                mensajeError.push("El codigo del vuelo no puede estar vacío");
            }
            if (HoraSalida.length == 0) {
                mensajeError.push("La hora de salida del vuelo no puede estar vacía");
            }
            if (DuracionVuelo.length == 0) {
                mensajeError.push("La duración del vuelo no puede estar vacía");
            }
            if (FechaSalida.length == 0) {
                mensajeError.push("La fecha de salida del vuelo no puede estar vacía");
            }
            if (TipoVuelo=="ida-vuelta") {
    
                if (AerolineaVuelta.length == 0) {
                    mensajeError.push("El nombre de la aerolinea de vuelta no puede estar vacío");
                }
                if (CodigoVueloVuelta.length == 0) {
                    mensajeError.push("El codigo del vuelo de vuelta no puede estar vacío");
                }
                if (HoraSalidaVuelta.length == 0) {
                    mensajeError.push("La hora de salida del vuelo de vuelta no puede estar vacía");
                }
                if (FechaSalidaVuelta.length == 0) {
                    mensajeError.push("La fecha de salida del vuelo de vuelta no puede estar vacía");
                }
                if (DuracionVueloVuelta.length == 0) {
                    mensajeError.push("La duración del vuelo de vuelta no puede estar vacía");
                }
            }
        }
        if (TipoEvento=="otro") {
            if (Fecha_Otros.length == 0) {
                mensajeError.push("La fecha del evento no puede estar vacía");
            }
            if (Descripcion.length == 0) {
                mensajeError.push("La descripcion evento no puede estar vacía");
            }
        }
    }
    if (mensajeError.length != 0) {
        alert("- " + mensajeError.join("\n - "))  
      }
    
    return mensajeError.length == 0;
    
    }
    