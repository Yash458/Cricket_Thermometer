package com.example.cricketthermometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etChrips;
    Button btnCalculate;
    TextView tvResults;
    DecimalFormat formatter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etChrips = findViewById(R.id.etChrips);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);
        formatter = new DecimalFormat("#0.00");

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(etChrips.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int chrips  = Integer.parseInt(etChrips.getText().toString().trim());

                    double temp = (chrips/3.0)+4;
                    String results = "The approximate temperature outside \n is" + formatter.format(temp) + " ° celcius";

                    tvResults.setText(results);
                    tvResults.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}