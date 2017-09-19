package com.jss.jssatenmythri2017_18.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jss.jssatenmythri2017_18.R;

public class Athelictics_detail extends AppCompatActivity {
    ListView listView;
    String[] strings = {"100m Running", "200m Running", "4x100m Running", "100m Three Legged Race"};
    ArrayAdapter arrayAdapter;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athelictics_detail);
        arrayAdapter = new ArrayAdapter(getApplicationContext(),R.layout.athelics_single_list,R.id.simple, strings);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);
    }
}
