package com.example.hwk4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> countryList;
    private HashMap<String, String> countryCapitalMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        countryList = new ArrayList<>();
        countryCapitalMap = new HashMap<>();

        // Read CSV and populate the list
        readCSV();

        // Set up ListView adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countryList);
        listView.setAdapter(adapter);

        // Handle ListView item clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country = countryList.get(position);
                String capital = countryCapitalMap.get(country);

                // Open DetailActivity
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("country", country);
                intent.putExtra("capital", capital);
                startActivity(intent);
            }
        });
    }

    // Read CSV file from res/raw and populate HashMap & ArrayList
    private void readCSV() {
        InputStream inputStream = getResources().openRawResource(R.raw.country_capital);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String country = parts[0].trim();
                    String capital = parts[1].trim();

                    countryList.add(country);
                    countryCapitalMap.put(country, capital);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
