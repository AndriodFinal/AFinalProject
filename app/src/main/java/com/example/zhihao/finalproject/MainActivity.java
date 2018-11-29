package com.example.zhihao.finalproject;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        // App Logo
//        toolbar.setLogo(R.drawable.icon_launcher);
//        // Title
//        toolbar.setTitle("Andriod Final Project");
//        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.drawable.icon_android);
        Button Transpo = (Button) findViewById(R.id.OCTranspo);
        Transpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent OC = new Intent(MainActivity.this, OCTranspoMain.class);
                startActivity(OC);
            }
        });
        Button movie = findViewById(R.id.movieButton);
        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mv = new Intent(MainActivity.this, Movie_Main.class);
                startActivity(mv);
            }
        });
        Button news = findViewById(R.id.News);
        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent news = new Intent(MainActivity.this, CBC_Main.class);
                startActivity(news);
            }
        });
        Button food = findViewById(R.id.foodButton);
        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent food = new Intent(MainActivity.this, food_main.class);
                startActivity(food);
            }
        });

        ArrayAdapter<String> MemberAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, GroupMember.getAllMembers());

        ListView listView = (ListView) findViewById(R.id.info);

        listView.setAdapter(MemberAdapter);
    }

}

