
namespace EjercicioListados
{
    partial class Form2
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
            this.inmobiliariaDataSet = new EjercicioListados.inmobiliariaDataSet();
            this.inmueblesBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.inmueblesTableAdapter = new EjercicioListados.inmobiliariaDataSetTableAdapters.inmueblesTableAdapter();
            ((System.ComponentModel.ISupportInitialize)(this.inmobiliariaDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.inmueblesBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // reportViewer1
            // 
            this.reportViewer1.Dock = System.Windows.Forms.DockStyle.Fill;
            reportDataSource1.Name = "DataSet1";
            reportDataSource1.Value = this.inmueblesBindingSource;
            this.reportViewer1.LocalReport.DataSources.Add(reportDataSource1);
            this.reportViewer1.LocalReport.ReportEmbeddedResource = "EjercicioListados.Report1.rdlc";
            this.reportViewer1.Location = new System.Drawing.Point(0, 0);
            this.reportViewer1.Name = "reportViewer1";
            this.reportViewer1.ServerReport.BearerToken = null;
            this.reportViewer1.Size = new System.Drawing.Size(800, 450);
            this.reportViewer1.TabIndex = 0;
            // 
            // inmobiliariaDataSet
            // 
            this.inmobiliariaDataSet.DataSetName = "inmobiliariaDataSet";
            this.inmobiliariaDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // inmueblesBindingSource
            // 
            this.inmueblesBindingSource.DataMember = "inmuebles";
            this.inmueblesBindingSource.DataSource = this.inmobiliariaDataSet;
            // 
            // inmueblesTableAdapter
            // 
            this.inmueblesTableAdapter.ClearBeforeFill = true;
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.reportViewer1);
            this.Name = "Form2";
            this.Text = "Form2";
            this.Load += new System.EventHandler(this.Form2_Load);
            ((System.ComponentModel.ISupportInitialize)(this.inmobiliariaDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.inmueblesBindingSource)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private Microsoft.Reporting.WinForms.ReportViewer reportViewer1;
        private System.Windows.Forms.BindingSource inmueblesBindingSource;
        private inmobiliariaDataSet inmobiliariaDataSet;
        private inmobiliariaDataSetTableAdapters.inmueblesTableAdapter inmueblesTableAdapter;
    }
}