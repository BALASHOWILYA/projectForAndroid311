package com.example.projectforandroid311;

import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText userEmailEditText;
    private EditText userPasswordEditText;
    private Button enterAccountButton;
    private Button saveEmailAndPasswordButton;

    private Button enterExampleRadioButton;
    private Button enterExampleToggleButton;
    private Button enterExampleThread;

    private Button enterExampleProgressBar;

    private Button enterPriorityThreadExample;

    private Button enterMethodsWaitingNotifies;
    private Button enterExampleAsyncTask;

    private Button enterExampleHandlerThread;
    private String userEmailTextForSave;
    private String userPasswordTextForSave;

    private Button enterExampleListView;

    private void init(){
        userEmailEditText = findViewById(R.id.email_edit_text_id);
        userPasswordEditText = findViewById(R.id.password_edit_text_id);
        enterAccountButton = findViewById(R.id.enter_account_button_id);
        saveEmailAndPasswordButton = findViewById(R.id.save_account_button_id);
        enterExampleRadioButton = findViewById(R.id.enter_example_radio_button_id);
        enterExampleToggleButton = findViewById(R.id.enter_example_toggle_button);
        enterExampleProgressBar = findViewById(R.id.enter_example_for_progress_bar_id);
        enterExampleThread = findViewById(R.id.enter_example_thread_id);
        enterPriorityThreadExample = findViewById(R.id.enter_priority_thread_example_id);
        enterMethodsWaitingNotifies = findViewById(R.id.enter_methodsWaitingNotifies);
        enterExampleAsyncTask = findViewById(R.id.enter_example_asyncTask_id);
        enterExampleHandlerThread = findViewById(R.id.enter_example_handler_thread_id);
        enterExampleListView = findViewById(R.id.enter_example_list_view);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        long time =  System.currentTimeMillis();
        Log.d("LifeCycleLog", "onCreate: " + time);
        init();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if(savedInstanceState != null){
            userEmailTextForSave = savedInstanceState.getString("userAccountEmailKey");
            userEmailTextForSave = savedInstanceState.getString("userAccountPasswordKey");
        }


        saveEmailAndPasswordButton.setOnClickListener((view)->{
            Log.d("checkButtonLog", "saveEmailBtn");
            userEmailTextForSave = userEmailEditText.getText().toString();
            userPasswordTextForSave = userPasswordEditText.getText().toString();

        });

        enterExampleRadioButton.setOnClickListener((view) ->
        {
            Intent intent = new Intent(MainActivity.this, ExampleForRadioButton.class);
            startActivity(intent);
        });

        enterExampleToggleButton.setOnClickListener((view) ->{
            Intent secondIntent = new Intent(MainActivity.this, ExampleForToggleButton.class);
            startActivity(secondIntent);
        });

        enterExampleProgressBar.setOnClickListener((view) ->{
            Intent secondIntent = new Intent(MainActivity.this, ExampleForProgressBar.class);
            startActivity(secondIntent);
        });

        enterExampleThread.setOnClickListener((view) ->{
            Intent secondIntent = new Intent(MainActivity.this, ExampleThreads.class);
            startActivity(secondIntent);
        });

        enterPriorityThreadExample.setOnClickListener((view) ->{
            Intent secondIntent = new Intent(MainActivity.this, ExampleThreadPriority.class);
            startActivity(secondIntent);
        });

        enterMethodsWaitingNotifies.setOnClickListener((view)->
        {
            Intent secondIntent = new Intent(MainActivity.this, ExampleMethoedsWaitNotifies.class);
            startActivity(secondIntent);
        });

        enterExampleAsyncTask.setOnClickListener((view)->
        {
            Intent secondIntent = new Intent(MainActivity.this, ExampleAsyncTask.class);
            startActivity(secondIntent);
        });

        enterExampleHandlerThread.setOnClickListener((view)->{
            Intent secondIntent = new Intent(MainActivity.this, ExampleHandlerThread.class);
            startActivity(secondIntent);
        });

        enterExampleListView.setOnClickListener((view)->{
            Intent secondIntent = new Intent(MainActivity.this, ExampleListView.class);
            startActivity(secondIntent);
        });





        enterAccountButton.setOnClickListener((view) ->{
            Log.d("checkButtonLog", "enterAccountBtn");
            Intent intent = new Intent(MainActivity.this, CalculatorActivity.class );
            intent.putExtra("userEmailKey",userEmailTextForSave);
            intent.putExtra("userPasswordKey",userEmailTextForSave);

            startActivity(intent);
            Log.d("checkButtonLog", "saveEmailBtn: " + userEmailTextForSave);
            Log.d("checkButtonLog", "saveEmailBtn: " + userPasswordTextForSave);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        long time =  System.currentTimeMillis();
        Log.d("LifeCycleLog", "onStart: " + time);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        long time =  System.currentTimeMillis();
        Log.d("LifeCycleLog", "onRestart: " + time);

    }

    @Override
    protected void onResume() {
        super.onResume();
        long time =  System.currentTimeMillis();
        Log.d("LifeCycleLog", "onResume: " + time);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        long time =  System.currentTimeMillis();
        outState.putString("userAccountEmailKey", userEmailTextForSave);
        outState.putString("userAccountPasswordKey", userPasswordTextForSave);
        Log.d("LifeCycleLog", "onSaveInstanceState: " + time);


    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        long time =  System.currentTimeMillis();
        Log.d("LifeCycleLog", "onRestoreInstanceState: " + time);

    }
}