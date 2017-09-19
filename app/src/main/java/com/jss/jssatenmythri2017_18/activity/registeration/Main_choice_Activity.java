package com.jss.jssatenmythri2017_18.activity.registeration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jss.jssatenmythri2017_18.R;

public class Main_choice_Activity extends AppCompatActivity {
Button regisitration,tshirt;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_choice_);

        regisitration= (Button) findViewById(R.id.registration);
        tshirt= (Button) findViewById(R.id.t_shirt);


        regisitration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=new Intent(Main_choice_Activity.this, RegistrationActivity.class);
                startActivity(i);
            }
        });

        tshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=new Intent(Main_choice_Activity.this, t_shirtActivity.class);
                startActivity(i);
            }
        });
    }

    int bakcounter;
    @Override
    public void onBackPressed() {
        if(bakcounter < 2){
            Toast.makeText(getApplicationContext(),"Press Back again to exit",Toast.LENGTH_SHORT).show();
            bakcounter++;
            return;
        }
        super.onBackPressed();
    }
}
