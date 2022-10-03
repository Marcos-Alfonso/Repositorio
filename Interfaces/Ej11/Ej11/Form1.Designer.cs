namespace Ej11
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.pbNs = new System.Windows.Forms.ProgressBar();
            this.pbNo = new System.Windows.Forms.ProgressBar();
            this.pbSi = new System.Windows.Forms.ProgressBar();
            this.lbTotal = new System.Windows.Forms.Label();
            this.lbNs = new System.Windows.Forms.Label();
            this.lbNo = new System.Windows.Forms.Label();
            this.lbSi = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.rbNs = new System.Windows.Forms.RadioButton();
            this.rbNo = new System.Windows.Forms.RadioButton();
            this.rbSi = new System.Windows.Forms.RadioButton();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.pbNs);
            this.groupBox1.Controls.Add(this.pbNo);
            this.groupBox1.Controls.Add(this.pbSi);
            this.groupBox1.Controls.Add(this.lbTotal);
            this.groupBox1.Controls.Add(this.lbNs);
            this.groupBox1.Controls.Add(this.lbNo);
            this.groupBox1.Controls.Add(this.lbSi);
            this.groupBox1.Controls.Add(this.button1);
            this.groupBox1.Controls.Add(this.rbNs);
            this.groupBox1.Controls.Add(this.rbNo);
            this.groupBox1.Controls.Add(this.rbSi);
            this.groupBox1.Location = new System.Drawing.Point(12, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(393, 167);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            // 
            // pbNs
            // 
            this.pbNs.Location = new System.Drawing.Point(214, 76);
            this.pbNs.Name = "pbNs";
            this.pbNs.Size = new System.Drawing.Size(155, 23);
            this.pbNs.TabIndex = 10;
            // 
            // pbNo
            // 
            this.pbNo.Location = new System.Drawing.Point(214, 58);
            this.pbNo.Name = "pbNo";
            this.pbNo.Size = new System.Drawing.Size(155, 23);
            this.pbNo.TabIndex = 9;
            // 
            // pbSi
            // 
            this.pbSi.Location = new System.Drawing.Point(214, 36);
            this.pbSi.Name = "pbSi";
            this.pbSi.Size = new System.Drawing.Size(155, 23);
            this.pbSi.TabIndex = 8;
            // 
            // lbTotal
            // 
            this.lbTotal.AutoSize = true;
            this.lbTotal.Location = new System.Drawing.Point(113, 113);
            this.lbTotal.Name = "lbTotal";
            this.lbTotal.Size = new System.Drawing.Size(13, 15);
            this.lbTotal.TabIndex = 7;
            this.lbTotal.Text = "0";
            // 
            // lbNs
            // 
            this.lbNs.AutoSize = true;
            this.lbNs.Location = new System.Drawing.Point(113, 88);
            this.lbNs.Name = "lbNs";
            this.lbNs.Size = new System.Drawing.Size(13, 15);
            this.lbNs.TabIndex = 6;
            this.lbNs.Text = "0";
            // 
            // lbNo
            // 
            this.lbNo.AutoSize = true;
            this.lbNo.Location = new System.Drawing.Point(113, 61);
            this.lbNo.Name = "lbNo";
            this.lbNo.Size = new System.Drawing.Size(13, 15);
            this.lbNo.TabIndex = 5;
            this.lbNo.Text = "0";
            // 
            // lbSi
            // 
            this.lbSi.AutoSize = true;
            this.lbSi.Location = new System.Drawing.Point(113, 36);
            this.lbSi.Name = "lbSi";
            this.lbSi.Size = new System.Drawing.Size(13, 15);
            this.lbSi.TabIndex = 4;
            this.lbSi.Text = "0";
            this.lbSi.Click += new System.EventHandler(this.label1_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(30, 109);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(62, 23);
            this.button1.TabIndex = 3;
            this.button1.Text = "Votar";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // rbNs
            // 
            this.rbNs.AutoSize = true;
            this.rbNs.Location = new System.Drawing.Point(30, 84);
            this.rbNs.Name = "rbNs";
            this.rbNs.Size = new System.Drawing.Size(62, 19);
            this.rbNs.TabIndex = 2;
            this.rbNs.TabStop = true;
            this.rbNs.Text = "NS/NC";
            this.rbNs.UseVisualStyleBackColor = true;
            // 
            // rbNo
            // 
            this.rbNo.AutoSize = true;
            this.rbNo.Location = new System.Drawing.Point(30, 59);
            this.rbNo.Name = "rbNo";
            this.rbNo.Size = new System.Drawing.Size(41, 19);
            this.rbNo.TabIndex = 1;
            this.rbNo.TabStop = true;
            this.rbNo.Text = "No";
            this.rbNo.UseVisualStyleBackColor = true;
            // 
            // rbSi
            // 
            this.rbSi.AutoSize = true;
            this.rbSi.Location = new System.Drawing.Point(30, 34);
            this.rbSi.Name = "rbSi";
            this.rbSi.Size = new System.Drawing.Size(34, 19);
            this.rbSi.TabIndex = 1;
            this.rbSi.TabStop = true;
            this.rbSi.Text = "Si";
            this.rbSi.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(433, 214);
            this.Controls.Add(this.groupBox1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private GroupBox groupBox1;
        private Label lbTotal;
        private Label lbNs;
        private Label lbNo;
        private Label lbSi;
        private Button button1;
        private RadioButton rbNs;
        private RadioButton rbNo;
        private RadioButton rbSi;
        private ProgressBar pbNs;
        private ProgressBar pbNo;
        private ProgressBar pbSi;
    }
}