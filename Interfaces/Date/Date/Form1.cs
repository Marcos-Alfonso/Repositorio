namespace Date
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            dtSalida.Enabled = false;
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void dateSelected(object sender, EventArgs e)
        {
            dtSalida.Enabled = true;
            dtSalida.MinDate = dtEntrada.Value;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                int totalHoras =(int) (dtSalida.Value - dtEntrada.Value).TotalHours;
                lbResultado.Text = $"Total a pagar: {totalHoras*Double.Parse(textBox1.Text)}";
            }
            catch (FormatException  ex)
            {
                
            }
            
        }

        private void dtEntrada_ValueChanged(object sender, EventArgs e)
        {

        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
}