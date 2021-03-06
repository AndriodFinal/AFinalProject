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
        Button Transpo = (Button) findViewById(R.id.OCTranspo);
        Transpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent OC = new Intent(MainActivity.this, OCTranspo.class);
                startActivity(OC);
            }
        });
        Button movie = findViewById(R.id.movieButton);
        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mv = new Intent(MainActivity.this, MovieActivity.class);
                startActivity(mv);
            }
        });
        Button news = findViewById(R.id.News);
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent news = new Intent(MainActivity.this, CBC_Main.class);
                startActivity(news);
            }
        });
        Button food = findViewById(R.id.foodButton);
        food.setOnClickListener(new View.OnClickListener() {
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

