package com.example.pickmix.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pickmix.MainActivity;
import com.example.pickmix.R;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity{

    FirebaseAuth auth;
    ProgressBar progressBar;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        progressBar =findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);

        if(auth.getCurrentUser() != null){
            progressBar.setVisibility(View.GONE);
            Intent intent=new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "please wait you are already logged in", Toast.LENGTH_SHORT).show();
            finish();

        }

    }

    public void login(View view ){

        Intent intent=new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(intent);

    }

    public void registration(View view) {
        Intent intent=new Intent(HomeActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }
}
