package com.example.hwk8;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Song> songList;
    private SongAdapter songAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);  // Uses activity_song.xml layout

        listView = findViewById(R.id.song_list_view);
        songList = new ArrayList<>();

        songList.add(new Song("1", "Blinding Lights", "The Weeknd", "After Hours", R.drawable.pic1, "https://www.youtube.com/watch?v=4NRXx6U8ABQ"));
        songList.add(new Song("2", "Watermelon Sugar", "Harry Styles", "Fine Line", R.drawable.pic2, "https://www.youtube.com/watch?v=E07s5ZYygMg"));
        songList.add(new Song("3", "Circles", "Post Malone", "Hollywood's Bleeding", R.drawable.pic3, "https://www.youtube.com/watch?v=wXhTHyIgQ_U"));
        songList.add(new Song("4", "Don't Start Now", "Dua Lipa", "Future Nostalgia", R.drawable.pic4, "https://www.youtube.com/watch?v=oygrmJFKYZY"));
        songList.add(new Song("5", "Rockstar", "DaBaby ft. Roddy Ricch", "Blame It on Baby", R.drawable.pic5, "https://www.youtube.com/watch?v=mxFstYSbBmc"));
        songList.add(new Song("6", "Adore You", "Harry Styles", "Fine Line", R.drawable.pic6, "https://www.youtube.com/watch?v=VF-r5TtlT9w"));
        songList.add(new Song("7", "Life Is Good", "Future ft. Drake", "High Off Life", R.drawable.pic7, "https://www.youtube.com/watch?v=l0U7SxXHkPY"));
        songList.add(new Song("8", "Memories", "Maroon 5", "Jordi", R.drawable.pic8, "https://www.youtube.com/watch?v=SlPhMPnQ58k"));
        songList.add(new Song("9", "The Box", "Roddy Ricch", "Please Excuse Me for Being Antisocial", R.drawable.pic9, "https://www.youtube.com/watch?v=UNZqm3dxd2w"));
        songList.add(new Song("10", "Savage Love", "Jawsh 685 x Jason Derulo", "Savage Love", R.drawable.pic10, "https://www.youtube.com/watch?v=gUci-tsiU4I"));

        songAdapter = new SongAdapter(this, songList);
        listView.setAdapter(songAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Song selectedSong = songList.get(position);
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("song", selectedSong);
            startActivity(intent);
        });
    }
}
