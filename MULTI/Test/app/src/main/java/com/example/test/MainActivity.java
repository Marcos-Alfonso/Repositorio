package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText e1;
    private EditText e2;
    private EditText e3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.nbMates);
        e2 = (EditText) findViewById(R.id.nbHistoria);
        e3 = (EditText) findViewById(R.id.nbLengua);
    }
    @Override
    protected void onStart(){
        super.onStart();
        //Toast.makeText(this, "Patata", Toast.LENGTH_LONG).show();
    }
    public void checkStatus(View view){

        double media = (Double.parseDouble(e1.getText().toString())+Double.parseDouble(e2.getText().toString())+Double.parseDouble(e3.getText().toString()));
        Toast.makeText(this, (media/3 >=5)?("Ha aprobado "):("Pa junio"), Toast.LENGTH_LONG).show();
    }
}