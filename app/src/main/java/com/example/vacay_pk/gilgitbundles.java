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


public class gilgitbundles extends AppCompatActivity {
    DatabaseReference reff;
    private Button gbut1;
    private Button gp1;
    private Button gp2;
    private Button gp3;
    private Button gbut2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gilgitbundles);


        gp1 = (Button) findViewById(R.id.gprice1);
        gp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        gp2 = (Button) findViewById(R.id.gprice2);
        gp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        gp3 = (Button) findViewById(R.id.gprice3);
        gp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        gbut1 = (Button) findViewById(R.id.gback);
        gbut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        gbut2 = (Button) findViewById(R.id.ghome);
        gbut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        reff= FirebaseDatabase.getInstance().getReference().child("bundles").child("gilgit");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String b1=snapshot.child("b1").getValue().toString();
                String b2=snapshot.child("b2").getValue().toString();
                String b3=snapshot.child("b3").getValue().toString();
                gp1.setText(b1);
                gp2.setText(b2);
                gp3.setText(b3);
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

