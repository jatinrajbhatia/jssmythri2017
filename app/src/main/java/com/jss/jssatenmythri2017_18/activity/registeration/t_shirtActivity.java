package com.jss.jssatenmythri2017_18.activity.registeration;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.helper.AccessServiceAPI;
import com.jss.jssatenmythri2017_18.util.Common;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class t_shirtActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    final String LOGIN_KEY = "logged_in";
    final String PREF_NAME = "mythri-2016";
    Button submit;

    Spinner spinner_size;

    EditText m_id;

    private AccessServiceAPI m_AccessServiceAPI;

    String selected_size,mythri_id;
    String[] userid;

    private ProgressDialog m_ProgresDialog;
    int a=0;


    String[]  size=new String[]{
            "S",
            "M",
            "L",
            "XL",
            "XXL",
            "XXXL"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_shirt);

        submit = (Button) findViewById(R.id.btntshirt);

        addItemsOnSpinner();

        
        m_id = (EditText) findViewById(R.id.mythri_id);

        m_AccessServiceAPI = new AccessServiceAPI();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mythri_id = m_id.getText().toString();
                selected_size = String.valueOf(spinner_size.getSelectedItem());


          //      Toast.makeText(t_shirtActivity.this,mythri_id+"\n"+selected_size, Toast.LENGTH_SHORT).show();
                new TaskRegister().execute(mythri_id, selected_size);

            }
        });

    }

    private void addItemsOnSpinner() {
        spinner_size = (Spinner) findViewById(R.id.spinner_size);
        List<String> list = new ArrayList<String>();
        list.add("Small");
        list.add("Medium");
        list.add("Large");
        list.add("XLarge");
        list.add("XXLarge");
        list.add("XXXLarge");
        list.add("XXXXLarge");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_size.setAdapter(dataAdapter);
    }


    public class TaskRegister extends AsyncTask<String, Void, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            m_ProgresDialog = ProgressDialog.show(t_shirtActivity.this, "Please wait", "Registration processing...", true);
        }

        @Override
        protected Integer doInBackground(String... params) {
            Map<String, String> postParam = new HashMap<>();

            postParam.put("myth", params[0]);
            postParam.put("tsize", params[1]);

//


            try{

                    String userString = m_AccessServiceAPI.getJSONStringWithParam_POST(Common.SERVICE_ADDTSHIRT_URL, postParam);
                    JSONObject userObject = new JSONObject(userString);
                    a = userObject.getInt("result");

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
                Toast.makeText(t_shirtActivity.this, "User does not exist", Toast.LENGTH_LONG).show();

            } else if(a == 13) {
                Toast.makeText(t_shirtActivity.this, "User already registerd!", Toast.LENGTH_LONG).show();
            }
            else if (a==5){
                Toast.makeText(t_shirtActivity.this, "Registration Successfull", Toast.LENGTH_LONG).show();
                Intent i= new Intent(t_shirtActivity.this,t_shirtActivity.class);
                startActivity(i);
                finish();

            }
            else
                Toast.makeText(t_shirtActivity.this, "Registration UnSuccessfull", Toast.LENGTH_LONG).show();
        }
    }
}


