package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ContentUris;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileDescriptor;
import java.util.ArrayList;

public class listaCanciones extends AppCompatActivity {

    RecyclerView rv;
    TextView noFound;
    ArrayList<ModeloAudio> listaCanciones = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_canciones);

        rv = findViewById(R.id.recyclerview);
        noFound = findViewById(R.id.no_found_text);

        if (checkPermission() == false){
            requestPermission();
            return;
        }
        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.ALBUM_ID
        };

        String selection = MediaStore.Audio.Media.IS_MUSIC +" != 0";

        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,projection,selection,null,null);
        while(cursor.moveToNext()){
            ModeloAudio songData = new ModeloAudio(cursor.getString(1),cursor.getString(0),cursor.getString(2), getAlbumart(Long.valueOf(cursor.getString(3))));
            if(new File(songData.getPath()).exists())
                listaCanciones.add(songData);
        }
        if(listaCanciones.size()==0){
            noFound.setVisibility(View.VISIBLE);
        }else{
            //recyclerview
            rv.setLayoutManager(new LinearLayoutManager(this));
            rv.setAdapter(new MusicListAdapter(listaCanciones,getApplicationContext()));
        }
    }
    public Bitmap getAlbumart(Long album_id)
    {
        Bitmap bm = null;
        try
        {
            final Uri sArtworkUri = Uri.parse("content://media/external/audio/albumart");

            Uri uri = ContentUris.withAppendedId(sArtworkUri, album_id);

            ParcelFileDescriptor pfd = this.getContentResolver().openFileDescriptor(uri, "r");

            if (pfd != null)
            {
                FileDescriptor fd = pfd.getFileDescriptor();
                bm = BitmapFactory.decodeFileDescriptor(fd);
            }
        } catch (Exception e) {
        }
        return bm;
    }
    boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(listaCanciones.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        }
        return false;
    }
    void requestPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(listaCanciones.this,Manifest.permission.READ_EXTERNAL_STORAGE)){
            Toast.makeText(listaCanciones.this,"Se necesitan los permisos de lectura",Toast.LENGTH_SHORT).show();
        }else ActivityCompat.requestPermissions(listaCanciones.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},123);
    }
}