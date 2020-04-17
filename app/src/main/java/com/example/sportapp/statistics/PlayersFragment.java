package com.example.sportapp.statistics;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sportapp.R;


public class PlayersFragment extends Fragment {

    TextView playerCountView;
    int playerCount;


    public PlayersFragment() {
        // Required empty public constructor
    }

    public PlayersFragment(int playerCount) {
        this.playerCount = playerCount;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_players, container, false);

        this.playerCountView = view.findViewById(R.id.player_count_view);

        this.playerCountView.setText(this.playerCount + "");



        // Inflate the layout for this fragment
        return view;

    }

    public static PlayersFragment newInstance(int playerCount){
        PlayersFragment fragment = new PlayersFragment(playerCount);
        return fragment;
    }
}
