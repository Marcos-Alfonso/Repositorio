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
            ProgressBar r = new ProgressBar();
            r.Value = 78;
            
            if (openFileDialog1.ShowDialog(this) == DialogResult.OK)
            {
            String filePath = openFileDialog1.FileName;
            textBox1.Text =(new StreamReader(filePath)).ReadToEnd();
            }
            
        }

        private void new_win(object sender, EventArgs e)
        {
       
            Form2 f = new Form2();
            f.Show(this);
            
        }
    }
}