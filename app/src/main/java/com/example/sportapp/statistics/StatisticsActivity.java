package com.example.sportapp.statistics;

import com.example.sportapp.R;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.sportapp.config.ConfigManager;
import com.example.sportapp.config.DefaultActivity;
import com.example.sportapp.database.SqlLiteDatabaseManager;


public class StatisticsActivity extends DefaultActivity {

    private SqlLiteDatabaseManager database;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        this.database = new SqlLiteDatabaseManager(this);

        int matches = this.database.getMatchCount();
        int players = this.database.getPlayerCount();

        layout = findViewById(R.id.linearlayout_id);

        Fragment playersFragment = PlayersFragment.newInstance(players);
        Fragment matchesFragment = MatchesFragment.newInstance(matches);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.players_container, playersFragment)
                .replace(R.id.matches_container, matchesFragment)
                .commit();

        ConfigManager.setOrientation(this, layout);
    }
}
