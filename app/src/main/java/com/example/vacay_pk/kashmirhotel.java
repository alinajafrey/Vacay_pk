package com.example.vacay_pk;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kashmirhotel extends AppCompatActivity {
    private Button Kb1;
    private Button kb2;
    private Button kb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Kb1=(Button)findViewById(R.id.khone);
        Kb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        kb2=(Button)findViewById(R.id.khtwo);
        kb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        kb3=(Button)findViewById(R.id.khthree);
        kb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }
    public void openActivity2()
    {
        Intent intent =new Intent(this,kashmirbundles.class);
        startActivity(intent);
    }
}
