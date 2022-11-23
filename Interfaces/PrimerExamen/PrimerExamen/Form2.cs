using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PrimerExamen
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }
        public DataGridView getTablaAlumnos()
        {
            return dtAlumnos;
        }

        private void btInsertar_Click(object sender, EventArgs e)
        {
            FormAltaMod f = new FormAltaMod(this, true);
            f.Text = "ALTA";
            f.ShowDialog();
        }

        private void btModificar_Click(object sender, EventArgs e)
        {
            if (dtAlumnos.SelectedRows.Count != 1)
            {
                MessageBox.Show("Culumna no seleccionada", "Error");
                return;
            }

            FormAltaMod f = new FormAltaMod(this, false);
            f.Text = "MODIFICACIÓN";
            f.ShowDialog();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            //eliminar
            if (dtAlumnos.SelectedRows.Count == 0)
            {
                MessageBox.Show("Culumna no seleccionada", "Error");
                return;
            }
            DialogResult dialogResult = MessageBox.Show("Desea eliminar "+ dtAlumnos.SelectedRows.Count+" fila/s", "Confirmar", MessageBoxButtons.YesNo);
            if (dialogResult == DialogResult.Yes)
            {
                foreach (DataGridViewRow row in dtAlumnos.SelectedRows)
                {
                    dtAlumnos.Rows.RemoveAt(row.Index);
                }
                MessageBox.Show(dtAlumnos.SelectedRows.Count+" fila/s eliminada", "Eliminadas");
            }


           

        }

        private void btVolver_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
