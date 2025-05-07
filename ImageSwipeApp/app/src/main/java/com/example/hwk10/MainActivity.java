package com.example.hwk10;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity implements ImageAdapter.OnImageClickListener {

    private ViewPager2 viewPager;
    private int[] imageIds = {
            R.drawable.td_rgb_a_1_0,
            R.drawable.td_rgb_a_1_1,
            R.drawable.td_rgb_a_1_2,
            R.drawable.td_rgb_a_1_3,
            R.drawable.td_rgb_a_1_4,
            R.drawable.td_rgb_a_1_5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(imageIds, this);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onImageClick(int imageId) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("imageId", imageId);
        startActivity(intent);
    }
}
