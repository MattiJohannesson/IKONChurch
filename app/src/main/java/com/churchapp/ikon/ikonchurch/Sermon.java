package com.churchapp.ikon.ikonchurch;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import java.net.URI;
import java.util.List;

public class Sermon{
    private Uri _Thumbnail;
    private String _Title, _Id, _Description;
    private List<Videos> _vids;

    public Sermon(String Id,Uri Thumbnail, String Title, String Description,List<Videos> Vids){
        _Thumbnail=Thumbnail;
        _Title=Title;
        _Id = Id;
        _Description = Description;
        _vids = Vids;
    }

    public String getId(){return _Id;}
    public Uri getThumbnail(){return _Thumbnail;}
    public String getTitle(){return _Title;}
    public String getDescription(){return _Description;}
}
