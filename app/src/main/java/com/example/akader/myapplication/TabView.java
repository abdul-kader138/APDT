package com.example.akader.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TabHost;

/**
 * Created by a.kader on 10/5/2017.
 */

public class TabView extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_view);
        TabHost tabHost=(TabHost) findViewById(R.id.tabHost);
        TabHost.TabSpec spec=tabHost.newTabSpec("Home");
        spec.setIndicator("Home",getResources().getDrawable(R.drawable.user));
        Intent intent=new Intent(getApplicationContext(),Home.class);
        spec.setContent(intent);
        tabHost.addTab(spec);


    }
}
