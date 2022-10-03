namespace Ej12
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(tbPalabra.Text != "")
            {
                if (cbIgnorar.Checked)
                {
                    introducePalabra(tbPalabra.Text);
                }
                else
                {
                    if (!lbPalabras.Items.Contains(tbPalabra.Text))
                    {
                        introducePalabra(tbPalabra.Text);
                    }
                }
            }
        }

        private void introducePalabra(string text)
        {
           lbPalabras.Items.Add(text);
            tbPalabra.Text = "";
            tbStats.Text = "-Número de palabras: " + lbPalabras.Items.Count
                + "\r\n-Número de carácteres totales: " + charCount()
                + "\r\n-Número de espacios : " + spaceCount();
        }

        private string charCount()
        {
            int count = 0;
            for (int i = 0; i < lbPalabras.Items.Count; i++)
            {
                count +=lbPalabras.Items[i].ToString().Length;
            }
            return count.ToString();
        }
        private string spaceCount()
        {
            String s;
            int count = 0;
            for (int i = 0; i < lbPalabras.Items.Count; i++)
            {
                s=lbPalabras.Items[i].ToString();
                for (int j = 0; j < s.Length; j++)
                {
                    if (s[j] == ' ') count++;
                }
            }
            return count.ToString();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            fontDialog1.ShowDialog();
            lbPalabras.Font = fontDialog1.Font;
            lbPalabras.ForeColor = fontDialog1.Color;
        }

        private void apply(object sender, EventArgs e)
        {
            
            lbPalabras.Font = fontDialog1.Font;
            lbPalabras.ForeColor = fontDialog1.Color;
        }
    }
}