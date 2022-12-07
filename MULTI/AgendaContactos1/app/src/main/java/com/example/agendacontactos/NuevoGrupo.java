package com.example.agendacontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoGrupo extends AppCompatActivity {

    EditText txtGrupo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_grupo);

        txtGrupo=(EditText) findViewById(R.id.editTextTextPersonName);
    }

    public void registrar(View view){
        GrupoSQL SQL = new GrupoSQL(this, "grupos", null, 1);
        SQLiteDatabase base = SQL.getWritableDatabase();
        String grupo = txtGrupo.getText().toString();

        if (grupo.isEmpty()){
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            ContentValues registro = new ContentValues();
            registro.put("nombre", grupo);

            base.insert("grupos", null, registro);
            base.close();
            txtGrupo.setText("");
        }
    }

    public void volver(View view){
        System.exit(0);
    }
}