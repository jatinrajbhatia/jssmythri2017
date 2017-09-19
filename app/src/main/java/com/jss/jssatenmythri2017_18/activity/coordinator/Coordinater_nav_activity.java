package com.jss.jssatenmythri2017_18.activity.coordinator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.activity.About;
import com.jss.jssatenmythri2017_18.activity.About_app;
import com.jss.jssatenmythri2017_18.activity.Committee;
import com.jss.jssatenmythri2017_18.activity.Games;
import com.jss.jssatenmythri2017_18.activity.LoginActivity;
import com.jss.jssatenmythri2017_18.activity.Notification;
import com.jss.jssatenmythri2017_18.activity.Support;

public class Coordinater_nav_activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences sharedPreferences;
    final String LOGIN_KEY="logged_in";
    final String PREF_NAME = "mythri-2016";
    String USERNAME = "useername";
    String MYTHRI_ID = "mythri_id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinater_nav_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        android.support.v4.app.FragmentManager transaction =getSupportFragmentManager();
        transaction.beginTransaction().replace(R.id.coordinater_frame,new About()).commit();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        sharedPreferences = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.my_event){
            android.support.v4.app.FragmentManager transaction =getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.coordinater_frame,new Your_Events()).commit();
        }else if (id == R.id.games) {
            android.support.v4.app.FragmentManager transaction =getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.coordinater_frame,new Games()).commit();
        }else if (id == R.id.notification) {
            android.support.v4.app.FragmentManager transaction =getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.coordinater_frame,new Notification()).commit();
        }else if (id == R.id.home) {
            android.support.v4.app.FragmentManager transaction =getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.coordinater_frame,new About()).commit();
        }else if(id==R.id.about_app)
        {
            android.support.v4.app.FragmentManager transaction =getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.coordinater_frame,new About_app()).commit();
        }else if(id==R.id.committee)
        {
            android.support.v4.app.FragmentManager transaction =getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.coordinater_frame,new Committee()).commit();
        }
        else if(id == R.id.logout){
            clearPref();
        }else if(id == R.id.support){
            android.support.v4.app.FragmentManager transaction =getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.coordinater_frame,new Support()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void clearPref() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(LOGIN_KEY,false);
        editor.apply();
        startActivity(new Intent(Coordinater_nav_activity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
        finish();
    }
}
