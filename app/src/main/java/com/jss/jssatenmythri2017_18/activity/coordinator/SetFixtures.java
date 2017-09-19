package com.jss.jssatenmythri2017_18.activity.coordinator;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.adapter.TeamListViewAdapter;
import com.jss.jssatenmythri2017_18.helper.AccessServiceAPI;
import com.jss.jssatenmythri2017_18.helper.Team;
import com.jss.jssatenmythri2017_18.util.Common;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SetFixtures extends AppCompatActivity {

    ArrayList<Team> myTeams;
    TeamListViewAdapter myAdapter;
    ListView myListView;
    Button myButton;
    AccessServiceAPI m_ServiceAccess;
    ProgressDialog progressDialog, progressDialog1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //fetch team names and put them into myTeams array

        gname = getIntent().getExtras().getString("gname");
        gtype = getIntent().getExtras().getString("gtype");
        ggen = getIntent().getExtras().getString("ggen");
        round = getIntent().getExtras().getString("round");


        myTeams = new ArrayList<Team>();


        m_ServiceAccess = new AccessServiceAPI();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_match);
        getTeamNames();

        myListView = (ListView) findViewById(R.id.myListView);
        myButton = (Button) findViewById(R.id.buttonStart);
        // Construct our adapter, using our own layout and myTeams

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Team> selectedTeams = new ArrayList<Team>();
                final SparseBooleanArray checkedItems = myListView.getCheckedItemPositions();
                int checkedItemsCount = checkedItems.size();
                for (int i = 0; i < checkedItemsCount; ++i) {
                    // Item position in adapter
                    int position = checkedItems.keyAt(i);
                    // Add team if item is checked == TRUE!
                    if (checkedItems.valueAt(i)) {
                        selectedTeams.add(myAdapter.getItem(position));
                    }
                }

                if (selectedTeams.size() < 2) {
                    Toast.makeText(getBaseContext(), "Need to select atleast two teams.", Toast.LENGTH_SHORT).show();
                    for (int j = 0; j < checkedItemsCount; j++) {
                        int position = checkedItems.keyAt(j);
                        myListView.setItemChecked(position, false);
                    }
                    myAdapter.notifyDataSetChanged();
                } else {
                    if (selectedTeams.size() > 2) {
                        Toast.makeText(getBaseContext(), "Need to select only two teams.", Toast.LENGTH_SHORT).show();
                        for (int j = 0; j < checkedItemsCount; j++) {
                            int position = checkedItems.keyAt(j);
                            myListView.setItemChecked(position, false);
                        }
                        myAdapter.notifyDataSetChanged();
                    } else {
                        String team1 = selectedTeams.get(0).getTeamName();
                        String team2 = selectedTeams.get(1).getTeamName();
                        for (int j = 0; j < checkedItemsCount; j++) {
                            int position = checkedItems.keyAt(j);
                            myListView.setItemChecked(position, false);
                            myTeams.remove(position);
                            myAdapter.remove(myAdapter.getItem(position));
                        }
                        myAdapter.notifyDataSetChanged();
                        new TaskLogin().execute(gname, gtype, ggen, round, team1, team2);
                    }
                }
            }
        });
    }

    String gname;
    String gtype;
    String ggen;
    String round;

    private void getTeamNames() {


        new FixMatch().execute(gname, gtype, ggen, round);

    }

    public class TaskLogin extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Open progress dialog during login
            progressDialog = ProgressDialog.show(SetFixtures.this, "Please wait...", "Fetching Team list...", true);
        }

        @Override
        protected Integer doInBackground(String... params) {
            Map<String, String> param = new HashMap<>();

            param.put("gname", params[0]);
            param.put("gtype", params[1]);
            param.put("ggen", params[2]);
            param.put("round", params[3]);
            param.put("team1", params[4]);
            param.put("team2", params[5]);

            JSONObject jsonObject;

            try {
                jsonObject = m_ServiceAccess.convertJSONString2Obj(m_ServiceAccess.getJSONStringWithParam_POST(Common.SERVICE_SETMATCH, param));
                return jsonObject.getInt("result");
            } catch (Exception e) {
                return Common.RESULT_ERROR;
            }

        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            if (result == 0) {
                Toast.makeText(SetFixtures.this, "Match Set!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SetFixtures.this, "Oops!! Check your internet connection", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class FixMatch extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Open progress dialog during login
            progressDialog1 = ProgressDialog.show(SetFixtures.this, "Please wait...", "Processing...", true);
        }

        @Override
        protected Integer doInBackground(String... params) {
            Map<String, String> param = new HashMap<>();

            param.put("gname", params[0]);
            param.put("gtype", params[1]);
            param.put("ggen", params[2]);
            param.put("win", params[3]);

            JSONObject jsonObject;

            try {
                jsonObject = m_ServiceAccess.convertJSONString2Obj(m_ServiceAccess.getJSONStringWithParam_POST(Common.SERVICE_GAMEUSERS, param));
                JSONArray userObject = jsonObject.getJSONArray("gamers");
                for (int i = 0; i < userObject.length(); i++) {
                    myTeams.add(new Team(userObject.getJSONObject(i).getString("t_name")));
                }
                return 1;
            } catch (Exception e) {
                return Common.RESULT_ERROR;
            }

        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            progressDialog1.dismiss();
            if (result == 1) {
                myAdapter = new TeamListViewAdapter(SetFixtures.this, R.layout.row_team_layout, myTeams);
                myListView.setAdapter(myAdapter);
                myListView.setItemsCanFocus(false);
            } else {
                Toast.makeText(SetFixtures.this, "Oops!! something went wrong! Try Again!!", Toast.LENGTH_SHORT).show();
            }

        }
    }

}
