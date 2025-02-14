<?php

require_once('conexion-php/conexion.php');
$mensajeError = null;

if (isset($_POST['login'])) {
    $usuario = $_POST['usuario'];
    $contrasena = $_POST['contrasena'];

    $sql = "SELECT * FROM agencia WHERE NombreAgencia = '$usuario' and Contraseña = '$contrasena'";
    $resultado = $conn->query($sql);

    if ($resultado->num_rows == 1) {
        session_start();
        $_SESSION['Agencia'] = $usuario;
        header(header: "location: /");
    } else {
        $mensajeError = "Usuario o contraseña incorrectos.";
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
    <title>Iniciar sesión</title>
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/validaciones.js"></script>
</head>

<body>
    <main class="modal">
        <section id="login" class="login">
            <h1>Iniciar sesión</h1>
            <form name="login" action="<?php echo $_SERVER['PHP_SELF']; ?>" onsubmit="return validarLogin()"
                method="post">
                <fieldset>
                    <label for="usuario">Usuario</label>
                    <input type="text" name="usuario">
                </fieldset>
                <fieldset>
                    <label for="contrasena">Contraseña</label>
                    <input type="password" name="contrasena">
                </fieldset>
                <button type="submit" name="login">Iniciar sesión</button>
            </form>
        </section>
    </main>
    <script type="text/javascript">
        document.addEventListener("DOMContentLoaded", function (event) {
            <?php if (!empty($mensajeError)) {
                echo 'alert("' . $mensajeError . '");';
            } ?>
        });
    </script>
</body>

</html>