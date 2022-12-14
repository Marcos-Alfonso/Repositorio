<!DOCTYPE HTML>  
<html>
<head>
<style>
.error {color: #FF0000;}

</style>
</head>
<body>  

<?php
$nameErr = $surnameErr = $genderErr = $birthDateErr = $functionError = $sueldoErr= $aficionErr="";
$name = $surname = $gender = $birthDate = $function = $sueldo=$aficion= "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  if (empty($_POST["name"])) {
    $nameErr = "Nombre requerido";
  } else {
    $name = test_input($_POST["name"]);
    // coprueba que solo son letras y espacios, para nomrbes compuestos
    if (!preg_match("/^[a-zA-Z-' ]*$/",$name)) {
      $nameErr = "Nombre incluye carácteres no permtido";
    }
    if(strlen($name)<3){
      $nameErr = "Nombre tiene que tener mas de 3 letras.";
    }
  }
  
  if (empty($_POST["surname"])) {
    $surnameErr = "Apellido requerido";
  } else {
    $surname = test_input($_POST["surname"]);
    //filtro apellido
    if (!preg_match("/^[a-zA-Z-' ]*$/",$surname)) {
      $surnameErr = "Apellido incluye carácteres no permtido";
    }
    if(str_word_count($surname)<=1){
      $surnameErr = "Debe haber mas de un apellido";
    }
  }
    
  if (empty($_POST["birthDate"])) {
    $birthDateErr = "Fecha de nacimiento requerido";
  } else {
    $birthDate = test_input($_POST["birthDate"]);
    if (!validFecha($birthDate)) {
      $birthDateErr = "Fecha No valida";
    }
    else if (2022-getYear($birthDate)<18) {
      $birthDateErr = "Usuario menor de edad";
    }
  }
  if (empty($_POST["sueldo"])) {
    $sueldoErr = "Sueldo Requerido";
  } else {
    $sueldo = test_input($_POST["sueldo"]);
    $selected = $_POST["function"];
    $function = $selected;
    if($selected == "peon" && ($sueldo<600 || $sueldo>1200)){
      $sueldoErr = "Sueldo no correspondiente para peón.";
    }
    if($selected == "oficial" && ($sueldo<900 || $sueldo>1500)){
      $sueldoErr = "Sueldo no correspondiente para Oficial.";
    }
    if($selected == "jefeDep" && ($sueldo<1400 || $sueldo>2500)){
      $sueldoErr = "Sueldo no correspondiente para Jede de Departamento.";
    }
    if($selected == "director" && ($sueldo<2000 || $sueldo>3000)){
      $sueldoErr = "Sueldo no correspondiente para Director.";
    }
  }

  if (empty($_POST["gender"])) {
    $genderErr = "Sexo Requerido";
  } else {
    $gender = test_input($_POST["gender"]);
   
  }
  if(!empty($_POST["Aficion"])){
    // Ciclo para mostrar las casillas checked checkbox.
    foreach($_POST["Aficion"] as $selected){
    $aficion = $aficion."/".$selected;
    }
    /*
    if(count($_POST["Aficion"])<2){
      $aficionErr = "Debe seleccionar al menos una afición";
    }else
    */
     if($gender == "Hombre" && count($_POST["Aficion"])== 1 && in_array("Deportes", $_POST["Aficion"]) ){
      $aficionErr = "Los hombres no pueden seleccionar solo deportes";
    }
  }else{
    $aficionErr = "Debe seleccionar al menos una afición";
  }
  if($nameErr == "" && $surnameErr =="" &&  $genderErr =="" && $birthDateErr =="" && 
   $functionError =="" && $sueldoErr=="" && $aficionErr==""){
    

    $myfile = fopen("empleados.csv", "a+")or die("Unable to open file!");
    fwrite($myfile, "$name,$surname,$gender,$birthDate,$function,$sueldo,$aficion\n");
    fclose($myfile);
    $nameErr = $surnameErr = $genderErr = $birthDateErr = $functionError = $sueldoErr= $aficionErr="";
    $name = $surname = $gender = $birthDate = $function = $sueldo=$aficion= "";
    echo '<script>alert("Usuario Creado!")</script>';
  }
 
}

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}

  //Introduce string de fecha y devuelve el año en el que haya nacido
