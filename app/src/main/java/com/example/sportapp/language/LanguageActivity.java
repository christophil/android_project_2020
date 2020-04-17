package com.example.sportapp.language;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.sportapp.R;
import com.example.sportapp.config.ConfigManager;
import com.example.sportapp.config.DefaultActivity;

public class LanguageActivity extends DefaultActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);


        layout = findViewById(R.id.linearlayout_id);

        Fragment englishFragment = LanguageEnglishFragment.newInstance(this);
        Fragment frenchFragment = LanguageFrenchFragment.newInstance(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.english_container, englishFragment)
                .replace(R.id.french_container, frenchFragment)
                .commit();

        ConfigManager.setOrientation(this, layout);
    }
}
