package com.example.sportapp.matches;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.sportapp.R;
import com.example.sportapp.config.DefaultActivity;
import com.example.sportapp.database.SqlLiteDatabaseManager;
import com.example.sportapp.database.models.MatchModel;
import com.example.sportapp.statistics.StatisticsActivity;

import java.util.ArrayList;

public class MatchesActivity extends DefaultActivity {

    private android.widget.ListView listView;
    private SqlLiteDatabaseManager database;
    private Button addMatchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        listView = (ListView) findViewById(R.id.list_view);
        addMatchButton = (Button) findViewById(R.id.add_match_button);

        this.addMatchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddMatchActivity.class);
                startActivity(i);
            }
        });

        this.database = new SqlLiteDatabaseManager(this);

        ArrayList<MatchModel> matchModels = this.database.getAllmatches();

        ArrayList<String> matchs = new ArrayList<String>();

        for(MatchModel match: matchModels){
            matchs.add(match.toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MatchesActivity.this,
                android.R.layout.simple_list_item_1, matchs);
        listView.setAdapter(adapter);
    }
}
