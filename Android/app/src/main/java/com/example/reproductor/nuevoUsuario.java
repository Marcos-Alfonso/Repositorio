package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class nuevoUsuario extends AppCompatActivity {

    int s;
    SoundPool sp;
    EditText nombre;
    EditText fecha;
    ImageView imagen;
    Handler handler = new Handler();
    Runnable runnable;
    int delay = 500;
    boolean canPlay = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);
        nombre = findViewById(R.id.nombre);
        fecha = findViewById(R.id.fecha);
         sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
         s =sp.load(this, R.raw.amongus_role, 1);
        ImageButton BSelectImage = findViewById(R.id.buttonImage);

        // One Preview Image
        imagen = findViewById(R.id.image);

        BSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (!imageSource.equals(""))return;
                if(checkedId == R.id.hombre){
                    imagen.setImageResource(R.drawable.hombre);
                }else{
                    imagen.setImageResource(R.drawable.mujer);
                }
            }
        });
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.fecha:
                        DatePickerDialog dialogoFecha = new DatePickerDialog(nuevoUsuario.this, listenerDeDatePicker, 2023, 1, 1);
                        dialogoFecha.show();
                        break;

                }
            }
        });
    }
    final Calendar calendario = Calendar.getInstance();
    int anio = calendario.get(Calendar.YEAR);
    int mes = calendario.get(Calendar.MONTH);
    int diaDelMes = calendario.get(Calendar.DAY_OF_MONTH);
    private DatePickerDialog.OnDateSetListener listenerDeDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int anio, int mes, int diaDelMes) {
            // Esto se llama cuando seleccionan una fecha. Nos pasa la vista, pero más importante, nos pasa:
            // El año, el mes y el día del mes. Es lo que necesitamos para saber la fecha completa
            String f = String.format(Locale.getDefault(), "%02d-%02d-%02d", anio, mes, diaDelMes);

            // La ponemos en el editText
            fecha.setText(f);
        }
    };


    int SELECT_PICTURE = 200;
    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Selecciona imagen"), SELECT_PICTURE);
    }
    String imageSource = "";
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    imageSource = selectedImageUri.toString();
                    imagen.setImageURI(Uri.parse(imageSource));
                }
            }
        }
    }
    public void add(View view){
        RadioGroup rg = findViewById(R.id.group);

        if(fecha.getText().toString().equals( "" )|| nombre.getText().toString().equals("") || rg.getCheckedRadioButtonId()==-1){
            Toast toast1 = Toast.makeText(getApplicationContext(), "Rellena los campos", Toast.LENGTH_SHORT);
            toast1.show();
            return;
        }else{
            String genero = "";
            if (rg.getCheckedRadioButtonId()==R.id.hombre){
                genero = "hombre";
            }else{
                genero = "mujer";
            }
            DB d = new DB(this);
            d.addUsuario(nombre.getText().toString(), fecha.getText().toString(), imageSource, genero);
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                if (canPlay){
                    handler.postDelayed(runnable, delay);
                    sp.play(s, 1, 1, 1, 0, 1);
                    canPlay = false;
                }
            }
        }, delay);
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        canPlay = true;
        handler.removeCallbacks(runnable); //stop handler when activity not visible super.onPause();
    }


}
