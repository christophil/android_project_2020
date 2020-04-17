package com.example.sportapp.camera;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sportapp.R;

public class CameraGalleryFragment extends Fragment {


    Button button;

    public CameraGalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_camera_gallery, container, false);

        this.button = view.findViewById(R.id.camera_select_picture_button);

        // Inflate the layout for this fragment
        return view;
    }

    public Button getButton() {
        return button;
    }

    public static CameraGalleryFragment newInstance(){
        CameraGalleryFragment fragment = new CameraGalleryFragment();
        return fragment;
    }

}
