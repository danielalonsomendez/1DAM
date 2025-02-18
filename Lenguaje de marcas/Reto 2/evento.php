<?php
require_once('conexion-php/conexion.php');
session_start();
$mensajeError = null;
if (isset($_POST['nombre-evento'])) {
    // Atributos comunes de todos los eventos
    $ViajeID = $_POST["viajeID"];
    $NombreEvento = $_POST["nombre-evento"];
    $TipoEvento = $_POST["tipoEventoRadio"];
    $TipoVuelo = $_POST["tipoVueloRadio"];


    $Precio = 0;
    if ($TipoEvento != null) {
        switch ($TipoEvento) {
            case "alojamientoRadio":
                $Precio = $_POST["PrecioAlojamiento"];
                break;
            case "vuelo":
                $Precio = $_POST["PrecioVuelo"];
                break;
            case "otro":
                $Precio = $_POST["PrecioOtros"];
                break;
        }
    }
    // Atributos ALOJAMIENTO
    $NombreHotel = $_POST["NombreHotel"];
    $FechaEntrada_Alojamiento = $_POST["FechaEntrada"];
    $FechaSalida_Alojamiento = $_POST["FechaSalida"];
    $Ciudad = $_POST["Ciudad"];
    $TipoHabitacion = $_POST["TipoHabitacion"];
    // Atributos OTROS
    $Fecha_Otros = $_POST["FechaOtros"];
    $Descripcion = $_POST["Descripción"];
    // Atributos VUELO
    $AeropuertoOrigen = $_POST["aeropuertoOrigen"];
    $AeropuertoDestino = $_POST["aeropuertoDestino"];
    // Atributos VUELO IDA
    $Aerolinea = $_POST["aerolinea"];
    $CodigoVuelo = $_POST["codigoVuelo"];
    $DuracionVuelo = $_POST["DuracionVuelo"];
    $HoraSalida = $_POST["HoraSalida"];
    $FechaSalida = $_POST["fechaSalida"];
    // Atributos VUELO VUELTA
    $AerolineaVuelta = $_POST["aerolineaVuelta"];
    $CodigoVueloVuelta = $_POST["codigoVueloVuelta"];
    $HoraSalidaVuelta = $_POST["horaSalidaVuelta"];
    $FechaSalidaVuelta = $_POST["fechaSalidaVuelta"];
    $DuracionVueloVuelta = $_POST["DuracionVueloVuelta"];
    if ($TipoEvento == "vuelo") {
        if ($TipoVuelo == "ida-vuelta") {
            $sql = "insert into Vuelo(ViajeID,NombreEvento,Precio,CodigoVuelo,FechaSalida,HoraSalida,DuracionVuelo,Aerolinea,AeropuertoOrigen,AeropuertoDestino)  values ('$ViajeID','$NombreEvento','$Precio','$CodigoVuelo','$FechaSalida','$HoraSalida','$DuracionVuelo','$Aerolinea','$AeropuertoDestino','$AeropuertoOrigen')";
            insertar($sql, $conn);
            $EventoVueltaID = getMaxVuelos($conn);
            $sql = "insert into Vuelo(ViajeID,NombreEvento,Precio,CodigoVuelo,FechaSalida,HoraSalida,DuracionVuelo,Aerolinea,AeropuertoOrigen,AeropuertoDestino,EventoVueltaID)  values ('$ViajeID','$NombreEvento','$Precio','$CodigoVuelo','$FechaSalida','$HoraSalida','$DuracionVuelo','$Aerolinea','$AeropuertoOrigen','$AeropuertoDestino',$EventoVueltaID)";

        } else {
            $sql = "insert into Vuelo(ViajeID,NombreEvento,Precio,CodigoVuelo,FechaSalida,HoraSalida,DuracionVuelo,Aerolinea,AeropuertoOrigen,AeropuertoDestino)  values
     ('$ViajeID','$NombreEvento','$Precio','$CodigoVuelo','$FechaSalida','$HoraSalida','$DuracionVuelo','$Aerolinea','$AeropuertoOrigen','$AeropuertoDestino')";

        }
    } else if ($TipoEvento == "alojamientoRadio") {
        $sql = "insert into Alojamiento(ViajeID,NombreEvento,Precio,NombreHotel,Ciudad,FechaEntrada,FechaSalida,TipoHabitacion) 
     values ('$ViajeID','$NombreEvento','$Precio','$NombreHotel','$Ciudad','$FechaEntrada_Alojamiento','$FechaSalida_Alojamiento','$TipoHabitacion')";
    } else if ($TipoEvento == "otro") {
        $sql = "insert into Otros(ViajeID,NombreEvento,Precio,Fecha,Descripcion) values ('$ViajeID','$NombreEvento','$Precio','$Fecha_Otros','$Descripcion')";
    }

    if ($conn->query($sql) === TRUE) {
        header("Location: /?eventoCreado=true");
    } else {
        $mensajeError = "Evento no creado correctamente.";
    }

}
function insertar($sql, $conn)
{
    return $conn->query($sql) === TRUE;
}
function getMaxVuelos($conn)
{
    $resultado = $conn->query("SELECT max(EventoID)  FROM Vuelo ");
    if ($resultado->num_rows == 1) {
        $row = $resultado->fetch_assoc();
        return $row['max(EventoID)'];
    } else {
        return null;
    }
}
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="language" content="es">
    <meta name="author" content="Iker Arrebola, Julen González y Daniel Alonso">
    <meta name="owner" content="Iker Arrebola, Julen González y Daniel Alonso">
    <meta name="description" content="Aplicación Web para la gestión de agencias de vuelo.">
    <meta name="keywords" content="vuelos, alojamientos, actividades">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <?php include_once('conexion-php/agencia.php'); ?>
    <title>Registrar Evento | <?php echo $nombreAgencia; ?></title>
    <link rel="stylesheet" type="text/css"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <script src="js/validaciones.js"></script>
