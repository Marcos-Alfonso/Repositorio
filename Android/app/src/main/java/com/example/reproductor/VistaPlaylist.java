package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reproductor.modelos.ModeloAudio;
import com.example.reproductor.modelos.Playlist;

import java.util.ArrayList;

public class VistaPlaylist extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<Playlist> listaPlaylist;
    ImageView imagen;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_playlist);

        rv = findViewById(R.id.recyclerviewPlaylist);
        id = (int)getIntent().getSerializableExtra("ID");
        listaPlaylist = (new DB(this)).getPlaylistList(id);
        //((TextView)findViewById(R.id.nombrePlaylist)).setText(String.valueOf(listaPlaylist.size()));
        rv.setLayoutManager(new GridLayoutManager(this, 3));
        rv.setAdapter(new PlaylistAdapter(listaPlaylist,getApplicationContext()));

        imagen = findViewById(R.id.pImage);
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });
    }

    public void addPlaylist(View view){
        TextView t = findViewById(R.id.nombrePlaylist);
        String s = t.getText().toString();
        (new DB(this)).addPlaylist(t.getText().toString(), imageSource, id);

        listaPlaylist = (new DB(this)).getPlaylistList(id);
        rv.setAdapter(new PlaylistAdapter(listaPlaylist,getApplicationContext()));

        t.setText("");
        imageSource = "";
        imagen.setImageResource(R.drawable.music_icon);
    }
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
}