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
        public AdminUsers()
        {
            InitializeComponent();

            MySqlConnection con = new MySqlConnection("server=127.0.0.1;uid=root;pwd=root;database=ahorcado");
            con.Open();
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
            /*
            adapter = new MySqlDataAdapter("SELECT * FROM usuario", con);

            MySqlCommandBuilder cmb = new MySqlCommandBuilder(adapter);
            dt = new DataTable();// <- My DataTable
            adapter.Fill(dt);
            
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

        private void button4_Click(object sender, EventArgs e)
        {
            /*
            if (dtUsers.SelectedRows.Count == 0)
            {
                lbError.Text = "No hay filas seleccionadas";
                return;
            }
            */
            if (dtUsers.SelectedRows[0].Cells["rol"].Value == "AD")
            {
                dtUsers.SelectedRows[0].Cells["rol"].Value = "JG";
            }
            else
            {
                dtUsers.SelectedRows[0].Cells["rol"].Value = "AD";
            }
            
            //lbError.Text = "";
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
           
        }
        private void execQuery()
        {

        }
        private void tick(object sender, EventArgs e)
        {
            
        }
    }
}
