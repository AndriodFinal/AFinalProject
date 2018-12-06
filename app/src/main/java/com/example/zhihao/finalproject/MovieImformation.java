package com.example.zhihao.finalproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MovieImformation extends Activity {
    private TextView movieTitleView;
    private TextView movieYearView;
    private TextView movieRatingView;
    private TextView movieRuntimeView;
    private TextView movieActorsView;
    private TextView moviePlotView;
    private ImageView movieImageView;
    private int movieIndex;
    private Bitmap image;

    private static final String imagePath = "/data/data/com.example.windows.androidfinal/files/";

    ArrayList<String> movieInventory;
;   private String movieTitle;
    private String movieYear;
    private String movieRating;
    private String movieRuntime;
    private String movieActors;
    private String moviePlot;
    private CheckBox checkBox;
    private CoordinatorLayout coordinatorLayout;
    private Button snack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_imformation);

        Toast toast = Toast.makeText(getApplicationContext(), "New Arrival", Toast.LENGTH_LONG);
        toast.show();




        movieInventory = new ArrayList<>();
        movieTitleView = (TextView) findViewById(R.id.movieTitleView);
        movieImageView = (ImageView) findViewById(R.id.movieImageView);
        movieYearView = (TextView) findViewById(R.id.movieYearView);
        movieRatingView = (TextView) findViewById(R.id.movieRatingView);
        movieRuntimeView = (TextView) findViewById(R.id.movieRuntimeView);
        movieActorsView = (TextView) findViewById(R.id.movieActorsView);
        moviePlotView = (TextView) findViewById(R.id.moviePlotView);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            movieTitle = bundle.get("MovieName").toString();
            Log.i(TAG, bundle.get("MovieName").toString());
            movieIndex = (int) bundle.get("MovieName");
        }

        dbMovieInfo(movieInventory, movieIndex);

        movieTitleView.setText("Title: " + movieInventory.get(0));
        movieYearView.setText("Year: " + movieInventory.get(1));
        movieRatingView.setText("Rating: " + movieInventory.get(2));
        // movieYearTxt.setText(ml.get(6));
        movieRuntimeView.setText("Runtime: " + movieInventory.get(3));
        movieActorsView.setText("Actors: " + movieInventory.get(4));
        moviePlotView.setText("Plot: " + movieInventory.get(5));
        setMovieValues();

        image = BitmapFactory.decodeFile(imagePath + movieInventory.get(0)+ ".png");
        movieImageView.setImageBitmap(image);

    }

    public void dbMovieInfo(ArrayList<String> al, int index){

        MovieDBHelper moviedbh = new MovieDBHelper(this);
        SQLiteDatabase db = moviedbh.getWritableDatabase();

        // Cursor c = db.rawQuery("SELECT * FROM movie_table WHERE movie_title =" + movieName, null);
        //int movieID = db.rawQuery("SELECT _id FROM movie_table WHERE movie_title=" + ml.get(0).toString(), null);
        Cursor c = db.rawQuery("SELECT * FROM movie_table WHERE movie_id = " + (index), null);
        if(c.getCount() !=0){
            c.moveToFirst();
            for(int i = 1; i <= 7; i++){
                String resultTitle = c.getString(i);
                al.add(resultTitle);
                Log.i(TAG, resultTitle);
            }
        }
    }

    private void setMovieValues(){
        for(String i: movieInventory){
            Log.i(TAG, i);
        }
    }

 /*   public boolean fileExistance(String fname){
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }



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
*/






    }






