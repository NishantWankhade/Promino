package com.example.promino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dealerActivity extends AppCompatActivity {
    Button search;
    Button upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer);
        search = findViewById(R.id.searchProductDealer);
        upload = findViewById(R.id.uploadDealer);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCommonAcitivity();
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUploadAcitivity();
            }
        });
    }

    private void goToUploadAcitivity() {
        Intent intent = new Intent(this,uploadDealersData.class);
        startActivity(intent);
    }

    private void goToCommonAcitivity() {
        Intent intent = new Intent(this,searchActivityDealer.class);
        startActivity(intent);
    }
}