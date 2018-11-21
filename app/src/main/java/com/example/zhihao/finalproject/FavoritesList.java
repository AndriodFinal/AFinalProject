package com.example.zhihao.finalproject;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class FavoritesList extends AppCompatActivity {
    private Button buttonb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites_list);
        buttonb = findViewById(R.id.bback);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {

                if (isChecked) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(FavoritesList.this);

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
        buttonb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "The  SnackBar Button was clicked.", Snackbar.LENGTH_SHORT)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(FavoritesList.this,"clicked",Toast.LENGTH_SHORT).show();
                            }
                        }).show();

            }
        });
    }
}