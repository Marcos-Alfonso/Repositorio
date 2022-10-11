<!DOCTYPE html>
<html>
<body>
<?php
//Crea un array asociativo que almacene nombres de ciudades de España. La clave que emplees puede ser numérica o de tipo cadena
$ciudades = array("HU"=>"Huelva", "SE"=>"Sevilla", "MD"=>"Madrid", "BR"=>"Barcelona", "MG"=>"Málaga");
echo "<h3>Array original</h3>";
foreach($ciudades as $x => $x_value) {
    echo "Ciudad=" . $x_value . ", Clave=" . $x;
    echo "<br>";
  }

//Ordena el array por orden alfabético según la clave
echo "<h3>Array ordenado</h3>";
ksort($ciudades);
foreach($ciudades as $x => $x_value) {
    echo "Ciudad=" . $x_value . ", Clave=" . $x;
    echo "<br>";
  }

//• Recupera el valor la tercera ciudad del array (lo visualizas por la salida)
echo array_values($ciudades)[2];

//Agrega la ciudad de Tarragona
$ciudades["TR"] = "Tarragona";

//• Verifica si Tarragona existe en el Array utilizando la funciónarray_search() . Visualiza su clave asociada por pantalla
echo "<br/>".array_search("Tarragona", $ciudades);
//• Visualiza el valor de la última ciudad del array
echo "<br/>".array_values($ciudades)[count($ciudades)-1];
//• Utiliza la función array_slice() para crear un nuevo array que no contengael primer y último elemento del array original
$newCiudad = array_slice($ciudades, 1, count($ciudades)-2);
foreach($newCiudad as $x => $x_value) {
    echo "Ciudad=" . $x_value . ", Clave=" . $x;
    echo "</br>";
  }
//• Visualiza los elementos de ambos arrays
echo "<h3>Array</h3>";
foreach($ciudades as $x => $x_value) {
  echo "Ciudad=" . $x_value . ", Clave=" . $x;
  echo "</br>";
}
echo "<h3>Array Sin el ultimo y el primero</h3>";
foreach($newCiudad as $x => $x_value) {
  echo "Ciudad=" . $x_value . ", Clave=" . $x;
  echo "</br>";
}
//• Elimina el primer elemento del primer array (utiliza array_shift())
array_shift($ciudades);
//• Elimina el último elemento del primer array (prueba con array_pop() )
array_pop($ciudades);
//• Visualiza todas las claves y valores del primer array (array_keys() yarray_values() )
for($i = 0; $i <count($ciudades); $i++){
  echo array_keys($ciudades)[$i]."-";
  echo array_values($ciudades)[$i]."</br>";
}
?>

</body>
</html>