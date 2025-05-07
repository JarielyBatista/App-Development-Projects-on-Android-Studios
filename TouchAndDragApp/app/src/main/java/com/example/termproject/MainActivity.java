package com.example.termproject;

import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView person1, person2;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.relativeLayout);
        person1 = findViewById(R.id.person1);
        person2 = findViewById(R.id.person2);

        // Enable drag for both persons
        View.OnLongClickListener dragStartListener = view -> {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDragAndDrop(data, shadowBuilder, view, 0);
            return true;
        };

        person1.setOnLongClickListener(dragStartListener);
        person2.setOnLongClickListener(dragStartListener);

        // Set the RelativeLayout as the drop target
        relativeLayout.setOnDragListener((v, event) -> {
            switch (event.getAction()) {
                case DragEvent.ACTION_DROP:
                    View draggedView = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) draggedView.getParent();
                    owner.removeView(draggedView);

                    RelativeLayout container = (RelativeLayout) v;
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                            draggedView.getWidth(), draggedView.getHeight());
                    params.leftMargin = (int) event.getX() - draggedView.getWidth() / 2;
                    params.topMargin = (int) event.getY() - draggedView.getHeight() / 2;
                    container.addView(draggedView, params);
                    draggedView.setVisibility(View.VISIBLE);
                    break;

                case DragEvent.ACTION_DRAG_STARTED:
                case DragEvent.ACTION_DRAG_ENTERED:
                case DragEvent.ACTION_DRAG_EXITED:
                case DragEvent.ACTION_DRAG_ENDED:
                    break;
            }
            return true;
        });
    }
}
