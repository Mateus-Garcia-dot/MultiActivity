package com.example.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class ShowResult extends AppCompatActivity {
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        result = findViewById(R.id.result);
        Bundle extras = getIntent().getExtras();
        float firstGrade = extras.getFloat("firstGrade");
        float secondGrade = extras.getFloat("secondGrade");
        int attendance = extras.getInt("attendance");

        float gradeAverage = (firstGrade + secondGrade) / 2;

        if (gradeAverage >= 7 && attendance >= 75) {
            result.setText("Aprovado");
            result.setTextColor(Color.BLUE);
        }
        if (gradeAverage >= 4 && gradeAverage <= 6.9 && attendance >= 75) {
            result.setText("Final");
            result.setTextColor(Color.YELLOW);
        }
        if (attendance < 75) {
            result.setText("Reprovado por falta");
            result.setTextColor(Color.RED);
        }
        if (gradeAverage < 4) {
            result.setText("Reprovado por nota");
            result.setTextColor(Color.RED);
        }

    }
}