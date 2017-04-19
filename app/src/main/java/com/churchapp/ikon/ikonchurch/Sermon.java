package com.churchapp.ikon.ikonchurch;

import android.widget.ImageView;

public class Sermon{
    private ImageView _Thumbnail;
    private String _Title;

    public Sermon(ImageView Thumbnail, String Title){
        _Thumbnail=Thumbnail;
        _Title=Title;
    }

    public ImageView getThumbnail(){return _Thumbnail;}

    public String getTitle(){return _Title;}
}
