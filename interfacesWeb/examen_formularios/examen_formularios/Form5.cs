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

namespace examen_formularios
{
    public partial class Form5 : Form
    {
        public Form5(String code)
        {
            InitializeComponent();

            ReportParameter rp = new ReportParameter("rpCountry", code);
            reportViewer1.LocalReport.SetParameters(rp);
            this.reportViewer1.RefreshReport();
        }

        private void Form5_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'worldDataSet.city' Puede moverla o quitarla según sea necesario.
            this.cityTableAdapter.Fill(this.worldDataSet.city);

            this.reportViewer1.RefreshReport();
        }
    }
}
