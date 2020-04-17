package com.example.sportapp.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sportapp.R;

public class HomeTitleFragment extends Fragment {


    public HomeTitleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home_title, container, false);

        // Inflate the layout for this fragment
        return view;
    }

    public static HomeTitleFragment newInstance(){
        HomeTitleFragment fragment = new HomeTitleFragment();
        return fragment;
    }

}
