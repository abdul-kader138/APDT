package com.example.akader.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ScreenSecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("second activity");
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();
        Toast.makeText(getApplicationContext(), bundle.getString("val") + bundle.getString("val2"), Toast.LENGTH_LONG).show();
        Button button = (Button) findViewById(R.id.bs);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
    }

}
