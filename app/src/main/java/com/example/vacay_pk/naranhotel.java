package com.example.vacay_pk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class naranhotel extends AppCompatActivity {

    private Button nb1;
    private Button nb2;
    private Button nb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nb1=(Button)findViewById(R.id.nhone);
        nb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        nb2=(Button)findViewById(R.id.nhtwo);
        nb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        nb3=(Button)findViewById(R.id.nhthree);
        nb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }
    public void openActivity()
    {
        Intent intent =new Intent(this,naranbundles.class);
        startActivity(intent);
    }
}
