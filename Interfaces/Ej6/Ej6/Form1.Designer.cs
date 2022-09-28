namespace Ej6
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
            this.paneEfectivo = new System.Windows.Forms.Panel();
            this.textBox3 = new System.Windows.Forms.TextBox();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.modoPago = new System.Windows.Forms.ComboBox();
            this.paneTarjeta = new System.Windows.Forms.Panel();
            this.textBox5 = new System.Windows.Forms.TextBox();
            this.textBox6 = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.paneEfectivo.SuspendLayout();
            this.paneTarjeta.SuspendLayout();
            this.SuspendLayout();
            // 
            // paneEfectivo
            // 
            this.paneEfectivo.BackColor = System.Drawing.Color.Silver;
            this.paneEfectivo.Controls.Add(this.paneTarjeta);
            this.paneEfectivo.Controls.Add(this.textBox3);
            this.paneEfectivo.Controls.Add(this.textBox2);
            this.paneEfectivo.Controls.Add(this.textBox1);
            this.paneEfectivo.Controls.Add(this.label3);
            this.paneEfectivo.Controls.Add(this.label2);
            this.paneEfectivo.Controls.Add(this.label1);
            this.paneEfectivo.Location = new System.Drawing.Point(52, 83);
            this.paneEfectivo.Name = "paneEfectivo";
            this.paneEfectivo.Size = new System.Drawing.Size(238, 100);
            this.paneEfectivo.TabIndex = 0;
            // 
            // textBox3
            // 
            this.textBox3.Location = new System.Drawing.Point(128, 61);
            this.textBox3.Name = "textBox3";
            this.textBox3.Size = new System.Drawing.Size(100, 23);
            this.textBox3.TabIndex = 4;
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(128, 36);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(100, 23);
            this.textBox2.TabIndex = 3;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(128, 11);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 23);
            this.textBox1.TabIndex = 1;
            // 
            // label3
            // 
            this.label3.AccessibleRole = System.Windows.Forms.AccessibleRole.None;
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(14, 64);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(49, 15);
            this.label3.TabIndex = 2;
            this.label3.Text = "Cambio";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(14, 39);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(61, 15);
            this.label2.TabIndex = 1;
            this.label2.Text = "Entregado";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(14, 14);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(33, 15);
            this.label1.TabIndex = 0;
            this.label1.Text = "Total";
            // 
            // modoPago
            // 
            this.modoPago.FormattingEnabled = true;
            this.modoPago.Items.AddRange(new object[] {
            "Efectivo",
            "Con tarjeta"});
            this.modoPago.Location = new System.Drawing.Point(52, 44);
            this.modoPago.Name = "modoPago";
            this.modoPago.Size = new System.Drawing.Size(121, 23);
            this.modoPago.TabIndex = 2;
            this.modoPago.SelectedIndexChanged += new System.EventHandler(this.modoPago_SelectedIndexChanged);
            // 
            // paneTarjeta
            // 
            this.paneTarjeta.BackColor = System.Drawing.Color.Silver;
            this.paneTarjeta.Controls.Add(this.textBox5);
            this.paneTarjeta.Controls.Add(this.textBox6);
            this.paneTarjeta.Controls.Add(this.label5);
            this.paneTarjeta.Controls.Add(this.label6);
            this.paneTarjeta.Location = new System.Drawing.Point(0, 0);
            this.paneTarjeta.Name = "paneTarjeta";
            this.paneTarjeta.Size = new System.Drawing.Size(238, 100);
            this.paneTarjeta.TabIndex = 5;
            // 
            // textBox5
            // 
            this.textBox5.Location = new System.Drawing.Point(128, 36);
            this.textBox5.Name = "textBox5";
            this.textBox5.Size = new System.Drawing.Size(100, 23);
            this.textBox5.TabIndex = 3;
            // 
            // textBox6
            // 
            this.textBox6.Location = new System.Drawing.Point(128, 11);
            this.textBox6.Name = "textBox6";
            this.textBox6.Size = new System.Drawing.Size(100, 23);
            this.textBox6.TabIndex = 1;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(14, 39);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(98, 15);
            this.label5.TabIndex = 1;
            this.label5.Text = "Fecha Caducidad";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(14, 14);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(56, 15);
            this.label6.TabIndex = 0;
            this.label6.Text = "NºTarjeta";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Gray;
            this.ClientSize = new System.Drawing.Size(324, 222);
            this.Controls.Add(this.modoPago);
            this.Controls.Add(this.paneEfectivo);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.paneEfectivo.ResumeLayout(false);
            this.paneEfectivo.PerformLayout();
            this.paneTarjeta.ResumeLayout(false);
            this.paneTarjeta.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private Panel paneEfectivo;
        private TextBox textBox3;
        private TextBox textBox2;
        private TextBox textBox1;
        private Label label3;
        private Label label2;
        private Label label1;
        private ComboBox modoPago;
        private Panel paneTarjeta;
        private TextBox textBox5;
        private TextBox textBox6;
        private Label label5;
        private Label label6;
    }
}