package com.example.assignment2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AnimalDisplayFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //inflate animal_display.xml
        View view = inflater.inflate(R.layout.activity_main, container, false);
        //find the views that are going to be accessed often only once in onCreateView
        //assign those views to member variables so we can reference them as many times as we want later on
        /*mBirdDescription = view.findViewById(R.id.bird_description);
        mCatDescription = view.findViewById(R.id.cat_description);
        mDogDescription = view.findViewById(R.id.dog_description);*/
        return view; //return the view that we inflated. It's going to be used as the main view of this fragment
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //once activity is created, lets attach the listeners.
        //addImageClickListeners();
        //addButtonClickListeners();
    }
}
