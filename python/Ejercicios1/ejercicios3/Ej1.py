"""
Ejercicio 1: Programa que parta de una lista con los nombres de los módulos de 2ºdam. 
Por cada uno de los módulos se preguntará que nota has sacado. La nota introducida se almacenará en otra lista. 
Por último se mostrará en diferentes líneas el nombre de cada módulo y la nota que corresponde.
"""
modulos = ["SGE", "ADAT", "PSP", "HLC", "DI", "EIE"]
notas = []
for i in modulos:
    print(f"Inserta nota de {i}")
    notas.append(input())
for i in range(0,len(notas)):
    print(f"{modulos[i]} ---> {notas[i]}")
