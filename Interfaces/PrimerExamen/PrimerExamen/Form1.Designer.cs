﻿
namespace PrimerExamen
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
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.gestiónAlumnosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuBuscador = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.BackColor = System.Drawing.SystemColors.ActiveBorder;
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.gestiónAlumnosToolStripMenuItem,
            this.menuBuscador});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(346, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // gestiónAlumnosToolStripMenuItem
            // 
            this.gestiónAlumnosToolStripMenuItem.BackColor = System.Drawing.SystemColors.ControlDark;
            this.gestiónAlumnosToolStripMenuItem.Name = "gestiónAlumnosToolStripMenuItem";
            this.gestiónAlumnosToolStripMenuItem.Size = new System.Drawing.Size(110, 20);
            this.gestiónAlumnosToolStripMenuItem.Text = "Gestión Alumnos";
            this.gestiónAlumnosToolStripMenuItem.Click += new System.EventHandler(this.gestiónAlumnosToolStripMenuItem_Click);
            // 
            // menuBuscador
            // 
            this.menuBuscador.BackColor = System.Drawing.SystemColors.ControlDark;
            this.menuBuscador.Name = "menuBuscador";
            this.menuBuscador.Size = new System.Drawing.Size(68, 20);
            this.menuBuscador.Text = "Buscador";
            this.menuBuscador.Click += new System.EventHandler(this.menuBuscador_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(346, 157);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form1";
            this.Text = "Menu Principal";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem gestiónAlumnosToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem menuBuscador;
    }
}

