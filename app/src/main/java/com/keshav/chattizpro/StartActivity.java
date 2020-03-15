package com.keshav.chattizpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ResourceCursorAdapter;

public class StartActivity extends AppCompatActivity {

    private Button mLoginBtn;
    private Button mRegBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mLoginBtn = findViewById(R.id.Login_btn_start);
        mRegBtn = findViewById(R.id.signup_btn_start);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(StartActivity.this,LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

        mRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegIntent = new Intent(StartActivity.this, RegisterActivity.class);
                startActivity(RegIntent);
            }
        });
    }


}
