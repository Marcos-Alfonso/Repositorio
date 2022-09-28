namespace Ej6
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void modoPago_SelectedIndexChanged(object sender, EventArgs e)
        {
            if(modoPago.SelectedIndex == 1)
            {
                textBox1.Text = "";
                textBox2.Text = "";
                textBox3.Text = "";
                paneTarjeta.Visible = true;
                paneEfectivo.Visible = false;
            }
            else
            {
                textBox6.Text = "";
                textBox5.Text = "";
                paneTarjeta.Visible = false;
                paneEfectivo.Visible = true;
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            modoPago.SelectedIndex = 1;
        }

        private void cambio(object sender, EventArgs e)
        {
            if(textBox1.Text !="" && textBox2.Text != "")
            {
                textBox3.Text = (Double.Parse(textBox2.Text) - Double.Parse(textBox1.Text)).ToString();
            }
        }
    }
}