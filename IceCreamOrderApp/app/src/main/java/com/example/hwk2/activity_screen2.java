package com.example.hwk2;  // Ensure this is the correct package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_screen2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        // Retrieve the passed data from MainActivity
        Intent getVar = getIntent();
        String allChoices = getVar.getStringExtra("choiceKey");

        // Split the choices
        String[] choicesArray = allChoices.split(",");

        // Extract flavor and toppings
        String flavor = choicesArray[0];
        StringBuilder toppings = new StringBuilder();
        for (int i = 1; i < choicesArray.length; i++) {
            toppings.append(choicesArray[i]).append(", ");
        }

        // Display choices in the TextView
        TextView textView = findViewById(R.id.textView3);
        textView.setText("Flavor: " + flavor + "\nToppings: " + toppings.toString());

        // Set up the "Continue" button listener
        Button continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate to another activity or go back to MainActivity
                Intent intent = new Intent(activity_screen2.this, MainActivity.class); // Adjust to the next activity
                startActivity(intent);  // Start the next activity
            }
        });
    }
}
