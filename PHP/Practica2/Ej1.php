<!DOCTYPE HTML>  
<html>
<head>
<style>
.error {color: #FF0000;}
</style>
</head>
<body>  

<?php
// define variables and set to empty values
$nameErr = $surnameErr = $genderErr = $birthDateErr = "";
$name = $surname = $gender = $birthDate = "";

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
      $nameErr = "Apellido incluye carácteres no permtido";
    }
    if(str_word_count($surname)<=1){
      $surnameErr = "Debe haber mas de un apellido";
    }
  }
    
  if (empty($_POST["birthDate"])) {
    $birthDateErr = "Fecha de nacimiento requerido";
  } else {
    $birthDate = test_input($_POST["birthDate"]);
    $date1=date_create_from_format($birthDate, "dd/mm/yyyy");
    $date2=date_create_from_format(date("dd/mm/yyyy"), "dd/mm/yyyy");
   echo $date2;
  }

  if (empty($_POST["gender"])) {
    $genderErr = "Sexo Requerido";
  } else {
    $gender = test_input($_POST["gender"]);
  }
}

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
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
  <span class="error"><?php echo $birthDateErr;?></span>
  <br><br>
  Categoría: 
  <select name="cat" id="cat">
    <option value="peon">Peón</option>
    <option value="oficial">Oficial</option>
    <option value="jefeDep">Jefe de Departamento</option>
    <option value="director">Director</option>
  </select>
  <br><br>
  Sexo:
  <input type="radio" name="gender" <?php if (isset($gender) && $gender=="m") echo "checked";?> value="Mujer">Mujer
  <input type="radio" name="gender" <?php if (isset($gender) && $gender=="h") echo "checked";?> value="Hombre">Hombre 
  <span class="error">* <?php echo $genderErr;?></span>
  <br><br>
  <input type="checkbox" class="form-check-input" id="conditions" name="conditions" value="1">Deportes
  <input type="checkbox" class="form-check-input" id="conditions" name="conditions" value="1">Lectura
  <input type="checkbox" class="form-check-input" id="conditions" name="conditions" value="1">Música
  <input type="checkbox" class="form-check-input" id="conditions" name="conditions" value="1">Cine
  <input type="checkbox" class="form-check-input" id="conditions" name="conditions" value="1">Idiomas
  <br><br>
  <input type="submit" name="submit" value="Submit">  
</form>

<?php
echo "<h2>Your Input:</h2>";
echo $name;
echo "<br>";
echo $surname;
echo "<br>";
echo $birthDate;
echo "<br>";
echo $gender;

?>

</body>
</html>