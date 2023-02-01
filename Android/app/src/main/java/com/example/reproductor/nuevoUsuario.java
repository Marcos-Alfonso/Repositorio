package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class nuevoUsuario extends AppCompatActivity {

    int s;
    SoundPool sp;

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 500;
    boolean canPlay = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);

         sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
         s =sp.load(this, R.raw.amongus_role, 1);

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

    public void reproduce(View view){
        sp.play(s, 1, 1, 1, 0, 1);
        Toast toast1 = Toast.makeText(getApplicationContext(), "Vivimos en una h", Toast.LENGTH_SHORT);
        toast1.show();
    }
}