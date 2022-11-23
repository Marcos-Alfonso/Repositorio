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
    public partial class FormNotas : Form
    {
        FormAltaMod form;
        public FormNotas(FormAltaMod f)
        {
            InitializeComponent();
            form = f;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(textBox1.Text == "" && textBox2.Text == "" && textBox3.Text == "")
            {
                MessageBox.Show("No hay notas introducidas. Debe meter al menos una. ", "Error");
                return;
            }

                //guardar
                if (textBox1.Text == "" )
            {
                textBox1.Text = "-";
            }
            if (textBox2.Text == "")
            {
                textBox2.Text = "-";
            }
            if (textBox3.Text == "")
            {
                textBox3.Text = "-";
            }
            form.setNotas(textBox1.Text + "," + textBox2.Text + "," + textBox3.Text);
            
            
            this.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            //cancelar
            this.Close();
        }

        private void checkNum(object sender, EventArgs e)
        {
            TextBox tx = (TextBox)sender;
            //@"-?\d+(?:\.\d+)?"
            //"[^0-9]"
            if (System.Text.RegularExpressions.Regex.IsMatch(tx.Text, "[^0-9]"))
            {
                tx.Text = tx.Text.Remove(textBox1.Text.Length - 1);
            }
            try
            {
                if (Int32.Parse(tx.Text) > 10)
                {
                    tx.Text = tx.Text.Remove(textBox1.Text.Length - 1);
                }
            }catch(Exception ex)
            {

            }
            
        }
    }
}
