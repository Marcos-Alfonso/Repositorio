
namespace examen_formularios
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.radioButton4 = new System.Windows.Forms.RadioButton();
            this.radioButton3 = new System.Windows.Forms.RadioButton();
            this.radioButton2 = new System.Windows.Forms.RadioButton();
            this.radioButton1 = new System.Windows.Forms.RadioButton();
            this.comboBox1 = new System.Windows.Forms.ComboBox();
            this.worldDataSet = new examen_formularios.worldDataSet();
            this.worldDataSetBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.countryBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.countryTableAdapter = new examen_formularios.worldDataSetTableAdapters.countryTableAdapter();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.worldDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.worldDataSetBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.countryBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.comboBox1);
            this.groupBox1.Controls.Add(this.textBox1);
            this.groupBox1.Controls.Add(this.button1);
            this.groupBox1.Controls.Add(this.radioButton4);
            this.groupBox1.Controls.Add(this.radioButton3);
            this.groupBox1.Controls.Add(this.radioButton2);
            this.groupBox1.Controls.Add(this.radioButton1);
            this.groupBox1.Location = new System.Drawing.Point(58, 25);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(457, 190);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Informes";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(244, 97);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 20);
            this.textBox1.TabIndex = 5;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(34, 161);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 4;
            this.button1.Text = "Abrir informe";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // radioButton4
            // 
            this.radioButton4.AutoSize = true;
            this.radioButton4.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.radioButton4.Location = new System.Drawing.Point(34, 123);
            this.radioButton4.Name = "radioButton4";
            this.radioButton4.Size = new System.Drawing.Size(102, 17);
            this.radioButton4.TabIndex = 3;
            this.radioButton4.TabStop = true;
            this.radioButton4.Text = "Seleccione país";
            this.radioButton4.UseVisualStyleBackColor = true;
            // 
            // radioButton3
            // 
            this.radioButton3.AutoSize = true;
            this.radioButton3.Location = new System.Drawing.Point(34, 100);
            this.radioButton3.Name = "radioButton3";
            this.radioButton3.Size = new System.Drawing.Size(210, 17);
            this.radioButton3.TabIndex = 2;
            this.radioButton3.TabStop = true;
            this.radioButton3.Text = "Ciudades con poblaciones mayores de ";
            this.radioButton3.UseVisualStyleBackColor = true;
            // 
            // radioButton2
            // 
            this.radioButton2.AutoSize = true;
            this.radioButton2.ForeColor = System.Drawing.SystemColors.ButtonShadow;
            this.radioButton2.Location = new System.Drawing.Point(34, 77);
            this.radioButton2.Name = "radioButton2";
            this.radioButton2.Size = new System.Drawing.Size(163, 17);
            this.radioButton2.TabIndex = 1;
            this.radioButton2.TabStop = true;
            this.radioButton2.Text = "Listado de países y ciudades";
            this.radioButton2.UseVisualStyleBackColor = true;
            // 
            // radioButton1
            // 
            this.radioButton1.AutoSize = true;
            this.radioButton1.Location = new System.Drawing.Point(34, 54);
            this.radioButton1.Name = "radioButton1";
            this.radioButton1.Size = new System.Drawing.Size(107, 17);
            this.radioButton1.TabIndex = 0;
            this.radioButton1.TabStop = true;
            this.radioButton1.Text = "Listado de paises";
            this.radioButton1.UseVisualStyleBackColor = true;
            this.radioButton1.CheckedChanged += new System.EventHandler(this.radioButton1_CheckedChanged);
            // 
            // comboBox1
            // 
            this.comboBox1.DataSource = this.countryBindingSource;
            this.comboBox1.DisplayMember = "Name";
            this.comboBox1.FormattingEnabled = true;
            this.comboBox1.Location = new System.Drawing.Point(152, 119);
            this.comboBox1.Name = "comboBox1";
            this.comboBox1.Size = new System.Drawing.Size(121, 21);
            this.comboBox1.TabIndex = 6;
            this.comboBox1.ValueMember = "Code";
            // 
            // worldDataSet
            // 
            this.worldDataSet.DataSetName = "worldDataSet";
            this.worldDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // worldDataSetBindingSource
            // 
            this.worldDataSetBindingSource.DataSource = this.worldDataSet;
            this.worldDataSetBindingSource.Position = 0;
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
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.groupBox1);
            this.Name = "Form2";
            this.Text = "Form2";
            this.Load += new System.EventHandler(this.Form2_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.worldDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.worldDataSetBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.countryBindingSource)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.RadioButton radioButton1;
        private System.Windows.Forms.RadioButton radioButton4;
        private System.Windows.Forms.RadioButton radioButton3;
        private System.Windows.Forms.RadioButton radioButton2;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.ComboBox comboBox1;
        private System.Windows.Forms.BindingSource worldDataSetBindingSource;
        private worldDataSet worldDataSet;
        private System.Windows.Forms.BindingSource countryBindingSource;
        private worldDataSetTableAdapters.countryTableAdapter countryTableAdapter;
    }
}