package com.example.akader.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ScreenSecond extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        /*
        * Check and work with Alert showing
        * */

        setContentView(R.layout.activity_second);







        /*
           * getIntent().getExtras() - get data from mainActivity;
           * and show it at toast
           * */

        final Bundle bundle = getIntent().getExtras();
        Toast toast = Toast.makeText(getApplicationContext(), bundle.getString("val")
                        + bundle.getString("val2") + bundle.getString("chk") + bundle.getString("chk1"),
                Toast.LENGTH_LONG);
        toast.setMargin(300, 500);
        toast.show();
        Button button = (Button) findViewById(R.id.bs);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.set1);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                /*
                *   Send result to mainActivity and finish the intent
                *
                * */
                intent.putExtra("Msg", editText.getText().toString());
                setResult(2121, intent);
                finish();
            }
        });


        Button button2 = (Button) findViewById(R.id.bs1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("test");
                AlertDialog a = getAlertDialog(getApplicationContext()).create();
                a.setTitle("Paragon Group");
                a.show();
            }
        });


    }

    private AlertDialog.Builder getAlertDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.alertMsg)).
                setCancelable(true).
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.out.println("printing");
//                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        return builder;
    }

}