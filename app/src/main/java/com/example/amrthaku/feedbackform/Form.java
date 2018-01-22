package com.example.amrthaku.feedbackform;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by amrthaku on 1/17/2018.
 */

public class Form extends AppCompatActivity {

    SQLiteHelper db = new SQLiteHelper(this);
    Feedback feedback = new Feedback();
    private EditText editText;
    private RadioGroup radioContentGroup;
    private RadioButton radioContentButton;
    private Button buttonSubmit;
    String radio,check,spin,text;
    private CheckBox checkBox1,checkBox2;
    private Spinner spinner1;
    final Context context = this;
    boolean CheckEditTextEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_main1);
        addListenerOnButton();
    }

    public void addListenerOnButton() {



        radioContentGroup = (RadioGroup) findViewById(R.id.radio_group);

        checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkbox2);

        spinner1 = (Spinner) findViewById(R.id.spinner);

        editText = (EditText) findViewById(R.id.editText_comment);

        buttonSubmit = (Button) findViewById(R.id.button_submit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioContentGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                if(selectedId!=-1) {
                    radioContentButton = (RadioButton) findViewById(selectedId);

                    radio = radioContentButton.getText().toString();
                }
                /*Toast.makeText(Form.this,
                        radioContentButton.getText(), Toast.LENGTH_SHORT).show();*/

                if(checkBox1.isChecked()){
                    check = "Java";
                }

                if(checkBox2.isChecked()){
                    check = "Android";
                }

                spin = String.valueOf(spinner1.getSelectedItem());

                text = editText.getText().toString();

                boolean b1 = CheckEditTextIsEmptyOrNot(radio);
                boolean b2 = CheckEditTextIsEmptyOrNot(check);
                boolean b3 = CheckEditTextIsEmptyOrNot(spin);
                boolean b4 = CheckEditTextIsEmptyOrNot(text);

                if(b1 == true && b2 == true && b3 == true && b4 == true)
                {


                    feedback.setContent(radio);
                    feedback.setTopic(check);
                    feedback.setEnjoyment(spin);
                    feedback.setComment(text);

                    db.insertFeedBackRecord(feedback);
                    Toast.makeText(Form.this,"Data Submit Successfully", Toast.LENGTH_LONG).show();
                    Intent intent3 = new Intent(context, extra.class);
                    startActivity(intent3);


                }

                else {

                    Toast.makeText(Form.this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();
                }

            }

        });
    }

    public boolean CheckEditTextIsEmptyOrNot(String Task){

        if(TextUtils.isEmpty(Task)){

            CheckEditTextEmpty = false ;

        }
        else {
            CheckEditTextEmpty = true ;
        }

        return CheckEditTextEmpty;
    }

}