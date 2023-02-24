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
        public Form2(String vendedor)
        {
            InitializeComponent();
            ReportParameter rp = new ReportParameter("pVendedor", vendedor);
            reportViewer1.LocalReport.SetParameters(rp);
            this.reportViewer1.RefreshReport();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'inmobiliariaDataSet.inmuebles' Puede moverla o quitarla según sea necesario.
            this.inmueblesTableAdapter.Fill(this.inmobiliariaDataSet.inmuebles);

            this.reportViewer1.RefreshReport();
        }
    }
}
