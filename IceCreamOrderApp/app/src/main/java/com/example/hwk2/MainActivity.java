package com.example.hwk2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declare objects
    RadioGroup flavorRG;
    RadioButton selectflavorRB;

    CheckBox pbCB;
    CheckBox rpCB;
    CheckBox caCB;
    CheckBox orCB;
    CheckBox rsCB;
    CheckBox hfCB;

    Button submitBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Define objects
        flavorRG = findViewById(R.id.flavorrgID);
        submitBTN = findViewById(R.id.button);

        pbCB = findViewById(R.id.pbcbID);
        rpCB = findViewById(R.id.rpcbID);
        caCB = findViewById(R.id.cacbID);
        orCB = findViewById(R.id.orcbID);
        rsCB = findViewById(R.id.rscbID);
        hfCB = findViewById(R.id.hfcbID);

        // Setup listener for button
        submitBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected radio button
                int selectFlavorID = flavorRG.getCheckedRadioButtonId();

                if (selectFlavorID != -1) { // Check if a radio button is selected
                    selectflavorRB = findViewById(selectFlavorID);
                    String selectFlavor = selectflavorRB.getText().toString();

                    // Create a StringBuilder to store all selected toppings
                    StringBuilder toppings = new StringBuilder();

                    // Add selected checkboxes (toppings) to the toppings string
                    if (pbCB.isChecked()) toppings.append("Peanut Butter, ");
                    if (rpCB.isChecked()) toppings.append("Reese's Pieces, ");
                    if (caCB.isChecked()) toppings.append("Caramel, ");
                    if (orCB.isChecked()) toppings.append("Oreo, ");
                    if (rsCB.isChecked()) toppings.append("Rainbow Sprinkles, ");
                    if (hfCB.isChecked()) toppings.append("Hot Fudge, ");

                    // Remove the trailing comma and space if any toppings were selected
                    if (toppings.length() > 0) {
                        toppings.setLength(toppings.length() - 2);
                    }

                    // Toast to show selected flavor and toppings
                    Toast.makeText(MainActivity.this, "Your selected flavor is: " + selectFlavor, Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, "Your selected toppings are: " + toppings.toString(), Toast.LENGTH_LONG).show();

                    // Prepare to pass the flavor and toppings to the next activity
                    String allChoices = selectFlavor + "," + toppings.toString();

                    // Create an Intent to go to the second screen (activity_screen2)
                    Intent intent = new Intent(MainActivity.this, activity_screen2.class);
                    // Pass the selected flavor and toppings to the new activity
                    intent.putExtra("choiceKey", allChoices);

                    // Start the new activity
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Please select a flavor.", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Set padding for system bars (status and navigation bars)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
