<?php

include 'conexion.php'
$titulo=$_RESQUEST['TITULO']
$isbn=$_REQUEST['ISBN'];
$quey="DELETE FROM documento WHERE TITULO='".$titulo."'AND ISBN='".$isbn";
echo($query);
$resultado = mysql_query($query) or die(mysql_error());
//Si la respuesta es correcta enviamos 1 y sino enviamos 0
if(mysql_affected_rows() == 1)
 $respuesta=array('resultado'=>1);
echo json_encode($respuesta);
mysql_close($conexion);
?>