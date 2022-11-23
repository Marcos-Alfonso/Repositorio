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
    public partial class FormAltaMod : Form
    {
        bool alta;
        Form2 form; 
        public FormAltaMod(Form2 f, bool b)
        {
            InitializeComponent();
            form = f;
            alta = b;
            if (alta)
            {
                lbTitulo.Text = "ALTA";
            }
            else
            {
                lbTitulo.Text = "MODIFICA";
                DataGridView tabla = form.getTablaAlumnos();
                txNombre.Text = tabla.SelectedRows[0].Cells[0].Value.ToString() ;
                txApellidos.Text = tabla.SelectedRows[0].Cells[1].Value.ToString();
                txNotas.Text = tabla.SelectedRows[0].Cells[2].Value.ToString();
                txMedia.Text = tabla.SelectedRows[0].Cells[3].Value.ToString();
            }
        }
        public void setNotas(String notas)
        {
            txNotas.Text = notas;
            String[] arrayNotas = notas.Split(',');
            int contador=0;
            Double n1, n2, n3;
            try
            {
                n1 = Double.Parse(arrayNotas[0]);
                contador += 1;
            }catch(Exception ex){ n1 = 0; }

            try
            {
                n2 = Double.Parse(arrayNotas[1]);
                contador += 1;
            }
            catch (Exception ex) { n2 = 0; }
            try
            {
                n3 = Double.Parse(arrayNotas[2]);
                contador += 1;
            }
            catch (Exception ex) { n3 = 0; }

            Double media = (n1 + n2 + n3) / contador;
            txMedia.Text = Math.Round(media, 2).ToString();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            //bt insertar notas
            FormNotas f = new FormNotas(this);
            f.ShowDialog();
        }

        private void btConfirmar_Click(object sender, EventArgs e)
        {
            DataGridView tabla = form.getTablaAlumnos();
            if (txApellidos.Text =="" && txNombre.Text == "" && txNotas.Text == "" && txMedia.Text == "")
            {
                MessageBox.Show("Rellena todos los campos para guardar.", "ERROR");
                
            }else if(alta){
                darAlta(tabla);
            }else if (!alta)
            {
                darModificacion(tabla);
            }
        }

        private void darModificacion(DataGridView tabla)
        {
            tabla.SelectedRows[0].Cells[0].Value = txNombre.Text;
            tabla.SelectedRows[0].Cells[1].Value = txApellidos.Text;
            tabla.SelectedRows[0].Cells[2].Value = txNotas.Text;
            tabla.SelectedRows[0].Cells[3].Value = txMedia.Text;
        }

        private void darAlta(DataGridView tabla)
        {
            DataGridViewRow row = (DataGridViewRow)tabla.Rows[0].Clone();
            row.Cells[0].Value = txNombre.Text;
            row.Cells[1].Value = txApellidos.Text;
            row.Cells[2].Value = txNotas.Text;
            row.Cells[3].Value = txMedia.Text;
            tabla.Rows.Add(row);

            MessageBox.Show("Alumno creado", "Confirmación");
            this.Close();
        }

        private void btCancelar_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
