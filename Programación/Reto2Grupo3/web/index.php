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
    <?php
    session_start();
    $mensajeError = null;
    include_once('conexion-php/agencia.php');

    if (isset($_GET['viajeCreado'])) {
        $mensajeError = "Viaje creado correctamente.";
    }
    if (isset($_GET['eventoCreado'])) {
        $mensajeError = "Evento creado correctamente.";
    }
    ?>
    <title><?php echo $nombreAgencia; ?></title>

    <link rel="stylesheet" type="text/css"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>

<body>
    <main class="modal">
        <section class="principal">
            <a href="#" id="logoprincipal"><img src="<?php echo $logoAgencia ?>" alt=""></a>
            <h2><?php echo $nombreAgencia; ?></h2>
            <a href="viaje.php" id="Vuelo" >Registrar Viaje<i class="fa-solid fa-plane xl"></i></a>
            <a href="evento.php" id="BotonEvento" >Registrar Evento <i
                    class="fa-solid fa-square-h xl"></i></a>
            <a id="Desconectar" class="desconectar">Desconectar<i
                    class="fa-solid fa-arrow-right-from-bracket xl"></i></a>
        </section>
    </main>
    <script type="text/javascript">
        document.addEventListener("DOMContentLoaded", function (event) {
            <?php if (!empty($mensajeError)) {
                echo 'alert("' . $mensajeError . '");';
            } ?>
        });
    </script>
    <script src="js/validaciones.js"></script>
</body>


</html>