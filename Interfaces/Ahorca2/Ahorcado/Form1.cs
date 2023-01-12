using System.Xml;
using MySql.Data.MySqlClient;
namespace Ahorcado
{
    public partial class Form1 : Form
    {
        MySqlConnection con;
        //get puntuaion total by usuario
        //SELECT usuario,SUM(puntos) FROM partida GROUP BY usuario;

        public Form1()
        {
            InitializeComponent();
            
               con = new MySqlConnection("server=127.0.0.1;uid=root;pwd=root;database=ahorcado");
               con.Open();
            this.Closed += (s, args) => con.Close();
        }
        //List<List<String>> list = new List<List<String>>();
        private void Form1_Load(object sender, EventArgs e)
        {
            
            //list.Clear();
            cbCategoria.Items.Clear();

            loadCombo();
            /*
            XmlDocument doc = new XmlDocument();
            doc.Load("../../../Resources/categorias.xml");
            
            foreach (XmlElement node in doc.DocumentElement.ChildNodes)
            {
                cbCategoria.Items.Add(node.Attributes["id"].InnerText);
                List<String> palabras = new List<String>();
                foreach(XmlNode n in node)
                {
                    palabras.Add(n.InnerText);
                }
                list.Add(palabras);
            }
            cbCategoria.SelectedIndex = 0;
            */
        }
        private void loadCombo()
        {
            String query = "SELECT DISTINCT(categoria) FROM palabra";
            MySqlCommand mycomand = new MySqlCommand(query, con);

            MySqlDataReader myreader = mycomand.ExecuteReader();
            while (myreader.Read())
            {
                cbCategoria.Items.Add(myreader.GetString("categoria"));
            }
            cbCategoria.SelectedIndex = 0;
            myreader.Close();
        }

    

        private void startGame(object sender, EventArgs e)
        {
            List<String> palabras = new List<string>();

            String query = "SELECT palabra FROM palabra WHERE categoria = '"+cbCategoria.Text+"';";
            MySqlCommand mycomand = new MySqlCommand(query, con);

            MySqlDataReader myreader = mycomand.ExecuteReader();
            while (myreader.Read())
            {
                palabras.Add(myreader.GetString("palabra"));
            }
            myreader.Close();

            Random rnd = new Random();
            String palabra = palabras[rnd.Next(palabras.Count)];
            
            Form2 f = new Form2();
            f.FormBorderStyle = FormBorderStyle.FixedSingle;
                
            f.init(txNombre.Text, cbCategoria.Text, palabra);
               
            //f.ShowDialog();
            this.Hide();
            f.Closed += (s, args) => this.Show();
                
            f.Show();
        }

        private void btLeaderBoard_Click(object sender, EventArgs e)
        {
            Form3 f = new Form3();
            f.FormBorderStyle = FormBorderStyle.FixedSingle;

            f.init(txNombre.Text,0);
            
            //f.ShowDialog();
            this.Hide();
            f.Closed += (s, args) => this.Show();
            //f.Closed += (s, args) => this.txNombre_TextChanged(sender, e);
            f.Show();
        }

        private void txNombre_TextChanged(object sender, EventArgs e)
        {
            cierraSesion();
            /*
            label1.Text = "Nuevo Usuario";
            List <Persona> personas = Form2.loadArray();
            foreach (Persona p in personas)
            {
                if (p.nombre.Equals(txNombre.Text))
                {
                    label1.Text=$"Usuario encontrado: \n" +
                        $"-Puntos: {p.puntos}\n" +
                        $"-Tiempo: {p.gameTime.ToString().Substring(0, 8)}";
                    
                }
            }
            */
            
        }

        private void iniciaSesion(object sender, EventArgs e)
        {
            if(button4.Text == "Inicia Sesión")
            {
                String query = "SELECT * FROM usuario WHERE nombre = '"+txNombre.Text+ "' AND pass = '"+textBox1.Text+"'";
                MySqlCommand mycomand = new MySqlCommand(query, con);

                MySqlDataReader myreader = mycomand.ExecuteReader();
                if (myreader.HasRows)
                {
                    txNombre.Enabled = false;
                    textBox1.Enabled = false;
                    button1.Visible = true;
                    button4.Text = "Cierra Sesión";
                    myreader.Read();
                    if (myreader.GetString("rol")=="AD")
                    {
                        label2.Visible = true;
                        button3.Visible = true;
                        button2.Visible = true;
                    }
                    cbCategoria.Visible = true;
                    label1.Text = "✓";
                    label1.ForeColor = Color.Green;
                    label1.Visible = true;
                    btLeaderBoard.Visible = true;
                    button5.Visible = false;
                }
                else
                {
                    label1.Text = "X   Datos incorrectos";
                    label1.ForeColor = Color.Red;
                    label1.Visible = true;
                }
                myreader.Close();
            }
            else
            {
                
                cierraSesion();
            }
        }
        private void cierraSesion()
        {
            txNombre.Enabled = true;
            textBox1.Enabled = true;
            button5.Visible = true;
            cbCategoria.Visible = false;
            button1.Visible = false;
            label2.Visible = false;
            button3.Visible = false;
            button2.Visible = false;
            button4.Text = "Inicia Sesión";
            label1.Visible = false;
            btLeaderBoard.Visible = false;
        }

        private void adminPalabras(object sender, EventArgs e)
        {
            adminPalabras f = new adminPalabras();
            f.FormBorderStyle = FormBorderStyle.FixedSingle;

            //f.ShowDialog();
            this.Hide();
            f.Closed += (s, args) => this.Show();
            //f.Closed += (s, args) => this.txNombre_TextChanged(sender, e);
            f.Show();
            loadCombo();
        }

        //nuevo usuario
        private void button5_Click(object sender, EventArgs e)
        {
            NuevoUsuario n = new NuevoUsuario(this);
          
            n.ShowDialog();
            
        }
        public void rellena(String n, String pass)
        {
            txNombre.Text = n;
            textBox1.Text = pass;
            iniciaSesion(null, null);
        }

        private void button2_Click(object sender, EventArgs e)
        {
             AdminUsers a = new AdminUsers();
            a.Show();
        }
    }
}