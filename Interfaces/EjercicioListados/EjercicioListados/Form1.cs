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

namespace EjercicioListados
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            cargaComboVendedores();
            cargaComboTipo();
        }

        private void cargaComboTipo()
        {
            string connectionString = "server=localhost;user=root;password=root;database=inmobiliaria;";

            string query = "SELECT DISTINCT(Tipo) FROM inmuebles;";

            MySqlConnection connection = new MySqlConnection(connectionString);

            MySqlCommand command = new MySqlCommand(query, connection);

            connection.Open();

            MySqlDataReader reader = command.ExecuteReader();

            while (reader.Read())
            {
                if (reader.GetString(0) != "")
                    comboBox2.Items.Add(reader.GetString(0));

            }

            connection.Close();
            if (comboBox2.Items.Count != 0)
            {
                comboBox2.SelectedIndex = 0;
            }
        }

        private void cargaComboVendedores()
        {
            string connectionString = "server=localhost;user=root;password=root;database=inmobiliaria;";

            string query = "SELECT DISTINCT(Vendedor) FROM inmuebles;";

            MySqlConnection connection = new MySqlConnection(connectionString);

            MySqlCommand command = new MySqlCommand(query, connection);

            connection.Open();

            MySqlDataReader reader = command.ExecuteReader();

            while (reader.Read())
            {
                if(reader.GetString(0)!= "")
                comboBox1.Items.Add(reader.GetString(0));
                
            }

            connection.Close();
            if(comboBox1.Items.Count != 0)
            {
                comboBox1.SelectedIndex = 0;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form2 f = new Form2();
            f.Show();
        }
    }
}
