namespace timerTest
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private static int count=0;
        
        private void timer1_Tick(object sender, EventArgs e)
        {
            label1.Text = System.DateTime.Now.ToString().Substring(10);
           
            DataGridViewColumn d = dataGridView1.Columns[3];
           
            
            
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int sum = 0;
            for (int i = 0; i < dataGridView1.RowCount-1; i++)
            {
                //if ((string)dataGridView1[3, i].Value !=null)
                    sum += Int32.Parse(dataGridView1[3, i].Value.ToString());
                
            }
            label2.Text = ((double)sum/(dataGridView1.RowCount-1)).ToString();

        }
        public static void AddPersona(Persona p)
        {
            p.
        }
    }
}