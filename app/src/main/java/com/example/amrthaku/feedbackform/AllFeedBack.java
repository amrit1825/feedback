package com.example.amrthaku.feedbackform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by amrthaku on 1/18/2018.
 */

public class AllFeedBack extends AppCompatActivity {

    private ListView obj1;
    ArrayList<Feedback> feedBacks = new ArrayList<>();
    SQLiteHelper db = new SQLiteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allfeedback);

        feedBacks = db.getAllFeedback();

        ArrayAdapter<Feedback> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, feedBacks);
        obj1 = (ListView)findViewById(R.id.list_item1);
        obj1.setAdapter(adapter);
    }
}

