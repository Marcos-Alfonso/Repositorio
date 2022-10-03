namespace Ej8
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            TextBox []arrayPrecios = new TextBox[3]{precio1,precio2,precio3};
            TextBox []arrayCantidad = new TextBox[3] { cantidad1, cantidad2, cantidad3 };
            double total = 0;
            for (int i = 0; i < arrayPrecios.Length; i++)
            {
                if (arrayPrecios[i].Text !="" )
                {
                    if(arrayCantidad[i].Text != "")
                    {
                        total += Int32.Parse(arrayCantidad[i].Text) * Double.Parse(arrayPrecios[i].Text);
                    }
                    else//interpreto que si no hay cantidad introducida interpreto que es 1.
                    {
                        total += Double.Parse(arrayPrecios[i].Text);
                    }
                    
                }
            }
            tbTotal.Text = (total*1.21).ToString();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            precio1.Text = ""; precio2.Text = ""; precio3.Text = "";
            cantidad1.Text = ""; cantidad2.Text = ""; cantidad3.Text = "";
            nombre1.Text = ""; nombre2.Text = ""; nombre3.Text = "";
            tbTotal.Text = "";
        }
    }
}