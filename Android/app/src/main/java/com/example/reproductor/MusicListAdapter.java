package com.example.reproductor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder>{

    ArrayList<ModeloAudio> listaCanciones;
    Context context;

    public MusicListAdapter(ArrayList<ModeloAudio> listaCanciones, Context context) {
        this.listaCanciones = listaCanciones;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
        return new MusicListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ModeloAudio songData = listaCanciones.get(position);
        holder.txTitulo.setText(songData.getTitle());

        if (songData.bm != null)
        holder.imgImagen.setImageBitmap(songData.bm);
        /*
        if(MyMediaPlayer.currentIndex==position){
            holder.titleTextView.setTextColor(Color.parseColor("#FF0000"));
        }else{
            holder.titleTextView.setTextColor(Color.parseColor("#000000"));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navigate to another acitivty

                MyMediaPlayer.getInstance().reset();
                MyMediaPlayer.currentIndex = position;
                Intent intent = new Intent(context,MusicPlayerActivity.class);
                intent.putExtra("LIST",songsList);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
 */
    }

    @Override
    public int getItemCount() {
        return listaCanciones.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txTitulo;
        ImageView imgImagen;
        public ViewHolder(View itemView) {
            super(itemView);
            txTitulo = itemView.findViewById(R.id.music_title_text);
            imgImagen = itemView.findViewById(R.id.icon_view);
        }
    }
}
