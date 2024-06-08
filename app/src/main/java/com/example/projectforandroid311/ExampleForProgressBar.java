package com.example.projectforandroid311;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExampleForProgressBar extends AppCompatActivity {

    private ProgressBar progressBarCircular;
    private ProgressBar progressBarHorizontal;
    private Button startProgressBarButton;
    private final Handler handler = new Handler();

    private  int progressStatus = 0;

    private void init(){
        progressBarCircular = findViewById(R.id.progress_bar_circular_id);
        progressBarHorizontal = findViewById(R.id.progress_bar_horizontal_id);
        startProgressBarButton = findViewById(R.id.start_progress_bar_button_id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_example_for_progress_bar);
        init();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        startProgressBarButton.setOnClickListener((view) ->{
            progressBarCircular.setVisibility(View.VISIBLE);
            progressBarHorizontal.setVisibility(View.VISIBLE);
            progressStatus = 0;

            new Thread(new Runnable(){
                @Override
                public  void  run(){
                    while (progressStatus < 100){
                        progressStatus += 1;

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                               progressBarHorizontal.setProgress(progressStatus);
                            }
                        });

                        try {
                            Thread.sleep(100);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBarCircular.setVisibility(View.GONE);
                            progressBarHorizontal.setVisibility(View.GONE);
                        }
                    });

                }
            }).start();
        });
    }
}