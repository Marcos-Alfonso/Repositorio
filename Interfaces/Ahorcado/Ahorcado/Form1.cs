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
            f.init();
            f.ShowDialog();
        }
    }
}