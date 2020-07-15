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


public class hunzabundles extends AppCompatActivity {
    DatabaseReference reff;
    private Button hbut1;
    private Button hp1;
    private Button hp2;
    private Button hp3;
    private Button hbut2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunzabundles);


        hp1=(Button)findViewById(R.id.hprice1);
        hp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        hp2=(Button)findViewById(R.id.hprice2);
        hp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        hp3=(Button)findViewById(R.id.hprice3);
        hp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        hbut1=(Button)findViewById(R.id.hback);
        hbut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        hbut2=(Button)findViewById(R.id.hhome);
        hbut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        reff= FirebaseDatabase.getInstance().getReference().child("bundles").child("hunza");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String b1=snapshot.child("h1").getValue().toString();                 //firebase retrieving data
                String b2=snapshot.child("h2").getValue().toString();
                String b3=snapshot.child("h3").getValue().toString();
                hp1.setText(b1);
                hp2.setText(b2);
                hp3.setText(b3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    public void openActivity1()
    {
        Intent intent =new Intent(this,Hunza.class);
        startActivity(intent);
    }
    public void openActivity2()
    {
        Intent intent =new Intent(this,hunzahotel.class);
        startActivity(intent);
    }
    public void openActivity3()
    {
        Intent intent =new Intent(this,hunzadestination.class);
        startActivity(intent);
    }
}

