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
    public partial class Form1 : Form
    {
        Form2 f2;
        public Form1()
        {
            InitializeComponent();
             f2= new Form2();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            
        }

        private void click(object sender, EventArgs e)
        {
            f2.ShowDialog();
        }
    }
}
