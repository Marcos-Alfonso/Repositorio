
namespace PrimerExamen
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
            this.dtAlumnos = new System.Windows.Forms.DataGridView();
            this.label2 = new System.Windows.Forms.Label();
            this.Nombre = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Apellidos = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Notas = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Media = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btInsertar = new System.Windows.Forms.Button();
            this.btModificar = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.btVolver = new System.Windows.Forms.Button();
            this.txMedia = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dtAlumnos)).BeginInit();
            this.SuspendLayout();
            // 
            // dtAlumnos
            // 
            this.dtAlumnos.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dtAlumnos.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Nombre,
            this.Apellidos,
            this.Notas,
            this.Media});
            this.dtAlumnos.Location = new System.Drawing.Point(12, 31);
            this.dtAlumnos.Name = "dtAlumnos";
            this.dtAlumnos.Size = new System.Drawing.Size(446, 200);
            this.dtAlumnos.TabIndex = 0;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(13, 12);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(47, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "Alumnos";
            // 
            // Nombre
            // 
            this.Nombre.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.AllCells;
            this.Nombre.HeaderText = "Nombre";
            this.Nombre.Name = "Nombre";
            this.Nombre.ReadOnly = true;
            this.Nombre.Width = 69;
            // 
            // Apellidos
            // 
            this.Apellidos.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.AllCells;
            this.Apellidos.HeaderText = "Apellidos";
            this.Apellidos.Name = "Apellidos";
            this.Apellidos.ReadOnly = true;
            this.Apellidos.Width = 74;
            // 
            // Notas
            // 
            this.Notas.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.AllCells;
            this.Notas.HeaderText = "Notas";
            this.Notas.Name = "Notas";
            this.Notas.ReadOnly = true;
            this.Notas.Width = 60;
            // 
            // Media
            // 
            this.Media.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.AllCells;
            this.Media.HeaderText = "Nota Media";
            this.Media.Name = "Media";
            this.Media.ReadOnly = true;
            this.Media.Width = 87;
            // 
            // btInsertar
            // 
            this.btInsertar.Location = new System.Drawing.Point(464, 31);
            this.btInsertar.Name = "btInsertar";
            this.btInsertar.Size = new System.Drawing.Size(75, 23);
            this.btInsertar.TabIndex = 4;
            this.btInsertar.Text = "Insertar";
            this.btInsertar.UseVisualStyleBackColor = true;
            this.btInsertar.Click += new System.EventHandler(this.btInsertar_Click);
            // 
            // btModificar
            // 
            this.btModificar.Location = new System.Drawing.Point(464, 60);
            this.btModificar.Name = "btModificar";
            this.btModificar.Size = new System.Drawing.Size(75, 23);
            this.btModificar.TabIndex = 5;
            this.btModificar.Text = "Modificar";
            this.btModificar.UseVisualStyleBackColor = true;
            this.btModificar.Click += new System.EventHandler(this.btModificar_Click);
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(464, 89);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(75, 23);
            this.button3.TabIndex = 6;
            this.button3.Text = "Eliminar";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // btVolver
            // 
            this.btVolver.Location = new System.Drawing.Point(464, 208);
            this.btVolver.Name = "btVolver";
            this.btVolver.Size = new System.Drawing.Size(75, 23);
            this.btVolver.TabIndex = 7;
            this.btVolver.Text = "Volver";
            this.btVolver.UseVisualStyleBackColor = true;
            this.btVolver.Click += new System.EventHandler(this.btVolver_Click);
            // 
            // txMedia
            // 
            this.txMedia.Location = new System.Drawing.Point(464, 182);
            this.txMedia.Name = "txMedia";
            this.txMedia.ReadOnly = true;
            this.txMedia.Size = new System.Drawing.Size(75, 20);
            this.txMedia.TabIndex = 8;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(464, 166);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(36, 13);
            this.label1.TabIndex = 9;
            this.label1.Text = "Media";
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(548, 248);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txMedia);
            this.Controls.Add(this.btVolver);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.btModificar);
            this.Controls.Add(this.btInsertar);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.dtAlumnos);
            this.Name = "Form2";
            this.Text = "Alumnos";
            ((System.ComponentModel.ISupportInitialize)(this.dtAlumnos)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dtAlumnos;
        private System.Windows.Forms.DataGridViewTextBoxColumn Nombre;
        private System.Windows.Forms.DataGridViewTextBoxColumn Apellidos;
        private System.Windows.Forms.DataGridViewTextBoxColumn Notas;
        private System.Windows.Forms.DataGridViewTextBoxColumn Media;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btInsertar;
        private System.Windows.Forms.Button btModificar;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button btVolver;
        private System.Windows.Forms.TextBox txMedia;
        private System.Windows.Forms.Label label1;
    }
}