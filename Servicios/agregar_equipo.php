<?php 
include 'conexion.php';

$equipoGene=$:POST['EQUIPOGENERICOID'];
$docente=$:POST['DOCENTEID'];
$estado=$:POST['ESTADOEQUIPOID'];
$usuario=$:POST['USUARIO'];
$hora=$:POST['HORAID'];
$codigoEqui=$:POST['CODIGOEQUIPO'];
$fechaAdqui=$:POST['FECHAADQUISICION'];
$query="INSER INTO equipoinformativco VALUES ('".$equipoGene"','".$docente"','".$estado"','".$usuario"','".$hora"','".$codigoEqui"','".$fechaAdqui"')";
$resultado = mysql_query($query) or die(mysql_error());
//Si la respuesta es correcta enviamos 1 y sino enviamos 0
if(mysql_affected_rows() == 1)
 $respuesta=array('resultado'=>1);
echo json_encode($respuesta);
mysql_close($conexion);
?>
