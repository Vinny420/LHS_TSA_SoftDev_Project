package com.example.lukeb.calendar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.lukeb.calendar.R.id.action_feed;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView nDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        CharSequence text = "Disclaimer: This is nonfunctional prototype software that is incomplete in many ways.";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        CharSequence text1 = "Nav drawer doesn't work, many features are still missing, and compatibility is limited.";
        Toast toast1 = Toast.makeText(context, text1, duration);
        toast1.show();

        nDrawer = (NavigationView) findViewById(R.id.navDrawer);
        nDrawer.setNavigationItemSelectedListener(this);

    }

    public void diagTasks(View v){

        nDrawer.setVisibility(View.INVISIBLE);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == action_feed){
            //if

        }
        return true;
    }
}
