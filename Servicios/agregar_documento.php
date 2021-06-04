<?php
include 'conexion.php';

$tipo=$_POST['TIPOPRODUCTOID'];
$autor=$_POST['AUTORID'];
$idioma=$_POST['IDIOMAID'];
$isbn=$_POST['ISBN'];
$edicion=$_POST['EDICION'];
$editorial=$_POST['EDITORIAL'];
$titulo=$_POST['TITULO'];

$respuesta=array('resultado'=>0);
json_encode($respuesta);
$conexion=mysqli_connect($servicio,$usuario,$password) or
die ("Problemas en la conexion");
mysqli_select_db($baseDato,$conexion) 
  or  die("Problemas en la seleccion de la base de datos");
$query = "INSERT INTO documento VALUES('".$tipo."','".$autor."','".$idioma."',".$isbn."',".$edicion."',".$editorial."',".$titulo.");";
echo($query);
$resultado = mysqli_query($query) or die(mysql_error());
//Si la respuesta es correcta enviamos 1 y sino enviamos 0
if(mysqli_affected_rows() == 1)
   $respuesta=array('resultado'=>1);
echo json_encode($respuesta);
mysqli_close($conexion);
?>