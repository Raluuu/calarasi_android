package com.miguelcr.a04_androidcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView screen;
    int number1, number2;
    String operation;
    String number = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView)findViewById(R.id.textViewScreen);
    }

    public void numberClicked(View view) {
        // Set the number into the TextView screen

        int idButtonClicked = view.getId(); // R.id.button7, R.id.button8
        String screenText = screen.getText().toString();


        if(idButtonClicked==R.id.button7) {
            number = "7";
        } else if(idButtonClicked==R.id.button8) {
            number = "8";
        }

        // Set text current number where user clicked
        if(screenText.equals("0")) {
            screen.setText(number);
        } else {
            screen.setText(screenText + number);
        }


    }


    public void operationClicked(View view) {
        String screenText = screen.getText().toString();

        if(!screenText.equals("")) {
            number1 = Integer.parseInt(screenText);

            // Clear the screen text to write the 2nd number
            screen.setText("");

            int id = view.getId();

            switch (id) {
                case R.id.buttonAdd:
                    operation = "+";
                    break;
                case R.id.buttonDiv:
                    operation = "/";
                    break;
                case R.id.buttonMul:
                    operation = "x";
                    break;
            }
        }

    }

    public void equalClicked(View view) {
        number2 = Integer.parseInt(screen.getText().toString());
        int result = 0;

        if(operation.equals("+")) {
            result = number1 + number2;
        } else if(operation.equals("/")) {
            result = number1 / number2;
        } else if(operation.equals("x")) {
            result = number1 * number2;
        }

        screen.setText(String.valueOf(result));
    }
}
