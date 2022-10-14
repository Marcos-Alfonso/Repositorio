package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

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

        txOutput= findViewById(R.id.txOutput);
        txControl= findViewById(R.id.txControl);

        btSuma= findViewById(R.id.btSuma);
        btResta= findViewById(R.id.btMenos);
        btDiv= findViewById(R.id.btDiv);
        btMulti= findViewById(R.id.btMulti);

        swBinary=findViewById(R.id.swBinary);
    }
    public void numberCLick(View view){
        Button b = (Button)view;
        if(Double.parseDouble(txOutput.getText().toString())==0){
            txOutput.setText("");
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
        operation = b.getText().toString();
        n1 = Double.parseDouble(txOutput.getText().toString());
        txControl.setText(String.valueOf(n1)+"\n"+operation);
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
        if(s.isChecked()){
            int i = Integer.parseInt(txOutput.getText().toString());
            txOutput.setText(Integer.toString(i, 2));
        }else{
            int i = Integer.parseInt(txOutput.getText().toString(), 2);
            txOutput.setText(String.valueOf(i));
        }
    }
    public void igualCLick(View view){
        double n2 = Double.parseDouble(txOutput.getText().toString());
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
                break;
            case"%":
                resu = n1%n2;
                break;
            case"":
                resu = n2;
                break;
        }

        if(resu%1 !=0)
            txOutput.setText(String.valueOf(resu));
        else
            txOutput.setText(String.valueOf((int)resu));

        txControl.setText("");
        operation = "";
        n1=0;
    }



}