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
            if(dg.SelectedRows != null)
            {

            }
        }

        private void btDelete_Click(object sender, EventArgs e)
        {

        }
    }
}
