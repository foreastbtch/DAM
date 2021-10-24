package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private Button btnSign;
    private EditText etEmail;
    private EditText etPass;
    private EditText etPass2;
    private EditText etDate;
    private Switch SW1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSign = (findViewById(R.id.button2));
        etEmail = (findViewById((R.id.editTextTextEmailAddress2)));
        etPass = (findViewById((R.id.editTextTextPassword3)));
        etPass2 = (findViewById((R.id.editTextTextPassword4)));
        etDate = (findViewById((R.id.editTextDate2)));
        SW1 = (findViewById(R.id.switch1));
        btnSign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (isValid()) {
                    Persoana p1 = new Persoana();
                    p1.setEmail(etEmail.getText().toString());
                    p1.setDataNasterii(etDate.getText().toString());
                    p1.setPassword(etPass.getText().toString());
//                    Intent newActivity = new Intent(SignUpActivity.this, MainActivity.class);
//                    startActivity(newActivity);
                    Bundle wrapperObject = new Bundle();
                    wrapperObject.putSerializable("persoana", p1);
                    Intent intent = new Intent();
                    intent.putExtra("raspuns bundle", wrapperObject);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValid() {
        if (etEmail.getText().toString().isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Completati email-ul...", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!isEmailValid(etEmail.getText().toString())) {
            Toast.makeText(SignUpActivity.this, "Email-ul nu este valid...", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etPass.getText().toString().isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Completati parola...", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etPass2.getText().toString().isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Confirmati parola...", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etPass.getText().toString().compareTo(etPass2.getText().toString()) != 0) {
            Toast.makeText(SignUpActivity.this, "Parolele nu se potrivesc...", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etDate.getText().toString().isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Completati data nasterii...", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (SW1.isChecked() != true) {
            Toast.makeText(SignUpActivity.this, "Politica nu a fost acceptata...", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}