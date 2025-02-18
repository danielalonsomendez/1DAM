<?php
require_once('conexion.php');
    $sql = "SELECT * FROM aerolinea";
    $resultado = $conn->query($sql);

    if ($resultado->num_rows >= 1) {
    
      foreach($resultado as $row) {
        $NombreAerolinea =  $row["NombreAerolinea"];
        $CodigoAerolinea = $row["CodigoAerolinea"];

        echo  "<option value=$CodigoAerolinea>$NombreAerolinea</option>";      
    }
    }

?>
 