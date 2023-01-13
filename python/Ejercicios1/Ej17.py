import random
#17.Juego de adivinar el numero, generaremos un número entre 1 y 100. Consiste en adivinar el número. Si fallamos nos dirán si es mayor o menor que el número buscado. También poner el número de intentos requeridos.
print("\nEj16:")
rnd = random.randint(0,100)
print(rnd)
nIntentos = 1
print("Inserta número: ")
while True:
    inp = int(input())
    if inp == rnd:
        print("Número correcto "+str(inp)+"!")
        break
    else:
        nIntentos+=1
        if inp>rnd:
            print("El número que buscas es menor")
        else:
            print("El número que buscas es mayor")
print("Número de intentos totales: "+str(nIntentos))