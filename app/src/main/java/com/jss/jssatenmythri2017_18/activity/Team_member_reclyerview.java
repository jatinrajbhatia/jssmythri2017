package com.jss.jssatenmythri2017_18.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.adapter.Teammember_Adapter;
import com.jss.jssatenmythri2017_18.util.Teamname_getter_setter;

import java.util.ArrayList;

public class Team_member_reclyerview extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Teammember_Adapter teammember_adapter;
    Intent intent;
    ArrayList<String> teammember;
    ArrayList<String> mythri_id;
    Teamname_getter_setter teamname_getter_setter;
    ArrayList<Teamname_getter_setter> teamname_adapter;
    ListView lv;
    String title;
    String name;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_member_reclyerview);
        teammember=new ArrayList<String>();
        mythri_id=new ArrayList<String>();
        intent=getIntent();
        title=intent.getStringExtra("title");
        lv= (ListView) findViewById(R.id.teammemberid);
        teammember.addAll(intent.getExtras().getStringArrayList("teammember"));
        //mythri_id.addAll(intent.getExtras().getStringArrayList("memberid"));
        setTitle("Team Name: "+title);
        arrayAdapter=new ArrayAdapter(getApplicationContext(),R.layout.athelics_single_list,R.id.simple,teammember);
        lv.setAdapter(arrayAdapter);
    }
}
