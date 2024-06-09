package com.example.projectforandroid311;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExampleMethoedsWaitNotifies extends AppCompatActivity {

    public static final String TAG = "MY_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_example_methoeds_wait_notifies);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Object sync = new Object();
        Data data = new Data();
        Thread thread = new Thread(new WaitingThread(sync, data));
        thread.start();

        try{
            Log.d(TAG, "main::Sleeping!");
            Thread.sleep(4000);
        } catch (InterruptedException exception){
            Log.d(TAG, "main::Interrupted: " + exception.getMessage());
        }

        synchronized (sync){
            Log.d(TAG, "main::settin value to 1");
            data.value = 1;
            Log.d(TAG, "main::notifying thread");
            sync.notify();
            Log.d(TAG, "main::Thread notified");
        }
    }

    static class Data {
        public  int value = 0;
    }

    static class WaitingThread implements  Runnable{

        private Data data;
        private Object sync;

        public  WaitingThread(Object sync, Data data){
            this.data = data;
            this.sync = sync;
        }
        @Override
        public void run() {
            Log.d(TAG, "own:: Thread started");
            synchronized (sync){
                if(data.value == 0){
                    try{
                        Log.d(TAG, "own:: Waiting");
                        sync.wait();
                        Log.d(TAG, "own:: Running again");
                    } catch (InterruptedException exception){
                        exception.printStackTrace();
                    }
                }
               Log.d(TAG, "own:: data.value=" + data.value);
            }

        }
    }
}