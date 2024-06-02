package com.example.projectforandroid311;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity {

    private Button goBackToRegistrationButton;
    private TextView userEmailTextView;
    private String emailFromIntent;
    private String passwordFromIntent;
    private String emailFromBundle;
    private String passwordFromBundle;
    private void init(){
        goBackToRegistrationButton = findViewById(R.id.back_to_registration_button_id);
        userEmailTextView = findViewById(R.id.account_email_text_view_id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        init();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intentForGettingData = getIntent();
        emailFromIntent = intentForGettingData.getStringExtra("userEmailKey");
        passwordFromIntent = intentForGettingData.getStringExtra("userPasswordKey");



        userEmailTextView.setText(emailFromIntent);

        goBackToRegistrationButton.setOnClickListener((view) ->{
            Log.d("checkButtonLog","go back button");
            Intent intent = new Intent(CalculatorActivity.this, MainActivity.class);
            startActivity(intent);

        });



    }
}