<?php
include 'conexion.php';
$us=$_POST['usuario'];
$contra=$_POST['contrasena'];

$sentencia=$conexion->prepare("SELECT * FROM usuario WHERE usuario=? AND contrasena=?");
$sentencia->bind_param('ss',$us,$contra);
$sentencia->execute();

$resultado = $sentencia->get_result();
if ($fila = $resultado->fetch_assoc()) {
         echo json_encode($fila,JSON_UNESCAPED_UNICODE);     
}
$sentencia->close();
$conexion->close();
?>