using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Data;
using System.Data.SqlTypes;
using System.Drawing;
using System.Linq;
using System.Reflection.Emit;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml;
using System.Text.Json;
using static System.Windows.Forms.LinkLabel;
using System.Xml.Serialization;
using Newtonsoft.Json;
using System.IO;

namespace Ahorcado
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }
        List<PictureBox> lista = new List<PictureBox>();
        private void Form2_Load(object sender, EventArgs e)
        {
            lista.AddRange(new Collection<PictureBox> {sq6, sq5, sq4,sq3,sq2,sq1 });
            start = System.DateTime.Now;
            foreach (PictureBox p in lista)
            {
                p.Visible = true;
            }/*
            sq1.Visible = false;
            sq2.Visible = false;
            sq3.Visible = false;
            sq4.Visible = false;
            sq5.Visible = false;
            sq6.Visible = false;
            */
        }

        String palabra;
        String categoria;
        String nombre;
        int puntos = 0;
        DateTime start;

        public void init(String nombre, String categoria, String palabra) {
            txUserName.Text = "Usuario: " + nombre; 
            this.nombre = nombre;

            txCategoria.Text = "Categoría: "+categoria;
            this.categoria = categoria;

            txPalabra.Text = getCodified(palabra) ;
            this.palabra = palabra;

            txPuntos.Text = "Puntos: "+puntos;
        }

        private string getCodified(string p)
        {
            String s = "";
            foreach (char c in p)
            {
                s += "_ ";
            }
            return s; 

        }
        int nErrores = 0;
        private void buttonClick(object sender, EventArgs e)
        {
            
            Button b = (Button)sender;
            if (palabra.ToLower().Contains(b.Text))
            {
                puntos+=2;
                char c = b.Text.ToCharArray()[0];
                recodify(c);
                b.BackColor = Color.Green;
            }
            else{
                puntos --;
                b.BackColor = Color.Red;
                txErrorChars.Text += b.Text + "/";
                txErrorCount.Text = "Número de errores: "+(++nErrores)+"/6";
                foreach (PictureBox p in lista)
                {
                    if (p.Visible)
                    {
                        p.Visible = false;
                        break;
                    }
                }
                if (nErrores >= 6)
                {
                    launchEnding();
                    
                }
            }
            b.Enabled = false;
            
           
        }

        private void launchEnding()
        {
            Persona p = new Persona();
            p.nombre = nombre;
            p.puntos = puntos;
            p.gameTime = System.DateTime.Now - start;
           
            List<Persona> parts = loadArray();

            bool tiene = false;
            foreach (Persona part in parts)
            {
                if(part.nombre == p.nombre)
                {
                    part.puntos += p.puntos;
                    part.gameTime += System.DateTime.Now - start;
                    tiene = true;
                }
            }
            if(!tiene)parts.Add(p);
            System.Xml.Serialization.XmlSerializer writer =
            new System.Xml.Serialization.XmlSerializer(typeof(List<Persona>));

            var path = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments) + "//leaderBoards.xml";
            
            System.IO.FileStream file = System.IO.File.Create(path);
            writer.Serialize(file, parts);
            file.Close();

            
            Form3 f = new Form3();
            f.FormBorderStyle = FormBorderStyle.FixedSingle;

            f.init(nombre, puntos);

            //f.ShowDialog();
            f.Show();
            
        }

        public static  List<Persona> loadArray()
        {
            try
            {
                var path = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments) + "//leaderBoards.xml";
                var serializer = new XmlSerializer(typeof(List<Persona>));
                using (var reader = XmlReader.Create(path))
                {
                    var lista = (List<Persona>)serializer.Deserialize(reader);
                    reader.Close();
                    return lista;
                }
                
            }catch(Exception ex)
            {
                
                return new List<Persona>();
            }
            
        }

        private void recodify(char c)
        {
            for(int i = 0; i<palabra.Length; i++)
            {
                if(palabra.ToCharArray()[i] == c)
                {
                    StringBuilder sb = new StringBuilder(txPalabra.Text);
                    sb[i * 2] = c;
                    txPalabra.Text = sb.ToString();
                }
            }
        }

        private void tick(object sender, EventArgs e)
        {
            String s = (System.DateTime.Now - start).ToString();
            txPlaytime.Text = s.Substring(0,8);
            txPuntos.Text = "Puntos: " + (puntos);
            //label1.Text = System.DateTime.Now.ToString().Substring(10);
        }
    }

    [Serializable]
    [XmlRoot("Persona")]
    public partial class Persona
    {
        public string nombre { get; set; }
        public int puntos { get; set; }

        public TimeSpan gameTime { get; set; }
    }
}
