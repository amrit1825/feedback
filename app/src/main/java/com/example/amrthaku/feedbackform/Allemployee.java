package com.example.amrthaku.feedbackform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by amrthaku on 1/17/2018.
 */

public class Allemployee extends AppCompatActivity {

    private ListView obj;
    ArrayList <Employee> employees = new ArrayList<>();
    SQLiteHelper db = new SQLiteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allemployee);

        employees = db.getAllRecords();

        ArrayAdapter<Employee> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, employees);
        obj = (ListView)findViewById(R.id.list_item);
        obj.setAdapter(adapter);
    }
}
