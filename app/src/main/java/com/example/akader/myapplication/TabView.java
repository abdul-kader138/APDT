package com.example.akader.myapplication;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;



public class TabView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_view);
        TabHost tabHost=(TabHost) findViewById(R.id.tabHost);
        TabSpec spec=tabHost.newTabSpec("Home");
        spec.setIndicator("Tab");
        Intent intent=new Intent(getApplicationContext(),Home.class);
        spec.setContent(intent);
        tabHost.setup();
        tabHost.addTab(spec);
    }
}
