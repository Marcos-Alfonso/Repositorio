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
            this.nombre = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.pass = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.rol = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.button4 = new System.Windows.Forms.Button();
            this.panel1 = new System.Windows.Forms.Panel();
            this.EliminaPartida = new System.Windows.Forms.Button();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.tiempo = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nombreUsuario = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.puntos = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.lbError = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dtUsers)).BeginInit();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // dtUsers
            // 
            this.dtUsers.AllowUserToAddRows = false;
            this.dtUsers.AllowUserToDeleteRows = false;
            this.dtUsers.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dtUsers.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dtUsers.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.nombre,
            this.pass,
            this.rol});
            this.dtUsers.Location = new System.Drawing.Point(12, 12);
            this.dtUsers.MultiSelect = false;
            this.dtUsers.Name = "dtUsers";
            this.dtUsers.ReadOnly = true;
            this.dtUsers.RowHeadersVisible = false;
            this.dtUsers.RowTemplate.Height = 25;
            this.dtUsers.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dtUsers.Size = new System.Drawing.Size(213, 286);
            this.dtUsers.TabIndex = 0;
            this.dtUsers.SelectionChanged += new System.EventHandler(this.changed);
            // 
            // nombre
            // 
            this.nombre.HeaderText = "Usuario";
            this.nombre.Name = "nombre";
            this.nombre.ReadOnly = true;
            // 
            // pass
            // 
            this.pass.HeaderText = "Contraseña";
            this.pass.Name = "pass";
            this.pass.ReadOnly = true;
            this.pass.Visible = false;
            // 
            // rol
            // 
            this.rol.HeaderText = "Rol";
            this.rol.Name = "rol";
            this.rol.ReadOnly = true;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(231, 77);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(128, 23);
            this.textBox1.TabIndex = 1;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.label3.Location = new System.Drawing.Point(231, 59);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(57, 15);
            this.label3.TabIndex = 13;
            this.label3.Text = "Nombre: ";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.label1.Location = new System.Drawing.Point(231, 104);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(70, 15);
            this.label1.TabIndex = 15;
            this.label1.Text = "Contraseña:";
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(231, 122);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(128, 23);
            this.textBox2.TabIndex = 14;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(231, 217);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(128, 23);
            this.button1.TabIndex = 16;
            this.button1.Text = "Añadir";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(231, 246);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(128, 23);
            this.button2.TabIndex = 17;
            this.button2.Text = "Modificar";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(231, 275);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(128, 23);
            this.button3.TabIndex = 18;
            this.button3.Text = "Eliminar";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // button4
            // 
            this.button4.Location = new System.Drawing.Point(231, 151);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(128, 23);
            this.button4.TabIndex = 19;
            this.button4.Text = "Cambiar Rol";
            this.button4.UseVisualStyleBackColor = true;
            this.button4.Click += new System.EventHandler(this.button4_Click);
            // 
            // panel1
            // 
            this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel1.Controls.Add(this.EliminaPartida);
            this.panel1.Controls.Add(this.dataGridView1);
            this.panel1.Location = new System.Drawing.Point(365, -9);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(237, 347);
            this.panel1.TabIndex = 20;
            // 
            // EliminaPartida
            // 
            this.EliminaPartida.Location = new System.Drawing.Point(15, 283);
            this.EliminaPartida.Name = "EliminaPartida";
            this.EliminaPartida.Size = new System.Drawing.Size(150, 23);
            this.EliminaPartida.TabIndex = 19;
            this.EliminaPartida.Text = "Eliminar";
            this.EliminaPartida.UseVisualStyleBackColor = true;
            this.EliminaPartida.Click += new System.EventHandler(this.EliminaPartida_Click);
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.tiempo,
            this.nombreUsuario,
            this.puntos});
            this.dataGridView1.Location = new System.Drawing.Point(15, 20);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.ReadOnly = true;
            this.dataGridView1.RowHeadersVisible = false;
            this.dataGridView1.RowTemplate.Height = 25;
            this.dataGridView1.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridView1.Size = new System.Drawing.Size(150, 257);
            this.dataGridView1.TabIndex = 0;
            // 
            // tiempo
            // 
            this.tiempo.HeaderText = "Tiempo";
            this.tiempo.Name = "tiempo";
            this.tiempo.ReadOnly = true;
            // 
            // nombreUsuario
            // 
            this.nombreUsuario.HeaderText = "Nombre";
            this.nombreUsuario.Name = "nombreUsuario";
            this.nombreUsuario.ReadOnly = true;
            this.nombreUsuario.Visible = false;
            // 
            // puntos
            // 
            this.puntos.HeaderText = "Puntos";
            this.puntos.Name = "puntos";
            this.puntos.ReadOnly = true;
            // 
            // lbError
            // 
            this.lbError.AutoSize = true;
            this.lbError.ForeColor = System.Drawing.Color.Red;
            this.lbError.Location = new System.Drawing.Point(231, 177);
            this.lbError.Name = "lbError";
            this.lbError.Size = new System.Drawing.Size(0, 15);
            this.lbError.TabIndex = 21;
            // 
            // AdminUsers
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.ClientSize = new System.Drawing.Size(543, 310);
            this.Controls.Add(this.lbError);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.button4);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.dtUsers);
            this.Name = "AdminUsers";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Administración de Usuarios";
            ((System.ComponentModel.ISupportInitialize)(this.dtUsers)).EndInit();
            this.panel1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private DataGridView dtUsers;
        private TextBox textBox1;
        private Label label3;
        private Label label1;
        private TextBox textBox2;
        private Button button1;
        private Button button2;
        private Button button3;
        private Button button4;
        private Panel panel1;
        private Label lbError;
        private DataGridViewTextBoxColumn nombre;
        private DataGridViewTextBoxColumn pass;
        private DataGridViewTextBoxColumn rol;
        private Button EliminaPartida;
        private DataGridView dataGridView1;
        private DataGridViewTextBoxColumn tiempo;
        private DataGridViewTextBoxColumn nombreUsuario;
        private DataGridViewTextBoxColumn puntos;
    }
}