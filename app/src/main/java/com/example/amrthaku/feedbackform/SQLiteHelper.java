package com.example.amrthaku.feedbackform;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {


    public static final String TABLE_NAME = "EMPLOYEE";
    public static final String COLUMN_ID = "EMP_ID";
    public static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    public static final String COLUMN_LAST_NAME = "LAST_NAME";

    public static final String TABLE_NAME1 = "FEEDBACK";
    public static final String COLUMN_ID1 = "ID";
    public static final String COLUMN_CONTENT1 = "CONTENT";
    public static final String COLUMN_TOPIC1 = "TOPIC";
    public static final String COLUMN_ENJOYMENT1 = "ENJOYMENT";
    public static final String COLUMN_COMMENT1 = "COMMENT";

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SQLiteDatabase.db";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);*/
        db.execSQL("create table " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_FIRST_NAME + " VARCHAR, " + COLUMN_LAST_NAME + " VARCHAR);");
        db.execSQL("create table " + TABLE_NAME1 + " ( " + COLUMN_ID1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_CONTENT1 + " VARCHAR, " + COLUMN_TOPIC1 + " VARCHAR, " + COLUMN_ENJOYMENT1 + " VARCHAR, " + COLUMN_COMMENT1 + " VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }

    private SQLiteDatabase database;

    public void insertRecord(Employee employee) {
        database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME, employee.getFirst_name());
        contentValues.put(COLUMN_LAST_NAME, employee.getLast_name());
        database.insert(TABLE_NAME, null, contentValues);
        database.close();
    }

    public ArrayList<Employee> getAllRecords() {
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                employee = new Employee();
                employee.setEmpId(cursor.getString(0));
                employee.setFirst_name(cursor.getString(1));
                employee.setLast_name(cursor.getString(2));
                employees.add(employee);
            }
        }
        cursor.close();
        database.close();
        return employees;
    }

    public void insertFeedBackRecord(Feedback feedback) {
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
                feedback.setId(cursor.getString(0));
                feedback.setContent(cursor.getString(1));
                feedback.setTopic(cursor.getString(2));
                feedback.setEnjoyment(cursor.getString(3));
                feedback.setComment(cursor.getString(4));
                feedBacks.add(feedback);
            }
        }
        cursor.close();
        database.close();
        return feedBacks;
    }

}