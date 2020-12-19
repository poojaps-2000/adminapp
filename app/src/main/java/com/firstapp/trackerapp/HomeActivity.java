package com.firstapp.trackerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    Button button,abt;
    EditText editTextBusId, editTextPassword;
    public static final String busId = "com.firstapp.trackerapp.busId";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editTextBusId = findViewById(R.id.busId);

        editTextPassword = findViewById(R.id.password);
        button = findViewById(R.id.button);
        abt = findViewById(R.id.abtus);
        mAuth = FirebaseAuth.getInstance();

        abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AboutPage.class);
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        callMap();
                    } else {
                        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    }
                } else {
                    callMap();

                }


            }
        });

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                callMap();
            }
            else{
                Toast.makeText(HomeActivity.this,"Permission denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void callMap() {
        final String email = editTextBusId.getText().toString();
        String password = editTextPassword.getText().toString();
        String email_check = "";

        if (email.isEmpty()) {
            Toast.makeText(HomeActivity.this, "ID required", Toast.LENGTH_SHORT).show();
        }
        else if (password.isEmpty()) {
            Toast.makeText(HomeActivity.this, "Password is empty", Toast.LENGTH_SHORT).show();
        }
        else {
            email_check = email + "@gmail.com";
            mAuth.signInWithEmailAndPassword(email_check, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(HomeActivity.this, MapsActivity.class);
                        intent.putExtra(busId, email);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(HomeActivity.this, "Check your ID and Password", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}