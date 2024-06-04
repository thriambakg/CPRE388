package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int seconds = 0;

    private boolean running;

    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {

            // Get the previous state of the stopwatch
            // if the activity has been
            // destroyed and recreated.
            seconds
                    = savedInstanceState
                    .getInt("seconds");
            running
                    = savedInstanceState
                    .getBoolean("running");
            wasRunning
                    = savedInstanceState
                    .getBoolean("wasRunning");
        }

        Button startstop = findViewById(R.id.button);
        Button reset = findViewById(R.id.button2);

        startstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (startstop.getText().toString() == getResources().getString(R.string.start))
                {
                    startstop.setText(R.string.stop);
                    onClickStart(view);

                }
                else
                {
                    startstop.setText(R.string.start);
                    onClickStop(view);

                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickReset(view);
            }
        });
        runTimer();
    }

    @Override
    public void onSaveInstanceState(
            Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState
                .putInt("seconds", seconds);
        savedInstanceState
                .putBoolean("running", running);
        savedInstanceState
                .putBoolean("wasRunning", wasRunning);
    }


    protected void onPause()
    {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    protected void onResume()
    {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    public void onClickStart(View view)
    {
        running = true;
    }

    public void onClickStop(View view)
    {
        running = false;
    }

    public void onClickReset(View view)
    {
        running = false;
        seconds = 0;
    }

    private void runTimer()
    {

        // Get the text view.
        final TextView timeView = findViewById(R.id.textView);

        // Creates a new Handler
        final Handler handler = new Handler();

        // Call the post() method,
        // passing in a new Runnable.
        // The post() method processes
        // code without a delay,
        // so the code in the Runnable
        // will run almost immediately.
        handler.post(new Runnable() {
            @Override

            public void run()
            {
                int hours = seconds / 36000;
                int minutes = (seconds) / 600;
                int secs = seconds / 10;
                int ts = seconds %10;

                // Format the seconds into hours, minutes,
                // and seconds.
                String time
                        = String
                        .format(Locale.getDefault(),
                                "%d:%02d:%02d:%d", hours,
                                minutes, secs,ts);



                // Set the text view text.
                timeView.setText(time);

                // If running is true, increment the
                // seconds variable.
                if (running) {
                    seconds++;
                }

                // Post the code again
                // with a delay of 1 second.
                handler.postDelayed(this, 100);
            }
        });
    }

}