package com.example.agendacontactos;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import android.widget.Toast;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private EditText txt_nombre, txt_codigo, txt_apellido, txt_email, txt_telefono;
    private Spinner txt_grupo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_codigo = (EditText) findViewById(R.id.editTextNumber);
        txt_nombre = (EditText) findViewById(R.id.editTextTextPersonName2);
        txt_apellido = (EditText) findViewById(R.id.editTextTextPersonName3);
        txt_telefono = (EditText) findViewById(R.id.editTextTextPersonName4);
        txt_email = (EditText) findViewById(R.id.editTextTextPersonName5);
        txt_grupo = (Spinner) findViewById(R.id.spinner);

        String g []= grup().split(",");
        ArrayAdapter<String> a = new ArrayAdapter(this, android.R.layout.simple_spinner_item, g);
        txt_grupo.setAdapter(a);
    }



    public void registrar(View view) {
        AdminSQL admin = new AdminSQL(this, "administracion", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = txt_codigo.getText().toString();
        String nombre = txt_nombre.getText().toString();
        String apellidos = txt_apellido.getText().toString();
        String email = txt_email.getText().toString();
        String tel = txt_telefono.getText().toString();
        String grupo = txt_grupo.getSelectedItem().toString();

        if (nombre.isEmpty() || apellidos.isEmpty() || email.isEmpty() || tel.isEmpty()) {
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("Nombre", nombre);
            registro.put("Apellidos", apellidos);
            registro.put("telefono", tel);
            registro.put("email", email);
            registro.put("grupo", grupo);

            base.insert("contactos", null, registro);
            base.close();

            txt_nombre.setText("");
            txt_apellido.setText("");
            txt_codigo.setText("");
            txt_telefono.setText("");
            txt_email.setText("");
            txt_grupo.setSelection(0);

        }
    }

    public void creargrupo(View view) {
        Intent crear = new Intent(this, NuevoGrupo.class);
        startActivity(crear);
    }

    public void consultar(View view) {
        AdminSQL admin = new AdminSQL(this, "administracion", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = txt_codigo.getText().toString();

        if (codigo.isEmpty()) {
            Toast.makeText(this, "Rellena el codigo para buscar", Toast.LENGTH_SHORT).show();
        } else {
            Cursor fila = base.rawQuery("Select Nombre, Apellidos, telefono, email, grupo FROM contactos WHERE codigo='" + codigo + "';", null);
            if (fila.moveToFirst()) {
                txt_nombre.setText(fila.getString(0));
                txt_apellido.setText(fila.getString(1));
                txt_telefono.setText(fila.getString(2));
                txt_email.setText(fila.getString(3));
                txt_grupo.setSelection(((ArrayAdapter<String>)txt_grupo.getAdapter()).getPosition(fila.getString(4)));
                base.close();
            } else {
                Toast.makeText(this, "El contacto no existe", Toast.LENGTH_SHORT).show();
                base.close();
            }
        }
    }

    public void eliminar(View view) {
        AdminSQL admin = new AdminSQL(this, "administracion", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();
        String codigo = txt_codigo.getText().toString();

        if (codigo.isEmpty()) {
            Toast.makeText(this, "Introduce el codigo del contacto", Toast.LENGTH_SHORT).show();
        } else {
            int cantidad = base.delete("contactos", "codigo=" + codigo, null);
            base.close();
            txt_codigo.setText("");

            if (cantidad == 1) {
                Toast.makeText(this, "Contacto eliminado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El contacto no existe", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void modificar(View view) {
        AdminSQL admin = new AdminSQL(this, "administracion", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = txt_codigo.getText().toString();
        String nombre = txt_nombre.getText().toString();
        String apellidos = txt_apellido.getText().toString();
        String email = txt_email.getText().toString();
        String tel = txt_telefono.getText().toString();
        String grupo = txt_grupo.getSelectedItem().toString();
        if (nombre.isEmpty() || apellidos.isEmpty() || email.isEmpty() || tel.isEmpty()) {
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("Nombre", nombre);
            registro.put("Apellidos", apellidos);
            registro.put("telefono", tel);
            registro.put("email", email);
            registro.put("grupo", grupo);
            int cantidad = base.update("contactos", registro, "codigo=" + codigo, null);
            base.close();
            if (cantidad == 1) {
                Toast.makeText(this, "Contacto Modificado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El contacto no existe", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private String grup() {
        String g=" ,";
        GrupoSQL con = new GrupoSQL(this, "grupos", null, 1);
        SQLiteDatabase base = con.getWritableDatabase();
        Cursor c = base.rawQuery("select nombre from grupos", null);
        while (c.moveToNext()) {
            g += c.getString(0)+",";
        }
        base.close();
        return g;
    }

    public void avanzada(View view){
        try {
            boolean busq=false;
            ArrayList<contacto> lista= new ArrayList<>();
            AdminSQL admin = new AdminSQL(this, "administracion", null, 1);
            SQLiteDatabase base = admin.getWritableDatabase();
            String where= "WHERE";
            String nombre = txt_nombre.getText().toString();
            String apellidos = txt_apellido.getText().toString();
            String email = txt_email.getText().toString();
            String tel = txt_telefono.getText().toString();
            String grupo = txt_grupo.getSelectedItem().toString();
            if (!nombre.isEmpty()){
                where+=" Nombre LIKE '%"+nombre+"%'";
                busq=true;
            }
            if (!apellidos.isEmpty() && nombre.isEmpty()){
                where+=" Apellidos LIKE'%"+apellidos+"%'";
                busq=true;
            } else if (!apellidos.isEmpty()){
                where+="AND Apellidos LIKE '%"+apellidos+"%'";
            }
            if (!tel.isEmpty() && nombre.isEmpty() && apellidos.isEmpty()){
                where+=" telefono LIKE '%"+tel+"%'";
                busq=true;
            } else if (!tel.isEmpty()) {
                where+="AND telefono LIKE '%"+tel+"%'";
            }
            if (!email.isEmpty() && nombre.isEmpty() && apellidos.isEmpty() && tel.isEmpty()){
                where+=" email LIKE '%"+email+"%'";
                busq=true;
            } else if (!email.isEmpty()){
                where+="AND email LIKE '%"+email+"%'";
            }
            if (!grupo.equals(" ") && email.isEmpty() && nombre.isEmpty() && apellidos.isEmpty() && tel.isEmpty()){
                where+=" grupo LIKE '%"+grupo+"%'";
                busq=true;
            } else if (!grupo.equals(" ")){
                where+="AND grupo LIKE '%"+grupo+"%'";
            }

            if (busq){
                //Toast.makeText(this, where, Toast.LENGTH_SHORT).show();
                Cursor c = base.rawQuery("select codigo, Nombre, Apellidos, telefono, email, grupo FROM contactos "+ where, null);
                for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                    contacto cont = new contacto(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                    lista.add(cont);
                }
                base.close();
                Intent busqa = new Intent(this, BussquedaAvandaza.class);
                busqa.putExtra("list", lista);
                startActivity(busqa);
            } else {
                Toast.makeText(this, "Rellena algun campo para hacer una busqueda. No se busca por código", Toast.LENGTH_SHORT).show();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

}