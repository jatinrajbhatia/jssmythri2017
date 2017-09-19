package com.jss.jssatenmythri2017_18.activity;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.activity.coordinator.Coordinater_nav_activity;
import com.jss.jssatenmythri2017_18.activity.registeration.Main_choice_Activity;
import com.jss.jssatenmythri2017_18.helper.AccessServiceAPI;
import com.jss.jssatenmythri2017_18.util.Common;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    private EditText mobile;
    private EditText password;
    private AccessServiceAPI m_ServiceAccess;
    private ProgressDialog progressDialog;
    int lid;
    String uname = null, id = null;
    int f;
    private CheckBox remember;
    String userName, userPass;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    //Pref by Ashwani - pref of whole app
    SharedPreferences sharedPreferences;
    final String LOGIN_KEY = "logged_in";
    final String PREF_NAME = "mythri-2017";
    final String IS_REGISTERATION = "registeration";
    String USERNAME = "useername";
    String MYTHRI_ID = "mythri_id";
    boolean isloggedin;
    boolean isRegisteration;

    SharedPreferences.Editor editor,editor1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_in);

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        isloggedin = sharedPreferences.getBoolean(LOGIN_KEY, false);

        final SharedPreferences pref1 = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor1 = pref1.edit();
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref2", MODE_PRIVATE);
        editor = pref.edit();
        mobile = (EditText) findViewById(R.id.editTextMobile);
        password = (EditText) findViewById(R.id.editTextPassword);
        remember = (CheckBox) findViewById(R.id.checkBox);

        if(pref1.getInt("key" , 0) == 1){

            mobile.setText(pref.getString("key_name1",""));
            password.setText(pref.getString("key_name2",""));

        }

        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    if (pref1.getInt("key", f) == 0) {
                        userName = mobile.getText().toString();
                        userPass = password.getText().toString();
                        editor.putString("key_name1", userName);
                        editor.putString("key_name2", userPass);
                        editor.commit();
                        f = 1;
                        editor1.putInt("key", f);
                        editor1.commit();
                    }
                }else{
                    editor1.putInt("key", 0);
                    editor1.commit();
                }
            }
        });
        m_ServiceAccess = new AccessServiceAPI();


    }

    public void btnLogin_Click(View view) {
        if ("".equals(mobile.getText().toString())) {
            mobile.setError("Username is required!");
            return;
        }
        if ("".equals(password.getText().toString())) {
            password.setError("Password is required!");
            return;
        }

        if(remember.isChecked()){
            userName = mobile.getText().toString();
            userPass = password.getText().toString();
            editor.putString("key_name1", userName);
            editor.putString("key_name2", userPass);
            editor.commit();
            f = 1;
            editor1.putInt("key", f);
            editor1.commit();
        }

        new TaskLogin().execute(mobile.getText().toString(), password.getText().toString());
    }

    public void btnGoRegister_Click(View v) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null) {
            if (data.getStringArrayExtra("data") != null) {

                String rawData[] = data.getStringArrayExtra("data");
                if (requestCode == 1) {
                    mobile.setText(rawData[0]);
                    password.setText(rawData[1]);

                }
            }
        }
    }

    public class TaskLogin extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Open progress dialog during login
            progressDialog = ProgressDialog.show(LoginActivity.this, "Please wait...", "Processing...", true);
        }

        @Override
        protected Integer doInBackground(String... params) {
            Map<String, String> param = new HashMap<>();

            param.put("mobile", params[0]);
            param.put("password", params[1]);

            JSONObject jsonObject;

            try {
                jsonObject = m_ServiceAccess.convertJSONString2Obj(m_ServiceAccess.getJSONStringWithParam_POST(Common.SERVICE_API_URL, param));
                JSONObject userObject = jsonObject.getJSONObject("user");
                String uname1 = userObject.getString("name");
                id = userObject.getString("mythri_id");

                uname = uname1;
                lid = userObject.getInt("login_id");

                return jsonObject.getInt("result");
            } catch (Exception e) {
                return Common.RESULT_ERROR;
            }

        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            if (Common.RESULT_SUCCESS == result) {
                Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_LONG).show();
                if (lid == 1) {

                    isloggedin = true;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(LOGIN_KEY, isloggedin);
                    editor.putString(USERNAME, uname);
                    editor.putString(MYTHRI_ID, id);
                    editor.putString(IS_REGISTERATION, "user");
                    editor.apply();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();
                } else if (lid == 3) {
                    isloggedin = true;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(LOGIN_KEY, isloggedin);
                    editor.putString(USERNAME, uname);
                    editor.putString(MYTHRI_ID, id);
                    editor.putString(IS_REGISTERATION, "register");
                    editor.apply();
                    Intent i = new Intent(getApplicationContext(), Main_choice_Activity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();
                } else if (lid == 2) {
                    isloggedin = true;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(LOGIN_KEY, isloggedin);
                    editor.putString(USERNAME, uname);
                    editor.putString(MYTHRI_ID, id);
                    editor.putString(IS_REGISTERATION, "coordinator");
                    editor.apply();
                    Intent i = new Intent(getApplicationContext(), Coordinater_nav_activity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Login fail", Toast.LENGTH_LONG).show();
            }
        }
    }

}