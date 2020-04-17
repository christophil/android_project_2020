package com.example.sportapp.matches;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sportapp.R;
import com.example.sportapp.config.DefaultActivity;
import com.example.sportapp.database.SqlLiteDatabaseManager;
import com.example.sportapp.database.models.MatchModel;

public class AddMatchActivity extends DefaultActivity {

    private Button saveMatchButton;
    private EditText playerOneEditText;
    private EditText playerTwoEditText;
    private EditText resultEditText;
    private SqlLiteDatabaseManager database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_match);

        this.database = new SqlLiteDatabaseManager(this);

        saveMatchButton = (Button) findViewById(R.id.save_match_button);
        playerOneEditText = (EditText) findViewById(R.id.player_one_edit);
        playerTwoEditText = (EditText) findViewById(R.id.player_two_edit);
        resultEditText = (EditText) findViewById(R.id.result_edit);

        this.saveMatchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(playerOneEditText.getText().toString().trim().length() > 0 && playerTwoEditText.getText().toString().trim().length() > 0 && resultEditText.getText().toString().trim().length() > 0){

                    boolean added = database.addMatch(new MatchModel(0, playerOneEditText.getText().toString().trim(), playerTwoEditText.getText().toString().trim(), resultEditText.getText().toString().trim()));

                    if(added){
                        Intent i = new Intent(getApplicationContext(), MatchesActivity.class);
                        startActivity(i);
                    }
                }
            }
        });
    }
}
