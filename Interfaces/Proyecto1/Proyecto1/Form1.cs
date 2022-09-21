namespace Proyecto1
{
    public partial class Form1 : Form
    {
        private int count = 0;
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {
            label1.Text = "gracias por hacer click";
        }

        private void screenClick(object sender, EventArgs e)
        {
            count++;
            label1.Text = "Cuenta"+count;
        }
    }
}