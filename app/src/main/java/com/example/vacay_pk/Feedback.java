package com.example.vacay_pk;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText names = findViewById(R.id.nameid);
        final EditText feedback = findViewById(R.id.actv);
        Button btn = findViewById(R.id.feedbackbutton);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/html");
                i.putExtra(Intent.EXTRA_EMAIL, new String("alinahassan555@gmail.com"));
                i.putExtra(Intent.EXTRA_SUBJECT, "Feedback from Vacay.pk");
                i.putExtra(Intent.EXTRA_TEXT, "Name:"+names.getText());
                i.putExtra(Intent.EXTRA_TEXT, "Message:"+ feedback.getText());
                try{
                    startActivity(Intent.createChooser(i, "Please Select Email"));
                } catch (android.content.ActivityNotFoundException e) {
                    Toast.makeText(Feedback.this, "There are no email clients", Toast.LENGTH_LONG);
                }
            }
        });
    }
}
