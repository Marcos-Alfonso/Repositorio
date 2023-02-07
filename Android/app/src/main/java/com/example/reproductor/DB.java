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

import com.example.reproductor.modelos.Usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NOMBRE = "reproductor.db";
    public static final String TABLA_USUARIOS = "CREATE TABLE USUARIOS( id INTEGER PRIMARY KEY AUTOINCREMENT, nombre String NOT NULL, fecha String default null, imagen String default \"\", genero String default null)";
    public static final String DELETE_USUARIOS = "DROP TABLE IF EXISTS USUARIOS";
    public DB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NOMBRE, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_USUARIOS);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(DELETE_USUARIOS);
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
}