package com.example.hwk8;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private ImageView albumCover;
    private TextView rankText, singerText, musicTitleText, albumTitleText, videoUrlText;
    private WebView videoWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        albumCover = findViewById(R.id.song_detail_album_cover);
        rankText = findViewById(R.id.song_detail_rank);
        singerText = findViewById(R.id.song_detail_singer);
        musicTitleText = findViewById(R.id.song_detail_music_title);
        albumTitleText = findViewById(R.id.song_detail_album_title);
        videoUrlText = findViewById(R.id.song_detail_video_url);
        videoWebView = findViewById(R.id.song_detail_video_webview);

        // Get song data from the intent
        Intent intent = getIntent();
        Song song = (Song) intent.getSerializableExtra("song");

        if (song != null) {
            albumCover.setImageResource(song.getAlbumCover()); // Make sure this is a valid resource ID (or use Glide if it's a URL)
            rankText.setText("Rank: " + song.getRank());
            singerText.setText("Singer: " + song.getSinger());
            musicTitleText.setText("Music Title: " + song.getMusicTitle());
            albumTitleText.setText("Album: " + song.getStudioAlbum());
            videoUrlText.setText("Video URL: " + song.getVideoUrl());

            // Open the YouTube video in the WebView when the URL is clicked
            videoUrlText.setOnClickListener(v -> videoWebView.loadUrl(song.getVideoUrl()));
        }
    }
}
