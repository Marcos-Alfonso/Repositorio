package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt0;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt8;
    Button bt9;

    Button btSuma;
    Button btResta;
    Button btDiv;
    Button btMulti;
    Button btComa;
    Button btResto;
    Button btMasMenos;

    Button btAnd;
    Button btOr;
    Button btXor;
    Button btNot;

    TextView txOutput;
    TextView txControl;

    Switch swBinary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt0= findViewById(R.id.bt0);
        bt1= findViewById(R.id.bt1);
        bt2= findViewById(R.id.bt2);
        bt3= findViewById(R.id.bt3);
        bt4= findViewById(R.id.bt4);
        bt5= findViewById(R.id.bt5);
        bt6= findViewById(R.id.bt6);
        bt7= findViewById(R.id.bt7);
        bt8= findViewById(R.id.bt8);
        bt9= findViewById(R.id.bt9);

        btComa= findViewById(R.id.btComa);
        txOutput= findViewById(R.id.txOutput);
        txControl= findViewById(R.id.txControl);

        btSuma= findViewById(R.id.btSuma);
        btResta= findViewById(R.id.btMenos);
        btDiv= findViewById(R.id.btDiv);
        btMulti= findViewById(R.id.btMulti);
        btResto= findViewById(R.id.btResto);
        btMasMenos= findViewById(R.id.btMasMenos);

        btAnd= findViewById(R.id.btAnd);
        btAnd.getBackground().setAlpha(100);
        btOr= findViewById(R.id.btOr);
        btOr.getBackground().setAlpha(100);
        btXor= findViewById(R.id.btXor);
        btXor.getBackground().setAlpha(100);
        btNot= findViewById(R.id.btNot);
        btNot.getBackground().setAlpha(100);

        swBinary=findViewById(R.id.swBinary);
    }
    public void numberCLick(View view){
        Button b = (Button)view;
        if(b.getText().equals(".") && txOutput.getText().toString().contains("."))return;
        if(txOutput.getText().toString().equals("0")){
            txOutput.setText("");
            if(b.getText().equals("."))  txOutput.setText("0");
        }
        txOutput.setText(txOutput.getText().toString()+b.getText().toString());
    }
    public void backCLick(View view){
        if(!txOutput.getText().toString().equals("0")){
            String s = txOutput.getText().toString();
            txOutput.setText(s.substring(0,s.length()-1));
            if(txOutput.getText().toString().equals("")){
                txOutput.setText("0");
            }
        }else if(!operation.equals("")){
            operation = "";
            if(n1%1 !=0)
                txOutput.setText(String.valueOf(n1));
            else
                txOutput.setText(String.valueOf((int)n1));
            n1 = 0;
            txControl.setText("");
        }
    }
    public void acCLick(View view){
        txOutput.setText("0");
        operation = "";
        n1= 0;
        txControl.setText("");
    }
    String operation = "";
    double n1 = 0;
    public void operationCLick(View view){
        Button b = (Button)view;
        if(operation != "")
            igualCLick(view);
        operation = b.getText().toString();

        String s = "";
        if(swBinary.isChecked()){
            n1 = Integer.parseInt(txOutput.getText().toString(), 2);
            s= txOutput.getText().toString();
        }else{
            n1 = Double.parseDouble(txOutput.getText().toString());
            s=String.valueOf(n1);
        }

        txControl.setText(s+"\n"+operation);
        txOutput.setText("0");
    }
    public void masmenosCLick(View view){
        String s = txOutput.getText().toString();
        if(s.charAt(0) == '-')
            txOutput.setText(s.substring(1));
        else
            txOutput.setText("-"+s);

    }
    public void changeSwitch(View view){
        Switch s = (Switch) view;
        txControl.setText("");
        operation="";
        n1 = 0;
        if(txOutput.getText().toString().contains(".")) txOutput.setText("0");
        if(s.isChecked()){
            int i = Integer.parseInt(txOutput.getText().toString());
            txOutput.setText(Integer.toString(i, 2));
        }else{
            int i = Integer.parseInt(txOutput.getText().toString(), 2);
            txOutput.setText(String.valueOf(i));
        }
        sw();
    }
    public void not(View view){
        String s = txOutput.getText().toString();
        String resu = "";
        for (char c:s.toCharArray()) {
            if(c =='0'){
                resu = resu+"1";
            }else{
                resu = resu+"0";
            }
        }
        txOutput.setText(resu);
    }
    private void sw(){
        Button[] btArray = new Button[]{
                bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btComa, btResto, btMasMenos, btAnd, btNot, btXor, btOr
        };
        for (Button bt:btArray) {
            bt.setEnabled(!bt.isEnabled());
            bt.getBackground().setAlpha(255-((swBinary.isChecked())?(155):(0)));

        }
        for (int i = 11; i < 15; i++) {
            btArray[i].getBackground().setAlpha(255-((swBinary.isChecked())?(0):(155)));
        }
        /*
        bt2.setEnabled(!bt2.isEnabled());
        bt3.setEnabled(!bt3.isEnabled());
        bt4.setEnabled(!bt4.isEnabled());
        bt5.setEnabled(!bt5.isEnabled());
        bt6.setEnabled(!bt6.isEnabled());
        bt7.setEnabled(!bt7.isEnabled());
        bt8.setEnabled(!bt8.isEnabled());
        bt9.setEnabled(!bt9.isEnabled());
        btComa.setEnabled(!btComa.isEnabled());
        btResto.setEnabled(!btResto.isEnabled());
        */

    }
    public void igualCLick(View view){
        double n2=0;

        if(operation.equals("AND") || operation.equals("OR")||operation.equals("XOR")){
            operaBinaria();

        }else{
            if(swBinary.isChecked()){
                n2 = Integer.parseInt(txOutput.getText().toString(), 2);
            }else{
                n2 = Double.parseDouble(txOutput.getText().toString());
            }


            String s = "";
            double resu = 0;
            switch(operation){
                case"+":
                    resu = n1+n2;
                    break;
                case"-":
                    resu = n1-n2;
                    break;
                case"x":
                    resu = n1*n2;
                    break;
                case"/":
                    resu = n1/n2;
                    if(n2 == 0){
                        Toast.makeText(this, "Operacion no valida", Toast.LENGTH_LONG).show();
                    }
                        resu=0;
                    break;
                case"%":
                    resu = n1%n2;
                    break;
                case"":
                    resu = n2;
                    break;
            }
            if(swBinary.isChecked()){
                txOutput.setText(Integer.toString((int)resu, 2));
            }else{
                if(resu%1 !=0)
                    txOutput.setText(String.valueOf(resu));
                else
                    txOutput.setText(String.valueOf((int)resu));
            }

        }


        txControl.setText("");
        operation = "";
        n1=0;
    }

    private void operaBinaria() {
        String s1 = txOutput.getText().toString();
        String s2 = Integer.toString((int)this.n1, 2);
        /*
        int diff = s1.length()-s2.length();

        if(diff>0){
            for (int i = 0; i < Math.abs(diff); i++) {
                s2 = "0"+s2;
            }
        }else if(diff<0){
            for (int i = 0; i < Math.abs(diff); i++) {
                s1 = "0"+s1;
            }
        }
        */
        int n2 = Integer.parseInt(s2,2);
        int n1 = Integer.parseInt(s1,2);

        int resu = 0;
        switch(operation){
            case"AND":
                resu = n1 & n2;
                break;
            case"OR":
                resu = n1 | n2;
                break;
            case"XOR":
                resu = n1 ^ n2;
                break;
            default :
                resu = n2;
                break;
        }
        txOutput.setText(Integer.toBinaryString(resu));
    }


}