function getYear($fecha){
  try{
  $year = explode("/",$fecha);
  
  return $year[2];
  }catch(Exception){}
  }
  //compruebo si la fecha tiene el formato que quiero y si está entre 1950 y la actualidad.
  function validFecha($fecha){
    try{
    $year = explode("/",$fecha);
    if(strlen($year[0])!=2 || $year[0]>31 ||$year[0]<1){
      return false;
    }
    if(strlen($year[1])!=2 || $year[1]>12 ||$year[1]<1){
      return false;
    }
    if(strlen($year[2])!=4 || $year[2]<1950 ||$year[2]>date("Y")){
      return false;
    }
    return true;
    }catch(Exception){
      return false;
    }
  }
  
    
?>

<h2 style="text-align:center;"><u>Alta datos Empleado</u></h2>
<p><span class="error">* Campo Requerido</span></p>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">  
  Nombre: <input type="text" name="name" value="<?php echo $name;?>">
  <span class="error">* <?php echo $nameErr;?></span>
  <br><br>
  Apellido: <input type="text" name="surname" value="<?php echo $surname;?>">
  <span class="error">* <?php echo $surnameErr;?></span>
  <br><br>
  Fecha de nacimiento: <input type="text" name="birthDate" value="<?php echo $birthDate;?>">(dd/MM/yyyy)
  <span class="error">* <?php echo $birthDateErr;?></span>
  <br><br>
  Sueldo: <input type="text" name="sueldo" value="<?php echo $sueldo;?>">
  <span class="error">* <?php echo $sueldoErr;?></span>
  <br><br>
  Categoría: 
  <select name="function" id="function" >
    <option value="peon">Peón</option>
    <option value="oficial">Oficial</option>
    <option value="jefeDep">Jefe de Departamento</option>
    <option value="director">Director</option>
  </select>
  <span class="error"> <?php echo $functionError;?></span>
  <br><br>
  Sexo:
  <input type="radio" name="gender" <?php if (isset($gender) && $gender=="Hombre") echo "checked";?> value="Hombre">Hombre 
  <input type="radio" name="gender" <?php if (isset($gender) && $gender=="Mujer") echo "checked";?> value="Mujer">Mujer
  
  <span class="error">* <?php echo $genderErr;?></span>
  <br><br>
  <input type="checkbox" class="form-check-input" id="conditions" name="Aficion[]" value="Deportes">Deportes
  <input type="checkbox" class="form-check-input" id="conditions" name="Aficion[]" value="Lectura">Lectura
  <input type="checkbox" class="form-check-input" id="conditions" name="Aficion[]" value="Musica">Música
  <input type="checkbox" class="form-check-input" id="conditions" name="Aficion[]" value="Cine">Cine
  <input type="checkbox" class="form-check-input" id="conditions" name="Aficion[]" value="Idiomas">Idiomas
  <span class="error">* <?php echo $aficionErr;?></span>
  <br><br>
  <input type="submit" name="submit" value="Enviar">  
  <br><br>
  <button onclick="myFunction()">Ver Empleados</button>
</form>
<script>
function myFunction() {
  window.open("Malfonso_Ej2_Activ2Trim1_HLC.php");
  window.close();
}
</script>
<?php
echo "<h2>Resumen Datos Empleado</h2>";
echo "Nombre: <span style='color: #03c2fc;'>$name</span>";
echo "<br>";
echo "Apellidos: <span style='color: #03c2fc;'>$surname</span>";
echo "<br>";
echo "Fecha de Nacimiento: <span style='color: #03c2fc;'>$birthDate</span>";
echo "<br>";
echo "Sueldo: <span style='color: #03c2fc;'>$sueldo</span>";
echo "<br>";
echo "Categoria: <span style='color: #03c2fc;'>$function</span>";
echo "<br>";
echo "Género: <span style='color: #03c2fc;'>$gender</span>";
echo "<br>";
echo "Aficiones: <span style='color: #03c2fc;'>$aficion</span>";
?>

</body>
</html>