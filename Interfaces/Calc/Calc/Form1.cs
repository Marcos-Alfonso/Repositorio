using System.ComponentModel;
using System.Text.RegularExpressions;

namespace Calc
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void bt1_Click(object sender, EventArgs e)
        {
            screen.Text += "1";
        }

        private void bt2_Click(object sender, EventArgs e)
        {
            screen.Text += "2";
        }

        private void bt3_Click(object sender, EventArgs e)
        {
            screen.Text += "3";
        }

        private void bt4_Click(object sender, EventArgs e)
        {
            screen.Text += "4";
        }

        private void bt5_Click(object sender, EventArgs e)
        {
            screen.Text += "5";
        }

        private void bt6_Click(object sender, EventArgs e)
        {
            screen.Text += "6";
        }

        private void bt7_Click(object sender, EventArgs e)
        {
            screen.Text += "7";
        }

        private void bt8_Click(object sender, EventArgs e)
        {
            screen.Text += "8";
        }

        private void bt9_Click(object sender, EventArgs e)
        {
            screen.Text += "9";
        }
        private void bt0_Click(object sender, EventArgs e)
        {
            screen.Text += "0";
        }
        private void btBack_Click(object sender, EventArgs e)
        {
            if(screen.Text != "")
            {
                screen.Text = screen.Text.Substring(0,screen.Text.Length-1);
            }
        }

        private void btDiv_Click(object sender, EventArgs e)
        {
            screen.Text += "/";
        }

        private void btMulti_Click(object sender, EventArgs e)
        {
            screen.Text += "x";
        }

        private void btResta_Click(object sender, EventArgs e)
        {
            screen.Text += "-";
        }

        private void btSuma_Click(object sender, EventArgs e)
        {
            screen.Text += "+";
        }

        private void btComma_Click(object sender, EventArgs e)
        {
            screen.Text += ",";
        }

        private void btC_Click(object sender, EventArgs e)
        {
            screen.Text = "";
        }

        private void btIgual_Click(object sender, EventArgs e)
        {
            String s = screen.Text;
            for (int i = 0; i < screen.Text.Length; i++)
            {
                if (s[i] == '+')
                {
                    suma(i);
                }
                else if (s[i] =='-')
                {
                    resta(i);
                }else if (s[i] == 'x')
                {
                    multi(i);
                }
                else if (s[i] == '/')
                {
                    div(i);
                }
            }
            
        }
        private void suma(int i)
        {
            double a = Double.Parse(screen.Text.Substring(0,i));
            double b = Double.Parse(screen.Text.Substring(i+1));
            screen.Text = (a + b).ToString();label1.Visible = true;
        }
        private void resta(int i)
        {
            double a = Double.Parse(screen.Text.Substring(0, i));
            double b = Double.Parse(screen.Text.Substring(i+1));
            screen.Text = (a-b).ToString();
        }
        private void multi(int i)
        {
            double a = Double.Parse(screen.Text.Substring(0, i));
            double b = Double.Parse(screen.Text.Substring(i + 1));
            screen.Text = (a * b).ToString();
        }
        private void div(int i)
        {
            double a = Double.Parse(screen.Text.Substring(0, i));
            double b = Double.Parse(screen.Text.Substring(i + 1));
            screen.Text = (Math.Round(a/b, 5)).ToString();
        }

        private void updateText(object sender, EventArgs e)
        {/*
            char c = screen.Text.Substring(screen.Text.Length - 1)[0];
            if (c != '1' || c != '2' || c != '3' || c != '4' || c != '5' || c != '6' || c != '7' ||
                c != '8' || c != '9' || c != '0' || c != '+' || c != '-' || c != 'x' || c != '/' ||
                c != ',' || c != '.' ) 
            {
                screen.Text = screen.Text.Substring(0, screen.Text.Length - 1);
            }
            //if (screen.Text[screen.Text.Length-1].)
            /*
            Regex regex = new Regex(@"[^0-9^+^\-^\/^\*^\(^\)]");
            MatchCollection matches = regex.Matches(screen.Text);
            if (matches.Count > 0)
            {
                //tell the user
            }
            */
        }
    }
}