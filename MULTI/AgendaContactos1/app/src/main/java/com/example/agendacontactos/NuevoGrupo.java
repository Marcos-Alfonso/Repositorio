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
            Toast.makeText(this, "Grupo Creado", Toast.LENGTH_SHORT).show();
            System.exit(0);
        }
    }
    public void elimina(View view){
        GrupoSQL SQL = new GrupoSQL(this, "grupos", null, 1);
        SQLiteDatabase base = SQL.getWritableDatabase();
        String grupo = txtGrupo.getText().toString();

        if (grupo.isEmpty()){
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            int cantidad = base.delete("grupos", "nombre LIKE '" + grupo+"'", null);
            base.close();
            txtGrupo.setText("");
            deleteContacts(grupo);
            if (cantidad == 1) {
                Toast.makeText(this, "Grupo eliminado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Grupo no existe", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void deleteContacts(String grupo) {
        AdminSQL admin = new AdminSQL(this, "administracion", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

            int cantidad = base.delete("contactos", "grupo LIKE '" + grupo+"'", null);
            base.close();

    }
    public void volver(View view){
        System.exit(0);
    }
}