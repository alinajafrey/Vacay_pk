package com.example.vacay_pk;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class swathotel extends AppCompatActivity {

    private Button sb1;
    private Button sb2;
    private Button sb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swathotel);
        sb1 = (Button) findViewById(R.id.shone);
        sb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySwatBundle();
            }
        });
        sb2 = (Button) findViewById(R.id.shtwo);
        sb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySwatBundle();
            }
        });
        sb3 = (Button) findViewById(R.id.shthree);
        sb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySwatBundle();
            }
        });
    }

    public void openActivitySwatBundle() {
        Intent intent = new Intent(this, swatbundles.class);
        startActivity(intent);
    }
}