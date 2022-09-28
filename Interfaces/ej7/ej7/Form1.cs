namespace ej7
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }


        private void btAcepta_Click(object sender, EventArgs e)
        {
            try
            {
                if (a.Text != "" || b.Text != "" || c.Text != "")
                {
                    lbAnswer.Text = "Los resultados son: ";
                    lbError.Visible = false;
                    if (rbSuma.Checked) suma();
                    if (rbResta.Checked) resta();
                    if (rbMulti.Checked) multi();
                    if (rbDividir.Checked) div();
                    if (rbTodas.Checked)
                    {
                        suma(); resta(); multi(); div();
                    }
                }
                else
                {
                    lbError.Visible = true;
                }
            }
            catch (FormatException ex)
            {
            }
        }

        private void suma()
        {
            lbAnswer.Text += "\n-Suma: " +( Int32.Parse( a.Text)+ Int32.Parse(b.Text) + Int32.Parse(c.Text) );
        }
        private void resta()
        {
            lbAnswer.Text += "\n-Resta: " + (Int32.Parse(a.Text) - Int32.Parse(b.Text) - Int32.Parse(c.Text));
        }
        private void multi()
        {
            lbAnswer.Text += "\n-Multiplicación: " + (Int32.Parse(a.Text) * Int32.Parse(b.Text) * Int32.Parse(c.Text));
        }
        private void div()
        {
            lbAnswer.Text += "\n-División: " + Math.Round(Double.Parse(a.Text) / Double.Parse(b.Text) / Double.Parse(c.Text), 5);
        }

        private void Borra_Click(object sender, EventArgs e)
        {
            lbAnswer.Text = "Los resultados son: ";
            lbError.Visible = false;
            a.Text = "";
            c.Text = "";
            b.Text = "";
        }
    }
}