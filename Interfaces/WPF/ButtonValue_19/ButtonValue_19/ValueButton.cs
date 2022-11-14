using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ButtonValue_19
{
    public partial class ValueButton: Button
    {
        private int varValue;

        public int ButtonValue
        {
            get { return varValue; }
            set
            {
                varValue = value;
            }
        }
        public ValueButton()
        {
            InitializeComponent();
        }
    }
}
