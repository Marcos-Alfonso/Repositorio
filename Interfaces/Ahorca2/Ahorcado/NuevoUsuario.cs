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
    public partial class NuevoUsuario : Form
    {
        Form1 f;
        public NuevoUsuario(Form1 f)
        {
            InitializeComponent();
            this.f = f;
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void NuevoUsuario_Load(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (txNombre.Text =="" || txPass.Text == ""|| txPassConfirm.Text == "")
            {
                lbError.Text = "Rellena todos los campos";
                lbError.Visible = true;
                return;
            }
            if ( txPass.Text != txPassConfirm.Text)
            {
                lbError.Text = "Contraseñas no coinciden";
                lbError.Visible = true;
                return;
            }
            MySqlConnection con = new MySqlConnection("server=127.0.0.1;uid=root;pwd=root;database=ahorcado");
            con.Open();

            String query = "INSERT INTO partida VALUES('" + txNombre.Text + "', '" + txPass.Text + "', 'JG' );";
            MySqlCommand mycomand = new MySqlCommand(query, con);
            MySqlDataReader myreader = mycomand.ExecuteReader();
            myreader.Close();
            con.Close();
            this.Close();
        }
    }
}
