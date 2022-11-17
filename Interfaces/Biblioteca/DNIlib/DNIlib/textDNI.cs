using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DNIlib
{
    public partial class textDNI: TextBox
    {
        public bool autoFill
        {
            get { return autoFill; }
            set
            {
                autoFill = value;
            }
        }
        public textDNI()
        {
            InitializeComponent();
            this.MaxLength = 9;
        }
        private void change(object sender, EventArgs e)
        {

            TextBox t = (TextBox)sender;
            t.ForeColor = Color.Black;
            if (t.Text.Length <= 8)
            {
                if (System.Text.RegularExpressions.Regex.IsMatch(t.Text, "[^0-9]"))
                {
                    t.Text = t.Text.Remove(t.Text.Length - 1);
                }
            }
            if (t.Text.Length == 8 && autoFill)
            {
                t.Text += calcLetra(Int32.Parse(t.Text));
            }
            if (t.Text.Length == 9 && !autoFill)
            {
                int n = Int32.Parse(t.Text.Substring(0, 8));
                if (t.Text.Substring(8, 1).Equals(calcLetra(n)))
                {
                    t.ForeColor = Color.Green;
                }
                else
                {
                    t.ForeColor = Color.Red;
                }
            }

        }

        private string calcLetra(int v)
        {
            char[] caracteres = new char[]
            {
                'T','R','W','A','G','M','Y','F','P','D','X',
                'B','N','J','Z','S','Q','V','H','L','C','K','E'
            };
            return caracteres[(int)(v % 23)].ToString();
        }
    }
}
