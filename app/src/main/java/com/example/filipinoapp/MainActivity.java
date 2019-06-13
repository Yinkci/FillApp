package com.example.filipinoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView name, msg;
    LinearLayout item1, item2, item3;

    SharedPreferences mPreference;
    SharedPreferences.Editor mEditor;

    DrawerLayout dl;
    ActionBarDrawerToggle t;
    NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView) findViewById(R.id.name);
        msg = (TextView) findViewById(R.id.message);
        item1 = (LinearLayout) findViewById(R.id.item1);
        item2 = (LinearLayout) findViewById(R.id.item2);
        item3 = (LinearLayout) findViewById(R.id.item3);

        mPreference = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreference.edit();

        name.setText(mPreference.getString("student", null));
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String currentDateandTime = sdf.format(new Date());

        int today = Integer.parseInt(currentDateandTime);
        if (today >= 0 && today <= 4) {
            msg.setText("Hi,");
        } else if (today >= 5 && today <= 11) {
            msg.setText("Good Morning,");
        } else if (today == 12) {
            msg.setText("Hi,");
        } else if (today >= 13 && today <= 17) {
            msg.setText("Good Afternoon,");
        } else if (today >= 18 && today <= 23) {
            msg.setText("Good Evening,");
        }

        // Menu
        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.app_name, R.string.app_name);
        dl.addDrawerListener(t);
        t.syncState();

        nv = (NavigationView)findViewById(R.id.nv);
        View headerView = nv.getHeaderView(0);
        TextView user_name = (TextView) headerView.findViewById(R.id.tvName);
        user_name.setText("HELLO " + mPreference.getString("student", null) + "!");

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.settings:
                        Intent intent1 = new Intent(MainActivity.this, Settings.class);
                        startActivity(intent1);
                        return true;
                    case R.id.help:
                        Intent intent2 = new Intent(MainActivity.this, HelpSupport.class);
                        startActivity(intent2);
                        return true;
                    default:
                        return true;
                }
            }
        });
        // ================================================================================================

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Instruction.class);
                startActivity(intent);
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MovieList.class);
                startActivity(intent);
            }
        });

        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TakeQuiz.class);
                startActivity(intent);
            }
        });

    }

    int back = 1;
    @Override
    public void onBackPressed() {
        if (back == 1) {
            Toast.makeText(getApplication(), "Press BACK again to exit", Toast.LENGTH_SHORT).show();
            back++;
        } else if (back == 2) {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;


        return false;
    }
}
