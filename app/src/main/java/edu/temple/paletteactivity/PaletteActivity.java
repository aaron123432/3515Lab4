package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources res = getResources();
        final String topic = getResources().getString(R.string.app_name);
        final String[] color = res.getStringArray(R.array.color);
        Spinner spinner = findViewById(R.id.spinner);
        final ColorAdapter adapter = new ColorAdapter(color, this);
        if(Locale.getDefault().getLanguage().equals("en")){
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                if(position != 0){
                    intent.putExtra("Color", color[position]);
                    startActivity(intent);
                }else{

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }else {
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    if(position != 0){
                        intent.putExtra("Color", color[position]);
                        startActivity(intent);
                    }else{

                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }
}

class ColorAdapter extends BaseAdapter{

    private String[] list;
    private Activity activity;
    public ColorAdapter(String[] list, Activity activity){
        this.list = list;
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int position) {
        return list[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = new TextView(activity.getApplicationContext());
        view.setId(position);
        view.setText(list[position]);
        String[] color = {"color", "Blue", "Green", "Red"};
        if(position != 0){
            view.setBackgroundColor(Color.parseColor(color[position]));
        }
        return view;
    }

}}
