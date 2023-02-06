package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

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
                imageSource = "";
                if(checkedId == R.id.hombre){
                    genero = "hombre";
                    imagen.setImageResource(R.drawable.hombre);
                }else{
                    genero = "mujer";

                    imagen.setImageResource(R.drawable.mujer);
                }
            }
        });
    }
    String genero = "";
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
        if(fecha.getText().toString() == "" || nombre.getText().toString() == ""){
            Toast toast1 = Toast.makeText(getApplicationContext(), "Rellena los campos", Toast.LENGTH_SHORT);
            toast1.show();
            return;
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