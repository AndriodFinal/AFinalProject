package com.example.zhihao.finalproject;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Movie_Main extends Activity {
    private static final int REQUEST_CODE=50;
    private Button Button;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);


        Button = findViewById(R.id.button);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Movie_Main.this,MovieImformation.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });

        Toast toast=Toast.makeText(getApplicationContext(), "Welcome to Joey's MovieApp", Toast.LENGTH_LONG);
        toast.show();

    }
}