<!DOCTYPE html>
<html>
<body>
<?php
//3. Crea un array multidimensional de evaluación de Alumnos de 1º de DAW. En cadafila debe aparecer: Nombre del Alumno, Nota 1º Eval, Nota 2º Eval y Nota final
//• La clase consta de diez alumnos
$daw = array();
for($i = 0; $i<9;$i++){
    //• Carga el array con datos ficticios. Las calificaciones se harán en pasos de 0.5
    $t1 = rand(0,9);
    $t1 +=0.5*rand(0,2);

    $t2 = rand(0,9);
    $t2 +=0.5*rand(0,2);
    //pongo de nota final 0, por lo pronto
    array_push($daw, array("Alumno".$i, $t1, $t2, 0));
}
//• La nota final obedece a la siguiente fórmula: Nota final = 0,4 * Nota 1ª Eval +0,6* Nota 2ª Eval
function calcFinal(&$array){
    foreach($array as &$alumno){
        $alumno[3] = 0.4*$alumno[1]+0.6*$alumno[2];
    }
}
calcFinal($daw);


//• En el caso de que la nota final sea de 4.5 se redondeará a 5
function roundFinal(&$array){
    foreach($array as &$alumno){
        if($alumno[3]>=4.5 && $alumno[3]<5){
            $alumno[3] = 5;
        }
    }
}
roundFinal($daw);

//• Por un despiste hay que introducir los datos de Carlos Ruiz Rus, 4, 4; Marcos Pérez López, 4.5, 5; y de Josefa Portillo Ruiz, 3, 5
array_push($daw, array("Carlos Ruiz Rus", 4, 4, 0));
array_push($daw, array("Marcos Pérez López", 4.5, 5, 0));
array_push($daw, array("Josefa Portillo Ruiz", 3,5, 0));
calcFinal($daw);
roundFinal($daw);

//• Nuevo error: la nota de la 1ª Evaluación de Josefa Portillo es 4
function getIndex($array, $nombre){
    for($i = 0; $i<count($array);$i++){
        if($array[$i][0] == $nombre)return $i;
    }
    return -1;
}
$daw[getIndex($daw, "Josefa Portillo Ruiz")][1] = 4;

//• Hay que dar de baja a Carlos Ruiz Rus, no ha pagado la matrícula
array_splice($daw, getIndex($daw, "Carlos Ruiz Rus"),1);

//• Produce un listado ordenado de mayor a menor según la Nota final
function getSorted($array){
    $sorted= array();
    while(count($array)>0){
        $maxIndex = 0;
        $maxNota = 0;
        for($i = 0; $i<count($array);$i++){
        if($array[$i][3] >$maxNota){
            $maxNota = $array[$i][3];
            $maxIndex = $i;
        }
        }
        array_push($sorted, $array[$maxIndex]);
        array_splice($array, $maxIndex, 1);
    }
    return $sorted;
}
print_r(getSorted($daw));
//• Especifica por pantalla los alumnos que obtuvieron mejores calificaciones en la primera y segunda evaluación
function getBetter($array, $term){//pido por parámetro si es del primer o segundo trimestre
    $maxIndex = 0;
    $maxNota = 0;
    for($i = 0; $i<count($array);$i++){
        if($array[$i][$term] >$maxNota){
            $maxNota = $array[$i][$term];
            $maxIndex = $i;
        }
    }
    return $maxIndex;
}
/*• Presenta dicha lista en una tabla HTML con las cabeceras Nombre del Alumno,
Nota 1º Eval, Nota 2º Eval y Nota final. Dibuja la cabecera en color Azul Claro y
las columnas pares en tono Gris. Debajo de la columna Nota Final incluye la nota
media del Curso
*/
?>

</body>
</html>