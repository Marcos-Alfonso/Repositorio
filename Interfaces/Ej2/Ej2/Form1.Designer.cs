namespace Ej2
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
            this.tbChar = new System.Windows.Forms.TextBox();
            this.tbLine = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.reset = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // tbChar
            // 
            this.tbChar.CharacterCasing = System.Windows.Forms.CharacterCasing.Upper;
            this.tbChar.Location = new System.Drawing.Point(47, 41);
            this.tbChar.MaxLength = 1;
            this.tbChar.Name = "tbChar";
            this.tbChar.Size = new System.Drawing.Size(20, 23);
            this.tbChar.TabIndex = 0;
            this.tbChar.TextChanged += new System.EventHandler(this.check);
            // 
            // tbLine
            // 
            this.tbLine.Location = new System.Drawing.Point(47, 79);
            this.tbLine.Name = "tbLine";
            this.tbLine.Size = new System.Drawing.Size(144, 23);
            this.tbLine.TabIndex = 1;
            this.tbLine.TextChanged += new System.EventHandler(this.check);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Segoe UI", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(47, 125);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(17, 25);
            this.label1.TabIndex = 2;
            this.label1.Text = " ";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // reset
            // 
            this.reset.Location = new System.Drawing.Point(111, 41);
            this.reset.Name = "reset";
            this.reset.Size = new System.Drawing.Size(80, 23);
            this.reset.TabIndex = 3;
            this.reset.Text = "Borrar";
            this.reset.UseVisualStyleBackColor = true;
            this.reset.Click += new System.EventHandler(this.reset_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(218, 198);
            this.Controls.Add(this.reset);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.tbLine);
            this.Controls.Add(this.tbChar);
            this.Name = "Form1";
            this.Text = "Comprueba carácter";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private TextBox tbChar;
        private TextBox tbLine;
        private Label label1;
        private Button reset;
    }
}