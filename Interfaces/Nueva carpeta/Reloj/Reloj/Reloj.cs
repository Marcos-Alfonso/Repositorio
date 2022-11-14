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
        public Reloj()
        {
            InitializeComponent();
        }

        protected virtual void update(object sender, EventArgs e)
        {
            lbDisplay.Text = DateTime.Now.ToLongTimeString();
        }
    }
}
