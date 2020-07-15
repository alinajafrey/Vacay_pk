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


public class swatbundles extends AppCompatActivity {
    DatabaseReference reff;
    private Button sbut1;
    private Button sp1;
    private Button sp2;
    private Button sp3;
    private Button sbut2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swatbundles);


        sp1 = (Button) findViewById(R.id.sprice1);
        sp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        sp2 = (Button) findViewById(R.id.sprice2);
        sp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        sp3 = (Button) findViewById(R.id.sprice3);
        sp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        sbut1 = (Button) findViewById(R.id.sback);
        sbut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        sbut2 = (Button) findViewById(R.id.shome);
        sbut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        reff= FirebaseDatabase.getInstance().getReference().child("bundles").child("swat");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String b1=snapshot.child("s1").getValue().toString();
                String b2=snapshot.child("s2").getValue().toString();
                String b3=snapshot.child("s3").getValue().toString();
                sp1.setText(b1);
                sp2.setText(b2);
                sp3.setText(b3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void openActivity() {
        Intent intent = new Intent(this, Gilgit.class);
        startActivity(intent);
    }

    public void openActivity1() {
        Intent intent = new Intent(this, gilgithotel.class);
        startActivity(intent);
    }

    public void openActivity2() {
        Intent intent = new Intent(this, gilgitdestination.class);
        startActivity(intent);
    }
}