</head>

<body id="top">
    <header>
        <a href="/" id="logo"><img src="<?php echo $logoAgencia ?>" alt=""></a>
        <nav>
            <label for="ico">☰</label>
            <input id="ico" type="checkbox">
            <ul>
                <li><a href="viaje.php"><i class="fa-sharp fa-solid fa-plane"></i>Registrar Viaje</a></li>
                <li><a href="evento.php"><i class="fa-solid fa-square-h"></i>Registrar Evento</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <form action="<?php echo $_SERVER['PHP_SELF']; ?>" onsubmit="return validarEvento()" method="post"
            id="RegistrarEvento" name="RegistrarEvento">
            <section id="evento">
                <h1>Registrar Evento</h1>
                <fieldset>
                    <label for="viajeID">Elegir viaje</label>
                    <select id="viajeID" name="viajeID">
                        <option></option>
                        <?php include('conexion-php/viajes.php'); ?>
                    </select>
                </fieldset>
                <fieldset>
                    <label for="vuelo-ida">Nombre del evento</label>
                    <input type="text" name="nombre-evento" placeholder="Escribe el nombre del evento">
                </fieldset>
                <fieldset class="inline">
                    <legend>Tipo de evento</legend>
                    <input type="radio" id="vuelo" name="tipoEventoRadio" onclick="tipoEvento(this)" value="vuelo">
                    <label for="vuelo">Vuelo</label>

                    <input type="radio" id="alojamientoRadio" name="tipoEventoRadio" onclick="tipoEvento(this)"
                        value="alojamientoRadio">
                    <label for="alojamientoRadio">Alojamiento</label>

                    <input type="radio" id="otro" name="tipoEventoRadio" onclick="tipoEvento(this)" value="otro">
                    <label for="otro">Otros</label>
                </fieldset>

            </section>

            <section id="vuelos">
                <h2>Vuelo de ida</h2>

                <fieldset class="inline">
                    <legend>Tipo de vuelo</legend>
                    <input type="radio" id="ida" name="tipoVueloRadio" onclick="tipoVuelo()" value="ida" checked>
                    <label for="ida">Ida</label>
                    <input type="radio" id="ida-vuelta" name="tipoVueloRadio" onclick="tipoVuelo()" value="ida-vuelta">
                    <label for="ida-vuelta">Ida y Vuelta</label>
                </fieldset>

                <div class="campos">
                    <fieldset>
                        <label for="aeropuertoOrigen">Aeropuerto de origen</label>
                        <select id="aeropuertoOrigen" name="aeropuertoOrigen">
                            <option></option>
                            <?php include('conexion-php/aeropuerto.php'); ?>
                        </select>
                    </fieldset>

                    <fieldset>
                        <label for="aeropuertoDestino">Aeropuerto de destino</label>
                        <select id="aeropuertoDestino" name="aeropuertoDestino">
                            <option></option>
                            <?php include('conexion-php/aeropuerto.php'); ?>
                        </select>
                    </fieldset>

                    <fieldset>
                        <label for="codigoVuelo">Codigo de vuelo</label>
                        <input type="text" id="codigoVuelo" name="codigoVuelo">
                    </fieldset>

                    <fieldset>
                        <label for="aerolinea">Aerolínea</label>
                        <select id="aerolinea" name="aerolinea">
                            <option></option>
                            <?php include('conexion-php/aerolinea.php'); ?>
                        </select>
                    </fieldset>

                    <fieldset>
                        <label for="fechaSalida">Fecha de salida</label>
                        <input type="date" id="fechaSalida" name="fechaSalida">
                    </fieldset>

                    <fieldset>
                        <label for="HoraSalida">Hora de salida</label>
                        <input type="time" id="HoraSalida" name="HoraSalida">
                    </fieldset>

                    <fieldset>
                        <label for="PrecioVuelo">Precio</label>
                        <div class="precio">
                            <input type="number" id="PrecioVuelo" name="PrecioVuelo" step="0.1">
                            <span>€</span>
                        </div>
                    </fieldset>

                    <fieldset>
                        <label for="DuracionVuelo">Duración del viaje (Horas)</label>
                        <input type="time" id="DuracionVuelo" min="0" name="DuracionVuelo">
                    </fieldset>
                </div>

            </section>

            <section id="vuelovuelta">
                <h2>Vuelo de Vuelta</h2>

                <div class="campos">
                    <fieldset>
                        <label for="codigoVueloVuelta">Codigo de vuelo</label>
                        <input type="text" id="codigoVueloVuelta" name="codigoVueloVuelta">
                    </fieldset>

                    <fieldset>
                        <label for="aerolineaVuelta">Aerolínea</label>
                        <select id="aerolineaVuelta" name="aerolineaVuelta">
                            <option></option>
                            <?php include('conexion-php/aerolinea.php'); ?>
                        </select>
                    </fieldset>

                    <fieldset>
                        <label for="fechaSalidaVuelta">Fecha de salida</label>
                        <input type="date" id="fechaSalidaVuelta" name="fechaSalidaVuelta">
                    </fieldset>

                    <fieldset>
                        <label for="horaSalidaVuelta">Hora de salida</label>
                        <input type="time" id="horaSalidaVuelta" name="horaSalidaVuelta">
                    </fieldset>

                    <fieldset>
                        <label for="DuracionVueloVuelta">Duración del viaje (Horas)</label>
                        <input type="time" id="DuracionVueloVuelta" min="0" name="DuracionVueloVuelta">
                    </fieldset>
                </div>

            </section>

            <section id="alojamientos">
                <h2>Alojamientos</h2>

                <div class="campos">
                    <fieldset>
                        <label for="FechaEntrada">Fecha de entrada</label>
                        <input type="date" id="FechaEntrada" name="FechaEntrada">
                    </fieldset>
                    <fieldset>
                        <label for="FechaSalida">Fecha de salida</label>
                        <input type="date" id="FechaSalida" name="FechaSalida">
                    </fieldset>
                </div>

                <fieldset>
                    <label for="Ciudad">Ciudad</label>
                    <input type="text" id="Ciudad" name="Ciudad">
                </fieldset>

                <fieldset>
                    <label for="NombreHotel">Nombre del hotel</label>
                    <input type="text" id="NombreHotel" name="NombreHotel">
                </fieldset>

                <div class="campos">
                    <fieldset>
                        <label for="PrecioAlojamiento">Precio</label>
                        <div class="precio">
                            <input type="number" id="PrecioAlojamiento" name="PrecioAlojamiento" step="0.1">
                            <span>€</span>
                        </div>
                    </fieldset>

                    <fieldset>
                        <label for="TipoHabitacion">Tipo de habitación</label>
                        <select id="TipoHabitacion" name="TipoHabitacion">
                            <option></option>
                            <option value="DB">Doble</option>
                            <option value="DUI">Doble con uso individual</option>
                            <option value="SIN">Individual</option>
                            <option value="TPL">Triple</option>
                        </select>

                    </fieldset>
                </div>

            </section>

            <section id="otros">
                <h2>Otros Servicios</h2>

                <div class="campos">
                    <fieldset>
                        <label for="FechaOtros">Fecha</label>
                        <input type="date" id="FechaOtros" name="FechaOtros">
                    </fieldset>

                    <fieldset>
                        <label for="PrecioOtros">Precio</label>
                        <div class="precio">
                            <input type="number" id="PrecioOtros" name="PrecioOtros" step="0.1">
                            <span>€</span>
                        </div>
                    </fieldset>
                </div>

                <fieldset>
                    <label for="Descripción">Descripción</label>
                    <textarea maxlength="500" name="Descripción" placeholder="Max. 500 palabras"></textarea>
                </fieldset>


            </section>
            <button type="submit" class="botonformulario">Guardar evento</button>
        </form>

    </main>

    <footer>
        <nav>
            <ul>
                <li><a href="#">© <?php echo $nombreAgencia; ?></a></li>
                <li><a onclick="return desconectar()" class="desconectar"><i
                            class="fa-solid fa-arrow-right-from-bracket"></i>Desconectar</a></li>
                <li><a href="#top"><i class="fa-solid fa-arrow-up"></i>Subir</a></li>
            </ul>
        </nav>
    </footer>
</body>

</html>