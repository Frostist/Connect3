package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //Connect 3 game coded by William Frost

    //If you wish to use the logs, switch it over to 'warn' and search for "Project".
    //Setting up TAG to be searchable in th logs
    String TAG = "Project";
    TextView textViewWon;
    Button buttonStart;

    //0: is yellow, 1: is red, 2: is empty
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    //These are the states that are checked to find out which counters have won
    int[] [] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 7}, {0, 3, 6}, {1, 4,  7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    //This definds which player goes first
    int activePlayer = 0;
    //Setting a value to know when the game finished
    boolean gameActive = true;

    public void dropIn(View view) {
        //Setting up the different squares to be recognisable.
        ImageView counter = (ImageView) view;
        //Me just logging which square has been pushed.
        Log.w(TAG, counter.getTag().toString());
        //Setting tappedCounter to be set to the specific block that ahs been pressed
        int tappedCounter = Integer.parseInt(counter.getTag().toString());


        //This is an if statement to determine if all the code can run below if the space which is being click on is empty or full
        if (gameState[tappedCounter] == 2 && gameActive) {

            //Tracking which colour is in which spot
            gameState[tappedCounter] = activePlayer;
            //This is to set the counter off the screen so that it "falls" into place when tapped.
            counter.setTranslationY(-1500);

            //The code required to change the colour of the coin placement and the player.
            //This is for yellow.
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
                //Me logging the colour placed.
                Log.w(TAG, "Yellow Placed");
            }

            //this is for red.
            else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
                //Me Logging the colour placed.
                Log.w(TAG, "Red Placed");
            }

            //This runs afterwards to drop the coin in place and to do the animations.
            counter.animate().translationYBy(1500).rotation(360).setDuration(300);
            //Me logging that a square has been clicked.
            Log.w(TAG, "Clicked");

            for (int[] winningPosition : winningPositions) {

                //This is to check if someone has won.
                //The 0 is equal to the first number in the series of {0, 1, 2} and 1 is equal to the second number, and three is equal to the third number,
                // so if all three numbers are present and equal to one another then someone has won the game.

                //gameState[winningPosition[0]] == gameState[winningPosition[1]] this is too check the first is equal to the second
                //gameState[winningPosition[1]] == gameState[winningPosition[2]] this is too check the second is equal tot eh third
                //gameState[winningPosition[0]] != 2 this is to check that none of the tokens are equal to 2(which means they are empty)

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {

                    //Printing to the Log someone has won.
                    Log.w(TAG, "Someone has won");

                    gameActive = false;

                    //Setting a string so that it can be replaced by the winners name and can be printed ina  toast
                    String winner;

                    //Setting up a statement to determine who has won.
                    //if the active player by the end of the game is 1 or 0 then print
                    if (activePlayer == 1) {
                        //setting winner to be yellow
                        winner = "Yellow";
                    } else {
                        //setting winner to be red
                        winner = "Red";
                    }
                    //finding views
                    buttonStart = findViewById(R.id.buttonStart);
                    textViewWon = findViewById(R.id.textViewWon);
                    //printing text to textbox
                    textViewWon.setText(String.format("%s Has Won", winner));
                    //Setting them to visable
                    buttonStart.setVisibility(View.VISIBLE);
                    textViewWon.setVisibility(View.VISIBLE);

                }
            }
        }
    }

    public void playAgain(View view) {

        //finding views
        buttonStart = findViewById(R.id.buttonStart);
        textViewWon = findViewById(R.id.textViewWon);
        //setting them to invisible
        buttonStart.setVisibility(View.INVISIBLE);
        textViewWon.setVisibility(View.INVISIBLE);
        //finding the grid layout
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        Log.w(TAG, "Button pressed");

        //This is to loop through all the items in the grid
        //and therefore is used to update them
        for(int i=0; i<gridLayout.getChildCount(); i++) {
            //Defining all the counters as imageviews
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            //setting all the counters to be set to null
            counter.setImageDrawable(null);
        }


        //This code is a repeat of the code at the start of the project and is here to reset the hard to all the default
        //this for loop is to set each value of gameState to its original value
        Arrays.fill(gameState, 2);

        //This defineds which player goes first
        activePlayer = 0;
        //Setting a value to know when the game finished
        gameActive = true;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}
