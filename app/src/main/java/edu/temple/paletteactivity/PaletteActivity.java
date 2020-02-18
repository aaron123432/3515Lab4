package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> list = new ArrayList<>();
        list.add("Choose a color");
        list.add("BLUE");
        list.add("GREEN");
        list.add("RED");
        Spinner spinner = findViewById(R.id.spinner);
        final ColorAdapter adapter = new ColorAdapter(list, this);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);

                if(position != 0){
                    intent.putExtra("Color", list.get(position).toString());
                }
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}

class ColorAdapter extends BaseAdapter{

    private ArrayList<String> list;
    private Activity activity;
    public ColorAdapter(ArrayList<String> list, Activity activity){
        this.list = list;
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = new TextView(activity.getApplicationContext());
        view.setId(position);
        view.setText(list.get(position));

        if(position != 0){
            view.setBackgroundColor(Color.parseColor(list.get(position)));
        }
        return view;
    }

}
