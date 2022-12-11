package com.example.agendacontactos;

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

import android.widget.Switch;
import android.widget.Toast;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private EditText txnombre,
            txcodigo,
            txapellido,
            txemail,
            txtelefono;
    private Spinner txgrupo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txcodigo = (EditText) findViewById(R.id.editTextNumber);
        txnombre = (EditText) findViewById(R.id.editTextTextPersonName2);
        txapellido = (EditText) findViewById(R.id.editTextTextPersonName3);
        txtelefono = (EditText) findViewById(R.id.editTextTextPersonName4);
        txemail = (EditText) findViewById(R.id.editTextTextPersonName5);
        txgrupo = (Spinner) findViewById(R.id.spinner);

        String g []= grup().split(",");
        ArrayAdapter<String> a = new ArrayAdapter(this, android.R.layout.simple_spinner_item, g);
        txgrupo.setAdapter(a);
    }



    public void registrar(View view) {
        AdminSQL admin = new AdminSQL(this, "administracion", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = txcodigo.getText().toString();
        String nombre = txnombre.getText().toString();
        String apellidos = txapellido.getText().toString();
        String email = txemail.getText().toString();
        String tel = txtelefono.getText().toString();
        String grupo = txgrupo.getSelectedItem().toString();

        Cursor fila = base.rawQuery("Select Nombre, Apellidos, telefono, email, grupo FROM contactos WHERE codigo='" + codigo + "';", null);
        if (fila.moveToFirst()) {
            Toast.makeText(this, "El contacto ya existe", Toast.LENGTH_SHORT).show();
            base.close();
            return;
        }
        if (nombre.isEmpty() || apellidos.isEmpty() || email.isEmpty() || tel.isEmpty()) {
            Toast.makeText(this, "Algun campo vacío", Toast.LENGTH_SHORT).show();
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

            txnombre.setText("");
            txapellido.setText("");
            txcodigo.setText("");
            txtelefono.setText("");
            txemail.setText("");
            txgrupo.setSelection(0);
        }
    }

    public void creargrupo(View view) {
        Intent crear = new Intent(this, NuevoGrupo.class);
        startActivity(crear);


        String g []= grup().split(",");
        ArrayAdapter<String> a = new ArrayAdapter(this, android.R.layout.simple_spinner_item, g);
        txgrupo.setAdapter(a);
    }
    public void cambiaText(View view){
        Switch s = (Switch) view;
        if(s.getText().equals("OR")){
            s.setText("AND");
        }else{
            s.setText("OR");
        }
    }
    public void eraseNombre(View view){txnombre.setText("");}
    public void eraseApellido(View view){
        txapellido.setText("");
    }
    public void eraseTelefono(View view){
        txtelefono.setText("");
    }
    public void eraseEmail(View view){
        txemail.setText("");
    }
    public void consultar(View view) {
        AdminSQL admin = new AdminSQL(this, "administracion", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = txcodigo.getText().toString();

        if (codigo.isEmpty()) {
            Toast.makeText(this, "Rellena el codigo para buscar", Toast.LENGTH_SHORT).show();
        } else {
            Cursor fila = base.rawQuery("Select Nombre, Apellidos, telefono, email, grupo FROM contactos WHERE codigo='" + codigo + "';", null);
            if (fila.moveToFirst()) {
                txnombre.setText(fila.getString(0));
                txapellido.setText(fila.getString(1));
                txtelefono.setText(fila.getString(2));
                txemail.setText(fila.getString(3));
                txgrupo.setSelection(((ArrayAdapter<String>)txgrupo.getAdapter()).getPosition(fila.getString(4)));
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
        String codigo = txcodigo.getText().toString();

        if (codigo.isEmpty()) {
            Toast.makeText(this, "Codigo vacío", Toast.LENGTH_SHORT).show();
        } else {
            int cantidad = base.delete("contactos", "codigo=" + codigo, null);
            base.close();
            txcodigo.setText("");

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

        String codigo = txcodigo.getText().toString();
        String nombre = txnombre.getText().toString();
        String apellidos = txapellido.getText().toString();
        String email = txemail.getText().toString();
        String telf = txtelefono.getText().toString();
        String grupo = txgrupo.getSelectedItem().toString();
        if (nombre.isEmpty() || apellidos.isEmpty() || email.isEmpty() || telf.isEmpty()) {
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("Nombre", nombre);
            registro.put("Apellidos", apellidos);
            registro.put("telefono", telf);
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
            String nombre = txnombre.getText().toString();
            String apellidos = txapellido.getText().toString();
            String email = txemail.getText().toString();
            String tel = txtelefono.getText().toString();
            String grupo = txgrupo.getSelectedItem().toString();

            Switch swApellidos = (Switch) findViewById(R.id.swApellidos);
            Switch swTelefono = (Switch) findViewById(R.id.swTelefono);
            Switch swEmail = (Switch) findViewById(R.id.swEmail);

            if (!nombre.isEmpty()){
                where+=" Nombre LIKE '%"+nombre+"%'";
                busq=true;
            }
            if (!apellidos.isEmpty() && nombre.isEmpty()){
                where+=" Apellidos LIKE'%"+apellidos+"%'";
                busq=true;
            } else if (!apellidos.isEmpty()){
                where+=swApellidos.getText()+" Apellidos LIKE '%"+apellidos+"%'";
            }
            if (!tel.isEmpty() && nombre.isEmpty() && apellidos.isEmpty()){
                where+=" telefono LIKE '%"+tel+"%'";
                busq=true;
            } else if (!tel.isEmpty()) {
                where+=swTelefono.getText()+" telefono LIKE '%"+tel+"%'";
            }
            if (!email.isEmpty() && nombre.isEmpty() && apellidos.isEmpty() && tel.isEmpty()){
                where+=" email LIKE '%"+email+"%'";
                busq=true;
            } else if (!email.isEmpty()){
                where+=swEmail.getText()+" email LIKE '%"+email+"%'";
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
                if(lista.isEmpty()){
                    Toast.makeText(this, "No se encontraron resultados", Toast.LENGTH_SHORT).show();
                    return ;
                }
                Intent busqa = new Intent(this, BusquedaAvanzada.class);
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