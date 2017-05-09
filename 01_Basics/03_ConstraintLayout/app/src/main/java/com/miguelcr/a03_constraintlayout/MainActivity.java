package com.miguelcr.a03_constraintlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView hotelName;
    boolean isHotelOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hotelName = (TextView) findViewById(R.id.textViewHotelName);

        hotelName.setText("Hotel opened");

    }

    public void hotelNameClicked(View view) {
        if(isHotelOpen) {
            hotelName.setText("Hotel closed");
            isHotelOpen = false;
        } else {
            hotelName.setText("Hotel opened");
            isHotelOpen = true;
        }
    }
}
