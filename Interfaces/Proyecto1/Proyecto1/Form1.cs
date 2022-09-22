namespace Proyecto1
{
    public partial class Form1 : Form
    {
       
        public Form1()
        {
            InitializeComponent();
        }

       

       

        private void btSuma_Click(object sender, EventArgs e)
        {
            if(n1.Text != "" && n2.Text != "")
            {
                lbResultado.Text = (Int32.Parse(n1.Text) + Int32.Parse(n2.Text)).ToString();
                empyError.Visible = false;

                n1.BackColor = Color.White;
                n2.BackColor = Color.White;
            }
            else
            {
                if (n1.Text == "")
                {
                    n1.BackColor = Color.Red;
                }
                    
                if(n2.Text== "")
                {
                    n2.BackColor = Color.Red;
                }
                    
                empyError.Visible = true;
            }
            
        }

        private void resta(object sender, EventArgs e)
        {
            if (n1.Text != "" && n2.Text != "")
            {
                lbResultado.Text = (Int32.Parse(n1.Text) - Int32.Parse(n2.Text)).ToString();
                empyError.Visible = false;
            }
            else
            {
                empyError.Visible = true;
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}