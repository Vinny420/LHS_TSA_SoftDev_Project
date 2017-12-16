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
 * Commentary by Luke Blevins of Lakeside TSA
 */


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    // Declare needed objects as global variables for access throughout the program

    RelativeLayout lay1;
    RelativeLayout lay2;
    RelativeLayout lay3;
    DrawerLayout drawerLayout;
    ActionBar actionBar;

    // Default method called automatically when activity is created

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);         // Set the content of this activity to the activity_main XML file
        navigate();                                     // Once finished with this, call the navigate function found below
    }

    // Method created to prep navigation drawer

    public void navigate(){                                 // Method called in onCreate method

        // If device is running Lollipop or above, run the following...
        if(Build.VERSION.SDK_INT >= 21) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);    // Set variable "toolbar" to item named "toolbar3" in XML file
            setSupportActionBar(toolbar);                               // Designate the item set to "toolbar" as the activity's actionBar
            actionBar = getSupportActionBar();                          // Set variable "actionBar" to whatever the activity's actionBar is. This is necessary for checking it later.
            lay1 = (RelativeLayout) findViewById(R.id.one);             // Initialize variables "lay1", "lay2", and "lay3" - that were originally declared above - to their respective XML items.
            lay2 = (RelativeLayout) findViewById(R.id.two);             //    < __________________________|           |
            lay3 = (RelativeLayout) findViewById(R.id.three);           //    < ______________________________________|


            drawerLayout = (DrawerLayout) findViewById(R.id.dLayout);   // Initialize variable "drawerLayout" to XML item "dLayout".
            if (actionBar != null) {                                    // Check if the activity's actionBar has been set (not equal to null)
                actionBar.setDisplayHomeAsUpEnabled(true);              // Enables the actionBar's back button
                ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {       // Create a new AppDrawer toggle. Refer to android documentation for more info on parameters. Also defines its own constructor after the class object.
                    public void onDrawerClosed(View view) {  // Method called when drawer is closed
                        supportInvalidateOptionsMenu();      // Declare that the options menu has changed, so should be recreated. It will be recreated when needed.

                    }

                    public void onDrawerOpened(View drawerView){    // Method called when drawer is opened
                        supportInvalidateOptionsMenu();             // Once again, declare that the options menu has changed, so should be recreated. It will be recreated when needed.

                    }
                };
                mDrawerToggle.setDrawerIndicatorEnabled(true);      // Enable drawer indicator on the "mDrawerToggle" which, in turn, enables the animated glyph on the activity's actionBar
                drawerLayout.setDrawerListener(mDrawerToggle);      // Set the appDrawer's actionListener to our newly created "mDrawerToggle" object
                mDrawerToggle.syncState();                          // Sync the appDrawer's indicator with the current state of the DrawerLayout
                setListener();                                      // Call the setListener method below

            }
        }
    }

    // Sets the item listener
    public void setListener(){
        NavigationView nView = (NavigationView) findViewById(R.id.nav_view);    // Declare a variable named "nView" and initialize it to the "nav_view" XML item.
        nView.setNavigationItemSelectedListener(this);                          // Set the listener called for a selected navDrawer item to one found below
    }


    // A method that is called when a navDrawer item is selected
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){                                               // Check which item was selected by returning its ID
            case R.id.action_feed:                                              // If the item selected's ID is "R.id.action_feed"
                actionBar.setTitle("Your Feed");                                // Set actionBar title to correct page title
                lay3.setVisibility(View.GONE);                                  // Hide layout3 from the "stack of layouts"
                lay2.setVisibility(View.GONE);                                  // Hide layout2 from the "stack of layouts"
                lay1.setVisibility(View.VISIBLE);                               // Show only the selected item on screen
                break;                                                          // Leave or "break" from the loop

            case R.id.action_calendar:                                          // If the item selected's ID is "R.id.action_calendar"
                actionBar.setTitle("Calendar");                                 // Set actionBar title to correct page title
                lay1.setVisibility(View.GONE);                                  // Hide layout1 from the "stack of layouts"
                lay3.setVisibility(View.GONE);                                  // Hide layout3 from the "stack of layouts"
                lay2.setVisibility(View.VISIBLE);                               // Show only the selected item on screen
                break;                                                          // Leave or "break" from the loop

            case R.id.action_settings:                                          // If the item selected's ID is "R.id.action_settings"
                actionBar.setTitle("Settings");                                 // Set actionBar title to correct page title
                lay1.setVisibility(View.GONE);                                  // Hide layout1 from the "stack of layouts"
                lay2.setVisibility(View.GONE);                                  // Hide layout3 from the "stack of layouts"
                lay3.setVisibility(View.VISIBLE);                               // Show only the selected item on screen
                break;                                                          // Leave or "break" from the loop

        }
        drawerLayout.closeDrawer(GravityCompat.START);                          // Regardless of selection, close drawer when loaded
        return true;                                                            // return true is navDrawer item was indeed selected
    }
}
