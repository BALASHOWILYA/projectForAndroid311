package com.example.projectforandroid311;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity {

    private Button goBackToRegistrationButton;
    private Button sendNotification;
    private TextView userEmailTextView;
    private String emailFromIntent;
    private String passwordFromIntent;
    private String emailFromBundle;
    private String passwordFromBundle;
    private void init(){
        goBackToRegistrationButton = findViewById(R.id.back_to_registration_button_id);
        userEmailTextView = findViewById(R.id.account_email_text_view_id);
        sendNotification = findViewById(R.id.send_notification_btn_id);
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

        sendNotification.setOnClickListener((view) ->{
            Intent intent = new Intent(this, ApplicationClass.NotificationBroadcast.class);
            sendBroadcast(intent);
            showDialogMethod();

        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.options_menu, menu );

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.menu_profile_id){
            Toast.makeText(this, "menu_profile_id", Toast.LENGTH_LONG).show();
        }
        if(itemId == R.id.menu_exit_id){
            Toast.makeText(this, "menu_exit_id", Toast.LENGTH_LONG).show();
        }
        if(itemId == R.id.menu_settings_id){
            Toast.makeText(this, "menu_settings_id", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDialogMethod() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Confirm exit")
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_LONG).show();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }
}