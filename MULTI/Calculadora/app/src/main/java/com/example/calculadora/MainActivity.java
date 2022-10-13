package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
            txOutput.setText(String.valueOf(n1));
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


}