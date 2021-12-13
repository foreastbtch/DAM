package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private TextView tvSign;
    private final int MainActivityRequest = 100;
    private TextView tvEmail;
    private TextView tvPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("lifecycle", "onCreate");
        btnLogin = (findViewById(R.id.button));
        tvSign = (findViewById(R.id.textView1));
        tvEmail = (findViewById(R.id.editTextTextPersonName));
        tvPass = (findViewById(R.id.editTextTextPersonName2));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Logare cu succes.", Toast.LENGTH_SHORT).show();
                Intent newActivity = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(newActivity);
            }
        });
        tvSign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                //startActivity(newActivity);
                startActivityForResult(intent, MainActivityRequest);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MainActivityRequest) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    Bundle newBundle = data.getBundleExtra("raspuns bundle");
                    Persoana persoana = (Persoana) newBundle.getSerializable("persoana");
                    tvEmail.setText(persoana.getEmail());
                    tvPass.setText(persoana.getPassword());
                }
            }
        }
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