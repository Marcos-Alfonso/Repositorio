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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        Form2 f = new Form2();
        private void gestiónAlumnosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            f.ShowDialog();
        }

        private void menuBuscador_Click(object sender, EventArgs e)
        {
            FormBuscador form = new FormBuscador(f);
            form.ShowDialog();
        }
    }
}
