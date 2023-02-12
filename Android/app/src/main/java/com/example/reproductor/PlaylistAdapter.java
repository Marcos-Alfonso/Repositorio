package com.example.reproductor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.reproductor.modelos.ModeloAudio;
import com.example.reproductor.modelos.Playlist;

import java.util.ArrayList;
import java.util.Objects;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder>{

    ArrayList<Playlist> listaPlaylist;
    Context context;

    public PlaylistAdapter(ArrayList<Playlist> listaPlaylist, Context context) {
        this.listaPlaylist = listaPlaylist;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.playlist_item,parent,false);
        return new PlaylistAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Playlist playlist = listaPlaylist.get(position);
        holder.txTitulo.setText(playlist.getNombre());
        if (!playlist.getImagen().equals("")){
            //holder.imgImagen.setImageURI(Uri.parse(playlist.getImagen()));
        }
        else{
            holder.imgImagen.setImageResource(R.drawable.amongus1);
        }

        /*
        if(MyMediaPlayer.currentIndex==position){
            holder.titleTextView.setTextColor(Color.parseColor("#FF0000"));
        }else{
            holder.titleTextView.setTextColor(Color.parseColor("#000000"));
        }
 */
        holder.imgImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navigate to another acitivty
                Toast toast1 = Toast.makeText(context, "-"+playlist.getImagen()+"-", Toast.LENGTH_SHORT);
                toast1.show();

                ArrayList<ModeloAudio> r = new DB(context).getAudioByID(listaPlaylist.get(position).getId());

                Intent intent = new Intent(context,ListaCanciones.class);
                intent.putExtra("LIST",r);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaPlaylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txTitulo;
        ImageView imgImagen;
        public ViewHolder(View itemView) {
            super(itemView);
            txTitulo = itemView.findViewById(R.id.txPlaylist);
            imgImagen = itemView.findViewById(R.id.imagePlaylist);
        }
    }
}
