using MySql.Data.MySqlClient;
using System;
using System.Collections;
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
    public partial class AdminUsers : Form
    {
        DataSet ds;
        DataTable dt;
        MySqlDataAdapter adapter;

        MySqlConnection con;
        String nSEL;
        public AdminUsers(String n)
        {
            InitializeComponent();
            nSEL = n;
            con = new MySqlConnection("server=127.0.0.1;uid=root;pwd=root;database=ahorcado");
            con.Open();
            cargaTabla();
           /*
            adapter = new MySqlDataAdapter("SELECT * FROM usuario", con);

            MySqlCommandBuilder cmb = new MySqlCommandBuilder(adapter);
            dt = new DataTable();// <- My DataTable
            adapter.Fill(dt);
            MySqlCommandBuilder commandBuilder = new MySqlCommandBuilder(adapter);
            dtUsers.DataSource = dt;
            */
            /*
            String query = "SELECT * FROM usuario";
            adapter = new MySqlDataAdapter(query, con);
            

            ds = new DataSet();
            adapter.Fill(ds, "usuario");
            dtUsers.DataSource = ds.Tables[0];
            

            dtUsers.Columns["pass"].Visible = false;
            dtUsers.Columns["rol"].AutoSizeMode = DataGridViewAutoSizeColumnMode.AllCells;
            
            */

            this.Closed += (s, args) => con.Close();
        }
        private void cargaTabla()
        {
            String query = $"SELECT * FROM usuario";
            MySqlCommand mycomand = new MySqlCommand(query, con);

            MySqlDataReader myreader = mycomand.ExecuteReader();
            dtUsers.Rows.Clear();
            while (myreader.Read())
            {
                int rowId = dtUsers.Rows.Add();
                DataGridViewRow row = dtUsers.Rows[rowId];
                row.Cells["nombre"].Value = myreader.GetString("nombre");
                row.Cells["pass"].Value = myreader.GetString("pass");
                row.Cells["rol"].Value = myreader.GetString("rol");
            }
            dtUsers.Columns["rol"].AutoSizeMode = DataGridViewAutoSizeColumnMode.AllCells;
            myreader.Close();
        }
        private void button4_Click(object sender, EventArgs e)
        {
            
            if (dtUsers.SelectedRows.Count == 0)
            {
                lbError.Text = "No hay filas seleccionadas";
                return;
            }
            
            if (dtUsers.SelectedRows[0].Cells["nombre"].Value.ToString() == "root")
            {
                lbError.Text = "No puedes alterar\nel usuario root";
                return;
            }
            if (dtUsers.SelectedRows[0].Cells["nombre"].Value.ToString() == nSEL)
            {
                lbError.Text = "No puedes alterar\ntu usuario";
                return;
            }

            if (dtUsers.SelectedRows[0].Cells["rol"].Value.ToString() ==  "AD")
            {

                dtUsers.SelectedRows[0].Cells["rol"].Value = "JG";
            }
            else
            {
                dtUsers.SelectedRows[0].Cells["rol"].Value = "AD";
                
            }
            
            
            String query = $"update usuario set rol = '{dtUsers.SelectedRows[0].Cells["rol"].Value}' where nombre like '{dtUsers.SelectedRows[0].Cells["nombre"].Value}'";
            MySqlCommand mycomand = new MySqlCommand(query, con);
            mycomand.ExecuteNonQuery();
            

        }
        //añadir
        private void button1_Click(object sender, EventArgs e)
        {

            if (textBox1.Text == "" || textBox2.Text == "")
            {
                lbError.Text = "Rellena ambos campos";
                return;
            }
            try
            {
                String query = $"insert into usuario values('{textBox1.Text}','{textBox2.Text}','JG')";
                MySqlCommand mycomand = new MySqlCommand(query, con);
                mycomand.ExecuteNonQuery();
                textBox1.Text = textBox2.Text = "";
                lbError.Text = "";
                cargaTabla();
            }
            catch (MySqlException)
            {
                lbError.Text = "Error. Duplicados";
            }
            
           
        }
        //elimina
        private void button3_Click(object sender, EventArgs e)
        {
            if (dtUsers.SelectedRows.Count == 0)
            {
                lbError.Text = "No hay filas seleccionadas";
                return;
            }
            if (dtUsers.SelectedRows[0].Cells["nombre"].Value.ToString() == nSEL)
            {
                lbError.Text = "No puedes eliminar\ntu usuario";
                return;
            }
            if (dtUsers.SelectedRows[0].Cells["nombre"].Value.ToString() == "root")
            {
                lbError.Text = "No puedes eliminar\nel usuario root";
                return;
            }
            DialogResult dialogResult = MessageBox.Show($"Desea eliminar a {dtUsers.SelectedRows[0].Cells["nombre"].Value}?", "Confirmar", MessageBoxButtons.YesNo);
            if (dialogResult == DialogResult.Yes)
            {
                String query = $"DELETE FROM usuario Where nombre like '{dtUsers.SelectedRows[0].Cells["nombre"].Value.ToString()}'";
                MySqlCommand mycomand = new MySqlCommand(query, con);
                mycomand.ExecuteNonQuery();
                cargaTabla();
            }
            


           
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (dtUsers.SelectedRows.Count == 0)
            {
                lbError.Text = "No hay filas seleccionadas";
                return;
            }
            if (dtUsers.SelectedRows[0].Cells["nombre"].Value.ToString() == nSEL)
            {
                lbError.Text = "No puedes modificar\ntu usuario";
                return;
            }
            if (dtUsers.SelectedRows[0].Cells["nombre"].Value.ToString() == "root")
            {
                lbError.Text = "No puedes modificar\nel usuario root";
                return;
            }
            if (textBox1.Text == "" || textBox2.Text == "")
            {
                lbError.Text = "Rellena ambos campos";
                return;
            }
            
            try
            {
                String query = $"update usuario set nombre = '{textBox1.Text}', pass = '{textBox2.Text}' where nombre like '{dtUsers.SelectedRows[0].Cells["nombre"].Value}'";
                MySqlCommand mycomand = new MySqlCommand(query, con);
                mycomand.ExecuteNonQuery();
                lbError.Text = "";
                cargaTabla();
            }
            catch (MySqlException)
            {
                lbError.Text = "Error. Duplicados";
            }
           
        }

        private void changed(object sender, EventArgs e)
        {
            if (dtUsers.SelectedRows.Count == 0)
            {
                return;
            }
            try
            {
                textBox1.Text = dtUsers.SelectedRows[0].Cells["nombre"].Value.ToString();
                textBox2.Text = dtUsers.SelectedRows[0].Cells["pass"].Value.ToString();
            }
            catch(Exception ex)
            {

            }
            cargaPartidas();
        }

        private void cargaPartidas()
        {
            
            try
            {
                String nombre = dtUsers.SelectedRows[0].Cells["nombre"].Value.ToString();

                String query = $"SELECT * FROM partida where usuario = '{nombre}'";
                MySqlCommand mycomand = new MySqlCommand(query, con);

                MySqlDataReader myreader = mycomand.ExecuteReader();
                dataGridView1.Rows.Clear();
                while (myreader.Read())
                {
                    int rowId = dataGridView1.Rows.Add();
                    DataGridViewRow row = dataGridView1.Rows[rowId];
                    row.Cells["nombreUsuario"].Value = myreader.GetString("usuario");
                    row.Cells["tiempo"].Value = myreader.GetString("tiempo");
                    row.Cells["puntos"].Value = myreader.GetString("puntos");
                }

                myreader.Close();
            }
            catch(Exception ex)
            {

            }
            
        }

        private void EliminaPartida_Click(object sender, EventArgs e)
        {
            try
            {
                if (dataGridView1.SelectedRows.Count == 0)
                {
                    return;
                }
                String query = $"DELETE FROM partida Where tiempo = '{dataGridView1.SelectedRows[0].Cells["tiempo"].Value}' and puntos = {dataGridView1.SelectedRows[0].Cells["puntos"].Value}";
                MySqlCommand mycomand = new MySqlCommand(query, con);
                mycomand.ExecuteNonQuery();
                cargaPartidas();
            }
            catch(Exception ex)
            {

            }
            
        }
    }
}
