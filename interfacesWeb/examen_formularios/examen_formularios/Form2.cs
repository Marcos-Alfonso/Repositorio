using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace examen_formularios
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (radioButton1.Checked)
            {
                Form3 f = new Form3();
                f.Show();
            }else if (radioButton2.Checked)
            {

            }
            else if (radioButton3.Checked)
            {
                int i = 0;
                if(textBox1.Text != "")
                {
                    try
                    {
                        i = Int32.Parse(textBox1.Text);
                    }
                    catch(Exception ae) { }

                }
                Form4 f = new Form4(i);

                f.Show();
            }
            else 
            {
                Form5 f = new Form5(comboBox1.SelectedValue.ToString());

                f.Show();
            }
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'worldDataSet.country' Puede moverla o quitarla según sea necesario.
            this.countryTableAdapter.Fill(this.worldDataSet.country);

        }
    }
}
