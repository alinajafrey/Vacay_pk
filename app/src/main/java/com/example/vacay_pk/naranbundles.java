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


public class naranbundles extends AppCompatActivity {
    DatabaseReference reff;
    private Button nbut1;
    private Button np1;
    private Button np2;
    private Button np3;
    private Button nbut2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naranbundles);

        nbut1 = (Button) findViewById(R.id.back);
        nbut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        np1 = (Button) findViewById(R.id.price1);
        np1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        np2 = (Button) findViewById(R.id.price2);
        np2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        np3 = (Button) findViewById(R.id.price3);
        np3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        nbut2 = (Button) findViewById(R.id.home);
        nbut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        reff= FirebaseDatabase.getInstance().getReference().child("bundles").child("naran");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String b1=snapshot.child("n1").getValue().toString();
                String b2=snapshot.child("n2").getValue().toString();
                String b3=snapshot.child("n3").getValue().toString();
                np1.setText(b1);
                np2.setText(b2);
                np3.setText(b3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void openActivity()
    {
        Intent intent =new Intent(this,Naran.class);
        startActivity(intent);
    }
    public void openActivity1()
    {
        Intent intent =new Intent(this,naranhotel.class);
        startActivity(intent);
    }
    public void openActivity2()
    {
        Intent intent =new Intent(this,narandestination.class);
        startActivity(intent);
    }

}

