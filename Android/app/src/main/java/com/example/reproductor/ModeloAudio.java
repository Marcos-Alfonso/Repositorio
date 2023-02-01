package com.example.reproductor;

import android.graphics.Bitmap;

import java.io.Serializable;

public class ModeloAudio implements Serializable {
    String path;
    String title;
    String duration;
    Bitmap bm;
    public ModeloAudio(String path, String title, String duration, Bitmap bm) {
        this.path = path;
        this.title = title;
        this.duration = duration;
        this.bm = bm;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
