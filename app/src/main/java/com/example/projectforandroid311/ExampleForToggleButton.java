package com.example.projectforandroid311;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExampleForToggleButton extends AppCompatActivity {

    private ToggleButton toggleButton;
    private TextView text;
    private String textForSaving;

    private void init(){
        toggleButton = findViewById(R.id.toggle_button_id);
        text = findViewById(R.id.show_text_view_id);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_example_for_toggle_button);
        init();


        if(savedInstanceState != null){
            textForSaving = savedInstanceState.getString("savedTextForToggleButton");
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    textForSaving = "Toggle Button Is On";
                    text.setText(textForSaving);

                }else {
                    textForSaving = "Toggle Button Is Off";
                    text.setText(textForSaving);
                }

            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("savedTextForToggleButton", textForSaving);
    }
}