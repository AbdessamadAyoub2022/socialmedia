package com.example.bibliotheque.model;

import android.graphics.Bitmap;

public class Books {
    private int id_book;
    private String _Titre;
    private Byte[] _image;
    public Books(String Titre,Byte []image,String Descrption)
    {
        this._Titre=Titre;
        this._image=image;

    }

    public String get_Titre() {
        return _Titre;
    }

    public Byte[] get_image() {
        return _image;
    }


    public void set_Titre(String _Titre) {
        this._Titre = _Titre;
    }

    public void set_image(Byte[] _image) {
        this._image = _image;
    }

}