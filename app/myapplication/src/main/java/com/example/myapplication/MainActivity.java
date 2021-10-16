package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("lifecycle", "onCreate");
        btnLogin = (findViewById(R.id.button));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Logare cu succes.", Toast.LENGTH_SHORT).show();
                Intent newActivity = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(newActivity);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("lifecycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("lifecycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("lifecycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("lifecycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("lifecycle", "onDestroy");
    }
}