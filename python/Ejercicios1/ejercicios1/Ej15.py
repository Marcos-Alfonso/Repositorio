#15.Pide dos cadenas por teclado, muestra ambas cadenas con un espacio entre ellas y con los 2 primeros caracteres intercambiados. Por ejemplo, hola mundo pasaría a mula hondo.
print("\nEj15:")
x = input()
y = input()
print(y[0:2]+x[2:len(x)]+" "+x[0:2]+y[2:len(y)])