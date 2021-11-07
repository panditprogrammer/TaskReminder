package com.panditprogrammer.sharedpreferencesdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView todoListView;
    Button addBtn ;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editText = findViewById(R.id.inputBox);
        todoListView = findViewById(R.id.todoList);
        addBtn = findViewById(R.id.setBtn);

        addBtn.setOnClickListener(v -> {
            // set To do on ListView
            String editValue = editText.getText().toString().trim();
            todoListView.setText(editValue);

            // create sharedpreferece editor
            SharedPreferences sharedPreferences = getSharedPreferences("TODO",MODE_PRIVATE);
            editor = sharedPreferences.edit();

            // save to sharedprefereces file that name is todo
            editor.putString("str",editValue);
            editor.apply();
            Toast.makeText(MainActivity.this, "Task Added", Toast.LENGTH_SHORT).show();
        });

        // get the sharedPreferences file data
        SharedPreferences getshared = getSharedPreferences("TODO",MODE_PRIVATE);
        String data = getshared.getString("str","Nothing to Show!");
        todoListView.setText(data);
    }

}