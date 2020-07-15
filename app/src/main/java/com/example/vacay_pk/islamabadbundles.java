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


public class islamabadbundles extends AppCompatActivity {
    DatabaseReference reff;
    private Button ibut1;
    private Button ip1;
    private Button ip2;
    private Button ip3;
    private Button ibut2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islamabadbundles);


        ip1 = (Button) findViewById(R.id.iprice1);
        ip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        ip2 = (Button) findViewById(R.id.iprice2);
        ip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        ip3 = (Button) findViewById(R.id.iprice3);
        ip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        ibut1 = (Button) findViewById(R.id.iback);
        ibut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        ibut2 = (Button) findViewById(R.id.ihome);
        ibut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        reff= FirebaseDatabase.getInstance().getReference().child("bundles").child("islamabad");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String b1=snapshot.child("i1").getValue().toString();
                String b2=snapshot.child("i2").getValue().toString();
                String b3=snapshot.child("i3").getValue().toString();
                ip1.setText(b1);
                ip2.setText(b2);
                ip3.setText(b3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    public void openActivity()
    {
        Intent intent =new Intent(this,Islamabad.class);
        startActivity(intent);
    }
    public void openActivity1()
    {
        Intent intent =new Intent(this,islamabadhotel.class);
        startActivity(intent);
    }
    public void openActivity2()
    {
        Intent intent =new Intent(this,islamabaddestination.class);
        startActivity(intent);
    }

}
