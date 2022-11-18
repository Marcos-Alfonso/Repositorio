using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace textNumberLib
{
    public partial class txNumber: TextBox
    {
        public txNumber()
        {
            InitializeComponent();
        }
        private void change(object sender, EventArgs e)
        {

            TextBox t = (TextBox)sender;
                if (System.Text.RegularExpressions.Regex.IsMatch(t.Text, "[^0-9]"))
            {
                t.Text = t.Text.Remove(t.Text.Length - 1);
            }
        }
    }
}
