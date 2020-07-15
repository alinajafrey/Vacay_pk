package com.example.vacay_pk;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Islamabad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gilgit);


        Button htl = findViewById(R.id.htl);

        htl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeHotels();
            }

        });

        Button dst = findViewById(R.id.dst);
        dst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeDestinations();
            }
        });

        Button maps= findViewById(R.id.maps);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeMaps();
            }
        });

        Button restaurant = findViewById(R.id.rstn);
        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeRestaurants();
            }
        });
        Button FB = findViewById(R.id.FFB);
        FB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fb();
            }
        });
    }

    public void seeHotels()
    {
        Intent intent = new Intent (this, islamabadhotel.class );
        startActivity(intent);
    }



    public void seeDestinations()
    {
        Intent intent = new Intent (this, islamabaddestination.class );
        startActivity(intent);
    }

    public void seeMaps()
    {
        // Intent intent = new Intent (this, activityMaps.class );
        //   startActivity(intent);
        Intent openURL = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps"));

        startActivity(openURL);

    }

    public void seeRestaurants()
    {
        Intent intent = new Intent (this, islamabadrestaurant.class );
        startActivity(intent);
    }
    public void fb()
    {
        Intent intent = new Intent (this, Feedback.class );
        startActivity(intent);
    }
}

