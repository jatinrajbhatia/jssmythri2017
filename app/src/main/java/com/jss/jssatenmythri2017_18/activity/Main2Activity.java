package com.jss.jssatenmythri2017_18.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jss.jssatenmythri2017_18.R;

public class Main2Activity extends AppCompatActivity {
    EditText username, password;
    Button login;
    String Url = "";
    String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = username.getText().toString().trim();
                pass = password.getText().toString().trim();
                if (user == "" || pass == "") {
                    Toast.makeText(getApplicationContext(), "not valid username or password", Toast.LENGTH_LONG).show();
                } else {


                    Toast.makeText(getApplicationContext(), user + " " + pass, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
