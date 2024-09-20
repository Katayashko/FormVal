package com.example.formvalidationapp;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextPasswordSubmit;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPasswordSubmit = findViewById(R.id.editTextPasswordSubmit);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String username = editTextUsername.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passSubmit = editTextPasswordSubmit.getText().toString().trim();

                if(username.isEmpty()){
                    Toast.makeText(MainActivity.this,"Proszę wprowadzić nazwę użytkownika", Toast.LENGTH_SHORT).show();
                } else if(email.isEmpty()){
                    Toast.makeText(MainActivity.this,"Proszę wprowadzić e-mail", Toast.LENGTH_SHORT).show();
                } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(MainActivity.this,"Niepoprawny adres e-mail", Toast.LENGTH_SHORT).show();
                } else if(password.isEmpty()){
                    Toast.makeText(MainActivity.this,"Proszę wprowadzić hasło", Toast.LENGTH_SHORT).show();
                } else if(passSubmit.isEmpty()){
                    Toast.makeText(MainActivity.this,"Proszę potwierdzić hasło", Toast.LENGTH_SHORT).show();
                }else if(!password.matches(passSubmit)){
                    Toast.makeText(MainActivity.this,"Hasła sa rozbieżne", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,"Formularz przesłany poprawnie", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}