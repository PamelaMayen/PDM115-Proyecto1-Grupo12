<?php

include 'conexion.php'
$equipoGene=$:POST['EQUIPOGENERICOID'];
$codigoEqui=$:POST['CODIGOEQUIPO'];
$query="DELETE FROM equipoinformatico WHERE EQUIPOGENERICOID='".$equipoGene."'AND CODIGOEQUIPO='".$CODIGOeQUI."';
echo($query);
$resultado = mysql_query($query) or die(mysql_error());
//Si la respuesta es correcta enviamos 1 y sino enviamos 0
if(mysql_affected_rows() == 1)
 $respuesta=array('resultado'=>1);
echo json_encode($respuesta);
mysql_close($conexion);
?>