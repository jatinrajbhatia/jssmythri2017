package com.jss.jssatenmythri2017_18.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.activity.coordinator.Coordinater_nav_activity;
import com.jss.jssatenmythri2017_18.activity.registeration.Main_choice_Activity;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences pref;
    final String LOGIN_KEY="logged_in";
    final String IS_REGISTERATION = "registeration";
    Animation animation;
    final String PREF_NAME = "mythri-2016";
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = (ImageView)findViewById(R.id.logo);
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomin);
        pref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        logo.setAnimation(animation);
        logo.setVisibility(View.VISIBLE);
//        m_AccessServiceAPI = new AccessServiceAPI();
        animation.start();
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
               switchScreen();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

    public void switchScreen(){
        boolean isLoggedIn = pref.getBoolean(LOGIN_KEY, false);
        String t = pref.getString(IS_REGISTERATION,"");
        String type = pref.getString(IS_REGISTERATION, "user");
        if (isLoggedIn && t.equals("user")) {
            //Open MainActivity
            startActivity(new Intent(SplashActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            finish();
        } else if (isLoggedIn && type.equals("register")) {
            startActivity(new Intent(SplashActivity.this, Main_choice_Activity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            finish();
        } else if(isLoggedIn && type.equals("coordinator")) {
            startActivity(new Intent(SplashActivity.this, Coordinater_nav_activity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            finish();
        }else{
            //Open Login Screen
            startActivity(new Intent(SplashActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            finish();
        }
    }


   /* private AccessServiceAPI m_AccessServiceAPI;
    public class TaskRegister extends AsyncTask<String, Void, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(String... params) {
            Map<String, String> postParam = new HashMap<>();
            try{
                String jsonString = m_AccessServiceAPI.getJSONStringWithParam_POST(Common.SERVICE_CHECK_VERSION_URL, postParam);
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONObject object = jsonObject.getJSONObject("version");
                return object.getInt("version");
            }catch (Exception e) {
                e.printStackTrace();
                return Common.RESULT_ERROR;
            }

        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            if(integer != Common.RESULT_ERROR) {
                try {
                    PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                    int verCode = pInfo.versionCode;
                    if (verCode < integer) {
                        alertUpgrade();
                    } else {

                    }

                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();

                }
            }else{
                final AlertDialog.Builder upgradeAlert = new AlertDialog.Builder(SplashActivity.this);
                upgradeAlert.setTitle("Connection Problem!!");
                upgradeAlert.setCancelable(false);
                upgradeAlert.setMessage("This app requires internet connectivity. Please check your internet connection and restart the app.");
                upgradeAlert.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                upgradeAlert.show();
            }

        }
    }

    public void alertUpgrade(){
        final AlertDialog.Builder upgradeAlert = new AlertDialog.Builder(this);
        upgradeAlert.setTitle("Update!!");
        upgradeAlert.setCancelable(false);
        upgradeAlert.setMessage("An Updated Version is available on Play Store, Please Update application to use extra functionalities of app.");
        upgradeAlert.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.jss.jssatenmythri2016_17"));
                startActivity(i);
            }
        });
        upgradeAlert.show();
    }*/
}

