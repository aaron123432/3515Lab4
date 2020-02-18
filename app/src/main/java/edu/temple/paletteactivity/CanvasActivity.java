package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Intent intent = getIntent();
        String color = intent.getStringExtra("Color");

        ConstraintLayout layout = findViewById(R.id.constraint);
        layout.setBackgroundColor(Color.parseColor(color));

        TextView view = findViewById(R.id.textView);
        view.setText(color);
        //finish();
    }
}
