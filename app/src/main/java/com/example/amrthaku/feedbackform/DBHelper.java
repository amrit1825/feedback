package com.example.amrthaku.feedbackform;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by amrthaku on 1/17/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query;
        query = "CREATE TABLE Employees ( EmpId TEXT, EmployeeName TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query;
        query = "DROP TABLE IF EXISTS Employees";
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }

    public void insertEmployee(String Name, String EmpId){
        SQLiteDatabase db = this.getWritableDatabase();
        String name = Name;
        String empId = EmpId;
        String query;
        query = "INSERT INTO EMPLOYEES VALUES(" + name + "," + empId + ")";
        db.execSQL(query);
    }

}
