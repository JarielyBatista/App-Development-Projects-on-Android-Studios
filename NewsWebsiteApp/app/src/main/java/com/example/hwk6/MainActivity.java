package com.example.hwk6;



import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsAdapter.OnItemClickListener {

    private List<NewsItem> newsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadCSVData(); // Load CSV data
        adapter = new NewsAdapter(newsList, this);
        recyclerView.setAdapter(adapter);
    }

    private void loadCSVData() {
        try {
            InputStream inputStream = getAssets().open("News_org_032025.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    newsList.add(new NewsItem(parts[0], parts[1], parts[2])); // Create NewsItem from CSV
                }
            }
            reader.close();
        } catch (IOException e) {
            Toast.makeText(this, "Error loading CSV", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("news_url", newsList.get(position).getUrl());
        startActivity(intent); // Open the URL in WebViewActivity
    }

}



