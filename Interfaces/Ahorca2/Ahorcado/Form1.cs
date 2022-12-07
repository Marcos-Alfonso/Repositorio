using System.Xml;
using MySql.Data.MySqlClient;
namespace Ahorcado
{
    public partial class Form1 : Form
    {
        MySqlConnection con;


        public Form1()
        {
            InitializeComponent();
            
               con = new MySqlConnection("server=127.0.0.1;uid=root;pwd=root;database=ahorcado");
            con.Open();
            label1.Text = con.ConnectionString.ToString();
        }
        List<List<String>> list = new List<List<String>>();
        private void Form1_Load(object sender, EventArgs e)
        {
            
            list.Clear();
            cbCategoria.Items.Clear();
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
        }

        private void startGame(object sender, EventArgs e)
        {
            if(txNombre.Text == "")
            {
                MessageBox.Show("Inserte nombre primero", "Error");
                return;
            }
            List<String> l = list[cbCategoria.SelectedIndex];
            Random rnd = new Random();
            String palabra = l[rnd.Next(l.Count)];

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
         
            //f.ShowDialog();
            this.Hide();
            f.Closed += (s, args) => this.Show();
            f.Closed += (s, args) => this.txNombre_TextChanged(sender, e);
            f.Show();
        }

        private void txNombre_TextChanged(object sender, EventArgs e)
        {
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
        }
    }
}