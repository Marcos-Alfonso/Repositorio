namespace Ahorcado
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
           
        }

        private void startGame(object sender, EventArgs e)
        {
            
            Form2 f = new Form2();
            
                try
                {
                    f.init(txNombre.Text, cbCategoria.SelectedItem.ToString(), "palabra");
                }catch(NullReferenceException ex)
                {
                    f.init(txNombre.Text, "categoría", "palabra");
                }
            //f.ShowDialog();
            this.Hide();
            f.Closed += (s, args) => this.Show();
            f.Show();
        }
        
    }
}