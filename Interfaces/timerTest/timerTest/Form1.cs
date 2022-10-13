using System.Data;
using System.Windows.Forms;

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
            recalcula_Click(sender, e);
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
            DataTable dt = new DataTable();
            if (filtro.Text != "")
                dt.DefaultView.RowFilter = string.Format("nombre = '%0%'", filtro.Text);
            else dt.DefaultView.RowFilter = "";
            dataGridView1.DataSource = dt;
            */
            foreach (DataGridViewRow row in dataGridView1.Rows)
            {
                if(filtro.Text != "")
                {
                    try
                    {
                     
                        if (!row.Cells["Apellidos"].Value.ToString().Contains(filtro.Text)) row.Visible = false;
                    }
                    catch (NullReferenceException ex)
                    {
                    }
                }
                else row.Visible = true;
                
               
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
    
        }

        private void recalcula_Click(object sender, EventArgs e) 
        {
            try
            {
                foreach (DataGridViewRow row in dataGridView1.Rows)
                {
                    String s = row.Cells["Nombre"].Value.ToString();
                    double totalNota = 0;
                    int count = 0;
                    foreach (DataGridViewRow row2 in dataGridView2.Rows)
                    {
                        try
                        {
                            if (s.Equals(row2.Cells["nPersona"].Value.ToString()))
                            {
                                totalNota += Double.Parse(row2.Cells["Nota"].Value.ToString());
                                count++;
                            }
                        }
                        catch (NullReferenceException exe){}
                    }
                    row.Cells["Notas"].Value = totalNota / count;
                }
            }
            catch (NullReferenceException ex){}
        }
    }
}