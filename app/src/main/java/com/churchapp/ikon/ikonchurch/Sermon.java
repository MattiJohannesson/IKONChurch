package com.churchapp.ikon.ikonchurch;

import android.widget.ImageView;

public class Sermon{
    private ImageView _Thumbnail;
    private String _Title, _Id, _Description, _HexID;

    public Sermon(String Id,ImageView Thumbnail, String Title, String Description,String HexID){
        _Thumbnail=Thumbnail;
        _Title=Title;
        _Id = Id;
        _Description = Description;
        _HexID = HexID;
    }

    public String getId(){return _Id;}

    public ImageView getThumbnail(){return _Thumbnail;}

    public String getTitle(){return _Title;}

    public String getDescription(){return _Description;}
}
