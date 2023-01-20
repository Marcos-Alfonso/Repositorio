"""
Ejercicio 4: Función que devuelve los cuadrados de una lista de números (parámetro) en otra lista.
"""

def cuadrado(sample):
    lista = []
    for i in sample: 
        lista.append(i**2)
    return lista

print(cuadrado([1, 2, 3, 4, 5, 6, 7, 8, 9]))