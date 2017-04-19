package com.churchapp.ikon.ikonchurch;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Media_AddSeries extends Activity {

    private static final int PICK_IMAGE = 1;
    public ImageView Thumbnail;
    public EditText Title;
    public List<Sermon> Sermons = new ArrayList<Sermon>();
    ArrayAdapter<Sermon> adapter;
    ListView SermonListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media__add_series);

        Thumbnail = (ImageView) findViewById(R.id.imageViewThumbnail);
        Title = (EditText) findViewById(R.id.editTextSermonTitle);
        SermonListView = (ListView) findViewById(R.id.ListViewSermon);
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

        Thumbnail.setImageURI(originalUri);
    }

    public void Submit(View view) {
        AddSermon(Thumbnail, Title.toString());
        PopulateList();
        Intent i = new Intent(Media_AddSeries.this, MediaTab.class);
        startActivity(i);
    }

    public void AddSermon(ImageView _thumbnail, String _title) {
        Sermons.add(new Sermon(_thumbnail, _title));
    }

    public void PopulateList(){
        adapter = new SermonListAdapter();
        SermonListView.setAdapter(adapter);
    }

    private class SermonListAdapter extends ArrayAdapter<Sermon>{
        public SermonListAdapter(){
            super (Media_AddSeries.this,R.layout.mediasermonitem, Sermons);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent){
            if (view == null){
                view = getLayoutInflater().inflate(R.layout.mediasermonitem, parent,false);

                Sermon currentSermon = Sermons.get(position);

                ImageView thumbnail = (ImageView) findViewById(R.id.imageViewThumbnail);
                TextView title = (TextView) findViewById(R.id.textViewTitle);
            }
            return view;
        }
    }

}

