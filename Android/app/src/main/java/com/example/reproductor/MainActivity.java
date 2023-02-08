package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.txNombre);
    }

    public void nuevoUsuario(View view){
        Intent myIntent = new Intent(this, nuevoUsuario.class);
        this.startActivity(myIntent);
    }
    public void lista(View view){
        Intent myIntent = new Intent(this, ListaCanciones.class);
        this.startActivity(myIntent);
    }
    public void iniciaSesion(View view){
        DB db = new DB(this);
        int i = db.userExist(nombre.getText().toString());
        if (i == -1){
            Toast toast1 = Toast.makeText(getApplicationContext(), "Usuario no existe", Toast.LENGTH_SHORT);
            toast1.show();
        }else{
            Toast toast1 = Toast.makeText(getApplicationContext(), "Usuario EXISTE", Toast.LENGTH_SHORT);
            toast1.show();
        }
    }

}