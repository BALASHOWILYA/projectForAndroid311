package com.example.projectforandroid311;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExampleForSharedPreferences extends AppCompatActivity {

    private TextView text;
    private EditText editText;

    private String PERSISTANT_STORAGE_NAME = "MY_STORAGE_NAME";
    private String userNameTextEdit;
    private String data;

    private Button buttonSaveUserName;
    private Button buttonPostUserName;

    private void init(){
        editText = findViewById(R.id.edit_text_for_shared_preferences_id);
        text = findViewById(R.id.text_for_shared_preferences_id);
        buttonSaveUserName = findViewById(R.id.save_nameButton_id);
        buttonPostUserName = findViewById(R.id.post_nameButton_id);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_example_for_shared_preferences);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();


        buttonSaveUserName.setOnClickListener(v->{
            userNameTextEdit = editText.getText().toString();
            SharedPreferences userName = getSharedPreferences(PERSISTANT_STORAGE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = userName.edit();

            editor.putString("name", userNameTextEdit);
            editor.commit();
        });


        buttonPostUserName.setOnClickListener(v->{

            String PERSISTANT_STORAGE_NAME = "MY_STORAGE_NAME";
            SharedPreferences getUserText = getSharedPreferences(PERSISTANT_STORAGE_NAME,
                    Context.MODE_PRIVATE);
            data = getUserText.getString("name", "Unnamed person");
            text.setText(data);
        });




    }
}