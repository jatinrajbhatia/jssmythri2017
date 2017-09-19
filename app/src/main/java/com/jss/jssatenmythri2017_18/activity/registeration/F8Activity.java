package com.jss.jssatenmythri2017_18.activity.registeration;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.helper.AccessServiceAPI;
import com.jss.jssatenmythri2017_18.util.Common;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class F8Activity extends AppCompatActivity {
    private EditText Teamname,player1,player2,player3,player4,player5,player6,player7,player8;
    private Button submit;
    String tname,pid1,pid2,pid3,pid4,pid5,pid6,pid7,pid8;
    String game,type,gender;
    String[] userid;
    private AccessServiceAPI m_AccessServiceAPI;
    private ProgressDialog m_ProgresDialog;
    int a=0;
    int nos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f8);
        Teamname=(EditText) findViewById(R.id.teamname);
        player1=(EditText) findViewById(R.id.p1);
        player2=(EditText) findViewById(R.id.p2);
        player3=(EditText) findViewById(R.id.p3);
        player4=(EditText) findViewById(R.id.p4);
        player5=(EditText) findViewById(R.id.p5);
        player6=(EditText) findViewById(R.id.p6);
        player7=(EditText) findViewById(R.id.p7);
        player8 =(EditText) findViewById(R.id.p8);

        m_AccessServiceAPI = new AccessServiceAPI();
        Intent i=getIntent();
        game= i.getStringExtra("game");
        type=i.getStringExtra("type");
        gender=i.getStringExtra("gender");
        nos = i.getExtras().getInt("nos");

        switch(nos){
            case 1:
                player2.setVisibility(View.GONE);
                player3.setVisibility(View.GONE);
                player4.setVisibility(View.GONE);
                player5.setVisibility(View.GONE);
                player6.setVisibility(View.GONE);
                player7.setVisibility(View.GONE);
                player8.setVisibility(View.GONE);
                break;
            case 2:
                player3.setVisibility(View.GONE);
                player4.setVisibility(View.GONE);
                player5.setVisibility(View.GONE);
                player6.setVisibility(View.GONE);
                player7.setVisibility(View.GONE);
                player8.setVisibility(View.GONE);
                break;
            case 4:
                player5.setVisibility(View.GONE);
                player6.setVisibility(View.GONE);
                player7.setVisibility(View.GONE);
                player8.setVisibility(View.GONE);
                break;
            case 6:
                player7.setVisibility(View.GONE);
                player8.setVisibility(View.GONE);
                break;
            case 7:
                player8.setVisibility(View.GONE);
                break;
            case 8:
                break;
        }

    }

    public void btnEnter_Click(View v) {

        if("".equals(Teamname.getText().toString())) {
            Teamname.setError("Teamname is required!");
            return;
        }
        tname = Teamname.getText().toString();

        switch (nos){
            case 1:
                pid1 = player1.getText().toString();
                userid = new String[]{pid1};
                new TaskRegister().execute(tname,game,type,gender);
                break;
            case 2:
                pid1 = player1.getText().toString();
                pid2 = player2.getText().toString();
                userid = new String[]{pid1,pid2};
                new TaskRegister().execute(tname,game,type,gender);
                break;
            case 4:
                pid1 = player1.getText().toString();
                pid2 = player2.getText().toString();
                pid3 = player3.getText().toString();
                pid4 = player4.getText().toString();
                userid = new String[]{pid1,pid2,pid3,pid4};
                new TaskRegister().execute(tname,game,type,gender);
                break;
            case 6:
                pid1 = player1.getText().toString();
                pid2 = player2.getText().toString();
                pid3 = player3.getText().toString();
                pid4 = player4.getText().toString();
                pid5 = player5.getText().toString();
                pid6 = player6.getText().toString();
                userid = new String[]{pid1,pid2,pid3,pid4,pid5,pid6};
                new TaskRegister().execute(tname,game,type,gender);
                break;
            case 7:
                pid1 = player1.getText().toString();
                pid2 = player2.getText().toString();
                pid3 = player3.getText().toString();
                pid4 = player4.getText().toString();
                pid5 = player5.getText().toString();
                pid6 = player6.getText().toString();
                pid7 = player7.getText().toString();
                userid = new String[]{pid1,pid2,pid3,pid4,pid5,pid6,pid7};
                new TaskRegister().execute(tname,game,type,gender);
                break;
            case 8:
                pid1 = player1.getText().toString();
                pid2 = player2.getText().toString();
                pid3 = player3.getText().toString();
                pid4 = player4.getText().toString();
                pid5 = player5.getText().toString();
                pid6 = player6.getText().toString();
                pid7 = player7.getText().toString();
                pid8 = player8.getText().toString();
                userid = new String[]{pid1,pid2,pid3,pid4,pid5,pid6,pid7,pid8};
                new TaskRegister().execute(tname,game,type,gender);
                break;

        }
    }
    public class TaskRegister extends AsyncTask<String, Void, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            m_ProgresDialog = ProgressDialog.show(F8Activity.this, "Please wait", "Registration processing...", true);
        }

        @Override
        protected Integer doInBackground(String... params) {
            Map<String, String> postParam = new HashMap<>();

            postParam.put("tname", params[0]);
            postParam.put("gname", params[1]);
            postParam.put("gtype", params[2]);
            postParam.put("ggen", params[3]);

//
            int i = 0;
            for(String userids : userid){
                postParam.put("userid["+(i++)+"]" , userids);
            }

            try{
                String jsonString = m_AccessServiceAPI.getJSONStringWithParam_POST(Common.SERVICE_CHECK_URL, postParam);
                JSONObject jsonObject = new JSONObject(jsonString);
                a = jsonObject.getInt("result");
                if(a==15){
                    String userString = m_AccessServiceAPI.getJSONStringWithParam_POST(Common.SERVICE_ADDGAME_URL, postParam);
                    JSONObject userObject = new JSONObject(userString);
                    a = userObject.getInt("result");
                }
                return a;
            }catch (Exception e) {
                e.printStackTrace();
                return Common.RESULT_ERROR;
            }

        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            m_ProgresDialog.dismiss();
            if(a == 12) {
                Toast.makeText(F8Activity.this, "User does not exist", Toast.LENGTH_LONG).show();

            } else if(a == 13) {
                Toast.makeText(F8Activity.this, "User already registerd!", Toast.LENGTH_LONG).show();
            } else if (a==10){
                Toast.makeText(F8Activity.this, "Enter unique team name", Toast.LENGTH_LONG).show();
            }
            else if (a==11){
                Toast.makeText(F8Activity.this, "Registration Successfull", Toast.LENGTH_LONG).show();
                Intent i= new Intent(F8Activity.this,RegistrationActivity.class);
                startActivity(i);
                finish();

            }
            else
                Toast.makeText(F8Activity.this, "Registration UnSuccessfull", Toast.LENGTH_LONG).show();
        }
    }
}
