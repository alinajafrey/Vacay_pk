package com.example.vacay_pk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button GoSafe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GoSafe = (Button) findViewById(R.id.button2);

        GoSafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onButtonClickView( view);
            }
        });
    }

    public void onButtonClickView(View v) {
        Intent intent = new Intent(this,screen2.class);
        startActivity(intent);
    }

}
