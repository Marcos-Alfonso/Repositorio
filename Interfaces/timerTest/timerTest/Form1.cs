using System.Data;

namespace timerTest
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
   
        }
        
        private void timer1_Tick(object sender, EventArgs e)
        {
            label1.Text = System.DateTime.Now.ToString().Substring(10);
 
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int sum = 0;
            for (int i = 0; i < dataGridView1.RowCount-1; i++)
            {
                //if ((string)dataGridView1[3, i].Value !=null)
                    //sum += Int32.Parse(dataGridView1[3, i].Value.ToString());
                
            }
            //label2.Text = ((double)sum/(dataGridView1.RowCount-1)).ToString();
            AddPersona();

        }
        Form2 f = new Form2();
        public void AddPersona()
        {
            f = new Form2();

            f.setForm(this, dataGridView1);
            if (dataGridView1.SelectedRows.Count == 1)
                f.cambio();
                f.Show();
        }

        private void cambio(object sender, DataGridViewRowStateChangedEventArgs e)
        {
            // For any other operation except, StateChanged, do nothing
            if (e.StateChanged != DataGridViewElementStates.Selected) return;
            f.cambio();

            // Calculate amount code goes here
        }
 
        private void update(object sender, EventArgs e)
        {
         
            /*
            if (filtro.Text != "")
                dt.DefaultView.RowFilter = string.Format("id LIKE '%0%'", filtro.Text);
            else dt.DefaultView.RowFilter = "";
            */

        }

        private void Form1_Load(object sender, EventArgs e)
        {
    
        }
    }
}