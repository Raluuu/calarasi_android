package com.miguelcr.a01_duckhunt;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView textViewPlayer, textViewCounter, textViewTimer;
    ImageView duck;

    int duckHunted = 0;
    Random random;
    boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textViewPlayer = (TextView) findViewById(R.id.textViewPlayer);
        textViewCounter = (TextView) findViewById(R.id.textViewCounter);
        textViewTimer = (TextView) findViewById(R.id.textViewTimer);
        duck = (ImageView) findViewById(R.id.imageViewDuck);

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String nick = sharedPref.getString(Constants.PREFERENCE_NAME,null);

        textViewPlayer.setText(nick);

        Typeface type = Typeface.createFromAsset(getAssets(),"pixel.ttf");
        textViewPlayer.setTypeface(type);

        // Hide the toolbar
        getSupportActionBar().hide();

        random = new Random();

        playGame();

    }

    private void playGame() {
        // number of ms 60000ms = 1minute , 1000ms = 1sec to wait between two moments
        new CountDownTimer(6000, 1000) {
            public void onTick(long millisUntilFinished) {
                textViewTimer.setText(millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                textViewTimer.setText("Game over");
                gameOver = true;
            }
        }.start();
    }

    public void duckClicked(View view) {
        if(!gameOver) {
            // Increase the duckHunted var
            duckHunted++;

            // Write the counter in the thextView
            textViewCounter.setText(String.valueOf(duckHunted));

            moveDuck();
        } else {
           showGameOverDialog();
        }
    }

    private void showGameOverDialog() {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setTitle("Game Over")
                .setMessage("You can't continue playing. Select one action to continue...")
                .setCancelable(false);

        // Add the buttons
        builder.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // restart all the data
                gameOver = false;
                duckHunted = 0;
                moveDuck();

                // Restart the countdowntimer
                playGame();


            }
        });
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Destroy the GameActivity
                finish();
            }
        });


        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();

        dialog.show();
    }

    private void moveDuck() {
        // move the duck a another random position
        // 1. Get screen width and height
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int screenWidth = display.getWidth();
        int screenHeight = display.getHeight();

        // Calculate the max values
        int maxX = screenWidth - duck.getWidth();
        int maxY = screenHeight - duck.getHeight();

        // 2. get random numbers in the correct range
        int x = random.nextInt(maxX - 0 + 1) + 0;
        int y = random.nextInt(maxY - 0 + 1) + 0;

        // 3. apply the random coordinates to the imageViewDuck
        duck.setX(x);
        duck.setY(y);
    }
}
