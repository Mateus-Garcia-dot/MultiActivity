package com.example.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText firstGrade;
    EditText secondGrade;
    EditText attendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.firstGrade = findViewById(R.id.firstGrade);
        this.firstGrade.setFilters(new InputFilter[]{new MinMaxInputFilter(0,10)});
        this.secondGrade = findViewById(R.id.secondGrade);
        this.secondGrade.setFilters(new InputFilter[]{new MinMaxInputFilter(0,10)});
        this.attendance = findViewById(R.id.attendance);
        this.attendance.setFilters(new InputFilter[]{new MinMaxInputFilter(0,100)});
    }

    public void calculate(View view) {
        Intent intent = new Intent(this, ShowResult.class);
        intent.putExtra("firstGrade", Float.parseFloat(firstGrade.getText().toString()));
        intent.putExtra("secondGrade", Float.parseFloat(secondGrade.getText().toString()));
        intent.putExtra("attendance", Integer.parseInt(attendance.getText().toString()));
        startActivity(intent);

    }
}
