namespace Ahorcado
{
    partial class Form3
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
            this.tx = new System.Windows.Forms.TextBox();
            this.btBack = new System.Windows.Forms.Button();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.tiempo = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Puntos = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // tx
            // 
            this.tx.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.tx.BackColor = System.Drawing.SystemColors.InactiveCaptionText;
            this.tx.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.tx.Font = new System.Drawing.Font("Arial", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.tx.ForeColor = System.Drawing.SystemColors.Menu;
            this.tx.Location = new System.Drawing.Point(28, 12);
            this.tx.Multiline = true;
            this.tx.Name = "tx";
            this.tx.ReadOnly = true;
            this.tx.Size = new System.Drawing.Size(395, 23);
            this.tx.TabIndex = 33;
            // 
            // btBack
            // 
            this.btBack.BackColor = System.Drawing.SystemColors.Desktop;
            this.btBack.Font = new System.Drawing.Font("Arial", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.btBack.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.btBack.Location = new System.Drawing.Point(339, 156);
            this.btBack.Name = "btBack";
            this.btBack.Size = new System.Drawing.Size(84, 50);
            this.btBack.TabIndex = 35;
            this.btBack.Text = "Menu Principal";
            this.btBack.UseVisualStyleBackColor = false;
            this.btBack.Click += new System.EventHandler(this.button26_Click);
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.tiempo,
            this.Puntos});
            this.dataGridView1.Location = new System.Drawing.Point(28, 56);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowTemplate.Height = 25;
            this.dataGridView1.Size = new System.Drawing.Size(199, 150);
            this.dataGridView1.TabIndex = 36;
            // 
            // tiempo
            // 
            this.tiempo.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.AllCells;
            this.tiempo.HeaderText = "Tiempo";
            this.tiempo.Name = "tiempo";
            this.tiempo.ReadOnly = true;
            this.tiempo.Width = 73;
            // 
            // Puntos
            // 
            this.Puntos.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.AllCells;
            this.Puntos.HeaderText = "Puntos";
            this.Puntos.Name = "Puntos";
            this.Puntos.ReadOnly = true;
            this.Puntos.Width = 69;
            // 
            // Form3
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.ClientSize = new System.Drawing.Size(435, 234);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.btBack);
            this.Controls.Add(this.tx);
            this.Name = "Form3";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Estadísticas";
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private TextBox tx;
        private Button btBack;
        private DataGridView dataGridView1;
        private DataGridViewTextBoxColumn tiempo;
        private DataGridViewTextBoxColumn Puntos;
    }
}