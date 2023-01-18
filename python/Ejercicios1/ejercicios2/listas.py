import random
"""
lista 1

Genera una lista de strings, los que quieras, y después junta los primeros carácteres en otro string aparte y muéstralo
"""
cadena = ""
lista = ["rojo", "azul", "verde","amarillo", "naranja", "morado", "marrón"]
for i in lista:
    cadena += i[0]
print(f"Lista de Strings: {lista}\nCadena generada: {cadena}\n\n")


"""
lista 2

Según la matemática estadística, si generamos números aleatorios entre 1 y 10 
y vemos cuantas veces se repite cada uno, deberían tener una tendencia a ser iguales.
Cuanto mas números generemos más iguales serán estas cuentas.
Programando, solo podremos utilizar números pseudoaleatorios debido a la funcionalidad de los sistemas en si
Mete números pseudoaleatorios en una lista, sin usar una seed predeterminada, y comprueba esto.
"""

numeros = []
for i in range(1,1000001):
    numeros.append(random.randint(1,10))
print(f"Veces que se repite x en {len(numeros)} elementos: ")
for i in range(1,11):
    print(f"{i} --> {numeros.count(i)}")