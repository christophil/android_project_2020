package com.example.sportapp.config;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportapp.MainActivity;
import com.example.sportapp.R;
import com.example.sportapp.camera.CameraActivity;
import com.example.sportapp.language.LanguageActivity;

public class DefaultActivity extends AppCompatActivity {

    LinearLayout layout;

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
