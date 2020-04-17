package com.example.sportapp.camera;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sportapp.R;

public class CameraCameraFragment extends Fragment {


    Button button;

    public CameraCameraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_camera_camera, container, false);

        this.button = view.findViewById(R.id.camera_take_picture_button);

        // Inflate the layout for this fragment
        return view;
    }

    public Button getButton() {
        return button;
    }

    public static CameraCameraFragment newInstance(){
        CameraCameraFragment fragment = new CameraCameraFragment();
        return fragment;
    }

}
