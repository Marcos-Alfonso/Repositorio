<!DOCTYPE html>
<html>
<style>
table, th, td {
  border:1px solid black;
}
</style>
<body>
<?php
/*
Crea un array que contenga la siguiente información sobre empleados de la
empresa CHESSCAISSA (introduce datos de prueba):
a. Nombre y Apellidos
b. Año de nacimiento
c. Código Postal
d. Email
e. Salario anual
f. Teléfonos de contacto (el del trabajo, casa y móvil)
*/
$empleado1 = array("Juan Pérez", "21/07/1998",21345, "email1@gmail.com", 123459, array(111,222,333));
$empleado2 = array("Pepe Balome", "21/12/1495",12333, "email2@gmail.com", 153411, array(444,555,666));
$empleado3 = array("Marcelo Conocelo", "13/11/2023",44556, "email3@gmail.com", 41234, array(777,888,999));
$empleados = array($empleado1, $empleado2, $empleado3);
/*
• Presenta por la salida los siguientes datos del primer empleado añadido al array
o Nombre y Apellidos
o Email
o número de móvil
*/
echo $empleados[0][0]."-".$empleados[0][4]."-".$empleados[0][5][2];
//• Especifica la fecha de nacimiento del segundo empleado
$empleados[1][1]="23/05/2002";
echo "</br>".$empleados[1][1];
//• Visualiza los Teléfonos de contacto de todos los empleados
$x = 1;
foreach($empleados as $emple) {
    echo "</b>Empleado ".$x."</b>"; 
    for($i = 0; $i <3; $i++){
        echo "</br>".$emple[5][$i];
      }
      $x++;
  }
//• Introduce los datos de dos empleados más: de José Pérez y Luis Macías (prueba con array_push() )
$empleado2 = array("Luis Macías", "12/01/1389",13333, "email5@gmail.com", 31234, array(454,565,676));
$empleado1 = array("José Perez", "23/07/0001",12344, "email4@gmail.com", 14423, array(121,232,343));

array_push($empleados, $empleado1, $empleado2);

//• Elimina al empleado ubicado en la penúltima posición
array_splice($empleados, count($empleados)-2, 1);
//• Obtén la suma de todos los salarios de los empleados (array_sum())
$sum = 0;
foreach($empleados as $emple) {
    $sum += $emple[4];
  }
  echo "</br> Salario total: ".$sum;
//• Sube el salario de José Pérez en 1000 € e introduce su nuevo teléfono de casa:995665544
$empleados[3][4]= 1000; 
$empleados[3][5][1] = 995665544;
echo "</br>".$empleados[3][4]." - ".$empleados[3][5][1];
//• Indica el total de empleados incluidos en el array
echo "</br> Total de empleados".Count($empleados);
//Visualiza los elementos del array en una Tabla HTML, en su cabecera debe aparecer el nombre de las claves, y en cada fila los datos de cada empleado
echo "<table>";
echo "<tr>
<td>Nombre y Apellidos</td>
<td>Fecha de Nacimiento</td>
<td>Cod. Postal</td>
<td>Correo</td>
<td>Salario Anual</td>
<td>Teléfonos de contacto</td>
</tr>";
foreach($empleados as $emple) {
    echo "<tr>";
    for($i = 0; $i <6; $i++){
        if($i != 5){
            echo "<td>".$emple[$i]."</td>";
        }else{
            
            echo "<td>".$emple[5][0]."</br>".$emple[5][1]."</br>".$emple[5][2]."</br>"."</td>";
            
        }
      }
    echo "</tr>";
  }
echo "</table>";
?>

</body>
</html>