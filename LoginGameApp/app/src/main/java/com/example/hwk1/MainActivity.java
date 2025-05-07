package com.example.hwk1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    // Declare objects
    EditText usernameET, passwordET;
    Button buttonBTN;

    // Hardcoded valid users
    private final HashMap<String, String> validUsers = new HashMap<>() {{
        put("Dog22", "A123!");
        put("3abC4", "544#B");
        put("gH299", "%F88c");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define objects
        usernameET = findViewById(R.id.usernameId);
        passwordET = findViewById(R.id.passwordId);
        buttonBTN = findViewById(R.id.buttonId);

        // Set up a listener for the button
        buttonBTN.setOnClickListener(view -> {
            String username = usernameET.getText().toString();
            String password = passwordET.getText().toString();

            // Check if credentials are valid
            if (validUsers.containsKey(username) && Objects.equals(validUsers.get(username), password)) {
                // If valid, go to the WelcomeActivity
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                intent.putExtra("USERNAME", username); // Pass the username to the next activity
                startActivity(intent);
            } else {
                // If invalid, show a Toast
                Toast.makeText(MainActivity.this, "Invalid username or password!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
