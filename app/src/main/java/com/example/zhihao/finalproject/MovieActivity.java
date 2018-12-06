package com.example.zhihao.finalproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.AsyncTask;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import static android.content.ContentValues.TAG;

public class MovieActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 50;
    private String movieURLS = "https://www.omdbapi.com/?apikey=6c9862c2&r=xml&t=";
    private String imageURL;
    private String movieTitle;
    private String movieYear;
    private String movieRating;
    private String movieRuntime;
    private String movieActors;
    private String moviePlot;

    String movieName;
    private TextView movieTitleView;
    private TextView movieYearView;
    private TextView movieRatingView;
    private TextView movieRuntimeView;
    private TextView movieActorsView;
    private TextView moviePlotView;
    private ImageView movieImageView;
    private EditText movieSearchEdit;


    //Button movieDetail;
    Button movieSearch;
    ProgressBar progressBar;
    Toolbar toolbar;
    Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_main);

        progressBar = findViewById(R.id.progressBar);
        toolbar = findViewById(R.id.toolbar);
        movieImageView = (ImageView) findViewById(R.id.movieImageView);
        movieTitleView = (TextView) findViewById(R.id.movieTitleView);
        movieYearView = (TextView) findViewById(R.id.movieYearView);
        movieRatingView = (TextView) findViewById(R.id.movieRatingView);
        movieRuntimeView = (TextView) findViewById(R.id.movieRuntimeView);
        movieActorsView = (TextView) findViewById(R.id.movieActorsView);
        moviePlotView = (TextView) findViewById(R.id.moviePlotView);
        movieSearchEdit = (EditText) findViewById(R.id.searchEditText);
//        setSupportActionBar(toolbar);

        movieSearch = (Button) findViewById(R.id.movieSearch);

        movieSearch.setOnClickListener((View e) -> {
            MovieQuery query = new MovieQuery();
            try {
                movieName = URLEncoder.encode(movieSearchEdit.getText().toString(), "UTF-8");
            } catch (UnsupportedEncodingException uee) {
                uee.printStackTrace();
            }
            query.execute();
            MovieFragment mf = new MovieFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.movieFragement, mf).commit();
        });

        // getFragmentManager().beginTransaction().replace(R.id.movieFragement, mf).commit();
        Toast toast = Toast.makeText(getApplicationContext(), "Welcome to Zhaoyu Wang's MovieApp", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
        AlertDialog.Builder builder;
        //int id;
        switch (item.getItemId()) {
            case R.id.help:
                builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.dialog_message)
                        .setTitle(R.string.moive_help)
                        .setMessage(R.string.newMessage)
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        }).show();
                break;
            case R.id.about:

                builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.dialog_message)
                        .setTitle(R.string.moive_about)
                        .setMessage(R.string.movieAuthorName)
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        }).show();

                break;
        }

        return true;
    }

    public static Bitmap getImage(URL url) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                return BitmapFactory.decodeStream(connection.getInputStream());
            } else
                return null;
        } catch (Exception e) {
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private class MovieQuery extends AsyncTask<String, Integer, String> {

        protected String doInBackground(String... args) {
            try {

                URL movieURL = new URL(movieURLS + movieName);
                HttpURLConnection conn = (HttpURLConnection) movieURL.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                // Starts the query
                conn.connect();
                InputStream in = (InputStream) conn.getInputStream();

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);

                XmlPullParser parser = factory.newPullParser();
                parser.setInput(in, "UTF-8");

                // String value;
                while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {

                    switch (parser.getEventType()) {
                        case XmlPullParser.START_TAG:
                            String name = parser.getName();
                            if (name.equals("movie")) {
                                movieTitle = parser.getAttributeValue(null, "title");
                                Log.i(TAG, movieTitle);
                                publishProgress(25);
                                movieYear = parser.getAttributeValue(null, "year");
                                Log.i(TAG, movieYear);
                                publishProgress(50);
                                movieRating = parser.getAttributeValue(null, "imdbRating");
                                publishProgress(75);
                                Log.i(TAG, movieRating);
                                movieRuntime = parser.getAttributeValue(null, "runtime");
                                Log.i(TAG, movieRuntime);
                                movieActors = parser.getAttributeValue(null, "actors");
                                moviePlot = parser.getAttributeValue(null, "plot");
                                imageURL = parser.getAttributeValue(null, "poster");
                                Log.i(TAG, imageURL);

                                URL iconUrl = new URL(imageURL + movieName + ".png");
                                image = getImage(iconUrl);
                                FileOutputStream outputStream = openFileOutput(movieName + ".png", Context.MODE_PRIVATE);
                                image.compress(Bitmap.CompressFormat.PNG, 80, outputStream);
                                outputStream.flush();
                                outputStream.close();
                            }
                            Log.i(TAG, name);
                            break;
                        case XmlPullParser.TEXT:
                            break;
                    }
                    parser.next();
                }
            } catch (Exception e) {
                Log.i(TAG, e.getMessage());
            }
            return "";
        }

        public void onProgressUpdate(Integer... args) {
            progressBar.setProgress(args[0]);
            progressBar.setVisibility(View.VISIBLE);
        }

        public void onPostExecute(String result) {
            try {
                movieImageView.setImageBitmap(image);
                movieTitleView.setText("Title: " + movieTitle);
                movieYearView.setText("Year: " + movieYear);
                movieRatingView.setText("Rating: " + movieRating);
                movieRuntimeView.setText("Movie Runtime: " + movieRuntime);
                movieActorsView.setText("Actors: " + movieActors);
                moviePlotView.setText("Plot: " + moviePlot);
                progressBar.setVisibility(View.INVISIBLE);
            } catch (Exception e) {
                Log.i(TAG, e.getMessage());
            }
        }
    }

 /*   public boolean fileExistance(String fname){
        File file = getBaseContext().getFileStreamPath(fname);
        image = BitmapFactory.decodeFile(file.getAbsolutePath());
        Log.i(TAG, file.getAbsolutePath());
        return file.exists();
    }*/
}
