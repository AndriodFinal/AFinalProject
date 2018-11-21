package com.example.zhihao.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class   food_main extends Activity {
    private ImageView imageView;
    private EditText editText;
    private Button buttonserch;
    private ProgressBar progressBar;
    public static final int REQUEST_CODE=50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageview);
        editText = findViewById(R.id.edittext);
        buttonserch = findViewById(R.id.button_serch);
        Toast.makeText(getApplicationContext(),"Toast test!",Toast.LENGTH_SHORT).show();
        buttonserch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(food_main.this,FoodNutritionDatabase.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
}
