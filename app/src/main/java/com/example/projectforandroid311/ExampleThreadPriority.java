package com.example.projectforandroid311;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExampleThreadPriority extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_example_thread_priority);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Thread highPriorityThread = new Thread(new Task(), "High priority thread");
        Thread normalPriorityThread = new Thread(new Task(),"Normal priority thread");
        Thread lowPriorityThread = new Thread(new Task(), "Low priority thread");

        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        normalPriorityThread.setPriority(Thread.NORM_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        lowPriorityThread.start();
        normalPriorityThread.start();
        highPriorityThread.start();
    }

    static class Task implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 5; i++){
                Log.d("SuperLog", Thread.currentThread().getName() + "is running");
                try{
                    Thread.sleep(1000);;
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}