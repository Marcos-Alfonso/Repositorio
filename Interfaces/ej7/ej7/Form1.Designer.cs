namespace ej7
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
            this.rbMulti = new System.Windows.Forms.RadioButton();
            this.group = new System.Windows.Forms.GroupBox();
            this.rbTodas = new System.Windows.Forms.RadioButton();
            this.rbDividir = new System.Windows.Forms.RadioButton();
            this.rbResta = new System.Windows.Forms.RadioButton();
            this.rbSuma = new System.Windows.Forms.RadioButton();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.a = new System.Windows.Forms.TextBox();
            this.b = new System.Windows.Forms.TextBox();
            this.c = new System.Windows.Forms.TextBox();
            this.btAcepta = new System.Windows.Forms.Button();
            this.Borra = new System.Windows.Forms.Button();
            this.lbAnswer = new System.Windows.Forms.Label();
            this.lbError = new System.Windows.Forms.Label();
            this.group.SuspendLayout();
            this.SuspendLayout();
            // 
            // rbMulti
            // 
            this.rbMulti.AutoSize = true;
            this.rbMulti.Location = new System.Drawing.Point(6, 72);
            this.rbMulti.Name = "rbMulti";
            this.rbMulti.Size = new System.Drawing.Size(82, 19);
            this.rbMulti.TabIndex = 0;
            this.rbMulti.Text = "Multiplicar";
            this.rbMulti.UseVisualStyleBackColor = true;
            // 
            // group
            // 
            this.group.Controls.Add(this.rbTodas);
            this.group.Controls.Add(this.rbDividir);
            this.group.Controls.Add(this.rbResta);
            this.group.Controls.Add(this.rbSuma);
            this.group.Controls.Add(this.rbMulti);
            this.group.Location = new System.Drawing.Point(37, 96);
            this.group.Name = "group";
            this.group.Size = new System.Drawing.Size(97, 159);
            this.group.TabIndex = 1;
            this.group.TabStop = false;
            this.group.Text = "Acciones";
            // 
            // rbTodas
            // 
            this.rbTodas.AutoSize = true;
            this.rbTodas.Location = new System.Drawing.Point(6, 122);
            this.rbTodas.Name = "rbTodas";
            this.rbTodas.Size = new System.Drawing.Size(56, 19);
            this.rbTodas.TabIndex = 5;
            this.rbTodas.Text = "Todas";
            this.rbTodas.UseVisualStyleBackColor = true;
            // 
            // rbDividir
            // 
            this.rbDividir.AutoSize = true;
            this.rbDividir.Location = new System.Drawing.Point(6, 97);
            this.rbDividir.Name = "rbDividir";
            this.rbDividir.Size = new System.Drawing.Size(59, 19);
            this.rbDividir.TabIndex = 4;
            this.rbDividir.Text = "Dividir";
            this.rbDividir.UseVisualStyleBackColor = true;
            // 
            // rbResta
            // 
            this.rbResta.AutoSize = true;
            this.rbResta.Location = new System.Drawing.Point(6, 47);
            this.rbResta.Name = "rbResta";
            this.rbResta.Size = new System.Drawing.Size(53, 19);
            this.rbResta.TabIndex = 3;
            this.rbResta.Text = "Resta";
            this.rbResta.UseVisualStyleBackColor = true;
            // 
            // rbSuma
            // 
            this.rbSuma.AutoSize = true;
            this.rbSuma.Checked = true;
            this.rbSuma.Location = new System.Drawing.Point(6, 22);
            this.rbSuma.Name = "rbSuma";
            this.rbSuma.Size = new System.Drawing.Size(59, 19);
            this.rbSuma.TabIndex = 2;
            this.rbSuma.TabStop = true;
            this.rbSuma.Text = "Sumar";
            this.rbSuma.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Segoe UI", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(143, 30);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(172, 32);
            this.label1.TabIndex = 2;
            this.label1.Text = "Tres Números";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label2.Location = new System.Drawing.Point(215, 77);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(149, 20);
            this.label2.TabIndex = 3;
            this.label2.Text = "Escribe 3 números: ";
            // 
            // a
            // 
            this.a.Location = new System.Drawing.Point(171, 100);
            this.a.Name = "a";
            this.a.Size = new System.Drawing.Size(69, 23);
            this.a.TabIndex = 4;
            // 
            // b
            // 
            this.b.Location = new System.Drawing.Point(246, 100);
            this.b.Name = "b";
            this.b.Size = new System.Drawing.Size(69, 23);
            this.b.TabIndex = 5;
            // 
            // c
            // 
            this.c.Location = new System.Drawing.Point(321, 100);
            this.c.Name = "c";
            this.c.Size = new System.Drawing.Size(69, 23);
            this.c.TabIndex = 6;
            // 
            // btAcepta
            // 
            this.btAcepta.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btAcepta.Location = new System.Drawing.Point(261, 279);
            this.btAcepta.Name = "btAcepta";
            this.btAcepta.Size = new System.Drawing.Size(75, 23);
            this.btAcepta.TabIndex = 7;
            this.btAcepta.Text = "Aceptar";
            this.btAcepta.UseVisualStyleBackColor = true;
            this.btAcepta.Click += new System.EventHandler(this.btAcepta_Click);
            // 
            // Borra
            // 
            this.Borra.Location = new System.Drawing.Point(342, 279);
            this.Borra.Name = "Borra";
            this.Borra.Size = new System.Drawing.Size(75, 23);
            this.Borra.TabIndex = 8;
            this.Borra.Text = "Borrar";
            this.Borra.UseVisualStyleBackColor = true;
            this.Borra.Click += new System.EventHandler(this.Borra_Click);
            // 
            // lbAnswer
            // 
            this.lbAnswer.AutoSize = true;
            this.lbAnswer.Location = new System.Drawing.Point(171, 147);
            this.lbAnswer.Name = "lbAnswer";
            this.lbAnswer.Size = new System.Drawing.Size(110, 15);
            this.lbAnswer.TabIndex = 9;
            this.lbAnswer.Text = "Los resultados son: ";
            // 
            // lbError
            // 
            this.lbError.AutoSize = true;
            this.lbError.ForeColor = System.Drawing.Color.Red;
            this.lbError.Location = new System.Drawing.Point(61, 261);
            this.lbError.Name = "lbError";
            this.lbError.Size = new System.Drawing.Size(352, 15);
            this.lbError.TabIndex = 10;
            this.lbError.Text = "Error.  Debes escribir tres números antes de efectuar operaciones. ";
            this.lbError.Visible = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.SandyBrown;
            this.ClientSize = new System.Drawing.Size(472, 328);
            this.Controls.Add(this.lbError);
            this.Controls.Add(this.lbAnswer);
            this.Controls.Add(this.Borra);
            this.Controls.Add(this.btAcepta);
            this.Controls.Add(this.c);
            this.Controls.Add(this.b);
            this.Controls.Add(this.a);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.group);
            this.Name = "Form1";
            this.Text = "Form1";
            this.group.ResumeLayout(false);
            this.group.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private RadioButton rbMulti;
        private GroupBox group;
        private RadioButton rbTodas;
        private RadioButton rbDividir;
        private RadioButton rbResta;
        private RadioButton rbSuma;
        private Label label1;
        private Label label2;
        private TextBox a;
        private TextBox b;
        private TextBox c;
        private Button btAcepta;
        private Button Borra;
        private Label lbAnswer;
        private Label lbError;
    }
}