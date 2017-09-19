package com.jss.jssatenmythri2017_18.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jss.jssatenmythri2017_18.R;


public class About extends Fragment {

  TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_about, container, false);

        // Inflate the layout for this fragment
        return view;
    }


}
