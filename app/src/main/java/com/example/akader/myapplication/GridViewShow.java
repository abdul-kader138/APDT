package com.example.akader.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.akader.myapplication.R;

/**
 * Created by a.kader on 10/4/2017.
 */

public class GridViewShow extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);
        Integer[] test={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        ArrayAdapter<Integer> arrayAdapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,test);
        GridView gridView=(GridView) findViewById(R.id.gView);
        gridView.setAdapter(arrayAdapter);
    }
}
