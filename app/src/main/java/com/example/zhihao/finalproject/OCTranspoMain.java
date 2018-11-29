package com.example.zhihao.finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class OCTranspoMain extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "RouteActivity";
    ProgressBar progressBar;
    String message;
    ListView listView;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_octranspo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        // App Logo
        toolbar.setLogo(R.drawable.icon_launcher);
        // Title
        toolbar.setTitle("OCTranspoMain");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_android);


        Button stop = (Button) findViewById(R.id.stops);
        Toast toast=Toast.makeText(getApplicationContext(), "Welcome to Zhihao's OC Transpo", Toast.LENGTH_LONG);
        toast.show();

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stops = new Intent(OCTranspoMain.this, OC_route.class);
                startActivity(stops);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_info:

                Log.d("Toolbar", "Item selected");
                AlertDialog.Builder build = new AlertDialog.Builder(OCTranspoMain.this);
                build.setTitle("Personal Information");
                build.setMessage("Zhihao Zhao \n  Version 1");
                build.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("clicked", "disappear");
                    }
                });
                build.show();


        }
            return true;
        }

    }

