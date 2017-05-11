package com.miguelcr.a01_simplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StudentDetailActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        textView = (TextView) findViewById(R.id.textViewName);

        // Get the variables from the Intent
        Bundle extras = getIntent().getExtras();
        String stuName = extras.getString("name");
        int stuAge = extras.getInt("age");

        textView.setText(stuName+" "+stuAge);
    }
}
