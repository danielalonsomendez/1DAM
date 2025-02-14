<?php
require_once('conexion.php');
$nombreAgencia = "";
$colorAgencia = "";
$logoAgencia = "";
$login = false;
if (isset($_SESSION['Agencia'])) {
  $nombreAgencia = $_SESSION['Agencia'];
  $sql = "SELECT * FROM agencia WHERE NombreAgencia = '$nombreAgencia'";
  $resultado = $conn->query($sql);

  if ($resultado->num_rows == 1) {
    $login = true;
    $row = $resultado->fetch_assoc();
    $colorAgencia = $row['ColorMarca'];
    $logoAgencia = $row['Logo'];
  }
}
if ($login == false) {
  header(header: "location: /login.php");
}
function colorTexto($hex)
{
  list($red, $green, $blue) = sscanf($hex, "#%02x%02x%02x");
  $luma = ($red + $green + $blue) / 3;

  if ($luma < 128) {
    $textcolour = "white";
  } else {
    $textcolour = "black";
  }
  return $textcolour;
}
?>
<style>
  * {
    --coloragencia:
      <?php echo $colorAgencia; ?>
    ;
    --coloragenciatexto:
      <?php echo colorTexto($colorAgencia); ?>
    ;
    ;
  }
</style>