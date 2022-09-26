namespace Ej2
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

        private void check(object sender, EventArgs e)
        {
            if(tbChar.Text!="" || tbLine.Text != "")
            {
                label1.Text = getSame() + " coincidencias.";
            }
            else
            {
                label1.Text = " ";
            }
        }

        private int getSame()
        {
            int count = 0;
            for(int i = 0; i < tbLine.Text.Length; i++)
            {
                if(tbChar.Text.ToString() == tbLine.Text[i].ToString().ToUpper())
                {
                    count++;
                }
            }
            return count;
        }

        private void reset_Click(object sender, EventArgs e)
        {
            label1.Text = " ";
            tbChar.Text = "";
            tbLine.Text = "";
        }
    }
}