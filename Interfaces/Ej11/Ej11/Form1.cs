namespace Ej11
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        int si = 0;
        int no = 0;
        int ns = 0;
        private void button1_Click(object sender, EventArgs e)
        {
                if (rbSi.Checked)
                {
                    si++;
                }
                else if(rbNo.Checked)
                {
                    no++;
                }
                else if (rbNs.Checked)
                {
                    ns++;
                }
            update();
            rbSi.Checked = false;
            rbNo.Checked = false;
            rbNs.Checked = false;  
        }

        private void update()
        {
            int total = si+no+ns;
            lbSi.Text = si + "  "+ Math.Round((((double)si / (double)total) * 100),2) + "%";
            lbNo.Text = no + "  " + Math.Round((((double)no / (double)total) * 100),2) + "%";
            lbNs.Text = ns + "  " + Math.Round((((double)ns / (double)total) * 100),2) + "%";
            lbTotal.Text = total.ToString();
            pbSi.Value = (int)(((double)si / total) * 100);
            pbNo.Value = (int)(((double)no / total) * 100);
            pbNs.Value = (int)(((double)ns / total) * 100);
            
        }
    }
}