package com.example.agendacontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BusquedaAvanzada extends AppCompatActivity {
    int PAGE_SIZE = 5;
    int i=0;
    TextView txtmax;
    EditText l;
    ListView lvContactos;
    ArrayList<contacto> p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avanzada);
        initiate();
    }
    private void initiate(){

        txtmax= (TextView)findViewById(R.id.textView10);
        l=(EditText)findViewById(R.id.editTextPhone);

        lvContactos= (ListView)findViewById(R.id.lvContactos);

        p =(ArrayList<contacto>) getIntent().getSerializableExtra("list");
        l.setText((i+1)+"-"+(i+PAGE_SIZE));
        String s = "Nº P-"+Math.ceil((double)p.size()/PAGE_SIZE);
        txtmax.setText(s.substring(0,s.length()-2));
        cargar(p);
    }
    public void refresh(View view){
        EditText et = (EditText) findViewById(R.id.editTextNumber2);
        PAGE_SIZE = Integer.parseInt(String.valueOf(et.getText()));
        initiate();
    }
    public void volver(View view){
        System.exit(0);
    }

    public void cargar(ArrayList<contacto> p){
        ArrayList<String> contactos = new ArrayList<>();
        try {
            for (int j = i; j <i+PAGE_SIZE; j++) {
                contacto c = p.get(j);
                String s = "Código: "+c.getCodigo()+"  Nombre: "+c.getNombre()+"\n"
                        +"Apellido: "+c.getApellido()+"  Telefono: "+c.getTelefono()+"\n"
                        +"Email: "+c.getEmail()+"  Grupo: "+c.getGrupo()+"\n";
                contactos.add(s);
            }
        }catch(Exception e){}
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactos);
        lvContactos.setAdapter(adapter);
    }

    public void avanzar(View view){
        if (i+PAGE_SIZE>=p.size()){
            Toast.makeText(this, "No hay mas contactos", Toast.LENGTH_SHORT).show();
        } else {
            i += PAGE_SIZE;
            cargar(p);
            l.setText((i+1)+"-"+(i+PAGE_SIZE));
        }
    }

    public void retroceder(View view){

        if (i==0){
            Toast.makeText(this, "Primer contacto", Toast.LENGTH_SHORT).show();
        } else {
            i =i-PAGE_SIZE;
            cargar(p);
            l.setText((i+1)+"-"+(i+PAGE_SIZE));
        }
    }


}