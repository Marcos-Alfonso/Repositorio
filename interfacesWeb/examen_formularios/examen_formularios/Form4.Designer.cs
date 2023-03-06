
namespace examen_formularios
{
    partial class Form4
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            Microsoft.Reporting.WinForms.ReportDataSource reportDataSource1 = new Microsoft.Reporting.WinForms.ReportDataSource();
            this.reportViewer1 = new Microsoft.Reporting.WinForms.ReportViewer();
            this.worldDataSet = new examen_formularios.worldDataSet();
            this.countryBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.countryTableAdapter = new examen_formularios.worldDataSetTableAdapters.countryTableAdapter();
            this.cityBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.cityTableAdapter = new examen_formularios.worldDataSetTableAdapters.cityTableAdapter();
            ((System.ComponentModel.ISupportInitialize)(this.worldDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.countryBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.cityBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // reportViewer1
            // 
            this.reportViewer1.Dock = System.Windows.Forms.DockStyle.Fill;
            reportDataSource1.Name = "DataSet1";
            reportDataSource1.Value = this.cityBindingSource;
            this.reportViewer1.LocalReport.DataSources.Add(reportDataSource1);
            this.reportViewer1.LocalReport.ReportEmbeddedResource = "examen_formularios.Report2.rdlc";
            this.reportViewer1.Location = new System.Drawing.Point(0, 0);
            this.reportViewer1.Name = "reportViewer1";
            this.reportViewer1.ServerReport.BearerToken = null;
            this.reportViewer1.Size = new System.Drawing.Size(800, 450);
            this.reportViewer1.TabIndex = 0;
            // 
            // worldDataSet
            // 
            this.worldDataSet.DataSetName = "worldDataSet";
            this.worldDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // countryBindingSource
            // 
            this.countryBindingSource.DataMember = "country";
            this.countryBindingSource.DataSource = this.worldDataSet;
            // 
            // countryTableAdapter
            // 
            this.countryTableAdapter.ClearBeforeFill = true;
            // 
            // cityBindingSource
            // 
            this.cityBindingSource.DataMember = "city";
            this.cityBindingSource.DataSource = this.worldDataSet;
            // 
            // cityTableAdapter
            // 
            this.cityTableAdapter.ClearBeforeFill = true;
            // 
            // Form4
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.reportViewer1);
            this.Name = "Form4";
            this.Text = "Form4";
            this.Load += new System.EventHandler(this.Form4_Load);
            ((System.ComponentModel.ISupportInitialize)(this.worldDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.countryBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.cityBindingSource)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private Microsoft.Reporting.WinForms.ReportViewer reportViewer1;
        private System.Windows.Forms.BindingSource countryBindingSource;
        private worldDataSet worldDataSet;
        private worldDataSetTableAdapters.countryTableAdapter countryTableAdapter;
        private System.Windows.Forms.BindingSource cityBindingSource;
        private worldDataSetTableAdapters.cityTableAdapter cityTableAdapter;
    }
}