package com.example.projectforandroid311;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class ExampleHandlerThread extends AppCompatActivity {

    private static final String TAG = "HandleThreadExample";
    private HandlerThread handlerThread;
    private Handler backgroundHandler;
    private Handler uiHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            // Enable edge-to-edge (custom implementation, verify this works in your context)
            EdgeToEdge.enable(this);

            setContentView(R.layout.activity_example_handler_thread);

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            handlerThread = new HandlerThread("BackgroundThread");
            handlerThread.start();

            backgroundHandler = new Handler(handlerThread.getLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    String task = (String) msg.obj;
                    Log.d(TAG, "Background task: " + task);

                    uiHandler.post(() -> Log.d(TAG, "Updating UI from background task"));
                }
            };

            uiHandler = new Handler(Looper.getMainLooper());

            Message message = backgroundHandler.obtainMessage();
            message.obj = "Performing background task";
            backgroundHandler.sendMessage(message);

        } catch (Exception e) {
            Log.e(TAG, "Error in onCreate", e);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerThread.quitSafely();
    }
}
