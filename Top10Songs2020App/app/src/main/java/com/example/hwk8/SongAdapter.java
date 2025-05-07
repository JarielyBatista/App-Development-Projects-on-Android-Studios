package com.example.hwk8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Song> songList;
    private LayoutInflater inflater;

    public SongAdapter(Context context, ArrayList<Song> songList) {
        this.context = context;
        this.songList = songList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return songList.size();
    }

    @Override
    public Object getItem(int position) {
        return songList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_song_adapter, null);
        }

        ImageView albumCover = convertView.findViewById(R.id.song_item_album_cover);
        TextView songTitle = convertView.findViewById(R.id.song_item_music_title);

        Song song = songList.get(position);

        albumCover.setImageResource(song.getAlbumCover()); // Use appropriate method to load the image
        songTitle.setText(song.getMusicTitle());

        return convertView;
    }
}
