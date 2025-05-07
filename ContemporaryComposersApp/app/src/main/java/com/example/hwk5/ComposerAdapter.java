package com.example.hwk5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.BaseAdapter;

import java.util.List;

public class ComposerAdapter extends BaseAdapter {

    private Context context;
    private List<Composer> composers;

    public ComposerAdapter(Context context, List<Composer> composers) {
        this.context = context;
        this.composers = composers;
    }

    @Override
    public int getCount() {
        return composers.size();
    }

    @Override
    public Object getItem(int position) {
        return composers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the layout for each row
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_composer_adapter, parent, false);
        }

        // Get the composer for this position
        Composer composer = composers.get(position);

        // Set the composer name
        TextView nameTextView = convertView.findViewById(R.id.composerNameTextView);
        nameTextView.setText(composer.getFirstName() + " " + composer.getLastName());

        // Set the composer photo
        ImageView composerImageView = convertView.findViewById(R.id.composerImageView);

        // Dynamically load the image from drawable folder
        String imageName = composer.getPhoto().toLowerCase(); // Ensure the image name is lowercase
        int imageResId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());

        if (imageResId != 0) {  // Check if image exists
            composerImageView.setImageResource(imageResId);
        } else {
            // If image doesn't exist, leave the ImageView empty or set a default placeholder if you have one
            // composerImageView.setImageResource(R.drawable.default_image);  // Uncomment if you have a default image
        }

        return convertView;
    }
}
