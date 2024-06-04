package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;

import android.widget.TextView;


import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    /*
    Instantiating variables for the score, number of misses, and the high score.
     */
    int scoret = 0;
    //tcoret stands for score text, it represents the numeric value that will be in the score text field
    int missest = -1;
    //missest represents misses text, it will represent the number of misses that the player has done.
    int delay = 3000;
    //This is the initial delay (in milli) of the moles 3 seconds
    boolean clicked = false;
    //This is a checker to see if the button with mole is clicked or not, default is false since no button has been clicked yet.
    ArrayList<ImageView> ButtonList = new ArrayList<>();
    //This array will hold all of the buttons in order of their creation, index 0 will be button 1, 1 will be button 2 etc.
    int highscore = 0;
    //This value shows the high score since the app started.





    /**
     * Creates the app and all of its elements
     * @param savedInstanceState previous state (not used)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences scores;
        scores = getSharedPreferences("Highscores",0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Adding text views to display scores
        TextView score = findViewById(R.id.textView);
        TextView misses = findViewById(R.id.textView2);
        TextView HS = findViewById(R.id.textView5);
        HS.setText(highscore);
        //This button restarts the game once the game is over.
        Button restart = findViewById(R.id.button);

        //Contains the audio file for when the mole is hit
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.bonk);

        //Loading and adding mole buttons to the array.
        ImageView Button1 = findViewById(R.id.Button1);
        ButtonList.add(Button1);
        ImageView Button2 = findViewById(R.id.Button2);
        ButtonList.add(Button2);
        ImageView Button3 = findViewById(R.id.Button3);
        ButtonList.add(Button3);
        ImageView Button4 = findViewById(R.id.Button4);
        ButtonList.add(Button4);
        ImageView Button5 = findViewById(R.id.Button5);
        ButtonList.add(Button5);
        ImageView Button6 = findViewById(R.id.Button6);
        ButtonList.add(Button6);
        ImageView Button7 = findViewById(R.id.Button7);
        ButtonList.add(Button7);
        ImageView Button8 = findViewById(R.id.Button8);
        ButtonList.add(Button8);
        ImageView Button9 = findViewById(R.id.Button9);
        ButtonList.add(Button9);

        game(score,misses,HS,mp,restart);


        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences HS;
        HS = getSharedPreferences("Highscores", Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = HS.edit();
        edit.putInt("HS",highscore);
    }

    /**
     * Runs the game using handles and delays which get reset when the game is reset.
     * @param scoreView the score visible to the player
     * @param missView the number of misses a player has made
     * @param hsView the high score shown to the user
     * @param sound the sound file to be played when a mole is hit
     * @param rest the restart button
     */
        public void game(TextView scoreView, TextView missView, TextView hsView, MediaPlayer sound,Button rest)
        {
            Handler h = new Handler();
            Random mole = new Random();



            //Game is run here
            h.post(new Runnable() {
                @Override
                public void run() {
                    //Check the number of misse
                    if (missest >= 4){
                        //Display Game over
                        missView.setText("Game Over");
                        //If high score has been broken, set new record
                        if (scoret>highscore) {
                            highscore = scoret;
                            
                        }
                        //Show the restart button to the player
                        rest.setVisibility(View.VISIBLE);
                        //If the button is clicked, the game will reset all scores and delays and recall run() from line 84.
                        rest.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                scoret = 0;
                                missest = -1;
                                clicked = false;
                                delay = 3000;
                                run();
                            }
                        });
                        return;
                    }

                    //Remove the button from visibility
                    rest.setVisibility(View.INVISIBLE);
                    //Display all number values
                    scoreView.setText(Integer.toString(scoret));
                    missView.setText(Integer.toString(missest));
                    hsView.setText(Integer.toString(highscore));

                    //Clear all previous moles at each delay interval so there are not multiple moles on the board at once.
                    for (int i = 0; i<=8; i++)
                    {
                        ButtonList.get(i).clearColorFilter();
                    }

                    //Generate random location for mole.
                    int w = mole.nextInt(9);

                    //Set the color to the square to indicate the mole's location
                    ButtonList.get(w).setColorFilter(Color.parseColor("Blue"));
                    //Allow user to click on the mole
                    ButtonList.get(w).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //Increase score
                            scoret++;
                            //Play sound effect
                            sound.start();
                            //decrease time delay
                            delay -= 100;
                            //Remove the mole from the tile
                            ButtonList.get(w).clearColorFilter();
                            //Set clicked to be true
                            clicked = true;
                            //Do not allow the button to be clicked again
                            ButtonList.get(w).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    //Do nothing
                                }
                            });
                        }
                    });


                    //If the button was clicked reset the clicked variable and restart the loop
                    if(clicked){

                        clicked = false;
                        h.postDelayed(this, delay);
                    }
                    //If the button was not clicked increase the number of misses by 1 and continue the loop
                    else{

                        missest++;
                        h.postDelayed(this, delay);
                    }
                }
            });
        }

    }




