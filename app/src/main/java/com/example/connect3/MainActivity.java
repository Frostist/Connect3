package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    String TAG = "Project";

    //0 is yellow, 1 is red.
    int activePlayer = 0;

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;

        counter.setTranslationY(-1500);

        if (activePlayer ==0 ) {
            counter.setImageResource(R.drawable.yellow);
            activePlayer = 1;
            Log.w(TAG, "Yellow Placed");
        }

        else {
            counter.setImageResource(R.drawable.red);
            activePlayer = 0;
            Log.w(TAG, "Red Placed");
        }


        counter.animate().translationYBy(1500).rotation(360).setDuration(300);
        Log.w(TAG, "Clicked");
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}
