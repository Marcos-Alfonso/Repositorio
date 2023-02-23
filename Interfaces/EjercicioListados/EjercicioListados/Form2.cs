using Microsoft.Reporting.WinForms;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EjercicioListados
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {

            /*
            ReportParameter rp = new ReportParameter("pVendedor", "");
            reportViewer1.LocalReport.SetParameters(rp);
            */
            this.inmueblesTableAdapter1.Fill(this.inmobiliariaDataSet1.inmuebles);
            this.reportViewer1.RefreshReport();
        }
    }
}
