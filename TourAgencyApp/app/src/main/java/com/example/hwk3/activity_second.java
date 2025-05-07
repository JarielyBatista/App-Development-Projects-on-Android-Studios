package com.example.hwk3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class activity_second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // List of top 10 cities
        String[] cities = {"New York", "Miami", "Orlando", "Los Angeles", "San Francisco", "Las Vegas",
                "Washington DC", "Chicago", "Boston"};

        // Set up ListView with the list of cities
        ListView listView = findViewById(R.id.cityListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cities);
        listView.setAdapter(adapter);

        // Set click listener on the list to transition to the third screen
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedCity = cities[position];
            Intent intent = new Intent(activity_second.this, activity_third.class);
            intent.putExtra("selectedCity", selectedCity);
            startActivity(intent);
        });
    }
}
