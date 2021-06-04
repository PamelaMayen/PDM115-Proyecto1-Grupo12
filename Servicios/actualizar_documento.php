<?php
include 'conexion.php';

$editorial=$_POST['EDITORIAL'];
$titulo=$_POST['TITULO']
$edicion=$_POST['EDICION'];

$respuesta=array('resultadp'=>);
json_encode($respuesta);
$conexion=mysqli_connect($servidor,$usuario,$password) or
die ("Problemas en la conexion");
mysqli_select_db($baseDatos,$conexion) 
 or die("Problemas en la seleccion de la base de datos");
$query="UPDATE documento SET EDITORIAL=".$editorial."AND EDICION".$edicion."WHERE TITULO='".$titulo"';
$resultado = mysqli_query($query) or die(mysql_error());
//Si la respuesta es correcta enviamos 1 y sino enviamos 0
if(mysqli_affected_rows() == 1)
 $respuesta=array('resultado'=>1);
echo json_encode($respuesta);
mysqli_close($conexion);
?>