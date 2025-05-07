package com.example.hwk9;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MediaPlayer howlingWolfPlayer;
    MediaPlayer woodyGuthriePlayer;
    Button playHowlingButton, stopHowlingButton, pauseHowlingButton;
    Button playWoodyButton, stopWoodyButton, pauseWoodyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        howlingWolfPlayer = MediaPlayer.create(this, R.raw.howling_wolf);
        woodyGuthriePlayer = MediaPlayer.create(this, R.raw.woody_guthrie);

        playHowlingButton = findViewById(R.id.playHowling);
        stopHowlingButton = findViewById(R.id.stopHowling);
        pauseHowlingButton = findViewById(R.id.pauseHowling);

        playWoodyButton = findViewById(R.id.playWoody);
        stopWoodyButton = findViewById(R.id.stopWoody);
        pauseWoodyButton = findViewById(R.id.pauseWoody);
    }

    public void playHowling(View view) {
        if (!howlingWolfPlayer.isPlaying()) {
            howlingWolfPlayer.start();
        } else {
            howlingWolfPlayer.pause();
        }
    }

    public void stopHowling(View view) {
        if (howlingWolfPlayer.isPlaying()) {
            howlingWolfPlayer.stop();
            howlingWolfPlayer = MediaPlayer.create(this, R.raw.howling_wolf);
        }
    }

    public void pauseHowling(View view) {
        if (howlingWolfPlayer.isPlaying()) {
            howlingWolfPlayer.pause();
        }
    }

    public void playWoody(View view) {
        if (!woodyGuthriePlayer.isPlaying()) {
            woodyGuthriePlayer.start();
        } else {
            woodyGuthriePlayer.pause();
        }
    }

    public void stopWoody(View view) {
        if (woodyGuthriePlayer.isPlaying()) {
            woodyGuthriePlayer.stop();
            woodyGuthriePlayer = MediaPlayer.create(this, R.raw.woody_guthrie);
        }
    }

    public void pauseWoody(View view) {
        if (woodyGuthriePlayer.isPlaying()) {
            woodyGuthriePlayer.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (howlingWolfPlayer != null) {
            howlingWolfPlayer.release();
        }
        if (woodyGuthriePlayer != null) {
            woodyGuthriePlayer.release();
        }
    }
}
