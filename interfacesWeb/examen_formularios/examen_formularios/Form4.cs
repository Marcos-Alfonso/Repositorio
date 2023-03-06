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
    public partial class Form4 : Form
    {
        int i = 0;
        public Form4(int max)
        {
            InitializeComponent();
            i = max;

        }

        private void Form4_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'worldDataSet.city' Puede moverla o quitarla según sea necesario.
            this.cityTableAdapter.Fill(this.worldDataSet.city);
            // TODO: esta línea de código carga datos en la tabla 'worldDataSet.country' Puede moverla o quitarla según sea necesario.
            this.countryTableAdapter.Fill(this.worldDataSet.country);

            this.reportViewer1.RefreshReport();

            ReportParameter rp = new ReportParameter("rpMax", i.ToString());
            reportViewer1.LocalReport.SetParameters(rp);
            this.reportViewer1.RefreshReport();
        }
    }
}
