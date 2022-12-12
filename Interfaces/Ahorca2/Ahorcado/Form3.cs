﻿using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Text;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ahorcado
{
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
            PrivateFontCollection pfc = new PrivateFontCollection();
            pfc.AddFontFile("../../../Resources/" + "/Minecraft.ttf");
            tx.Font = new Font(pfc.Families[0], tx.Font.Size, tx.Font.Style);
            btBack.Font = new Font(pfc.Families[0], btBack.Font.Size, btBack.Font.Style);
        }

        private void Form3_Load(object sender, EventArgs e)
        {
            List<Persona> list = Form2.loadArray();
            foreach (Persona persona in list)
            {
                DataGridViewRow row = (DataGridViewRow)dataGridView1.Rows[0].Clone();
                row.Cells[0].Value = persona.nombre;
                row.Cells[1].Value = persona.puntos;
                row.Cells[2].Value = persona.gameTime.ToString().Substring(0, 8);
                dataGridView1.Rows.Add(row);
            }
        }
        
        String nombre;
        int puntos = 0;
        DateTime start;

        public void init(String nombre, int puntos)
        {
            this.nombre = nombre;
            this.puntos = puntos;
            tx.Text = $"Nombre: {nombre}, Puntos: {puntos}";


            MySqlConnection con = new MySqlConnection("server=127.0.0.1;uid=root;pwd=root;database=ahorcado");
            con.Open();
            String query = "SELECT tiempo, puntos FROM partida WHERE usuario = '"+nombre+"';";
            MySqlCommand mycomand = new MySqlCommand(query, con);

            MySqlDataReader myreader = mycomand.ExecuteReader();
            while (myreader.Read())
            {
                DataGridViewRow row = (DataGridViewRow)dataGridView1.Rows[0].Clone();
                row.Cells[1].Value = myreader.GetInt16("puntos");
                row.Cells[0].Value = myreader.GetTimeSpan("tiempo");
                dataGridView1.Rows.Add(row);
            }
            myreader.Close();
            con.Close();
        }

        private void button26_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
