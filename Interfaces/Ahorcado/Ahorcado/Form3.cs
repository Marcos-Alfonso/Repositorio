using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ahorcado
{
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

        private void Form3_Load(object sender, EventArgs e)
        {
            List<Persona> list = Form2.loadArray();

            foreach (Persona persona in list)
            {
                DataGridViewRow row = (DataGridViewRow)dataGridView1.Rows[0].Clone();
                row.Cells[0].Value = persona.nombre;
                row.Cells[1].Value = persona.puntos;
                row.Cells[2].Value = persona.gameTime.ToString().Substring(0, 8);
                dataGridView1.Rows.Add(row);
            }
        }
        
        String nombre;
        int puntos = 0;
        DateTime start;

        public void init(String nombre, int puntos)
        {
            this.nombre = nombre;
            this.puntos = puntos;
            tx.Text = $"Nombre: {nombre},\tPuntos: {puntos}";
        }

        private void button26_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
