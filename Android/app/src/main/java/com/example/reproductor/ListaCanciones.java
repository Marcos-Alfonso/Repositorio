package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ContentUris;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reproductor.modelos.ModeloAudio;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListaCanciones extends AppCompatActivity {

    RecyclerView rv;
    TextView noFound;
    ArrayList<ModeloAudio> listaCanciones = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_canciones);

        rv = findViewById(R.id.recyclerview);
        noFound = findViewById(R.id.no_found_text);


        if (cargaDefault()) return;

        ArrayList<ModeloAudio> r = (ArrayList<ModeloAudio>)getIntent().getSerializableExtra("LIST");
        if (r != null){
            Toast toast1 = Toast.makeText(this, "-"+"-", Toast.LENGTH_SHORT);
            toast1.show();
            listaCanciones = r;
        }
        if(listaCanciones.size()==0){
            noFound.setVisibility(View.VISIBLE);
        }else{
            //recyclerview
            rv.setLayoutManager(new LinearLayoutManager(this));
            rv.setAdapter(new MusicListAdapter(listaCanciones,getApplicationContext()));
        }
    }

    private boolean cargaDefault() {
        if (checkPermission() == false){
            requestPermission();
            return true;
        }
        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.ALBUM_ID
        };

        String selection = MediaStore.Audio.Media.IS_MUSIC +" != 0";

        Cursor cursor = this.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,projection,selection,null,null);
        while(cursor.moveToNext()){
            Uri sArtworkUri = Uri.parse("content://media/external/audio/albumart");
            Uri albumArtUri = ContentUris.withAppendedId(sArtworkUri,Long.parseLong(cursor.getString(3)));
            try {
                ParcelFileDescriptor pfd = this.getContentResolver()
                        .openFileDescriptor(albumArtUri, "r");
                if (pfd !=null) {
                    ModeloAudio songData = new ModeloAudio(cursor.getString(1),cursor.getString(0),cursor.getString(2), albumArtUri.toString());
                    if(new File(songData.getPath()).exists())
                        listaCanciones.add(songData);
                }
            } catch (FileNotFoundException e) {
                ModeloAudio songData = new ModeloAudio(cursor.getString(1),cursor.getString(0),cursor.getString(2), "");
                if(new File(songData.getPath()).exists())
                    listaCanciones.add(songData);
            }
        }
        return false;
    }

    boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(ListaCanciones.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        }
        return false;
    }
    void requestPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(ListaCanciones.this,Manifest.permission.READ_EXTERNAL_STORAGE)){
            Toast.makeText(ListaCanciones.this,"Se necesitan los permisos de lectura",Toast.LENGTH_SHORT).show();
        }else ActivityCompat.requestPermissions(ListaCanciones.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},123);
    }
}