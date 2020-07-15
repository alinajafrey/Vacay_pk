package com.example.vacay_pk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class murreebundles extends AppCompatActivity {
    DatabaseReference reff;
    private Button mbut1;
    private Button mp1;
    private Button mp2;
    private Button mp3;
    private Button mbut2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_murreebundles);

        mbut1 = (Button) findViewById(R.id.back);
        mbut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        mp1 = (Button) findViewById(R.id.price1);
        mp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        mp2 = (Button) findViewById(R.id.price2);
        mp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        mp3 = (Button) findViewById(R.id.price3);
        mp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        mbut2 = (Button) findViewById(R.id.home);
        mbut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        reff= FirebaseDatabase.getInstance().getReference().child("bundles").child("murree");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String b1=snapshot.child("m1").getValue().toString();
                String b2=snapshot.child("m2").getValue().toString();
                String b3=snapshot.child("m3").getValue().toString();
                mp1.setText(b1);
                mp2.setText(b2);
                mp3.setText(b3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void openActivity()
    {
        Intent intent =new Intent(this,Murree.class);
        startActivity(intent);
    }
    public void openActivity1()
    {
        Intent intent =new Intent(this,murreehotel.class);
        startActivity(intent);
    }
    public void openActivity2()
    {
        Intent intent =new Intent(this,murreedestination.class);
        startActivity(intent);
    }

}

