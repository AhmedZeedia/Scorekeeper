package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScore1;
    private int mScore2;
    private TextView mtext1;
    private TextView mtext2;
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtext1 = (TextView)findViewById(R.id.score_1);
        mtext2 = (TextView)findViewById(R.id.score_2);
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){

            case R.id.decreaseTeam1:
                mScore1--;
                mtext1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                mScore2--;
                mtext2.setText(String.valueOf(mScore2));
                break;
        }
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){
            case R.id.increaseTeam1:
                mScore1++;
                mtext1.setText(String.valueOf(mScore1));
                break;

            case R.id.increaseTeam2:
                mScore2++;
                mtext2.setText(String.valueOf(mScore2));
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        // Change the label of the menu based on the state of the app.
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Check if the correct item was clicked.
        if (item.getItemId() == R.id.night_mode) {
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            // Set the theme mode for the restarted activity.
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
            // Recreate the activity for the theme change to take effect.
            recreate();
        }
        return true;
    }

    /**
     * Method that is called when the configuration changes,
     * used to preserve the state of the app.
     *
     * @param outState The bundle that will be passed in to the Activity when it is restored.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the scores.
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }
}
