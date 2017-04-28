package com.churchapp.ikon.ikonchurch;

import android.widget.ImageView;

public class Sermon{
    private ImageView _Thumbnail;
    private String _Title, _Id, _Description;

    public Sermon(String Id,ImageView Thumbnail, String Title, String Description){
        _Thumbnail=Thumbnail;
        _Title=Title;
        _Id = Id;
        _Description = Description;
    }

    public String getId(){return _Id;}
    public ImageView getThumbnail(){return _Thumbnail;}
    public String getTitle(){return _Title;}
    public String getDescription(){return _Description;}
}
