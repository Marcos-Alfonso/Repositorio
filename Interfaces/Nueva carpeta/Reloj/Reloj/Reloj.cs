using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Reloj
{
    public partial class Reloj: UserControl
    {
        private DateTime fecha;

        public DateTime fechaAlarma
        {
            get { return fecha; }
            set
            {
                fecha = value;
            }
        }
        public Reloj()
        {
            InitializeComponent();
            fecha = DateTime.Now;
        }

        protected virtual void update(object sender, EventArgs e)
        {
            lbDisplay.Text = DateTime.Now.ToLongTimeString();
            TimeSpan dif = (fecha - DateTime.Now);

            if((int)dif.TotalDays <= 0)
            {

                timeRemaining.Text = dif.ToString().Substring(0,8);
            }
            else
            {
                timeRemaining.Text = ((int)dif.TotalDays).ToString()+" dias.";
            }
            
        }

        private void lbDisplay_Click(object sender, EventArgs e)
        {

        }

        private void timeRemaining_Click(object sender, EventArgs e)
        {

        }
    }
}
