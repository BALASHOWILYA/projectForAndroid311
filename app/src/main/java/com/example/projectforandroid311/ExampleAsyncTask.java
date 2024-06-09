package com.example.projectforandroid311;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExampleAsyncTask extends AppCompatActivity {

    private TextView textForButton;
    private Button button;

    private void init() {
        button = findViewById(R.id.start_button_id);
        textForButton = findViewById(R.id.text_for_button_id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_example_async_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();  // Call the init method to initialize the views

        button.setOnClickListener((view) -> {
            new MyAsyncTask().execute();
        });
    }

    private class MyAsyncTask extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textForButton.setText("Task started...");
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                Thread.sleep(3000);  // Simulate a long-running operation
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            return "Task completed";
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            textForButton.setText(result);
        }
    }
}