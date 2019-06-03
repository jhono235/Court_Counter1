package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0, scoreB = 0, toRemainingHome = 3, toRemainingAway = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Methods to update scores for Away

    public void touchdownAway(View view) {
        displayScoreB(scoreB += 6);
    }

    public void extraPointAway(View view) {
        displayScoreB(scoreB += 1);
    }

    public void fieldGoalAway(View view) {
        displayScoreB(scoreB += 3);
    }

    public void safetyAway(View view) {
        displayScoreB(scoreB += 2);
    }

    //Uses a timeout for the away team
    public void awayTimeoutCounter(View view) {
        if (toRemainingAway != 0)
            timeoutsAway(toRemainingAway -= 1);
    }

    //Methods to update score for Home Team

    public void extraPointHome(View view) {
        displayScoreA(scoreA += 1);
    }

    public void touchdownHome(View view) {
        displayScoreA(scoreA += 6);
    }

    public void fieldGoalHome(View view) {
        displayScoreA(scoreA += 3);
    }

    public void safetyHome(View view) {
        displayScoreA(scoreA += 2);
    }

    //Uses a timeout for the home team
    public void homeTimeoutCounter(View view) {
        if (toRemainingHome != 0)
            timeoutsHome(toRemainingHome -= 1);
    }

    //This method resets the score and timeout timer
    public void resetScore(View view) {
        displayScoreA(0);
        displayScoreB(0);
        timeoutsHome(3);
        timeoutsAway(3);
        scoreA = 0;
        scoreB = 0;
        toRemainingHome = 3;
        toRemainingAway = 3;
    }


    private void displayScoreA(int numberA) {
        TextView scoreTextView = findViewById(R.id.teamAScore);
        scoreTextView.setText("" + numberA);

    }

    private void displayScoreB(int numberB) {
        TextView scoreTextView = findViewById(R.id.teamBScore);
        scoreTextView.setText("" + numberB);


    }

    private void timeoutsHome(int number) {
        TextView timeoutsTextView = findViewById(R.id.timeoutsLeftHome);
        timeoutsTextView.setText("" + number);
    }

    private void timeoutsAway(int number) {
        TextView timeoutsTextView = findViewById(R.id.timeoutsLeftAway);
        timeoutsTextView.setText("" + number);
    }
}
