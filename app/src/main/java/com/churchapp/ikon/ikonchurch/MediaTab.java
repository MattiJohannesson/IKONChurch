package com.churchapp.ikon.ikonchurch;

import android.app.Activity;
import android.content.Intent;
import com.churchapp.ikon.ikonchurch.Media_AddSeries;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MediaTab extends Activity {

    boolean isVisable;
    LinearLayout OptBar;
    ArrayAdapter<Sermon> SermonAdapter;
    ListView SermonListView;
    Media_AddSeries SeriesAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_media_tab );
//        Populatelist();

        SeriesAdd = new Media_AddSeries();
        SermonListView = (ListView) findViewById( R.id.ListViewSermon );

        OptBar = (LinearLayout) findViewById( R.id.LinearLayoutOptionsBar );
        if (OptBar.getVisibility() == View.VISIBLE) {
            isVisable = false;
            OptBar.setVisibility( View.INVISIBLE );
        } else {
            isVisable = true;
        }
//        Populatelist();
    }

    public void OptionBar(View view) {
        if (!isVisable) {
            OptBar.setVisibility( View.VISIBLE );
            isVisable = true;
        } else {
            OptBar.setVisibility( View.INVISIBLE );
            isVisable = false;
        }
    }

    public void AddPreach(View view) {
        if (view.getId() == R.id.buttonAddNewPreach) {
            Intent i = new Intent( MediaTab.this, MediaAdd.class );
            startActivity( i );
        } else {
            return;
        }
    }

    public void AddSermon(View view) {
        if (view.getId() == R.id.buttonAddNewSermon) {
            Intent i = new Intent( MediaTab.this, Media_AddSeries.class );
            startActivity( i );
        } else {
            return;
        }
    }

//    private void Populatelist() {
//        SermonAdapter = new SermonListAdapter();
//        SermonListView.setAdapter( SermonAdapter );
//    }

//    private class SermonListAdapter extends ArrayAdapter<Sermon> {
//
//        public SermonListAdapter() {
////            super( MediaTab.this, R.layout.mediasermonitem, SeriesAdd.Sermons);
//        }
//
//        @Override
//        public View getView(int Pos, View view, ViewGroup parent) {
//            if (view == null)
//                view = getLayoutInflater().inflate( R.layout.mediasermonitem, parent, false );
//
//            Sermon currentSermon = SeriesAdd.Sermons.get( Pos );
//
//            ImageView Thumbnail = (ImageView) view.findViewById( R.id.imageViewThumbnail );
//            Thumbnail.setImageURI(currentSermon.getThumbnail());
//            return view;
//        }
//    }
}
