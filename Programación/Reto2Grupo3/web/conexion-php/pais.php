<?php
require_once('conexion.php');
    $sql = "SELECT * FROM pais";
    $resultado = $conn->query($sql);

    if ($resultado->num_rows >= 1) {
    
      foreach($resultado as $row) {
        $DescripcionPais =  $row["DescripcionPais"];
        $PaisCodigo = $row["PaisCodigo"];

        echo  "<option value=$PaisCodigo>$DescripcionPais</option>";      
    }
    }

?>
 