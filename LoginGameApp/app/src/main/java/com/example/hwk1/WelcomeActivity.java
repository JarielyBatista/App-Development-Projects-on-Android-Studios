package com.example.hwk1;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome); // Correct layout file name

        // Get the username from the intent
        String username = getIntent().getStringExtra("USERNAME");

        // Set the welcome message
        TextView welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText(getString(R.string.welcome_message, username)); // Assuming welcome_message is defined in strings.xml
    }
}
