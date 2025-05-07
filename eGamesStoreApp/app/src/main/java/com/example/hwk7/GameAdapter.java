package com.example.hwk7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GameAdapter extends BaseAdapter {
    private Context context;
    private List<Game> gameList;

    public GameAdapter(Context context, List<Game> gameList) {
        this.context = context;
        this.gameList = gameList;
    }

    @Override
    public int getCount() {
        return gameList.size();
    }

    @Override
    public Object getItem(int position) {
        return gameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item, null);
        }

        Game game = gameList.get(position);

        ImageView gameImage = convertView.findViewById(R.id.gameImage);
        TextView gameTitle = convertView.findViewById(R.id.gameTitle);

        gameTitle.setText(game.getTitle());
        // Assuming you have a method to load images (e.g., using Glide or Picasso)
        // You can use Glide or Picasso to load the image into the ImageView
        // Glide.with(context).load(game.getImage()).into(gameImage);

        return convertView;
    }
}
