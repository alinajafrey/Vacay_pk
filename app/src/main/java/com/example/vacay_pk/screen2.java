package com.example.vacay_pk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class screen2 extends AppCompatActivity {
    private Button NEXT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        NEXT= (Button) findViewById(R.id.button);

        NEXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onButtonClickView( view);
            }
        });
    }
    private void  onButtonClickView(View view) {

        Intent intent = new Intent(this,screen3.class);
        startActivity(intent);
    }
}

