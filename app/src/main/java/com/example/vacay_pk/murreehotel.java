package com.example.vacay_pk;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class murreehotel extends AppCompatActivity {

    private Button mb1;
    private Button mb2;
    private Button mb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_murreehotel);
        mb1 = (Button) findViewById(R.id.mhone);
        mb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        mb2 = (Button) findViewById(R.id.mhtwo);
        mb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        mb3 = (Button) findViewById(R.id.mhthree);
        mb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }

    public void openActivity() {
        Intent intent = new Intent(this, murreebundles.class);
        startActivity(intent);
    }
}