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
        public AdminUsers()
        {
            InitializeComponent();

            MySqlConnection con = new MySqlConnection("server=127.0.0.1;uid=root;pwd=root;database=ahorcado");
            con.Open();
            String query = "SELECT * FROM usuario";
            MySqlDataAdapter adapter = new MySqlDataAdapter(query, con);

            DataSet ds = new DataSet();
            adapter.Fill(ds);
            dtUsers.DataSource = ds.Tables[0];
            dtUsers.Columns["pass"].Visible = false;
            dtUsers.Columns["rol"].AutoSizeMode = DataGridViewAutoSizeColumnMode.AllCells;

        }

        private void button4_Click(object sender, EventArgs e)
        {
            if (dtUsers.SelectedRows.Count == 0)
            {
                lbError.Text = "No hay filas seleccionadas";
                return;
            }
            if (dtUsers.SelectedRows[0].Cells["rol"].Value == "AD")
            {
                dtUsers.SelectedRows[0].Cells["rol"].Value = "JG";
            }
            else
            {
                dtUsers.SelectedRows[0].Cells["rol"].Value = "AD";
            }
            lbError.Text = "";

        }

        private void button1_Click(object sender, EventArgs e)
        {

        }
    }
}
