package com.example.zhihao.finalproject;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CBC_Main extends Activity {
    protected static final String ACTIVITY_NAME = "CBC_Main";
    private static final int REQUEST_CODE = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //ArrayAdapter<String> newstitle = new ArrayAdapter<String>(this, android.R.layout. Resources.getNewsTitle());
        NewsAdapter newsAdapter = new NewsAdapter(this,R.layout.new_items,Resources.getNewsTitle());
        ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(newsAdapter);



    }

    public class NewsAdapter extends ArrayAdapter<Resources> {

        public NewsAdapter(Context cxt,int resource,List<Resources> object){
            super(cxt,resource,object);
        }

        public View getView(int position, View convertView, ViewGroup parent){
            Resources resources = getItem(position);
            View onNewsView = LayoutInflater.from(getContext()).inflate(R.layout.new_items,parent,false);
            TextView textView=(TextView) onNewsView.findViewById(R.id.textView);
            textView.setText(Resources.getNewsTitle().get(position).getTitle());
            Toast.makeText(getApplicationContext(),"Toast test!",Toast.LENGTH_SHORT).show();
            onNewsView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(),downloadeActivity.class);
                    getContext().startActivity(intent);
                }
            });
            return onNewsView;
        }

    }
}
