package com.heyletscode.ihavetofly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean isMute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });

        TextView highScoreTxt = findViewById(R.id.highScoreTxt);

        final SharedPreferences prefs = getSharedPreferences("game", MODE_PRIVATE);
        highScoreTxt.setText("HighScore: " + prefs.getInt("highscore", 0));

        isMute = prefs.getBoolean("isMute", false);

        final ImageView volumeCtrl = findViewById(R.id.volumeCtrl);

        if (isMute)
            volumeCtrl.setImageResource(R.drawable.ic_volume_off_black_24dp);
        else
            volumeCtrl.setImageResource(R.drawable.ic_volume_up_black_24dp);

        volumeCtrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isMute = !isMute;
                if (isMute)
                    volumeCtrl.setImageResource(R.drawable.ic_volume_off_black_24dp);
                else
                    volumeCtrl.setImageResource(R.drawable.ic_volume_up_black_24dp);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isMute", isMute);
                editor.apply();

            }
        });
        RadioGroup rgDificultad = findViewById(R.id.dificultad), rgVelocidad = findViewById(R.id.velocidad);


        rgDificultad.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb=findViewById(checkedId);
                SharedPreferences.Editor editor = prefs.edit();
                if (rb.getText().toString().equals("Facil")){
                    editor.putFloat("dificultad", 1.5f);
                }else if (rb.getText().toString().equals("Medio")){
                    editor.putFloat("dificultad", 1.0f);
                }else if (rb.getText().toString().equals("Dificil")){
                    editor.putFloat("dificultad", 0.5f);
                }
                editor.apply();
            }
        });
        rgVelocidad.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb=findViewById(checkedId);
                SharedPreferences.Editor editor = prefs.edit();
                if (rb.getText().toString().equals("Rapido")){
                    editor.putFloat("velocidad", 1.3f);
                }else if (rb.getText().toString().equals("Normal")){
                    editor.putFloat("velocidad", 1.0f);
                }else if (rb.getText().toString().equals("Lento")){
                    editor.putFloat("velocidad", 0.5f);
                }
                editor.apply();
            }
        });
        float dificultad = prefs.getFloat("dificultad", 1.0f);

        float velocidad = prefs.getFloat("velocidad", 1.0f);

        RadioButton rb;
        if (dificultad == 0.5f){
            rb = (RadioButton) rgDificultad.getChildAt(0);

        } else if(dificultad == 1.5f){
            rb = (RadioButton) rgDificultad.getChildAt(2);
        }else{
            rb = (RadioButton) rgDificultad.getChildAt(1);
        }
        rb.setChecked(true);

        if (velocidad == 0.5f){
            rb = (RadioButton) rgVelocidad.getChildAt(2);

        } else if(velocidad == 1.3f){
            rb = (RadioButton) rgVelocidad.getChildAt(0);
        }else{
            rb = (RadioButton) rgVelocidad.getChildAt(1);
        }
        rb.setChecked(true);


    }
}
