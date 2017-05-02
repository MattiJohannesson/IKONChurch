package com.churchapp.ikon.ikonchurch;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.media.audiofx.AudioEffect;
import android.net.Uri;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.churchapp.ikon.ikonchurch.HexConverter;
import java.util.ArrayList;
import java.util.List;

public class Media_AddSeries extends Activity {
    private HexConverter Hex;
    private static final int PICK_IMAGE = 1;
    public ImageView Thumbnail;
    public Uri ThumbnailURI;
    public EditText Title, Description;
    public List<Videos> Vids;
    public List<Sermon> Sermons = new ArrayList<>();
    private String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media__add_series);

        Thumbnail = (ImageView) findViewById(R.id.imageViewThumbnail);
        Title = (EditText) findViewById(R.id.editTextSermonTitle);
        Description = (EditText) findViewById(R.id.editTextSermonDescription);
    }

    public void AddImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent.createChooser(intent, "Select Thumbnail"), PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) return;
        if (null == data) return;
        Uri originalUri = null;
        if (requestCode == PICK_IMAGE) {
            originalUri = data.getData();
        }

        ThumbnailURI = originalUri;
        Thumbnail.setImageURI(originalUri);
    }

    public void AddSermon(){
        HexConverter Hex = new HexConverter();
        ID = Hex.FromDECtoHEX(ArrayController.Sermons.size() + 1);
        new Sermon(ID,ThumbnailURI,Title.toString(),Description.toString(),Vids);
    }

    public void submit(View view){
        AddSermon();
    }
}

