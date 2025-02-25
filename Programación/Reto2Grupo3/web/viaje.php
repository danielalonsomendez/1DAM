<?php
require_once('conexion-php/conexion.php');
session_start();
$mensajeError = null;
if (isset($_POST['NombreViaje'])) {
  $NombreAgencia = $_SESSION['Agencia'];
  $NombreViaje = $_POST["NombreViaje"];
  $TipoViaje = $_POST["TipoViaje"];
  $Pais = $_POST["pais"];
  $FechaInicio = $_POST["FechaInicio"];
  $FechaFin = $_POST["FechaFin"];
  $DescripcionViaje = $_POST["DescripcionViaje"];
  $ServiciosNoIncluidos = $_POST["ServiciosNoIncluidos"];

  $sql = "insert into Viaje(NombreViaje ,DescripcionViaje ,TipoViaje,FechaInicio ,FechaFin ,ServiciosNoIncluidos,NombreAgencia,PaisDestino) 
     values ('$NombreViaje','$DescripcionViaje','$TipoViaje','$FechaInicio' ,'$FechaFin','$ServiciosNoIncluidos','$NombreAgencia','$Pais')";
  echo $sql;
  if ($conn->query($sql) === TRUE) {
    header("Location: /?viajeCreado=true");
  } else {
    $mensajeError = "Viaje no creado correctamente.";
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
  <title>Registrar Viaje | <?php echo $nombreAgencia; ?></title>

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
    <section>
      <h1>Registrar Viaje</h1>
      <form action="<?php echo $_SERVER['PHP_SELF']; ?>" onsubmit="return validarViaje()" method="post"
        name="RegistrarViaje">
        <fieldset>
          <label for="NombreViaje">Nombre del viaje</label>
          <input type="text" name="NombreViaje" placeholder="Escriba el nombre del viaje">
        </fieldset>
        <div class="campos">
          <fieldset>
            <label for="pais">Pais</label>
            <select id="pais" name="pais">
              <option></option>
              <?php include_once('conexion-php/pais.php'); ?>
            </select>
          </fieldset>
          <fieldset>
            <label for="TipoViaje">Tipo de viaje</label>
            <select name="TipoViaje" id="TipoViaje">
              <option></option>
              <option>Novios</option>
              <option>Senior</option>
              <option>Grupos</option>
              <option>Grandes viajes(destinos exoticos)</option>
              <option>Combinado(vuelo+hotel)</option>
              <option>Escapadas</option>
              <option>Familias con niños menores</option>
            </select>
          </fieldset>

          <fieldset>
            <label for="FechaInicio">Fecha de inicio</label>
            <input type="date" onchange="calcularDias()" id="FechaInicio" name="FechaInicio">
          </fieldset>

          <fieldset>
            <label for="FechaFin">Fecha de fin</label>
            <input type="date" onchange="calcularDias()" id="FechaFin" name="FechaFin">
          </fieldset>
        </div>

        <fieldset>
          <span id="DuracionViaje"></span>
        </fieldset>

        <fieldset>
          <label for="DescripcionViaje">Descripción</label>
          <textarea maxlength="500" name="DescripcionViaje" placeholder="Max. 500 palabras"></textarea>
        </fieldset>

        <fieldset>
          <label for="ServiciosNoIncluidos">Servicios no incluidos</label>
          <textarea maxlength="500" name="ServiciosNoIncluidos" placeholder="Max. 500 palabras"></textarea>
        </fieldset>

        <button type="submit" class="botonformulario">Guardar viaje</button>
      </form>
    </section>

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
  <script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function (event) {
      <?php if (!empty($mensajeError)) {
        echo 'alert("' . $mensajeError . '");';
      } ?>
    });
  </script>

</body>

</html>