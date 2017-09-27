package com.example.akader.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class ScreenSecond extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("second activity");
        setContentView(R.layout.activity_second);




          /*
           * getIntent().getExtras() - get data from mainActivity;
           * and show it at toast
           * */

        Bundle bundle = getIntent().getExtras();
        Toast toast = Toast.makeText(getApplicationContext(), bundle.getString("val") + bundle.getString("val2"), Toast.LENGTH_LONG);
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
    }
}
