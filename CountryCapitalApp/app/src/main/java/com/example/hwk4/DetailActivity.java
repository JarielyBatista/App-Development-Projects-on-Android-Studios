package com.example.hwk4;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView countryTextView, capitalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        countryTextView = findViewById(R.id.countryTextView);
        capitalTextView = findViewById(R.id.capitalTextView);

        String country = getIntent().getStringExtra("country");
        String capital = getIntent().getStringExtra("capital");

        countryTextView.setText("Country: " + country);
        capitalTextView.setText("Capital: " + capital);
    }
}
