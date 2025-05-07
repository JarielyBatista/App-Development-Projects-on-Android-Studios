package com.example.hwk3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class activity_third extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView cityName = findViewById(R.id.cityName);
        ImageView landmark1 = findViewById(R.id.landmarkImage1);
        ImageView landmark2 = findViewById(R.id.landmarkImage2);
        ImageView landmark3 = findViewById(R.id.landmarkImage3);

        // Get the selected city name from the intent
        String selectedCity = getIntent().getStringExtra("selectedCity");

        // Set the city name text
        cityName.setText(selectedCity);

        // Check if selectedCity is null or empty
        if (selectedCity != null && !selectedCity.isEmpty()) {
            // Assign images based on selected city
            switch (selectedCity.toLowerCase()) {
                case "new york":
                    landmark1.setImageResource(R.drawable.brooklyn_bridge);
                    landmark2.setImageResource(R.drawable.empire_state_building);
                    landmark3.setImageResource(R.drawable.statue_of_liberty);
                    break;
                case "miami":
                    landmark1.setImageResource(R.drawable.bayside_marketplace);
                    landmark2.setImageResource(R.drawable.street_art);
                    landmark3.setImageResource(R.drawable.vizcaya_museum);
                    break;
                case "orlando":
                    landmark1.setImageResource(R.drawable.disney_resort);
                    landmark2.setImageResource(R.drawable.kia_center);
                    landmark3.setImageResource(R.drawable.orlando_eye);
                    break;
                case "los angeles":
                    landmark1.setImageResource(R.drawable.hollywood_sign);
                    landmark2.setImageResource(R.drawable.griffith_observatory);
                    landmark3.setImageResource(R.drawable.santa_monica_pier);
                    break;
                case "san francisco":
                    landmark1.setImageResource(R.drawable.golden_gate_bridge);
                    landmark2.setImageResource(R.drawable.alcatraz_island);
                    landmark3.setImageResource(R.drawable.painted_ladies);
                    break;
                case "las vegas":
                    landmark1.setImageResource(R.drawable.welcome_to_las_vegas_sign);
                    landmark2.setImageResource(R.drawable.bellagio_fountains);
                    landmark3.setImageResource(R.drawable.stratosphere_tower);
                    break;
                case "washington dc":
                    landmark1.setImageResource(R.drawable.white_house);
                    landmark2.setImageResource(R.drawable.lincoln_memorial);
                    landmark3.setImageResource(R.drawable.capitol_building);
                    break;
                case "chicago":
                    landmark1.setImageResource(R.drawable.cloud_gate);
                    landmark2.setImageResource(R.drawable.willis_tower);
                    landmark3.setImageResource(R.drawable.navy_pier);
                    break;
                case "boston":
                    landmark1.setImageResource(R.drawable.faneuil_hall);
                    landmark2.setImageResource(R.drawable.freedom_trail);
                    landmark3.setImageResource(R.drawable.boston_common);
                    break;
                default:
                    // Handle the case where no city matches
                    break;
            }
        }
    }
}
