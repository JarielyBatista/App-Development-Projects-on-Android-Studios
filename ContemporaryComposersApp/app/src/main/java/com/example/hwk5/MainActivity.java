package com.example.hwk5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView composerListView;
    private List<Composer> composerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Make sure this matches the XML layout name

        // Find the ListView by its ID
        composerListView = findViewById(R.id.composerListView);

        // Create the list of composers
        composerList = new ArrayList<>();
        composerList.add(new Composer("Roy", "Agnew", "roy_agnew", 1891, 1944, "Australia"));
        composerList.add(new Composer("Hugo", "Alpen", "hugo_alpen", 1842, 1917, "Australia"));
        composerList.add(new Composer("Arthur", "Benjamin", "arthur_benjamin", 1893, 1960, "Australia"));
        composerList.add(new Composer("Hooper", "Brewster-Jones", "hooper_brewster_jones", 1887, 1949, "Australia"));
        composerList.add(new Composer("Vince", "Courtney", "vince_courtney", 1887, 1951, "Australia"));
        composerList.add(new Composer("Arthur", "Chanter", "arthur_chanter", 1886, 1950, "Australia"));
        composerList.add(new Composer("Percy", "Code", "percy_code", 1888, 1953, "Australia"));
        composerList.add(new Composer("George", "DeChaneet", "george_dechaneet", 1861, 1926, "Australia"));
        composerList.add(new Composer("John", "Delany", "john_delany", 1852, 1907, "Australia"));
        composerList.add(new Composer("Herbert", "DePinna", "herbert_depinna", 1880, 1936, "Australia"));

        // Set up the adapter for the ListView
        ComposerAdapter adapter = new ComposerAdapter(this, composerList);
        composerListView.setAdapter(adapter);

        // Set item click listener to show details when clicked
        composerListView.setOnItemClickListener((parent, view, position, id) -> {
            Composer selectedComposer = composerList.get(position);

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("firstName", selectedComposer.getFirstName());
            intent.putExtra("lastName", selectedComposer.getLastName());
            intent.putExtra("photo", selectedComposer.getPhoto());
            intent.putExtra("yearOfBirth", selectedComposer.getYearOfBirth());
            intent.putExtra("yearOfDeath", selectedComposer.getYearOfDeath());
            intent.putExtra("country", selectedComposer.getCountry());

            startActivity(intent);
        });
    }
}
