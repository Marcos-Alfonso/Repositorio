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
                paneTarjeta.Visible = true;
                paneEfectivo.Visible = false;
            }
            else
            {
                paneTarjeta.Visible = false;
                paneEfectivo.Visible = true;
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            modoPago.SelectedIndex = 1;
        }
    }
}