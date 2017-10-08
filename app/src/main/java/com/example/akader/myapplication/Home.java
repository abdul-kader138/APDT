package com.example.akader.myapplication;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;



public class Home extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
    }
}
