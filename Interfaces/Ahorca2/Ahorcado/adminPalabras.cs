using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
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
            loadPalabras();
        }

        private void loadPalabras()
        {
            lbError.Visible = false;
            dataGridView1.Rows.Clear();
            MySqlConnection con = new MySqlConnection("server=127.0.0.1;uid=root;pwd=root;database=ahorcado");
            con.Open();
            String query = "SELECT * FROM palabra ORDER BY categoria, palabra;";
            MySqlCommand mycomand = new MySqlCommand(query, con);

            MySqlDataReader myreader = mycomand.ExecuteReader();
            
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

        private void button1_Click(object sender, EventArgs e)
        {
            if (txPalabra.Text != "" && txCategoria.Text != "")
            {
                MySqlConnection con = new MySqlConnection("server=127.0.0.1;uid=root;pwd=root;database=ahorcado");
                con.Open();
                String query = "INSERT INTO palabra VALUES('"+txPalabra.Text+ "','"+txCategoria.Text+"');";
                MySqlCommand mycomand = new MySqlCommand(query, con);

                MySqlDataReader myreader = mycomand.ExecuteReader();

                while (myreader.Read())
                {
                    
                }

                myreader.Close();
                con.Close();
                txPalabra.Text = txCategoria.Text = "";
                loadPalabras();
            }
        }
        //modificar
        private void button2_Click(object sender, EventArgs e)
        {

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
                loadPalabras();
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
        private void select(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void cambio(object sender, EventArgs e)
        {
            
        }
    }
}
