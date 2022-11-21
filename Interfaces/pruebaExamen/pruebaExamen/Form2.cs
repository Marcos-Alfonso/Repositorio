using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace pruebaExamen
{
    public partial class Form2 : Form
    {

        public Form2()
        {
            InitializeComponent();

            //inicio tres articulos
            DataGridViewRow row1 = (DataGridViewRow)dtArticulos.Rows[0].Clone();
            row1.Cells[0].Value = 1234;
            row1.Cells[1].Value = "Alimento";
            row1.Cells[2].Value = 12.49;
            dtArticulos.Rows.Add(row1);
            DataGridViewRow row2 = (DataGridViewRow)dtArticulos.Rows[0].Clone();
            row2.Cells[0].Value =4321;
            row2.Cells[1].Value = "Software";
            row2.Cells[2].Value = 32.99;
            dtArticulos.Rows.Add(row2);
            DataGridViewRow row3 = (DataGridViewRow)dtArticulos.Rows[0].Clone();
            row3.Cells[0].Value = 1423;
            row3.Cells[1].Value = "Aceite";
            row3.Cells[2].Value = 39.99;
            dtArticulos.Rows.Add(row3);
        }

        private void btInsertar_Click(object sender, EventArgs e)
        {
            Form3 f = new Form3(true, this);
            f.Show();
        }

        private void btEliminar_Click(object sender, EventArgs e)
        {
            foreach (DataGridViewRow row in dtPresu.SelectedRows)
            {
                dtPresu.Rows.RemoveAt(row.Index);
            }
        }

        private void btModificar_Click(object sender, EventArgs e)
        {

        }
        public DataGridView getDataArticulos()
        {
            return this.dtArticulos;
        }
    }
}
