package com.example.zhihao.finalproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.Snackbar;
import android.widget.Button;
import android.widget.TextView;


public class route extends Activity {
    private Button snack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        ArrayAdapter<String> MemberAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, routeInfomation.getAllRouteCode());

        ListView listView = (ListView) findViewById(R.id.codeList);
        listView.setAdapter(MemberAdapter);
        snack = findViewById(R.id.snackButton);
        snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "The  SnackBar Button was clicked.", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();

            }
        });
        Button buttonNormal = (Button) findViewById(R.id.dialog);
        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNormalDialog();
            }
            private void showNormalDialog(){
                final AlertDialog.Builder normalDialog =
                        new AlertDialog.Builder(route.this);
                normalDialog.setIcon(R.drawable.icon_dialog);
                normalDialog.setTitle("Im Dialog");
                normalDialog.setMessage("Want you want to do?");
                normalDialog.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                normalDialog.setNegativeButton("close",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                normalDialog.show();
            }




});
}}