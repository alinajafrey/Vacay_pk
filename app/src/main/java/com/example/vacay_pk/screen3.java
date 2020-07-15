package com.example.vacay_pk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class screen3 extends AppCompatActivity {
    private Button heyletsgo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        heyletsgo = (Button) findViewById(R.id.button3);

        heyletsgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onButtonClickView(view);
            }
        });
    }

    private void onButtonClickView(View view) {

        Intent intent = new Intent(this, Loginn.class);
        startActivity(intent);
    }
}