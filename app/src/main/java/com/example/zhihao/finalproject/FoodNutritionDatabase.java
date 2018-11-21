package com.example.zhihao.finalproject;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodNutritionDatabase extends Activity {
    private Button buttonback;
    private ListView listView;
    public static final int REQUEST_CODE=50;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_nutrition_database);
        buttonback = findViewById(R.id.button_back);

        FoodAdapter fAdapter = new FoodAdapter(this,R.layout.activity_food_item,FoodDatabaseList.getAllFood());

        listView = (ListView) findViewById(R.id.foodlist);

        listView.setAdapter(fAdapter);



        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {

                if (isChecked) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(FoodNutritionDatabase.this);

                    //Chain together various setter methods to set the dialog characteristics

                    builder.setMessage(R.string.dialog_message) //Add a dialog message to strings.xml


                            .setTitle(R.string.dialog_title)

                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int id) {

                                    Intent resultIntent = new Intent();

                                    resultIntent.putExtra("Response", "Here is my response");

                                    setResult(Activity.RESULT_OK, resultIntent);

                                    finish(); // User clicked OK button

                                }

                            })
                            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int id) {

                                    // User cancelled the dialog

                                }

                            })

                            .show();

                }

            }

        });

    }
    public class FoodAdapter extends ArrayAdapter<FoodDatabaseList> {

        public FoodAdapter(Context context, int resource, List<FoodDatabaseList> obj) {
            super(context, resource,obj);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            FoodDatabaseList food=getItem(position);//get value from FoodDatabaseList
            View oneFoodView = LayoutInflater.from(getContext()).inflate(R.layout.activity_food_item,parent,false);

            TextView textView = oneFoodView.findViewById(R.id.food_textView);
            Button button = oneFoodView.findViewById(R.id.addfavbutton);

            textView.setText(FoodDatabaseList.getAllFood().get(position).getName());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(FoodNutritionDatabase.this,FavoritesList.class);
                    startActivityForResult(intent, REQUEST_CODE);
                }
            });
            return oneFoodView;
        }
    }

}
