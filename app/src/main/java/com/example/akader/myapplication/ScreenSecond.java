package com.example.akader.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;


public class ScreenSecond extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);




       /*
        * SeekBar - Working with a SeekBar
        *
        * */

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);


        /*
        * SeekBar - Get SeekBar changed Value
        *
        * */

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(getApplicationContext(), "-" + i, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        /*
        * WebView - Use External URL using webkit engine
        *
        * */

//                WebView webView=(WebView) findViewById(R.id.webView);
//                webView.loadUrl("http://javatpoint.com/");



        /*
        * Rating example
        * setNumStars()- Define how many stars we want to show
        * setRating()-Define how many stars are blinking
        * layout_width,layout_height must be wrap_content
        * */


        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating);



        /*
        * Check for  Auto Complete Text View
        * getResources().getStringArray(R.array.countries) - Used to load Data from XMl file        *
        * ArrayAdapter- Is object of List and its constructor params are ()-
         * Context,android.R.layout.simple_dropdown_item_1line,arrays
        * */

        String[] countriesList = getResources().getStringArray(R.array.countries);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, countriesList);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.actv);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setThreshold(1);



         /*
        * To get Selected Item of Auto Complete Text View
        * adapterView.getItemAtPosition(i) - here i index of selected value       *
        * */


        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("Get Value of");
                String text = (String) adapterView.getItemAtPosition(i);
                System.out.println(text);
            }
        });




         /*
        * Check for  Spinner
        * getResources().getStringArray(R.array.countries) - Used to load Data from XMl file        *
        * ArrayAdapter- Is object of List and its constructor params are ()-
         * Context,android.R.layout.simple_spinner_dropdown_item,arrays
        * */

        String[] countries = getResources().getStringArray(R.array.countries);
        ArrayAdapter<String> arrayAdapters = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, countries);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapters);



         /*
        * To get Selected Item of Auto Complete Text View
        * adapterView.getItemAtPosition(i) - here i index of selected value       *
        * */


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String val = (String) adapterView.getItemAtPosition(i);
                System.out.println(val);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




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





               /*
               * Check and work with Alert showing
               * */


        Button button2 = (Button) findViewById(R.id.bs1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("test");

                /*
                *   show alert using common method
                * */


                AlertDialog a = getAlertDialog(getApplicationContext()).create();
                a.setTitle("Paragon Group");
                a.show();
            }
        });


    }


    /*
    *Create a Alert Dialog box Object which  we call ad-hoc
    * */

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