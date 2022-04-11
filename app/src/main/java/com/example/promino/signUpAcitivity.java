package com.example.promino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signUpAcitivity extends AppCompatActivity {
    EditText email;
    EditText password1;
    FirebaseAuth register;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_acitivity);
        email = findViewById(R.id.email2);
        password1 = findViewById(R.id.PASSWORD1);
        signup = findViewById(R.id.signup1);
        register = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String mail = email.getText().toString();
        String pass1 = password1.getText().toString();


        if(mail.isEmpty() || pass1.isEmpty()){
            Toast.makeText(this, "Fill All details", Toast.LENGTH_LONG).show();
        }
        else{
            register.createUserWithEmailAndPassword(mail, pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"Registration Successful :)",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(signUpAcitivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(signUpAcitivity.this, "Registration Failed!!", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}