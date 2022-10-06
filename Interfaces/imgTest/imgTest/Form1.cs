namespace imgTest
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (openFileDialog1.ShowDialog(this) == DialogResult.OK)
            {
                String filePath = openFileDialog1.FileName;
                /*
                comboBox1.DisplayMember = "Text";
                comboBox1.ValueMember = "Value";
                comboBox1.Items.Add(new {Text=comboBox1.Items.Count, Value= filePath });*/
                //comboBox1.Items.Add(new Item(comboBox1.Items.Count, filePath));
            }
        }

        private void changeds(object sender, EventArgs e)
        {
            label1.Text = comboBox1.SelectedItem.ToString();
            //String s = comboBox1.SelectedValue.ToString();
            //pictureBox1.Image= Image.FromFile(comboBox1.SelectedItem.ToString());
        }
    }
    public class Item
    {
        public string Text { get; set; }
        public string Value { get; set; }
    }

}