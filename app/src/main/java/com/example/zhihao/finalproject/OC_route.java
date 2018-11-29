package com.example.zhihao.finalproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.design.widget.Snackbar;
import android.widget.Button;


public class OC_route extends AppCompatActivity {
    private Button snack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        Toolbar toolbar = findViewById(R.id.toolbar);
        // App Logo
        toolbar.setLogo(R.drawable.icon_launcher);
        // Title
        toolbar.setTitle("OCTranspoMain");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_android);

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
                final AlertDialog.Builder btnDialog =
                        new AlertDialog.Builder(OC_route.this);
                btnDialog.setIcon(R.drawable.icon_dialog);
                btnDialog.setTitle("Im Dialog");
                btnDialog.setMessage("Want you want to do?");
                btnDialog.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                btnDialog.setNegativeButton("close",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                btnDialog.show();
            }




});
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_info:

                Log.d("Toolbar", "Item selected");
                AlertDialog.Builder build = new AlertDialog.Builder(OC_route.this);
                build.setTitle("Personal Information");
                build.setMessage("Zhihao Zhao \n  Version 1");
                build.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("clicked", "disappear");
                    }
                });
                build.show();


        }
        return true;
    }}