package com.example.promino;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class uploadDealersData extends AppCompatActivity {
    EditText dealer;
    EditText email;
    EditText number;
    Button save;

    FirebaseFirestore DB = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_dealers_data);

        dealer = findViewById(R.id.dealerName);
        email = findViewById(R.id.dealerEmail);
        number = findViewById(R.id.dealerNumber);
        save = findViewById(R.id.saveDealerData);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDealer();
            }
        });
    }

    private void addDealer() {
        Map<String , Object> Dealer = new HashMap<>();
        String name = dealer.getText().toString();
        String mail = email.getText().toString();
        Number num = Integer.parseInt(number.getText().toString());

        Dealer.put("Name",name);
        Dealer.put("Email",mail);
        Dealer.put("Number", num);
        DB.collection("Dealers").add(Dealer).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "Document Added : " + documentReference.getId());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG,"Error In adding data.", e);
            }
        });
    }
}