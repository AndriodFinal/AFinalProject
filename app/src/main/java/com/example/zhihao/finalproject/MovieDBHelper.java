package com.example.zhihao.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class MovieDBHelper extends SQLiteOpenHelper {
    protected static final String DATABASE_NAME = "Movies.db";
    protected static final String TABLE_NAME = "movie_table";
    public static final String MOVIE_ID = "movie_id";
    public static final String MOVIE_TITLE = "movie_title";
    public static final String MOVIE_YEAR = "movie_year";
    public static final String MOVIE_RATING = "movie_rating";
    public static final String MOVIE_RUNTIME ="movie_runtime";
    public static final String MOVIE_ACTORS ="movie_actors";
    public static final String MOVIE_PLOT ="movie_plot";
    public static final String MOVIE_IMAGE_URL = "movie_image_URL";
    protected static final int VERSION_NUM = 2;

    public MovieDBHelper(Context ctx){
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                "(" + MOVIE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MOVIE_TITLE + " TEXT," +
                MOVIE_YEAR + " INTEGER," +
                MOVIE_RATING + " TEXT," +
                MOVIE_RUNTIME + " INTEGER," +
                MOVIE_ACTORS + "  TEXT," +
                MOVIE_PLOT + " TEXT," +
                MOVIE_IMAGE_URL + " TEXT" +
                ");");
        Log.i(TAG, "onCreate start");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        Log.i(TAG, "onUpgrade start");
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int newVersion, int oldVersion){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
            Log.i(TAG, "onDowngrade start");
    }

}