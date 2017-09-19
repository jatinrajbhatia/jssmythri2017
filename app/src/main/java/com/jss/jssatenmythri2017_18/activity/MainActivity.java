package com.jss.jssatenmythri2017_18.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jss.jssatenmythri2017_18.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView unamet, unameid;
    String loginname, loginid;

    //Shared Pref by Ashwani - whole app preference
    SharedPreferences sharedPreferences;
    final String LOGIN_KEY = "logged_in";
    final String PREF_NAME = "mythri-2016";
    String USERNAME = "useername";
    String MYTHRI_ID = "mythri_id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        loginname = sharedPreferences.getString(USERNAME, "JSS");
        String id = sharedPreferences.getString(MYTHRI_ID, "mythri_dev_jss");
        if (!id.equals("mythri_dev_jss")) {
            loginid = "MYTHRI_17_" + id;
        }

        Toast.makeText(getApplicationContext(), loginname + " " + loginid, Toast.LENGTH_LONG).show();

        Fragment mf = new MainFragment();
        android.support.v4.app.FragmentManager transaction = getSupportFragmentManager();
        transaction.beginTransaction().replace(R.id.main_frame, new principal()).commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        unamet = (TextView) header.findViewById(R.id.uname);
        unameid = (TextView) header.findViewById(R.id.uid);
        unameid.setText(loginid);
        unamet.setText(loginname);
    }

    int bakcounter;
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(bakcounter < 2){
                Toast.makeText(getApplicationContext(),"Press Back again to exit",Toast.LENGTH_SHORT).show();
                bakcounter++;
                return;
            }
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.usergames) {
            android.support.v4.app.FragmentManager transaction = getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.main_frame, new UserGames()).commit();
        } else if (id == R.id.games) {
            android.support.v4.app.FragmentManager transaction = getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.main_frame, new Games()).commit();
        } else if (id == R.id.notification) {
            android.support.v4.app.FragmentManager transaction = getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.main_frame, new Notification()).commit();
        } else if (id == R.id.home) {
            android.support.v4.app.FragmentManager transaction = getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.main_frame, new About()).commit();
        } else if (id == R.id.about_app) {
            android.support.v4.app.FragmentManager transaction = getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.main_frame, new About_app()).commit();
        } else if (id == R.id.logout) {
            clearPref();
        } else if (id == R.id.support) {
            android.support.v4.app.FragmentManager transaction = getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.main_frame, new Support()).commit();
        } else if (id == R.id.committee) {
            android.support.v4.app.FragmentManager transaction = getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.main_frame, new Committee()).commit();
        } else if (id == R.id.share) {
            shareapp();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void clearPref() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(LOGIN_KEY, false);
        editor.apply();
        startActivity(new Intent(MainActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
        finish();
    }

    public void shareapp() {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, "JSS Mythri 2017-18 android app.\nClick on link to download: " +
                "https://play.google.com/store/apps/details?id=" + this.getPackageName());
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Jss Mythri 2017-18");
        startActivity(Intent.createChooser(sharingIntent, "Share using"));
    }
}
