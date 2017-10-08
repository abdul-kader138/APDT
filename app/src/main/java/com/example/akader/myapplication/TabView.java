package com.example.akader.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;


public class TabView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_view);



        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabSpec spec1 = tabHost.newTabSpec("Home");
        Intent intent = new Intent(this, Home.class);
        spec1.setContent(intent);
//        spec1.setContent(R.id.tab1);
        spec1.setIndicator("Home");


        TabSpec spec2 = tabHost.newTabSpec("About Us");
        spec2.setIndicator("About Us");
        spec2.setContent(R.id.tab2);


        TabSpec spec3 = tabHost.newTabSpec("Service");
        spec3.setContent(R.id.tab3);
        spec3.setIndicator("Service");
        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);


    }
}
