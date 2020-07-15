package com.example.vacay_pk;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class screen4 extends ListActivity {

    ListView listView;
    String menuitems[] = {
            "Murree",
            "Islamabad",
            "Swat ",
            "Naran",
            "Gilgit",
            "Hunza",
            "Kashmir"

    };


    int imageid[] = {
            R.drawable.muree,
            R.drawable.islamabad,
            R.drawable.swat,
            R.drawable.naran,
            R.drawable.gilgit,
            R.drawable.hunza,
            R.drawable.kashmir,  };







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);



        listView = findViewById(android.R.id.list);
        MyAdapter adapter = new MyAdapter(this, menuitems, imageid);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), Murree.class);

                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), Islamabad.class);

                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(getApplicationContext(), Swat.class);

                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(), Naran.class);

                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(getApplicationContext(), Gilgit.class);

                    startActivity(intent);
                }
                if (position == 5) {
                    Intent intent = new Intent(getApplicationContext(), Hunza.class);

                    startActivity(intent);
                }
                if (position == 6) {
                    Intent intent = new Intent(getApplicationContext(), Kashmir.class);

                    startActivity(intent);
                }
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String menuitems[];
        int imageid[];

        MyAdapter(Context c, String menuitem[], int imageid[]) {
            super(c, R.layout.rox_item,R.id.textView1, menuitem);
            this.context = c;
            this.menuitems = menuitem;
            this.imageid = imageid;

        }
        @NonNull
        @Override
        public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.rox_item,parent,false);
            ImageView image=row.findViewById(R.id.imageView);
            TextView textView=row.findViewById(R.id.textView1);
            image.setImageResource(imageid[position]);
            textView.setText(menuitems[position]);

            return row;
        }
    }
}
