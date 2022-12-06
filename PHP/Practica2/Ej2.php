<!DOCTYPE HTML>  
<html>
<head>
<style>
table{
    
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
tr{
    
    text-align: left;
}
th, td{
    padding: 12px 15px;
}
.peon{
    background-color: #F7C7DB;
}
.oficial{
    background-color: #F79AD3;
}
.jefeDep{
    background-color: #C86FC9;
}
.director{
    background-color: #8E518D;
}
</style>
</head>
<body>  
    <table>
        <tr>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Sexo</th>
            <th>Fecha de Nacimiento</th>
            <th>Categoria</th>
            <th>Salario</th>
            <th>Aficiones</th>
        </tr>
<?php
$myfile = fopen("empleados.csv", "r");
$suma = 0;
if ($myfile) {
    
    while (($line = fgets($myfile)) !== false) {
        $partes = explode(",", $line);
        echo "<tr class='$partes[4]'>";
        /*
        if($partes[4] == "peon"){
            echo "<tr class='peon'>";
        }else{
            echo "<tr>";
        }*/
            foreach($partes as $parte){
                echo "<td>$parte</td>";
            }
        echo "</tr>";
        $suma += $partes[5];
    }
    fclose($myfile);
}
        echo "<tr>
            <td colspan='5'></td>
            <td style='background-color: grey;' >$suma</td>
        </tr>";
?>
        
</table>

</body>
</html>