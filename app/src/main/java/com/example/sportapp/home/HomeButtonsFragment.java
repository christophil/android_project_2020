package com.example.sportapp.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sportapp.R;
import com.example.sportapp.statistics.StatisticsActivity;


public class HomeButtonsFragment extends Fragment {

    Button statisticsButton;

    public HomeButtonsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home_buttons, container, false);

        this.statisticsButton = view.findViewById(R.id.home_statistics_button);

        this.statisticsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getContext(), StatisticsActivity.class);
                startActivity(i);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public static HomeButtonsFragment newInstance(){
        HomeButtonsFragment fragment = new HomeButtonsFragment();
        return fragment;
    }

}
