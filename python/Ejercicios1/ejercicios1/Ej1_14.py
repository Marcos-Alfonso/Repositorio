import random


#Ejercicio 1
print("Ej1:")
print("hello world")

#Ejercicio 2
print("\nEj2:")
x = 3
y = 2
print(x+y)

#3.Mostrar el precio del IVA de un producto con un valor de 100 y su precio final.
print("\nEj3:")
x = 100
print("Precio IVA: "+str(x*0.21))
print("Precio final: "+str(x*1.21))

#4.De dos números, saber cual es el mayor.
print("\nEj4:")
x=5
y=6
if x>y:
    print("X es mayor")
else:
    print("Y es mayor")

#5.Crea una variable numérica y si esta entre 0 y 10, mostrar un mensaje indicándolo.
print("\nEj5:")
x = 4
if x<=10 and x>=0:
    print(str(x)+" está entre los valores 0-10")
#6.Añadir al anterior ejercicio, que si esta entre 11 y 20, muestre otro mensaje diferente y si esta entre 21 y 30 otro mensaje.
print("\nEj6:")
x = 23
if x<=10 and x>=0:
    print("X está entre los valores 0-10")
elif x>10 and x<=20:
    print("X está entre los valores 11-20")
elif x>20 and x<=30:
    print("X está entre los valores 21-30")

#7.Mostrar con un while los números del 1 al 100.
print("\nEj7:")
i = 1
while i <= 100:
  print(i)
  i += 1
#8.Mostrar con un for los números del 1 al 100.
print("\nEj8:")
for i in range(1, 101):
  print(i)
#9.Mostrar los caracteres de la cadena «Hola mundo».
print("\nEj9:")
for str in "Hola mundo":
    print(str)
#10.Mostrar los números pares entre 1 al 100.
print("\nEj10:")
for i in range(1, 101):
  if i%2 ==0: 
    print(i)
#11.Generar un rango entre 0 y 10.
print("\nEj11:")
x = range(10)
for i in x:
    print(i)
#12.Generar un número entre 5 y 10.
print("\nEj12:")
print(random.randint(5,10))
#13.Generar un rango de 0 a 10 y de 15 a 20, incluidos el 10 y 20.
print("\nEj13:")
x = range(11)
y = range(15,21)

print("Primer rango:")
for i in x:
    print(i)
print("Segundo rango:")
for i in y:
    print(i)
#14.Generar un rango desde 0 hasta la longitud de la cadena “Hola mundo”.
print("\nEj14:")
x = range(len("Hola mundo")+1)
for i in x:
    print(i)


