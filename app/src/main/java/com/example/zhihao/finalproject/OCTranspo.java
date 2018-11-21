package com.example.zhihao.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class OCTranspo extends Activity {
    protected static final String ACTIVITY_NAME = "RouteActivity";
    ProgressBar progressBar;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_octranspo);
        Button stop = (Button) findViewById(R.id.stops);

        Toast toast=Toast.makeText(getApplicationContext(), "Welcome to Zhihao's OC Transpo", Toast.LENGTH_LONG);
        toast.show();

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stops = new Intent(OCTranspo.this, route.class);
                startActivity(stops);
            }
        });
    }
}
