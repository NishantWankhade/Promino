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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class uploadFarmersData extends AppCompatActivity {
    EditText farmer;
    EditText email;
    EditText number;
    Button save;
    FirebaseFirestore DB = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_farmers_data);

        farmer = findViewById(R.id.farmerName);
        email = findViewById(R.id.farmerEmail);
        number = findViewById(R.id.farmerNumber);
        save = findViewById(R.id.saveFarmerData);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });
    }

    private void addData() {
        Map<String , Object> Farmer = new HashMap<>();
        String name = farmer.getText().toString();
        String mail = email.getText().toString();
        Number num = Integer.parseInt(number.getText().toString());

        Farmer.put("Name",name);
        Farmer.put("Email",mail);
        Farmer.put("Number", num);

        DB.collection("Farmers").add(Farmer).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "Document Added : " + documentReference.getId());
                Intent intent = new Intent(uploadFarmersData.this,farmerActivity.class);
                Toast.makeText(uploadFarmersData.this, "Saved!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG,"Error In adding data.", e);
            }
        });
    }

}