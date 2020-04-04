package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //If you wish to use the logs, switch it over to 'warn' and search for "Project".
    //Setting up TAG to be searchable in th logs
    String TAG = "Project";

    //0: is yellow, 1: is red, 2: is empty
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int activePlayer = 0;
    TextView textViewDis;

    public void dropIn(View view) {
        //Setting up the different squares to be recognisable.
        ImageView counter = (ImageView) view;
        //Me just logging which square has been pushed.
        Log.w (TAG, counter.getTag().toString());
        //Setting tappedCounter to be set to the specific block that ahs been pressed
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        //Tracking which colour is in which spot
        gameState[tappedCounter] = activePlayer;
        //This is to set the counter off the screen so that it "falls" into place when tapped.
        counter.setTranslationY(-1500);

        //The code required to change the colour of the coin placement and the player.
        //This is for yellow.
        if (activePlayer ==0 ) {
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
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}
