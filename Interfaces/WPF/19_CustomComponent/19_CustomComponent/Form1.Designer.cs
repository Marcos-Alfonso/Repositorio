
namespace _19_CustomComponent
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.valueButton1 = new ButtonValue_19.ValueButton();
            this.reloj1 = new Reloj.Reloj();
            this.SuspendLayout();
            // 
            // valueButton1
            // 
            this.valueButton1.ButtonValue = 0;
            this.valueButton1.Location = new System.Drawing.Point(68, 68);
            this.valueButton1.Name = "valueButton1";
            this.valueButton1.Size = new System.Drawing.Size(400, 200);
            this.valueButton1.TabIndex = 0;
            this.valueButton1.Text = "valueButton1";
            this.valueButton1.UseVisualStyleBackColor = true;
            // 
            // reloj1
            // 
            this.reloj1.Location = new System.Drawing.Point(175, 121);
            this.reloj1.Name = "reloj1";
            this.reloj1.Size = new System.Drawing.Size(220, 94);
            this.reloj1.TabIndex = 1;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.reloj1);
            this.Controls.Add(this.valueButton1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private ButtonValue_19.ValueButton valueButton1;
        private Reloj.Reloj reloj1;
    }
}

