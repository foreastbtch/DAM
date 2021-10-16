package com.example.temadam;

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

        Log.v("Lifecycle", "onCreate");

        btnLogin = (findViewById(R.id.button2));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Succesful login", Toast.LENGTH_LONG).show();
                Intent newWindow = new Intent(MainActivity.this,MainActivity2.class );
                startActivity(newWindow);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v("Lifecycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v("Lifecycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v("Lifecycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v("Lifecycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v("Lifecycle", "onDestroy");
    }
}