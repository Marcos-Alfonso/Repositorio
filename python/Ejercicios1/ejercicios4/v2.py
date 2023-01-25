from Alumno import Alumno
print("Inserta nombre:")
nombre = input ()
print("Inserta nota:")
nota = input()
a1 = Alumno(nombre,int(nota) )
print(a1)
if a1.aprobado(): 
    print("Este alumno está aprobado")
else:
    print("Este alumo no está aprobado")