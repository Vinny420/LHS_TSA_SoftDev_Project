package com.example.lukeb.calendar;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.transition.Visibility;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

/*
 * Luke Blevins - Modified 12/12/2017
 */


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    RelativeLayout lay1;
    RelativeLayout lay2;
    RelativeLayout lay3;
    DrawerLayout drawerLayout;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigate();
    }

    public void navigate(){
        if(Build.VERSION.SDK_INT >= 21) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
            setSupportActionBar(toolbar);
            actionBar = getSupportActionBar();
            lay1 = (RelativeLayout) findViewById(R.id.one);
            lay2 = (RelativeLayout) findViewById(R.id.two);
            lay3 = (RelativeLayout) findViewById(R.id.three);


            drawerLayout = (DrawerLayout) findViewById(R.id.dLayout);
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
                    public void onDrawerClosed(View view) {
                        supportInvalidateOptionsMenu();
                        //drawerOpened = false;
                    }

                    public void onDrawerOpened(View drawerView) {
                        supportInvalidateOptionsMenu();
                        //drawerOpened = true;
                    }
                };
                mDrawerToggle.setDrawerIndicatorEnabled(true);
                drawerLayout.setDrawerListener(mDrawerToggle);
                mDrawerToggle.syncState();
                setListener();

            }
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_feed:
                actionBar.setTitle("Your Feed");
                lay3.setVisibility(View.GONE);
                lay2.setVisibility(View.GONE);
                lay1.setVisibility(View.VISIBLE);
                break;
            case R.id.action_calendar:
                actionBar.setTitle("Calendar");
                lay1.setVisibility(View.GONE);
                lay3.setVisibility(View.GONE);
                lay2.setVisibility(View.VISIBLE);
                break;
            case R.id.action_settings:
                actionBar.setTitle("Settings");
                lay1.setVisibility(View.GONE);
                lay2.setVisibility(View.GONE);
                lay3.setVisibility(View.VISIBLE);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setListener(){
        NavigationView nView = (NavigationView) findViewById(R.id.nav_view);
        nView.setNavigationItemSelectedListener(this);
    }
}
