package com.jss.jssatenmythri2017_18.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jss.jssatenmythri2017_18.adapter.Adapter;
import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.util.Text_Getter_Setter;

import java.util.ArrayList;


public class Games extends Fragment {

     RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] name={"Badminton","Table Tennis","Chess","Carrom",
            "Tug Of War","Cricket","Football","Volleyball",
            "Basketball","Athelitics", "Shot Put","Kabaddi","Fun Games"};
   ArrayList<Text_Getter_Setter> list=new ArrayList<Text_Getter_Setter>();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for(String n:name){
            Text_Getter_Setter text_getter_setter=new Text_Getter_Setter(n);
            list.add(text_getter_setter);
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.Recylerviewid);
        layoutManager=new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter=new Adapter(list,getContext());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_games, container, false);

        // Inflate the layout for this fragment
        return view;
    }


}
