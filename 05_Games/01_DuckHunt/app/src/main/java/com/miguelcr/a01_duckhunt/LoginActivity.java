package com.miguelcr.a01_duckhunt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText editTextNick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNick = (EditText) findViewById(R.id.editTextName);

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String lastName = sharedPref.getString(Constants.PREFERENCE_NAME,null);

        if(lastName!=null) {
            editTextNick.setText(lastName);
        }

    }

    public void startGame(View view) {
        // Launch the GameActivity
        String nick = editTextNick.getText().toString();

        if(nick.trim().equals("")) {
            Toast.makeText(this, "Write a nick please!", Toast.LENGTH_SHORT).show();
            editTextNick.setError("Nick is required");
        } else {
            // Edit the preferences file to save the last nick written
            SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(Constants.PREFERENCE_NAME,nick);
            editor.commit();

            Intent i = new Intent(LoginActivity.this, GameActivity.class);

            startActivity(i);
        }
    }
}
