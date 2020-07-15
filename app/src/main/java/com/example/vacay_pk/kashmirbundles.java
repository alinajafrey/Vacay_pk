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


public class kashmirbundles extends AppCompatActivity {
    DatabaseReference reff;
    private Button kbut1;
    private Button kp1;
    private Button kp2;
    private Button kp3;
    private Button kbut2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kashmirbundles);

        kbut1=(Button)findViewById(R.id.back);
        kbut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        kp1=(Button)findViewById(R.id.price1);
        kp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        kp2=(Button)findViewById(R.id.price2);
        kp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        kp3=(Button)findViewById(R.id.price3);
        kp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        kbut2=(Button)findViewById(R.id.home);
        kbut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        reff= FirebaseDatabase.getInstance().getReference().child("bundles").child("kashmir");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String b1=snapshot.child("k1").getValue().toString();
                String b2=snapshot.child("k2").getValue().toString();
                String b3=snapshot.child("k3").getValue().toString();
                kp1.setText(b1);
                kp2.setText(b2);
                kp3.setText(b3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    public void openActivity()
    {
        Intent intent =new Intent(this,Kashmir.class);
        startActivity(intent);
    }
    public void openActivity1()
    {
        Intent intent =new Intent(this,kashmirhotel.class);
        startActivity(intent);
    }
    public void openActivity2()
    {
        Intent intent =new Intent(this,kashmirdestination.class);
        startActivity(intent);
    }

}
