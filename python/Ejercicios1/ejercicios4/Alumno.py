class Alumno(object):
    def __init__(self, nombre, nota):
        self.nombre = nombre
        self.nota = nota
    
    def __str__(self):
        return f"Nombre: {self.nombre} \tNota: {self.nota}"

    def aprobado(self):
        if(self.nota >=5):
            return True
        else:
            return False
