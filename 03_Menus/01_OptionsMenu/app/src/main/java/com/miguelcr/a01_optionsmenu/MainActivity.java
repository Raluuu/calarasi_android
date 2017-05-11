package com.miguelcr.a01_optionsmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // We load the menu in this activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_new_message:
                newMessage();
                return true;
            case R.id.action_take_photo:
                takePhoto();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void takePhoto() {
        Toast.makeText(this, "Are you sure? You don't have a good camera!", Toast.LENGTH_SHORT).show();
    }

    private void newMessage() {
        Toast.makeText(this, "I know that you want to write a new message. Try later, I'm coding!", Toast.LENGTH_SHORT).show();
    }
}
