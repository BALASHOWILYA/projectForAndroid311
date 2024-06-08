package com.example.projectforandroid311;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExampleForRadioButton extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button submitButton;


    private final int correctAnswerId = R.id.radioButton1;
    private void init(){
        radioGroup = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.submit_button_id);
    }



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_example_for_radio_button);
        init();



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        submitButton.setOnClickListener(view ->{
            int selectedId = radioGroup.getCheckedRadioButtonId();

            if(selectedId != -1){
                if(selectedId == correctAnswerId){
                    Toast.makeText(ExampleForRadioButton.this, "CORRECT", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(ExampleForRadioButton.this,"INCORRECT", Toast.LENGTH_LONG).show();
                }

            }
        });

    }


}