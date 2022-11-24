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
    public partial class FormBuscador : Form
    {
        Form2 form; 
        public FormBuscador(Form2 f)
        {
            InitializeComponent();
            form = f;
            DataGridView dt = f.getTablaAlumnos();
            foreach(DataGridViewRow row in dt.Rows)
            {
                DataGridViewRow row2 = (DataGridViewRow)dtAlumnos.Rows[0].Clone();
                row2.Cells[0].Value = row.Cells[0].Value;
                row2.Cells[1].Value = row.Cells[1].Value;
                dtAlumnos.Rows.Add(row2);
            }
        }

        private void txFiltro_TextChanged(object sender, EventArgs e)
        {
            if (txFiltro.Text == "")
            {
                foreach (DataGridViewRow row in dtAlumnos.Rows)
                {
                    //todos los try catch de este estilo son para prevenir que ocurra un error con al ultima fila en blanco de los gridview
                    try
                    {
                        
                    String apellido = row.Cells[1].Value.ToString();
                    row.Visible = true;
                    }
                    catch (Exception ex) { }
                }
            }
            else
            {
                foreach (DataGridViewRow row in dtAlumnos.Rows)
                {
                    try
                    {
                        String apellido = row.Cells[1].Value.ToString();
                        if (!apellido.Contains(txFiltro.Text))
                        {
                            row.Visible = false;
                        }
                    }
                    catch (Exception ex){ }
                   
                }
            }
            
        }

        private void abreAlumnos(object sender, DataGridViewCellEventArgs e)
        {
            DataGridView data = (DataGridView)sender;
            DataGridViewCell cell = data.SelectedCells[0];
            
            String nombre = cell.OwningRow.Cells[0].Value.ToString();
            String apellido = cell.OwningRow.Cells[1].Value.ToString();

            DataGridView dt = form.getTablaAlumnos();
            foreach (DataGridViewRow row in dt.Rows)
            {
                try
                {
                    if (row.Cells[0].Value.ToString().Equals(nombre)
                    && row.Cells[1].Value.ToString().Equals(apellido))
                {
                    dt.ClearSelection();
                    row.Selected = true;
                }
                }
                catch (Exception ex) { }
            }

            form.ShowDialog();
        }
    }
}
