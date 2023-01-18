#crea una tupla y leela al revés
tupla = (1,2,3,4,5,6,7,8,9,10)
for i in reversed(tupla):
    print(i)
#por cada elemento de una tupla, muestralo y di que tipo de dato es
tupla = (123,"cadena",True,'H',bytearray(5),200.334)
for i in tupla:
    print(f"{i} ---> {type(i)}")