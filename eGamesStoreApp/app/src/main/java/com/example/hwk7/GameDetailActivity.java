package com.example.hwk7;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GameDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        Game game = (Game) getIntent().getSerializableExtra("game");

        ImageView gameImage = findViewById(R.id.gameImage);
        TextView gameTitle = findViewById(R.id.gameTitle);
        TextView gameDescription = findViewById(R.id.gameDescription);

        gameTitle.setText(game.getTitle());
        gameDescription.setText(game.getDescription());
        // Assuming you use Glide or Picasso to load images
        // Glide.with(this).load(game.getImage()).into(gameImage);
    }
}
