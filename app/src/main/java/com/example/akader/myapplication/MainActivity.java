package com.example.akader.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







        /*
        * get button id and add onclick listener to the button
        * */


        Button button = (Button) findViewById(R.id.b);
        Button button2 = (Button) findViewById(R.id.b2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.et1);
                Intent intent = new Intent();


        /*
        * ACTION_DIAL - send to dial with specific Number
        * */

                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + editText.getText().toString()));


                /*
        * ACTION_GET_CONTENT - get any king of file like-Image,Music,Video etc
        * */

//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                intent.setType("image/*");
                startActivity(intent);
            }
        });











        /*
        * get button id and add onclick listener to the button
        * */

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText1 = (EditText) findViewById(R.id.et1);


        /*
        * Communicate between Activity to Activity
        * startActivityForResult- here mainActivity send data to SecondActivity
        * and also receive data from SecondActivity
        * */
                Intent intent1 = new Intent(MainActivity.this, ScreenSecond.class);
                intent1.putExtra("val", editText1.getText().toString());
                intent1.putExtra("val2", "Hello");
                startActivityForResult(intent1, 2121);
            }
        });
    }






       /*
        * onActivityResult- Check SecondActivity result data
        * */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2121) {
            TextView textView = (TextView) findViewById(R.id.t1);
            String val = data.getStringExtra("Msg");
            textView.setText(val);
        }

    }
}


