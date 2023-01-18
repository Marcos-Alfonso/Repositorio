"""
 Programa que pida cuatro números (utiliza la coma como separador). 
 Se creará una tupla con los números y se muestra la media.
"""
print("Inserta cuatro números: ")
t = (float(input()),float(input()), float(input()), float(input()))
suma = float(t[0]+t[1]+t[2]+t[3])
print(suma/4)
