package com.example.akader.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.akader.myapplication.Service.PlayerService;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        /*
        * Buttton View Layout Showing
        *
        *
        * */


        Button bShow=(Button) findViewById(R.id.bShow);

        bShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), ButtonShowView.class);
                startActivity(intent);
            }
        });





        /*
        * Frame View Layout Showing
        *
        *
        * */


        Button fTable=(Button) findViewById(R.id.fViewShow);

        fTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), FrameViewLayout.class);
                startActivity(intent);
            }
        });



          /*
        * Table Layout Showing
        *
        *
        * */


        Button table=(Button) findViewById(R.id.tViewShow);

        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), TableRowLayout.class);
                startActivity(intent);
            }
        });



        /*
        * Grid View Showing
        *
        *
        * */


        Button gridView=(Button) findViewById(R.id.gViewShow);

        gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), GridViewShow.class);
                startActivity(intent);
            }
        });


        Button sButton = (Button) findViewById(R.id.sMedia);
        Button pButton = (Button) findViewById(R.id.pMedia);
        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                VideoView videoView =(VideoView)findViewById(R.id.vView);
                MediaController mediaController= new MediaController(getApplicationContext());
                mediaController.setAnchorView(videoView);

                //specify the location of media file
                String path=Environment.getExternalStorageDirectory().getPath()+"/raw/test_v.mp4";
                Uri uri=Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/raw/test_v.mp4");

                //Setting MediaController and URI, then starting the videoView
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(uri);
                videoView.requestFocus();
                videoView.start();
                startService(new Intent(getApplicationContext(), PlayerService.class));
            }
        });

        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(getApplicationContext(), PlayerService.class));
            }
        });



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
                CheckBox checkBox = (CheckBox) findViewById(R.id.cb1);
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.cb2);
                String s = String.valueOf(checkBox.isChecked());
                String s2 = String.valueOf(checkBox1.isChecked());

        /*
        * Communicate between Activity to Activity
        * startActivityForResult- here mainActivity send data to SecondActivity
        * and also receive data from SecondActivity
        * */
                Intent intent1 = new Intent(MainActivity.this, ScreenSecond.class);
                intent1.putExtra("val", editText1.getText().toString());
                intent1.putExtra("val2", "Hello");
                intent1.putExtra("chk", s);
                intent1.putExtra("chk1", s2);
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


