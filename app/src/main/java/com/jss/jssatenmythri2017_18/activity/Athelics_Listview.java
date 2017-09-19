package com.jss.jssatenmythri2017_18.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jss.jssatenmythri2017_18.R;

public class Athelics_Listview extends AppCompatActivity {
  ListView lv;
    ArrayAdapter arrayAdapter;
    String string[]={"100m Running","200m Running","4x100m Relay",
    //"100m 3 Three Legged Race"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athelics__listview);
        lv= (ListView) findViewById(R.id.listView);
        arrayAdapter=new ArrayAdapter(getApplicationContext(),R.layout.athelics_single_list,R.id.simple,string);
        lv.setAdapter(arrayAdapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String string=((TextView)view.findViewById(R.id.simple)).getText().toString();

                    switch(string)
                    {
                        case "100m Running":{
                            Toast.makeText(getApplicationContext(),string,Toast.LENGTH_LONG).show();
                            Intent i=new Intent(getApplicationContext(),GamedetailActivity.class);
                            i.putExtra("title",string);
                            startActivity(i);
                        }break;
                        case "200m Running":{
                            Toast.makeText(getApplicationContext(),string,Toast.LENGTH_LONG).show();
                            Intent i=new Intent(getApplicationContext(),GamedetailActivity.class);
                            i.putExtra("title",string);
                            startActivity(i);
                        }break;
                        case "4x100m Relay":{
                            Toast.makeText(getApplicationContext(),string,Toast.LENGTH_LONG).show();
                            Intent i=new Intent(getApplicationContext(),GamedetailActivity.class);
                            i.putExtra("title",string);
                            startActivity(i);
                        }break;
//                        case "100m 3 Three Legged Race":{
//                            Toast.makeText(getApplicationContext(),string,Toast.LENGTH_LONG).show();
//                            Intent i=new Intent(getApplicationContext(),GamedetailActivity.class);
//                            i.putExtra("title",string);
//                            startActivity(i);
//                        }break;
                    }
                }
            });


    }
}
