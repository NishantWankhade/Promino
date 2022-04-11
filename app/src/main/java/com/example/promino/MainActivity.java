package com.example.promino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button farmer;
    Button dealer;
    Button customer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        farmer = findViewById(R.id.Farmer);
        dealer = findViewById(R.id.Dealer);
        customer = findViewById(R.id.Customer);
        
        farmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFarmer();
            }
        });

        dealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDealer();
            }
        });

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCustomer();
            }
        });
    }

    private void goToCustomer() {
        Toast.makeText(this, "Welcome Customer !!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, customerActivity.class);
        startActivity(intent);
    }

    private void goToDealer() {
        Toast.makeText(this, "Welcome Dealer !!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, dealerActivity.class);
        startActivity(intent);
    }

    private void goToFarmer() {
        Toast.makeText(this, "Welcome Farmer !!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, farmerActivity.class);
        startActivity(intent);
    }
}