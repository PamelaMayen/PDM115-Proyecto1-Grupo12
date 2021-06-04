<?php
$servidor="localhost";
$usuario="root";
$baseDato="proyecto";
$password="";
    
$conexion=new mysqli($servidor,$usuario,$password,$baseDato);
if($conexion->connect_errno){
    echo "El sitio web está experimentado problemas";
}
?>