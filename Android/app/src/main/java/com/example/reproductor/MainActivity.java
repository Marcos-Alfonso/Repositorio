package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nuevoUsuario(View view){
        Intent myIntent = new Intent(this, nuevoUsuario.class);
        this.startActivity(myIntent);
    }
    public void lista(View view){
        Intent myIntent = new Intent(this, ListaCanciones.class);
        this.startActivity(myIntent);
    }

}