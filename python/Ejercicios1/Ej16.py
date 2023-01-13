#16.Pide una cadena e indica si es un palíndromo o no.
print("\nEj16:")
x = input()
isPalindrome = True
for i in range(0,len(x)):
    if x[i]!= x[len(x)-i-1]: 
        isPalindrome = False
if isPalindrome: 
    print("Es palíndromo")
else:
    print("No es palíndromo")