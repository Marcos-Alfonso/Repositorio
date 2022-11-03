package com.example.multi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton rbAlumno;
    EditText etNombre;
    EditText etEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbAlumno = (RadioButton)findViewById(R.id.rbAlumno);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etEdad = (EditText) findViewById(R.id.etEdad);
    }
    public void cambia(View view){
        Intent i = new Intent(this, second.class);
        i.putExtra("nombre", etNombre.getText().toString());
        i.putExtra("edad", Integer.parseInt(etEdad.getText().toString()));
        if(rbAlumno.isChecked()){
            i.putExtra("modo", true);
        }else{
            i.putExtra("modo", false);
        }

    }
}