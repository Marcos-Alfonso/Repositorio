
"""
Ejercicio 3: Programa que pide las palabras del diccionario junto con su traducción a otro idioma.
 A continuación pedirá una frase para traducir. 
Se mostrará la frase traducida. Las palabras que no existan se muestran sin traducir.
"""
diccionario = {}
palabras = input("Introduce la lista de palabras y traducciones en formato palabra/traducción separadas por comas: ")
for i in palabras.split(','):
    clave, valor = i.split('/')
    diccionario[clave] = valor

while(True):
    frase = input('\nIntroduce una frase en español: (Introduce \'adios\' para salir)')
    if(frase == "adios"):
        print("gusbai")
        break
    for i in frase.split():
        if i in diccionario:
            #la variable end=' 'es para que no haya salto de línea y se vea mejor la frase
            print(diccionario[i], end=' ')
        else:
            print(i, end=' ')