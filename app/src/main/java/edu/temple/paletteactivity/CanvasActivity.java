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
        TextView view = findViewById(R.id.textView);
        view.setText(color);

        if(color.compareToIgnoreCase("Azul") == 0){
            color = "Blue";
        }else if(color.compareToIgnoreCase("Verde") == 0){
            color = "Green";
        }else if(color.compareToIgnoreCase("Rojo") == 0){
            color = "Red";
        }

        layout.setBackgroundColor(Color.parseColor(color));


        //finish();
    }
}
