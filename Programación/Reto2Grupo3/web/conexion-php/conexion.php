<?php
$conn = new mysqli("127.0.0.1:33060", "root", "elorrieta", "viajeserrekamari");
if ($conn->connect_error) {
    die("Fallo en la conexión: " . $conn->connect_error);
}
?>