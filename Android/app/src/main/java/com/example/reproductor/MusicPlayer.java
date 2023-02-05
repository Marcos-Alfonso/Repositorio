package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MusicPlayer extends AppCompatActivity {

    TextView txTitulo, now, total;
    SeekBar barra;
    ShapeableImageView imagen;
    ImageView pause, next, previous, repeat, random;

    ArrayList<ModeloAudio> listaCanciones;
    ModeloAudio actual;
    MediaPlayer mediaPlayer = MyMediaPlayer.getInstance();
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        txTitulo = findViewById(R.id.titulo);
        now = findViewById(R.id.now);
        total = findViewById(R.id.total);
        barra = findViewById(R.id.bar);
        imagen = findViewById(R.id.imagenFondo);
        pause = findViewById(R.id.stopResume);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);

        repeat = findViewById(R.id.repeat);
        random = findViewById(R.id.random);

        listaCanciones = (ArrayList<ModeloAudio>) getIntent().getSerializableExtra("LIST");
        txTitulo.setSelected(true);

        inicia();


        pause.setOnClickListener(v-> pausePlay());
        next.setOnClickListener(v-> playNextSong());
        previous.setOnClickListener(v-> playPreviousSong());
        repeat.setOnClickListener(v-> changeLoop());
        random.setOnClickListener(v-> changeRandom());

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer!=null){
                    barra.setProgress(mediaPlayer.getCurrentPosition());
                    now.setText(convertToMMSS(mediaPlayer.getCurrentPosition()+""));

                    checkImages();

                }
                new Handler().postDelayed(this,20);
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                playNextSong();
            }
        });
        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(mediaPlayer!=null && fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });


    }

    private void checkImages() {
        if(mediaPlayer.isPlaying()){
            pause.setImageResource(android.R.drawable.ic_media_pause);
            imagen.setRotation(x++);
        }else{
            pause.setImageResource(android.R.drawable.ic_media_play);
        }

        if(isRandom){
            random.setImageResource(R.drawable.random_active);
        }else{
            random.setImageResource(R.drawable.random);
        }

        if (loop == 0){
            repeat.setImageResource(R.drawable.repeat_not_active);
        }else if(loop == 1){
            repeat.setImageResource(R.drawable.repeat_active);
        }else{
            repeat.setImageResource(R.drawable.repeat_only);
        }
    }

    int loop = 0;
    private void changeLoop(){
        if(loop == 0){
            loop++;
            return;
        }
        if (loop == 1){
            loop++;
            return;
        }
        loop = 0;
    }

    boolean isRandom = false;
    private void changeRandom(){
        isRandom = !isRandom;
    }


    private void playMusic(){
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(actual.getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            barra.setProgress(0);
            barra.setMax(mediaPlayer.getDuration());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void playNextSong(){
        if (loop == 2){
            mediaPlayer.reset();
            inicia();
            return;
        }
        if(MyMediaPlayer.currentIndex== listaCanciones.size()-1){
            if (loop ==1){
                MyMediaPlayer.currentIndex = 0;
                mediaPlayer.reset();
                inicia();
            }
            return;
        }
        if (isRandom){
            MyMediaPlayer.currentIndex = randomDifferent();
        }else{
            MyMediaPlayer.currentIndex +=1;
        }

        mediaPlayer.reset();
        inicia();
    }

    private int randomDifferent() {
        int rnd ;
        do {
            Random r = new Random();
            rnd = r.nextInt(listaCanciones.size());
        }while(rnd == MyMediaPlayer.currentIndex);
        return rnd;
    }

    private void playPreviousSong(){
        if(restart()){
            mediaPlayer.reset();
            inicia();
            return;
        }
        if(MyMediaPlayer.currentIndex== 0)
            return;
        MyMediaPlayer.currentIndex -=1;
        mediaPlayer.reset();
        inicia();
    }

    private boolean restart() {
        if(mediaPlayer.getCurrentPosition()<2000)return true;

        return false;
    }

    private void pausePlay(){
        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
        else
            mediaPlayer.start();
    }

    private void inicia() {
        actual = listaCanciones.get(MyMediaPlayer.currentIndex);
        txTitulo.setText(actual.getTitle());
        total.setText(convertToMMSS(actual.getDuration()));
        RelativeLayout r = findViewById(R.id.main_layout);
        if (!actual.getBm().equals("")){
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), Uri.parse(actual.getBm()));
                r.setBackgroundColor(calculateAverageColor(bitmap, 1));
            } catch (IOException e) {
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Toast por defecto", Toast.LENGTH_SHORT);
                e.printStackTrace();
            }
            imagen.setImageURI(Uri.parse(actual.getBm()));
        }else{
            imagen.setImageResource(R.drawable.music_icon);
            r.setBackgroundColor(Color.parseColor("#FF9C9C"));

        }


        playMusic();

    }
    public int calculateAverageColor(Bitmap bitmap, int pixelSpacing) {
        int R = 0; int G = 0; int B = 0;
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int n = 0;
        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        for (int i = 0; i < pixels.length; i += pixelSpacing) {
            int color = pixels[i];
            R += Color.red(color);
            G += Color.green(color);
            B += Color.blue(color);
            n++;
        }
        return Color.rgb(R / n, G / n, B / n);
    }
    public static String convertToMMSS(String duration){
        Long millis = Long.parseLong(duration);
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1));
    }
}