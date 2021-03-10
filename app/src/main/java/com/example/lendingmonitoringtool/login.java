package com.example.lendingmonitoringtool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    EditText edt_logUname,edt_logpass;
    Button btn_logLOgin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    edt_logpass =findViewById(R.id.edt_logPass);
    edt_logUname = findViewById(R.id.edt_logUsername);
    btn_logLOgin = findViewById(R.id.btn_logButtonLogin);


    btn_logLOgin.setOnClickListener(v -> {

        String usernameLogACT = edt_logUname.getText().toString();
        String passwordLogACT = edt_logpass.getText().toString();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = reference.orderByChild("fn").equalTo(usernameLogACT);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    String passwordFromdb = snapshot.child(usernameLogACT).child("pass").getValue(String.class);
                    if(passwordFromdb.equals(passwordLogACT)){
                        String nameFromdb = snapshot.child(usernameLogACT).child("fn").getValue(String.class);
                        String lastnameFromdb = snapshot.child(usernameLogACT).child("ln").getValue(String.class);
                        String numberFromdb = snapshot.child(usernameLogACT).child("number").getValue(String.class);
                        String emailFromdb = snapshot.child(usernameLogACT).child("eml").getValue(String.class);
                        
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    });


    }



}