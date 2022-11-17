using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace textLength
{
    public partial class txLength: UserControl
    {
        public int maxLength
        {
            get { return textBox1.MaxLength; }
            set
            {
                textBox1.MaxLength = value;
                label2.Text = textBox1.Text.Length + "/" + textBox1.MaxLength;
            }
        }
        public txLength()
        {
            InitializeComponent();
            label2.Text = "0/" + textBox1.MaxLength;
        }

        private void update(object sender, EventArgs e)
        {
            label2.Text = textBox1.Text.Length+"/" + textBox1.MaxLength;
        }
    }
}
