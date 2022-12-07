package com.example.agendacontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BussquedaAvandaza extends AppCompatActivity {
    int i=0;
    TextView txtcodigo, txtnombre, txtapellido, txttel, txtemail, txtgrupo, txtmax;
    EditText l;
    ArrayList<contacto> p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bussqueda_avandaza);
        txtcodigo = (TextView) findViewById(R.id.textView4);
        txtnombre = (TextView)findViewById(R.id.textView3);
        txtapellido = (TextView)findViewById(R.id.textView5);
        txttel = (TextView)findViewById(R.id.textView6);
        txtemail = (TextView)findViewById(R.id.textView7);
        txtgrupo = (TextView)findViewById(R.id.textView8);
        txtmax= (TextView)findViewById(R.id.textView10);
        l=(EditText)findViewById(R.id.editTextPhone);


        p =(ArrayList<contacto>) getIntent().getSerializableExtra("list");
        txtmax.setText("de "+ p.size());
        cargar(p);
        //Toast.makeText(this, prueba.get(0), Toast.LENGTH_SHORT).show();
    }

    public void volver(View view){
        System.exit(0);
    }

    public void cargar(ArrayList<contacto> p){
        txtcodigo.setText("Codigo: "+p.get(i).getCodigo());
        txtnombre.setText("Nombre: "+p.get(i).getNombre());
        txtapellido.setText("Apellidos: "+p.get(i).getApellido());
        txttel.setText("Telefono: "+p.get(i).getTelefono());
        txtemail.setText("Email: "+p.get(i).getEmail());
        txtgrupo.setText("Grupo: "+p.get(i).getGrupo());
    }

    public void avanzar(View view){
        if (i==p.size()-1){
            Toast.makeText(this, "Ultimo contacto alcanzado", Toast.LENGTH_SHORT).show();
        } else {
            i++;
            cargar(p);
            l.setText((i+1)+"");
        }
    }

    public void retroceder(View view){
        if (i==0){
            Toast.makeText(this, "Primer contacto avanzado", Toast.LENGTH_SHORT).show();
        } else {
            i--;
            cargar(p);
            l.setText((i+1)+"");
        }
    }

    public void cambio(View view){
        int num = Integer.parseInt(l.getText().toString())-1;
        if (num<0 || num>=p.size()){
            Toast.makeText(this, "Numero fuera del limite", Toast.LENGTH_SHORT).show();
            l.setText((i+1)+"");
        } else {
            i=num;
            cargar(p);
        }
    }
}