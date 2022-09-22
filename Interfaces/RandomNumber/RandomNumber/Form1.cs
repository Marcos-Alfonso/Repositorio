namespace RandomNumber
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        
        int r;
        private void button1_Click(object sender, EventArgs e)
        {
            Random rnd = new Random();
            r = rnd.Next(1,51);
            lbAnswer.Text = "Debes introducir un n�mero";
            tbNumber.Text = "";
            tbNumber.ReadOnly = false;
            button1.Visible = false;
        }

        private void tbNumber_TextChanged(object sender, EventArgs e)
        {
            if(tbNumber.Text == "")
            {
                lbAnswer.Text = "Debes introducir un n�mero";
            }
            else
            {
                if (Int32.Parse(tbNumber.Text) > r)
                {
                    lbAnswer.Text = "El n�mero que buscas es menor";
                }else if (Int32.Parse(tbNumber.Text) < r)
                {
                    lbAnswer.Text = "El n�mero que buscas es mayor";
                }
                else
                {
                    tbNumber.ReadOnly = true;
                    
                    lbAnswer.Text = "Congratulaciones, has ganado!";
                    button1.Visible = true;
                }
            }
        }
    }
}