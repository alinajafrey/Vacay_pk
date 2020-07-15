package com.example.vacay_pk;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gilgithotel extends AppCompatActivity {

    private Button gb1;
    private Button gb2;
    private Button gb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gilgithotel);
        gb1=(Button)findViewById(R.id.ghone);
        gb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        gb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        gb2=(Button)findViewById(R.id.ghtwo);
        gb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        gb3=(Button)findViewById(R.id.ghthree);
        gb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }
    public void openActivity2()
    {
        Intent intent =new Intent(this,gilgitbundles.class);
        startActivity(intent);
    }
}