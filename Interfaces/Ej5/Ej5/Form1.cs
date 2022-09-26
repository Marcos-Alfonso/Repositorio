namespace Ej5
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void change(object sender, EventArgs e)
        {
            label1.ForeColor = Color.Black;
            label1.Text = "Usted ha seleccionado la palabra '"+comboBox1.SelectedItem.ToString()+"' que se encuentra en la posición "+comboBox1.SelectedIndex;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text != "" )
            {
                if (comboBox1.Items.Contains(textBox1.Text))
                {
                    label1.ForeColor = Color.Red;
                    label1.Text = "Error. Cadena ya perteneciente. ";
                }
                else
                {
                    comboBox1.Items.Add(textBox1.Text);
                     label1.Text = "";
                     textBox1.Text = "";
                }
                
            }
        }

        
    }
}