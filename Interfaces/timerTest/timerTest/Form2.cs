using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace timerTest
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }
        Form1 form;
        DataGridView dg;
        private void Form2_Load(object sender, EventArgs e)
        {
            
        }
        public void setForm(Form1 f, DataGridView d)
        {
            form = f;
            dg = d;
            
        }

        private void btAdd_Click(object sender, EventArgs e)
        {
            if (true)
                dg.Rows.Add(txNombre.Text, txApellidos.Text, txNota.Text, txTelf.Text);
        }

        private void btMod_Click(object sender, EventArgs e)
        {

                foreach (DataGridViewRow item in this.dg.SelectedRows)
                {
                    item.Cells[0].Value = txNombre.Text;
                    item.Cells[1].Value = txApellidos.Text;
                    item.Cells[2].Value = txNota.Text;
                    item.Cells[3].Value = txTelf.Text;
                }
                /*
                dg.SelectedRows[0].Cells[0].Value = txNombre.Text;
                dg.SelectedRows[0].Cells[1].Value = txApellidos.Text;
                dg.SelectedRows[0].Cells[2].Value = txNota.Text;
                dg.SelectedRows[0].Cells[3].Value = txTelf.Text;
                */
            
        }

        private void btDelete_Click(object sender, EventArgs e)
        {
            DialogResult dialogResult = MessageBox.Show("Va a eliminar: "+dg.SelectedRows.Count+" columnas.", "Advertencia", MessageBoxButtons.YesNo);
            if (dialogResult == DialogResult.Yes)
            {
                foreach (DataGridViewRow item in this.dg.SelectedRows)
                {
                    dg.Rows.RemoveAt(item.Index);
                }
            }
            else if (dialogResult == DialogResult.No)
            {
                //do something else
            }
        }

        public void cambio()
        {
            try
            {
                if (dg.SelectedRows.Count == 1)
                        {
                    txNombre.Text = dg.SelectedRows[0].Cells[0].Value.ToString();
                        txApellidos.Text = dg.SelectedRows[0].Cells[1].Value.ToString();
                        txNota.Text = dg.SelectedRows[0].Cells[2].Value.ToString();
                    txTelf.Text = dg.SelectedRows[0].Cells[3].Value.ToString();
               }
            }
            catch (NullReferenceException e)
            {
                
            }
            
        }
    }
}
