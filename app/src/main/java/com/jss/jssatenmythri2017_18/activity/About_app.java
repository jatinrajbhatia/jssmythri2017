package com.jss.jssatenmythri2017_18.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jss.jssatenmythri2017_18.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link About_app.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link About_app#newInstance} factory method to
 * create an instance of this fragment.
 */
public class About_app extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_app, container, false);
    }
}
