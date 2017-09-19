package com.jss.jssatenmythri2017_18.activity.coordinator;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.adapter.RVAdapter;
import com.jss.jssatenmythri2017_18.helper.AccessServiceAPI;
import com.jss.jssatenmythri2017_18.helper.Team_Info;
import com.jss.jssatenmythri2017_18.util.Common;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewFixtures extends AppCompatActivity {

    public List<Team_Info> team_infoList;
    RecyclerView rv;
    ProgressDialog progressDialog;
    AccessServiceAPI m_ServiceAccess;
    private String gname;
    private String gtype;
    private String ggen;
    private String round;
    SharedPreferences pr;
    String NAME = "ViewFixtures";
    String GAME_KEY = "gname";
    String GAME_TYPE_KEY = "gtype";
    String GEN_KEY = "ggen";
    String ROUND_KEY = "round";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fixtures);

        pr = getSharedPreferences(NAME,MODE_PRIVATE);

        rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        m_ServiceAccess = new AccessServiceAPI();

        if(getIntent().getExtras().getString("type").equals("back")){
            gname = pr.getString(GAME_KEY,"");
            gtype = pr.getString(GAME_TYPE_KEY,"");
            ggen = pr.getString(GEN_KEY,"");
            round = pr.getString(ROUND_KEY,"");
        }else {
            gname = getIntent().getExtras().getString("gname");
            gtype = getIntent().getExtras().getString("gtype");
            ggen = getIntent().getExtras().getString("ggen");
            round = getIntent().getExtras().getString("round");
        }
        SharedPreferences.Editor editor = pr.edit();
        editor.putString(GAME_KEY,gname);
        editor.putString(GAME_TYPE_KEY,gtype);
        editor.putString(GEN_KEY,ggen);
        editor.putString(ROUND_KEY,round);
        editor.apply();

        init();

    }



    public void init(){
        team_infoList = new ArrayList<>();

        new GetFixedMatch().execute(gname,round);

    }

    public class GetFixedMatch extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Open progress dialog during login
            progressDialog = ProgressDialog.show(ViewFixtures.this, "Please wait...", "Fetching data...", true);
        }

        @Override
        protected Integer doInBackground(String... params) {
            Map<String, String> param = new HashMap<>();

            param.put("gname", params[0]);
            param.put("round", params[1]);

            JSONObject jsonObject;

            try {
                jsonObject = m_ServiceAccess.convertJSONString2Obj(m_ServiceAccess.getJSONStringWithParam_POST(Common.SERVICE_GETMATCH, param));
                JSONArray userObject = jsonObject.getJSONArray("match");
                String g_type,g_gen,t1,t2;
                for(int i = 0; i < userObject.length(); i++){

                    g_type = userObject.getJSONObject(i).getString("g_type");
                    g_gen = userObject.getJSONObject(i).getString("g_gen");
                    if(g_gen .equals(ggen) && g_type.equals(gtype)){

                        t1 = userObject.getJSONObject(i).getString("team1");
                        t2 = userObject.getJSONObject(i).getString("team2");
                        team_infoList.add(new Team_Info(t1,t2));

                    }


                }

                return 1;
            } catch (Exception e) {
                return Common.RESULT_ERROR;
            }

        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            if(result == 1){
                RVAdapter adapter = new RVAdapter(team_infoList, ViewFixtures.this);
                rv.setAdapter(adapter);
                rv.invalidate();
            }else{
                Toast.makeText(ViewFixtures.this,"Oops!! Check your internet connection",Toast.LENGTH_SHORT).show();
            }
        }
    }


}
