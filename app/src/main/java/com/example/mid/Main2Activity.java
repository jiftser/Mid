package com.example.mid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    EditText edit1;
    EditText edit2;
    RadioButton rd1;
    RadioButton rd2;
    Button submit;
    TextView text1;
    Button bttn1;
    Button bttn2;
    TextView text2;
    TextView text3;
    Button bttn3;
    Button bttn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edit1 = (EditText)findViewById(R.id.editText);
        edit2 = (EditText)findViewById(R.id.editText2);
        rd1 = (RadioButton)findViewById(R.id.radioButton);
        rd2 = (RadioButton)findViewById(R.id.radioButton2);
        submit = (Button)findViewById(R.id.button3);
        text1 = (TextView)findViewById(R.id.textView8);
        bttn1 = (Button)findViewById(R.id.button4);
        bttn2 = (Button)findViewById(R.id.button5);
        text2 = (TextView)findViewById(R.id.textView10);
        text3 = (TextView)findViewById(R.id.textView12);
        bttn3 = (Button)findViewById(R.id.button6);
        bttn4 = (Button)findViewById(R.id.button7);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit1.getText().toString();
                String yearS = edit2.getText().toString();
                int year = Integer.parseInt(yearS);
                if(rd1.isChecked()){
                    text1.setText("Hi Mr "+name+", You are "+(2020-year)+" years old.");
                } else if(rd2.isChecked()){
                    text1.setText("Hi Miss "+name+", You are "+(2020-year)+" years old.");
                }
            }
        });
        bttn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                new DatePickerDialog(Main2Activity.this, d,
                        c.get(Calendar.YEAR),
                        c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        bttn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                new DatePickerDialog(Main2Activity.this, d2,
                        c.get(Calendar.YEAR),
                        c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        bttn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
            }
        });
        bttn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, Main3Activity.class));
            }
        });
    }
    Calendar c = Calendar.getInstance();
    DateFormat txtDate = DateFormat.getDateInstance();
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year,
                              int monthOfYear, int dayOfMonth) {
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, monthOfYear);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            text2.setText("You chose to leave on "+
                    txtDate.format(c.getTime()));
        }
    };
    DatePickerDialog.OnDateSetListener d2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year,
                              int monthOfYear, int dayOfMonth) {
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, monthOfYear);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            text3.setText("You chose to come back on "+
                    txtDate.format(c.getTime()));
        }
    };
}
