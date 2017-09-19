package com.jss.jssatenmythri2017_18.activity.coordinator;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.helper.AccessServiceAPI;
import com.jss.jssatenmythri2017_18.util.Common;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class WinnerUpdate extends AppCompatActivity {

    TextView teamone,teamtwo;
    ProgressDialog progressDialog,progressDialog1;
    AccessServiceAPI m_ServiceAccess;
    Button btnupdate;
    int winner = 0;

    SharedPreferences pr;
    String NAME = "ViewFixtures";
    String GAME_KEY = "gname";
    String GAME_TYPE_KEY = "gtype";
    String GEN_KEY = "ggen";

    String gname,gtype,ggen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_update);
        pr = getSharedPreferences(NAME,MODE_PRIVATE);

        gname = pr.getString(GAME_KEY,"");
        gtype = pr.getString(GAME_TYPE_KEY,"");
        ggen = pr.getString(GEN_KEY,"");

        teamone = (TextView)findViewById(R.id.teamone);
        teamtwo = (TextView)findViewById(R.id.teamtwo);

        btnupdate = (Button)findViewById(R.id.btnupdate);

        teamone.setText(getIntent().getExtras().getString("team1"));
        teamtwo.setText(getIntent().getExtras().getString("team2"));

        teamone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                winner = 1;
                teamone.setBackgroundColor(Color.GREEN);
                teamtwo.setBackgroundColor(Color.RED);
            }
        });

        teamtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                winner = 2;
                teamtwo.setBackgroundColor(Color.GREEN);
                teamone.setBackgroundColor(Color.RED);
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(winner == 1){
                    new UpdateWinner().execute(gname,gtype,ggen,teamone.getText().toString());
                }else if(winner == 2){
                    new UpdateWinner().execute(gname,gtype,ggen,teamtwo.getText().toString());
                }else{
                    Toast.makeText(getApplicationContext(),"TAP ON THE WINNER TEAM TO UPDATE",Toast.LENGTH_SHORT).show();
                }
            }
        });
        m_ServiceAccess = new AccessServiceAPI();
    }

    public class UpdateWinner extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Open progress dialog during login
            progressDialog1 = ProgressDialog.show(WinnerUpdate.this, "Please wait...", "Updating...", true);
        }

        @Override
        protected Integer doInBackground(String... params) {
            Map<String, String> param = new HashMap<>();

            param.put("gname", params[0]);
            param.put("gtype", params[1]);
            param.put("ggen", params[2]);
            param.put("tname", params[3]);

            JSONObject jsonObject;

            try {
                jsonObject = m_ServiceAccess.convertJSONString2Obj(m_ServiceAccess.getJSONStringWithParam_POST(Common.SERVICE_UPDATE_WINNER, param));


                return jsonObject.getInt("result");
            } catch (Exception e) {
                return Common.RESULT_ERROR;
            }

        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            progressDialog1.dismiss();
            if (result == 0) {
                Toast.makeText(WinnerUpdate.this, "Winner Updated!!", Toast.LENGTH_SHORT).show();
                if(winner == 2){
                    new UpdateLooser().execute(gname,gtype,ggen,teamone.getText().toString());
                }else if(winner == 1){
                    new UpdateLooser().execute(gname,gtype,ggen,teamtwo.getText().toString());
                }
            } else {
                Toast.makeText(WinnerUpdate.this, "Oops!! something went wrong! Try Again!!", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public class UpdateLooser extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Open progress dialog during login
            progressDialog1 = ProgressDialog.show(WinnerUpdate.this, "Please wait...", "Updating...", true);
        }

        @Override
        protected Integer doInBackground(String... params) {
            Map<String, String> param = new HashMap<>();

            param.put("gname", params[0]);
            param.put("gtype", params[1]);
            param.put("ggen", params[2]);
            param.put("tname", params[3]);

            JSONObject jsonObject;

            try {
                jsonObject = m_ServiceAccess.convertJSONString2Obj(m_ServiceAccess.getJSONStringWithParam_POST(Common.SERVICE_UPDATE_LOOSER, param));


                return jsonObject.getInt("result");
            } catch (Exception e) {
                return Common.RESULT_ERROR;
            }

        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            progressDialog1.dismiss();
            if (result == 0) {
                Toast.makeText(WinnerUpdate.this, "Winner Updated!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(WinnerUpdate.this, ViewFixtures.class);
                intent.putExtra("type","back");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(WinnerUpdate.this, "Oops!! something went wrong! Try Again!!", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
