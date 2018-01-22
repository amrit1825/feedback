package com.example.amrthaku.feedbackform;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by amrthaku on 1/18/2018.
 */

public class SQLiteHelperFeedback extends SQLiteOpenHelper {

    public static final String TABLE_NAME1 = "FEEDBACK";
    public static final String COLUMN_ID1 = "ID";
    public static final String COLUMN_CONTENT1 = "CONTENT";
    public static final String COLUMN_TOPIC1 = "TOPIC";
    public static final String COLUMN_ENJOYMENT1 = "ENJOYMENT";
    public static final String COLUMN_COMMENT1 = "COMMENT";


    private static final int DATABASE_VERSION1 = 1;
    public static final String DATABASE_NAME1 = "SQLiteDatabase.db";

    public SQLiteHelperFeedback(Context context) {
        super(context, DATABASE_NAME1, null, DATABASE_VERSION1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME1 + " ( " + COLUMN_ID1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_CONTENT1 + " VARCHAR, " + COLUMN_TOPIC1 + " VARCHAR, " + COLUMN_ENJOYMENT1 + " VARCHAR, " + COLUMN_COMMENT1 + "VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }

    private SQLiteDatabase database;

    public void insertRecord(Feedback feedback) {
        database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CONTENT1, feedback.getContent());
        contentValues.put(COLUMN_TOPIC1, feedback.getTopic());
        contentValues.put(COLUMN_ENJOYMENT1, feedback.getEnjoyment());
        contentValues.put(COLUMN_COMMENT1, feedback.getComment());
        database.insert(TABLE_NAME1, null, contentValues);
        database.close();
    }

    public ArrayList<Feedback> getAllFeedback() {
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME1, null, null, null, null, null, null);
        ArrayList<Feedback> feedBacks = new ArrayList<>();
        Feedback feedback;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                feedback = new Feedback();
                feedback.setContent(cursor.getString(0));
                feedback.setTopic(cursor.getString(1));
                feedback.setEnjoyment(cursor.getString(2));
                feedback.setComment(cursor.getString(3));
                feedBacks.add(feedback);
            }
        }
        cursor.close();
        database.close();
        return feedBacks;
    }

}
