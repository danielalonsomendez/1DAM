<?php
require_once('conexion.php');
    $sql = "SELECT * FROM viaje WHERE NombreAgencia = '$nombreAgencia'";
    $resultado = $conn->query($sql);

    if ($resultado->num_rows >= 1) {
    
      foreach($resultado as $row) {
        $ViajeID =  $row["ViajeID"];
        $NombreViaje = $row["NombreViaje"];

        echo  "<option value=$ViajeID>$NombreViaje</option>";      
    }
    }

?>
 