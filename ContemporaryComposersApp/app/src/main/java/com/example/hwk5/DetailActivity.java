package com.example.hwk5;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView composerImage = findViewById(R.id.composerImage);
        TextView composerName = findViewById(R.id.composerName);
        TextView composerDetails = findViewById(R.id.composerDetails);

        // Get the data from the intent
        String firstName = getIntent().getStringExtra("firstName");
        String lastName = getIntent().getStringExtra("lastName");
        String photo = getIntent().getStringExtra("photo");
        int yearOfBirth = getIntent().getIntExtra("yearOfBirth", 0);
        int yearOfDeath = getIntent().getIntExtra("yearOfDeath", 0);
        String country = getIntent().getStringExtra("country");

        // Set the data on the views
        String fullName = firstName + " " + lastName;
        composerName.setText(fullName);
        composerDetails.setText("Born: " + yearOfBirth + "\nDied: " + yearOfDeath + "\nCountry: " + country);

        // Set the image based on the photo filename
        int imageId = getResources().getIdentifier(photo, "drawable", getPackageName());
        composerImage.setImageResource(imageId);
    }
}
