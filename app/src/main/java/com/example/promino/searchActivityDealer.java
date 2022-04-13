package com.example.promino;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class searchActivityDealer extends AppCompatActivity {
    FirebaseFirestore DB = FirebaseFirestore.getInstance();
    TextView data;
    Button sea;
    String s = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_dealer);
        data = findViewById(R.id.dealerData1);
        sea = findViewById(R.id.search);
        CollectionReference Co = DB.collection("Dealers");
        sea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText("");
                Co.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(DocumentSnapshot doc : task.getResult()){
                                Log.d(TAG,doc.getId() + "=>" + doc.getData());
                                s += doc.get("Name").toString();
                                s += "->>";
                                s += doc.get("Number").toString();
                                s += "\n";
                            }
                            data.setText(s);
                            s = "";
                        }else{
                            Log.d(TAG,"Error ",task.getException());
                        }
                    }
                });
            }
        });
    }
}