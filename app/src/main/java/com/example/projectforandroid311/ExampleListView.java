package com.example.projectforandroid311;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExampleListView extends AppCompatActivity {

    private Button button;
    private ListView listView;

    private Spinner spinner;
    private String[] cities;
    private String[] countries;

    private void init(){
        button = findViewById(R.id.button_id);
        listView = findViewById(R.id.list_view_id);
        spinner = findViewById(R.id.spinner_id);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_example_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        cities = getResources().getStringArray(R.array.cities);
        countries = getResources().getStringArray(R.array.countries);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
              this,
              android.R.layout.select_dialog_singlechoice,
                cities

        );

        ArrayAdapter<String> secondArrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);
        spinner.setAdapter(secondArrayAdapter);

        button.setOnClickListener((view) ->{
            Intent intent = new Intent(this, ExampleGalleryAndBaseAdapter.class);
            startActivity(intent);
            Log.d("SuperLog", cities[listView.getCheckedItemPosition()]);
        });


    }
}