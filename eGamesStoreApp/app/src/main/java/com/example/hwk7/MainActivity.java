package com.example.hwk7;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.Serializable;
import java.util.List;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private List<Game> gameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "onCreate() is running!");

        // Initialize GridView and fetch game data from CSV
        GridView gridView = findViewById(R.id.gameGridView);
        gameList = CSVReader.readCSV(this, "egames2024.csv");

        // Create adapter and set it to GridView
        GameAdapter adapter = new GameAdapter(this, gameList);
        gridView.setAdapter(adapter);

        gridView.setAdapter(adapter);

// Check if adapter has items
        if (adapter.getCount() == 0) {
            Log.e("MainActivity", "GameAdapter is empty! No items to display.");
        } else {
            Log.d("MainActivity", "GridView has " + adapter.getCount() + " items.");
        }


        // Set up click listener to go to GameDetailActivity
        gridView.setOnItemClickListener((AdapterView<?> parent, android.view.View view, int position, long id) -> {
            Intent intent = new Intent(MainActivity.this, GameDetailActivity.class);
            intent.putExtra("game", (Serializable) gameList.get(position));  // FIXED HERE
            startActivity(intent);
        });
    }
}
