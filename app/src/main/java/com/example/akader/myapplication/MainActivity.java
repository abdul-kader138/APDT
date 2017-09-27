package com.example.akader.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadText(View view){
        EditText editText=(EditText) findViewById(R.id.et1);
        TextView text=  (TextView) findViewById(R.id.t2);
        text.setText(editText.getText());
    }


}
