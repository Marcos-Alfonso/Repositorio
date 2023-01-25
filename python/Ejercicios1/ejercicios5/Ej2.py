class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad
    def __str__(self):
        return f"Nombre: {self.nombre}\tEdad:{self.edad}"

class Empleado(Persona):
    def __init__(self, nombre, edad, sueldo):
        super().__init__(nombre, edad)
        self.sueldo = sueldo
    def __str__(self):
        return super().__str__() + f"\tSueldo:{self.sueldo}"
    def debeInpuestos(self):
        return int(self.sueldo) >3000

print("Inserte nombre y edad de la persona:")
persona = Persona(input(), input())
print(persona)

print("Inserte nombre, edad y sueldo del empleado:")
emple = Empleado(input(), input(), input())
print(emple)
if(emple.debeInpuestos()):
    print("Debe impuestos.")
else:
    print("No debe impuestos")