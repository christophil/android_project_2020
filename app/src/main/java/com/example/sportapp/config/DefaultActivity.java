package com.example.sportapp.config;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sportapp.MainActivity;
import com.example.sportapp.R;
import com.example.sportapp.camera.CameraActivity;
import com.example.sportapp.language.LanguageActivity;
import com.example.sportapp.matches.AddMatchActivity;
import com.example.sportapp.matches.MatchesActivity;
import com.example.sportapp.statistics.StatisticsActivity;

public class DefaultActivity extends AppCompatActivity {

    LinearLayout layout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.default_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
                break;
            case R.id.language:
                Intent intent2 = new Intent(this, LanguageActivity.class);
                this.startActivity(intent2);
                break;
            case R.id.camera:
                Intent intent3 = new Intent(this, CameraActivity.class);
                this.startActivity(intent3);
                break;
            case R.id.matches:
                Intent intent4 = new Intent(this, MatchesActivity.class);
                this.startActivity(intent4);
                break;
            case R.id.statistics:
                Intent intent5 = new Intent(this, StatisticsActivity.class);
                this.startActivity(intent5);
                break;
            case R.id.add_match:
                Intent intent6 = new Intent(this, AddMatchActivity.class);
                this.startActivity(intent6);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        ConfigManager.setOrientation(this, layout);
    }
}
