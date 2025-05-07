package com.example.hwk10;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private ImageView detailImage;
    private TextView detailName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailImage = findViewById(R.id.detailImage);
        detailName = findViewById(R.id.detailName);

        int imageId = getIntent().getIntExtra("imageId", 0);

        if (imageId != 0) {
            detailImage.setImageResource(imageId);
        }

        detailName.setText("Susan Choo");
    }
}
