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
    public partial class Form3 : Form
    {
        Form2 f;
        public Form3(Boolean b, Form2 f)
        {
            this.f = f; 
            InitializeComponent();
            if (b)
            {
                btInsertar.Enabled = true;
                btInsertar.Visible = true;
                btModificar.Enabled = false;
                btModificar.Visible = false;
            }
            else
            {
                btInsertar.Enabled = false;
                btInsertar.Visible = false;
                btModificar.Enabled = true;
                btModificar.Visible = true;
            }
        }

        private void Form3_Load(object sender, EventArgs e)
        {

        }

        private void checkID(object sender, EventArgs e)
        {
            lbError.Visible = true;

            DataGridView dtArt = f.getDataArticulos();
            foreach(DataGridViewRow row in dtArt.Rows)
            {
                try
                {
                    if (row.Cells[0].Value.ToString().Equals(txID))
                    {
                        lbError.Visible = false;
                        txNombre.Text = row.Cells[1].Value.ToString();
                        txPrecio.Text = row.Cells[2].Value.ToString();
                    }
                }
                catch(NullReferenceException ex)
                {

                }
               
            }
        }

        private void recalculaSubtotal(object sender, EventArgs e)
        {

        }
    }
}
