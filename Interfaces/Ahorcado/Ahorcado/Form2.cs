using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Reflection.Emit;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ahorcado
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            start = System.DateTime.Now;
            txErrorCount.Focus();
        }

        String palabra;
        String categoria;
        String nombre;
        DateTime start;
        public void init(String nombre, String categoria, String palabra) {
            txUserName.Text = "Usuario: " + nombre; 
            this.nombre = nombre;

            txCategoria.Text = "Categoría: "+categoria;
            this.categoria = categoria;

            txPalabra.Text = getCodified(palabra) ;
            this.palabra = palabra;
        }

        private string getCodified(string p)
        {
            String s = "";
            foreach (char c in p)
            {
                s += "_ ";
            }
            return s; 

        }
        int nErrores = 0;
        private void buttonClick(object sender, EventArgs e)
        {
            
            Button b = (Button)sender;
            if (palabra.ToLower().Contains(b.Text))
            {
                char c = b.Text.ToCharArray()[0];
                /*
                StringBuilder sb = new StringBuilder(txPalabra.Text);
                sb[palabra.IndexOf(c)*2] =c;
                txPalabra.Text = sb.ToString();
                */
                recodify(c);
                b.BackColor = Color.Green;
            }
            else{
                b.BackColor = Color.Red;
                txErrorChars.Text += b.Text + "/";
                
                txErrorCount.Text = "Número de errores: "+(++nErrores)+"/20";
               
            }
            b.Enabled = false;
        }

        private void recodify(char c)
        {
            for(int i = 0; i<palabra.Length; i++)
            {
                if(palabra.ToCharArray()[i] == c)
                {
                    StringBuilder sb = new StringBuilder(txPalabra.Text);
                    sb[i * 2] = c;
                    txPalabra.Text = sb.ToString();
                }
            }
            
        }

        private void tick(object sender, EventArgs e)
        {
            String s = (System.DateTime.Now - start).ToString();
            txPlaytime.Text = s.Substring(0,8);
            //label1.Text = System.DateTime.Now.ToString().Substring(10);
           
        }
    }
}
