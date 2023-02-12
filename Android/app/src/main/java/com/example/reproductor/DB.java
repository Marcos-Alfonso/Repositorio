package com.example.reproductor;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.reproductor.modelos.ModeloAudio;
import com.example.reproductor.modelos.Playlist;
import com.example.reproductor.modelos.Usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NOMBRE = "reproductor.db";
    //public static final String TABLA_USUARIOS = "CREATE TABLE USUARIOS( id INTEGER PRIMARY KEY AUTOINCREMENT, nombre String NOT NULL, fecha String default null, imagen String default \"\", genero String default null)";
   // public static final String DELETE_USUARIOS = "DROP TABLE IF EXISTS USUARIOS";
    public static final String[] TABLAS = new String[]{
            "CREATE TABLE USUARIOS( id INTEGER PRIMARY KEY AUTOINCREMENT, nombre String NOT NULL, fecha String default null, imagen String default \"\", genero String default null)",
            "CREATE TABLE PLAYLIST( id INTEGER PRIMARY KEY AUTOINCREMENT, nombre String NOT NULL, imagen String default \"\", id_usuario INTEGER NOT NULL)",
            "CREATE TABLE CANCIONES( id_playlist INTEGER PRIMARY KEY, src String NOT NULL)"
    };
    public static final String[] DELETE_TABLAS = new String[]{
            "DROP TABLE IF EXISTS USUARIOS",
            "DROP TABLE IF EXISTS PLAYLIST",
            "DROP TABLE IF EXISTS CANCIONES"
    };
    Context c;
    public DB(Context context) {
        super(context, DB_NOMBRE, null, DB_VERSION);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (String query:TABLAS) {
            sqLiteDatabase.execSQL(query);
        }

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        for (String query:DELETE_TABLAS) {
            db.execSQL(query);
        }
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    public long addUsuario(String nombre, String fecha, String imagen, String genero){
        SQLiteDatabase sqldb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("fecha", fecha);
        values.put("imagen", imagen);
        values.put("genero", genero);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = sqldb.insert("usuarios", null, values);
        return newRowId;
    }
    public long addPlaylist(String nombre,  String imagen, int id_usuario){
        SQLiteDatabase sqldb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("imagen", imagen);
        values.put("id_usuario", id_usuario);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = sqldb.insert("playlist", null, values);
        return newRowId;
    }
    public ArrayList<Playlist> getPlaylistList( int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                "id",
                "nombre",
                "imagen"
        };
        String selection = "id_usuario = ?";
        String[] selectionArgs = { String.valueOf(id) };
        Cursor cursor = db.query(
                "PLAYLIST",   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        ArrayList<Playlist> lista = new ArrayList<>();
        while(cursor.moveToNext()) {
            lista.add(new Playlist(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
        }
        return lista;
    }
    public ArrayList<ModeloAudio> getAudioByID( int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                "src"
        };
        String selection = "id_playlist = ?";
        String[] selectionArgs = { String.valueOf(id) };
        Cursor cursor = db.query(
                "CANCIONES",   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        ArrayList<String>src = new ArrayList<>();
        while(cursor.moveToNext()) {
            src.add(cursor.getString(0));
        }
        ArrayList<ModeloAudio> listaDefault =cargaDefault();
        ArrayList<ModeloAudio> def = new ArrayList<>();
        for (String s:src) {
            for (ModeloAudio audio:listaDefault) {
                if (src.equals(audio.getPath()))def.add(audio);
            }
        }
        return def;
    }

    private ArrayList<ModeloAudio> cargaDefault() {
        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.ALBUM_ID
        };

        String selection = MediaStore.Audio.Media.IS_MUSIC +" != 0";

        Cursor cursor = c.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,projection,selection,null,null);
        ArrayList<ModeloAudio>listaCanciones = new ArrayList<>();
        while(cursor.moveToNext()){
            Uri sArtworkUri = Uri.parse("content://media/external/audio/albumart");
            Uri albumArtUri = ContentUris.withAppendedId(sArtworkUri,Long.parseLong(cursor.getString(3)));
            try {
                ParcelFileDescriptor pfd = c.getContentResolver()
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
        return listaCanciones;
    }

    public int userExist(String nombre){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                "id"
        };
        String selection = "nombre = ?";
        String[] selectionArgs = { nombre };
        Cursor cursor = db.query(
                "USUARIOS",   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        while(cursor.moveToNext()) {
            int itemId = cursor.getInt(0);
            return itemId;
        }
        return -1;
    }
}