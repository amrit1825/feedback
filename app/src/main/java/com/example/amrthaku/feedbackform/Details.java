package com.example.amrthaku.feedbackform;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by amrthaku on 1/17/2018.
 */

public class Details extends AppCompatActivity {

    Employee employee = new Employee();
    SQLiteHelper db = new SQLiteHelper(this);
    EditText e1, e2;
    Button b1;
    String firstName, lastName;

    boolean CheckEditTextEmpty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details1);

        e1 = (EditText) findViewById(R.id.editText1);


        e2 = (EditText) findViewById(R.id.editText2);




        final Context context = this;

        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {


            public void onClick(View arg0) {
                firstName = e1.getText().toString();
                lastName = e2.getText().toString();

                boolean b1 = CheckEditTextIsEmptyOrNot(firstName);
                boolean b2 = CheckEditTextIsEmptyOrNot(lastName);

                if(b1 == true && b2 == true)
                {

                    employee.setFirst_name(firstName);

                    employee.setLast_name(lastName);



                    db.insertRecord(employee);
                    Toast.makeText(Details.this,"Data Submit Successfully", Toast.LENGTH_LONG).show();
                    ClearEditTextAfterDoneTask();

                    Intent intent2 = new Intent(context, Form.class);
                    startActivity(intent2);


                }
                else {

                    Toast.makeText(Details.this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();
                }
            }});}


            public boolean CheckEditTextIsEmptyOrNot(String Task){

                if(TextUtils.isEmpty(Task)){

                    CheckEditTextEmpty = false ;

                }
                else {
                    CheckEditTextEmpty = true ;
                }

                return CheckEditTextEmpty;
            }

            public void ClearEditTextAfterDoneTask(){

                e1.getText().clear();
                e2.getText().clear();
            }





                /*employee.setFirst_name(firstName);

                employee.setLast_name(lastName);



                db.insertRecord(employee);

                Intent intent2 = new Intent(context, Form.class);
                startActivity(intent2);*/

}


