<?php
require_once('conexion.php');
    $sql = "SELECT * FROM aeropuerto";
    $resultado = $conn->query($sql);

    if ($resultado->num_rows >= 1) {
    
      foreach($resultado as $row) {
        $NombreAeropuerto =  $row["NombreAeropuerto"];
        $CodigoAeropuerto = $row["CodigoAeropuerto"];

        echo  "<option value=$CodigoAeropuerto>$NombreAeropuerto</option>";      
    }
    }

?>
 