package com.churchapp.ikon.ikonchurch;

import android.app.Activity;
import android.os.Bundle;

import java.util.List;

/**
 * Created by mattijoh on 28/04/2017.
 */

public class ArrayController extends Activity{

    public static List<Sermon> Sermons;

    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
    }

    public void populatList(List name){

    }

}
