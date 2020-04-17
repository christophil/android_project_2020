package com.example.sportapp.language;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sportapp.R;
import com.example.sportapp.config.ConfigManager;


public class LanguageFrenchFragment extends Fragment {

    Button selectButton;
    Activity activity;

    public LanguageFrenchFragment() {
        // Required empty public constructor
    }

    public LanguageFrenchFragment(Activity activity) {
        this.activity = activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_language_french, container, false);

        this.selectButton = view.findViewById(R.id.language_french_select_button);

        this.selectButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ConfigManager.setAppLocale("fr", getContext());
                activity.recreate();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public static LanguageFrenchFragment newInstance(Activity activity){
        LanguageFrenchFragment fragment = new LanguageFrenchFragment(activity);
        return fragment;
    }

}
