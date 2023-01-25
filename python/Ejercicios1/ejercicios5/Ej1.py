class Operacion(object):
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def operar(self):
        pass

class Suma(Operacion):
    def operar(self):
        return (self.x +self.y)

class Resta(Operacion):
    def operar(self):
        return (self.x - self.y)

suma = Suma(23,45)
print(suma.operar())
resta = Resta(23,45)
print(resta.operar())
