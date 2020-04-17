package com.example.sportapp.statistics;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sportapp.R;

public class MatchesFragment extends Fragment {

    TextView matchesCountView;
    int matchesCount;


    public MatchesFragment() {
        // Required empty public constructor
    }

    public MatchesFragment(int matchesCount) {
        this.matchesCount = matchesCount;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_matches, container, false);

        this.matchesCountView = view.findViewById(R.id.match_count_view);

        this.matchesCountView.setText(this.matchesCount + "");



        // Inflate the layout for this fragment
        return view;

    }

    public static MatchesFragment newInstance(int matchesCount){
        MatchesFragment fragment = new MatchesFragment(matchesCount);
        return fragment;
    }
}
