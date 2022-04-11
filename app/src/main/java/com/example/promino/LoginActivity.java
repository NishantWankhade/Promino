package com.example.promino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth auth;
    EditText email;
    EditText password;
    Button login;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.button);
        signup = findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginNewUser();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,signUpAcitivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginNewUser() {
        String EMAIL = email.getText().toString();
        String PASSWORD = password.getText().toString();

        if(EMAIL.isEmpty() || PASSWORD.isEmpty()){
            Toast.makeText(this,"Fill all the fields ", Toast.LENGTH_LONG ).show();
        }
        else{
            auth.signInWithEmailAndPassword(EMAIL,PASSWORD).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Login Failed!\nSign Up required",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}