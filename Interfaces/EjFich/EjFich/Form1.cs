using System.IO;
using System.Windows.Forms;

namespace EjFich
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (openFileDialog1.ShowDialog(this) == DialogResult.OK)
            {
            String filePath = openFileDialog1.FileName;
            textBox1.Text =(new StreamReader(filePath)).ReadToEnd();

            }
            
        }
    }
}