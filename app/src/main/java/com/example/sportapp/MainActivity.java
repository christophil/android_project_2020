package com.example.sportapp;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.sportapp.R;
import com.example.sportapp.config.ConfigManager;
import com.example.sportapp.config.DefaultActivity;
import com.example.sportapp.home.HomeButtonsFragment;
import com.example.sportapp.home.HomeTitleFragment;
import com.example.sportapp.language.LanguageEnglishFragment;
import com.example.sportapp.language.LanguageFrenchFragment;


public class MainActivity extends DefaultActivity {

    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.linearlayout_main);

        Fragment buttonsFragment = HomeButtonsFragment.newInstance();
        Fragment titleFragment = HomeTitleFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.buttons_container, buttonsFragment)
                .replace(R.id.title_container, titleFragment)
                .commit();

        ConfigManager.setOrientation(this, layout);
    }


}
