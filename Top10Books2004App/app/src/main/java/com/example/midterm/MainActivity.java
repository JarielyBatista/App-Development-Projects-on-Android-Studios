package com.example.midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Book Data
    String[] bookTitles = {
            "Fake Work", "The Shape of a Life", "Why the Western Can't Win",
            "The Road Less Stupid", "World Politics in a New Era", "Play It Again",
            "Demon or Unrest", "What the Dog Saw", "The Storm We Made", "Heartless Hunter"
    };

    String[] bookAuthors = {
            "B. Peterson and G. W. Nelson", "Shing-Tung Yau", "Fadi Lama",
            "K. Cunningham", "S.L.Spiegel et.al.", "Alan Rusbridger",
            "Erik Larson", "Malcolm Gladwell", "Vanessa Chan", "Kristen Ciccarelli"
    };

    int[] bookImages = {
            R.drawable.fake_work, R.drawable.shape_of_life, R.drawable.why_western,
            R.drawable.road_less_stupid, R.drawable.world_politics, R.drawable.play_it_again,
            R.drawable.demon_unrest, R.drawable.what_dog_saw, R.drawable.storm_we_made,
            R.drawable.heartless_hunter
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find ListView
        ListView bookListView = findViewById(R.id.bookListView);

        // Create adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookTitles);
        bookListView.setAdapter(adapter);

        // Handle item clicks
        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, BookDetailActivity.class);
                intent.putExtra("title", bookTitles[position]);
                intent.putExtra("author", bookAuthors[position]);
                intent.putExtra("imageResId", bookImages[position]);
                startActivity(intent);
            }
        });
    }
}
