package com.example.datepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{
    EditText editText;
    int d,m,y;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);


        Calendar ca=Calendar.getInstance();
        d=ca.get(Calendar.DAY_OF_MONTH);
        m=ca.get(Calendar.MONTH);
        y=ca.get(Calendar.YEAR);


        editText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new DatePickerDialog(MainActivity.this,listener,y,m,d).show();
            }
        });
    }

    DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
        {
            editText.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            y=year;
            m=month;
            d=dayOfMonth;
        }
    };
}
