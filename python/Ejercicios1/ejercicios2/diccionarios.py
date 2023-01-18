# Vamos a juntar conceptos. Crea dos tuplas con el mismo tamaño, 5, una sera de nombres y otra edades. 
#Ahora junta esas dos tuplas en un diccionario siendo el nombre la key y la edad el value
edades = (23,67,12,200,45)
nombres = ("Roberto", "Balome", "Marcelo", "Lucas", "Matías")
dictionary = dict()
for i in range(0,len(edades)):
    dictionary.update({edades[i]:nombres[i]})
print(dictionary)
#Crea un diccionario: con clave nombre de alumnos y con valor una lista con las notas del curso, debe haber unusuario llamado Rodrigo
# Muestrala y después muestra solo las notas de Rodrigo.
notas = {
  "Juan" : [1,2,8],
  "Rodrigo" : [2,3,9],
  "Pepe" : [10,2,1]
}
print(notas)
print(notas["Rodrigo"])