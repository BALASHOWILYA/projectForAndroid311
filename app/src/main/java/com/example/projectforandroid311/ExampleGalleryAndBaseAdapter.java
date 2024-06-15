package com.example.projectforandroid311;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Gallery;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExampleGalleryAndBaseAdapter extends AppCompatActivity implements TextWatcher {


    private Gallery gallery;
    private TextView imageCount;
    private AutoCompleteTextView autoCompleteTextView;
    private MultiAutoCompleteTextView multiAutoCompleteTextView;
    private String[] countries;
    private String[] cities;

    private void init(){
        gallery = findViewById(R.id.gallery_id);
        autoCompleteTextView = findViewById(R.id.auto_complete_text_view_id);
        multiAutoCompleteTextView = findViewById(R.id.multi_auto_complete_text_view);
        imageCount = findViewById(R.id.image_count);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_example_gallery_and_base_adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

        ImageAdapter imageAdapter = new ImageAdapter(this);
        gallery.setAdapter(imageAdapter);

        countries = getResources().getStringArray(R.array.countries);
        cities = getResources().getStringArray(R.array.cities);




        autoCompleteTextView.addTextChangedListener(this);

        autoCompleteTextView.setAdapter(
                new ArrayAdapter(
                        this,
                        android.R.layout.simple_dropdown_item_1line,
                        countries
                ));


        multiAutoCompleteTextView.setAdapter(
                new ArrayAdapter(
                        this,
                        android.R.layout.simple_dropdown_item_1line,
                        cities
                )
        );
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        imageCount.setText("Amount images: " + gallery.getAdapter().getCount());


    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}