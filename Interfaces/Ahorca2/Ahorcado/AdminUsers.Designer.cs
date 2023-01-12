namespace Ahorcado
{
    partial class AdminUsers
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
            this.dtUsers = new System.Windows.Forms.DataGridView();
            ((System.ComponentModel.ISupportInitialize)(this.dtUsers)).BeginInit();
            this.SuspendLayout();
            // 
            // dtUsers
            // 
            this.dtUsers.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dtUsers.Location = new System.Drawing.Point(12, 12);
            this.dtUsers.Name = "dtUsers";
            this.dtUsers.RowTemplate.Height = 25;
            this.dtUsers.Size = new System.Drawing.Size(213, 286);
            this.dtUsers.TabIndex = 0;
            // 
            // AdminUsers
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.ClientSize = new System.Drawing.Size(543, 310);
            this.Controls.Add(this.dtUsers);
            this.Name = "AdminUsers";
            this.Text = "Form4";
            ((System.ComponentModel.ISupportInitialize)(this.dtUsers)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private DataGridView dtUsers;
    }
}