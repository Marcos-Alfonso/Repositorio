namespace Ej9
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (tbSalario.Text!=""&&tbDias.Text!="")
            {
                tbTotal.Text=(Int32.Parse(tbDias.Text)*Double.Parse(tbSalario.Text)*0.75).ToString();
            }
        }
    }
}