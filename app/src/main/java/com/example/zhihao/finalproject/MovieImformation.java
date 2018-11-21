package com.example.zhihao.finalproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.zhihao.finalproject.R;

public class MovieImformation extends Activity {
    private Button snack;

    CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_imformation);

        Toast toast = Toast.makeText(getApplicationContext(), "New Arrival", Toast.LENGTH_LONG);
        toast.show();

        snack = findViewById(R.id.snackButton);
        snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Confirmed.", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {

                if (isChecked) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MovieImformation.this);

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

    }}