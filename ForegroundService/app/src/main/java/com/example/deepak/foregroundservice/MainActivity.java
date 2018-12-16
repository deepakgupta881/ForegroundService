package com.example.deepak.foregroundservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etInput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = findViewById(R.id.et_input);
    }


    public void startService(View view) {
        Intent intent = new Intent(this, ExampleService.class);
        intent.putExtra("data", etInput.getText().toString());
//        startForegroundService(intent);
        startService(intent);

    }

    public void stopService(View view) {
        Intent intent = new Intent(this, ExampleService.class);
        startService(intent);
    }
}
