package com.example.zhihao.finalproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class downloadeActivity extends Activity {
    private Button button1;
    private Button button2;
    private static final String ACTIVITY_NAME = "downloadeActivity";
    private static final int REQUEST_CODE = 50;
    //LinearLayout rootLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloade);
        button1 = findViewById(R.id.button1);

        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"delete data",Snackbar.LENGTH_SHORT).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(downloadeActivity.this, "Undo delete data", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {

                if (isChecked) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(downloadeActivity.this);

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

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(downloadeActivity.this)
                        .setTitle("INFO")
                        .setMessage("Do you want to leave")
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent resultintent = new Intent();
                                setResult(Activity.RESULT_OK, resultintent);
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });






    }

}