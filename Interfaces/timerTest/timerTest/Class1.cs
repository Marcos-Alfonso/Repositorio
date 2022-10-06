using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace timerTest
{
    internal class Persona
    {
        String nombre;
        String apellidos;
        int telefono;
        int nota;

        public Persona(string nombre, string apellidos, int telefono, int nota)
        {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.telefono = telefono;
            this.nota = nota;
        }
    }
}
