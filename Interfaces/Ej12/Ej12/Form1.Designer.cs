namespace Ej12
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.tbPalabra = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.lbPalabras = new System.Windows.Forms.ListBox();
            this.tbStats = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.cbIgnorar = new System.Windows.Forms.CheckBox();
            this.SuspendLayout();
            // 
            // tbPalabra
            // 
            this.tbPalabra.Location = new System.Drawing.Point(38, 141);
            this.tbPalabra.Name = "tbPalabra";
            this.tbPalabra.Size = new System.Drawing.Size(100, 23);
            this.tbPalabra.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(38, 123);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(46, 15);
            this.label1.TabIndex = 1;
            this.label1.Text = "Palabra";
            // 
            // lbPalabras
            // 
            this.lbPalabras.FormattingEnabled = true;
            this.lbPalabras.ItemHeight = 15;
            this.lbPalabras.Location = new System.Drawing.Point(164, 49);
            this.lbPalabras.Name = "lbPalabras";
            this.lbPalabras.Size = new System.Drawing.Size(153, 244);
            this.lbPalabras.Sorted = true;
            this.lbPalabras.TabIndex = 2;
            // 
            // tbStats
            // 
            this.tbStats.Location = new System.Drawing.Point(342, 102);
            this.tbStats.Multiline = true;
            this.tbStats.Name = "tbStats";
            this.tbStats.ReadOnly = true;
            this.tbStats.Size = new System.Drawing.Size(160, 147);
            this.tbStats.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(390, 84);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(67, 15);
            this.label2.TabIndex = 4;
            this.label2.Text = "Estadísticas";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(52, 170);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 5;
            this.button1.Text = "Añadir";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // cbIgnorar
            // 
            this.cbIgnorar.AutoSize = true;
            this.cbIgnorar.Location = new System.Drawing.Point(52, 199);
            this.cbIgnorar.Name = "cbIgnorar";
            this.cbIgnorar.Size = new System.Drawing.Size(64, 19);
            this.cbIgnorar.TabIndex = 6;
            this.cbIgnorar.Text = "Ignorar";
            this.cbIgnorar.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(514, 312);
            this.Controls.Add(this.cbIgnorar);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.tbStats);
            this.Controls.Add(this.lbPalabras);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.tbPalabra);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private TextBox tbPalabra;
        private Label label1;
        private ListBox lbPalabras;
        private TextBox tbStats;
        private Label label2;
        private Button button1;
        private CheckBox cbIgnorar;
    }
}