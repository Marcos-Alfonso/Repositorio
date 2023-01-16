using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ahorcado
{
    public partial class adminPalabras : Form
    {
        public adminPalabras()
        {
            InitializeComponent();
            loadPalabras("%");
            loadCombo();
        }

        private void loadPalabras(string cat)
        {
            lbError.Visible = false;
            MySqlConnection con = new MySqlConnection("server=127.0.0.1;uid=root;pwd=root;database=ahorcado");
            con.Open();
            String query = $"SELECT * FROM palabra WHERE categoria LIKE '{cat}' ORDER BY categoria, palabra;";
            MySqlCommand mycomand = new MySqlCommand(query, con);

            MySqlDataReader myreader = mycomand.ExecuteReader();
            dataGridView1.Rows.Clear();
            while (myreader.Read())
            {
                int rowId = dataGridView1.Rows.Add();
                DataGridViewRow row = dataGridView1.Rows[rowId];
                row.Cells["palabra"].Value = myreader.GetString("palabra");
                row.Cells["categoria"].Value = myreader.GetString("categoria");
            }
            
            
            myreader.Close();
            con.Close();
        }

        private void loadCombo()
        {
            MySqlConnection con = new MySqlConnection("server=127.0.0.1;uid=root;pwd=root;database=ahorcado");
            con.Open();
            String query = "SELECT DISTINCT(categoria) FROM palabra";
            MySqlCommand mycomand = new MySqlCommand(query, con);

            MySqlDataReader myreader = mycomand.ExecuteReader();
            cbCategoria.Items.Clear();
            cbCategoria.Items.Add("");
            while (myreader.Read())
            {
                cbCategoria.Items.Add(myreader.GetString("categoria"));
            }
            cbCategoria.SelectedIndex = 0;
            myreader.Close();
            con.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try { 
            if (txPalabra.Text != "" && txCategoria.Text != "")
            {
                MySqlConnection con = new MySqlConnection("server=127.0.0.1;uid=root;pwd=root;database=ahorcado");
                con.Open();
                String query = "INSERT INTO palabra VALUES('"+txPalabra.Text.ToUpper()+ "','"+txCategoria.Text.ToUpper() + "');";
                MySqlCommand mycomand = new MySqlCommand(query, con);

                MySqlDataReader myreader = mycomand.ExecuteReader();

                while (myreader.Read())
                {
                    
                }

                myreader.Close();
                con.Close();
                txPalabra.Text = txCategoria.Text = "";
                loadPalabras("%");
                loadCombo();
                }
            }catch(Exception ex)
            {
                lbError.Text = "Palabra ya existente.";
                lbError.Visible = true;
            }
        }
        //modificar
        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                if (txPalabra.Text != "" && txCategoria.Text != "")
            {
                if (dataGridView1.SelectedRows.Count == 1)
                {
                    MySqlConnection con = new MySqlConnection("server=127.0.0.1;uid=root;pwd=root;database=ahorcado");
                    con.Open();
                    DataGridViewRow row = dataGridView1.SelectedRows[0];
                    String query = $"UPDATE palabra SET palabra = '{txPalabra.Text.ToUpper()}', categoria = '{txCategoria.Text.ToUpper()}' WHERE palabra = '{row.Cells[0].Value}' AND categoria = '{row.Cells[1].Value}';";
                    MySqlCommand mycomand = new MySqlCommand(query, con);

                    MySqlDataReader myreader = mycomand.ExecuteReader();

                    while (myreader.Read())
                    {}
                    myreader.Close();
                    con.Close();
                    txPalabra.Text = txCategoria.Text = "";
                    loadPalabras("%");
                        loadCombo();
                    }
                else
                {
                    lbError.Text = "Selecciona al una fila.";
                    lbError.Visible = true;
                }
            }
            else
            {
                lbError.Text = "Campos vacios.";
                lbError.Visible = true;
            }

        }catch(Exception ex)
            {
                lbError.Text = "Palabra ya existente.";
                lbError.Visible = true;
            }
}
        //eliminar
        private void button3_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count == 0)
            {
                lbError.Text = "Selecciona al menos una fila.";
                lbError.Visible= true;
                return;
            }
            DialogResult dialogResult = MessageBox.Show("Desea eliminar "+dataGridView1.SelectedRows.Count+" filas?", "Confirmar", MessageBoxButtons.YesNo);
            if (dialogResult == DialogResult.Yes)
            {
                foreach (DataGridViewRow row in dataGridView1.SelectedRows)
                {
                    elimina(row.Cells[0].Value.ToString(), row.Cells[1].Value.ToString());
                }
                loadPalabras("%");
                loadCombo();
            }
            
            
        }
        private void elimina(String palabra, String categoria)
        {
            MySqlConnection con = new MySqlConnection("server=127.0.0.1;uid=root;pwd=root;database=ahorcado");
            con.Open();
            String query = "DELETE FROM palabra WHERE palabra='"+palabra+"' AND categoria='"+categoria+"'";
            MySqlCommand mycomand = new MySqlCommand(query, con);

            MySqlDataReader myreader = mycomand.ExecuteReader();

            while (myreader.Read())
            {
            }

            myreader.Close();
            con.Close();
        }


        private void cambio(object sender, EventArgs e)
        {
            
        }

        private void select(object sender, EventArgs e)
        {
            try
            {
                if (dataGridView1.SelectedRows.Count != 0)
                {
                    DataGridViewRow row = dataGridView1.SelectedRows[0];
                    txPalabra.Text = row.Cells[0].Value.ToString();
                    txCategoria.Text = row.Cells[1].Value.ToString();
                }
            }catch(Exception ex)
            {

            }
            
        }

        private void cambiaCat(object sender, EventArgs e)
        {
            if (cbCategoria.Text.Equals(""))
            {
                loadPalabras("%");
                return;
            }
            loadPalabras(cbCategoria.Text);
        }
    }
}
