package com.example.lukeb.calendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragThree extends Fragment {
    View myView;

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // Creates a new view for the fragment. Then, it sets the XML layout file as the contents of the view. Finally, a copy of this new view is returned.
        myView = inflater.inflate(R.layout.fragment_frag_three, container, false);
        return myView;
    }
}
