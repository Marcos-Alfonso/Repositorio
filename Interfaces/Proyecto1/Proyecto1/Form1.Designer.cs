namespace Proyecto1
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.label1 = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.label2 = new System.Windows.Forms.Label();
            this.n1 = new System.Windows.Forms.TextBox();
            this.n2 = new System.Windows.Forms.TextBox();
            this.btSuma = new System.Windows.Forms.Button();
            this.lbResultado = new System.Windows.Forms.Label();
            this.btResta = new System.Windows.Forms.Button();
            this.empyError = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Cursor = System.Windows.Forms.Cursors.No;
            this.label1.Font = new System.Drawing.Font("Segoe UI", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(36, 65);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(105, 25);
            this.label1.TabIndex = 0;
            this.label1.Text = "Número 1: ";
            this.label1.UseWaitCursor = true;
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(12, 290);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(155, 118);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.CenterImage;
            this.pictureBox1.TabIndex = 1;
            this.pictureBox1.TabStop = false;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Cursor = System.Windows.Forms.Cursors.No;
            this.label2.Font = new System.Drawing.Font("Segoe UI", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label2.Location = new System.Drawing.Point(36, 90);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(105, 25);
            this.label2.TabIndex = 2;
            this.label2.Text = "Número 2: ";
            this.label2.UseWaitCursor = true;
            // 
            // n1
            // 
            this.n1.Location = new System.Drawing.Point(147, 67);
            this.n1.Name = "n1";
            this.n1.Size = new System.Drawing.Size(100, 23);
            this.n1.TabIndex = 3;
            // 
            // n2
            // 
            this.n2.Location = new System.Drawing.Point(147, 92);
            this.n2.Name = "n2";
            this.n2.Size = new System.Drawing.Size(100, 23);
            this.n2.TabIndex = 4;
            // 
            // btSuma
            // 
            this.btSuma.Location = new System.Drawing.Point(350, 243);
            this.btSuma.Name = "btSuma";
            this.btSuma.Size = new System.Drawing.Size(75, 23);
            this.btSuma.TabIndex = 5;
            this.btSuma.Text = "Suma";
            this.btSuma.UseVisualStyleBackColor = true;
            this.btSuma.Click += new System.EventHandler(this.btSuma_Click);
            // 
            // lbResultado
            // 
            this.lbResultado.AutoSize = true;
            this.lbResultado.Location = new System.Drawing.Point(450, 126);
            this.lbResultado.Name = "lbResultado";
            this.lbResultado.Size = new System.Drawing.Size(65, 15);
            this.lbResultado.TabIndex = 6;
            this.lbResultado.Text = "Resultado: ";
            // 
            // btResta
            // 
            this.btResta.Location = new System.Drawing.Point(431, 243);
            this.btResta.Name = "btResta";
            this.btResta.Size = new System.Drawing.Size(75, 23);
            this.btResta.TabIndex = 7;
            this.btResta.Text = "Resta";
            this.btResta.UseVisualStyleBackColor = true;
            this.btResta.Click += new System.EventHandler(this.resta);
            // 
            // empyError
            // 
            this.empyError.AutoSize = true;
            this.empyError.Font = new System.Drawing.Font("Segoe UI", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.empyError.ForeColor = System.Drawing.Color.Red;
            this.empyError.Location = new System.Drawing.Point(61, 127);
            this.empyError.Name = "empyError";
            this.empyError.Size = new System.Drawing.Size(186, 15);
            this.empyError.TabIndex = 8;
            this.empyError.Text = "Debe introducir valores primero";
            this.empyError.Visible = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.InactiveCaption;
            this.ClientSize = new System.Drawing.Size(739, 420);
            this.Controls.Add(this.empyError);
            this.Controls.Add(this.btResta);
            this.Controls.Add(this.lbResultado);
            this.Controls.Add(this.btSuma);
            this.Controls.Add(this.n2);
            this.Controls.Add(this.n1);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.label1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form1";
            this.RightToLeftLayout = true;
            this.Text = "Form";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Label label1;
        private PictureBox pictureBox1;
        private Label label2;
        private TextBox n1;
        private TextBox n2;
        private Button btSuma;
        private Label lbResultado;
        private Button btResta;
        private Label empyError;
    }
}