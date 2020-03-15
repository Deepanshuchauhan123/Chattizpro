package com.keshav.chattizpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class LoginActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPassword;
    private Button mLoginBtn;

    private FirebaseAuth mAuth;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        mProgressDialog =new ProgressDialog(this);

        mEmail = findViewById(R.id.email_login);
        mPassword = findViewById(R.id.pass_login);
        mLoginBtn = findViewById(R.id.login_btn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = mEmail.getText().toString().trim();
                String Password = mPassword.getText().toString().trim();

                loginUser(Email,Password);
            }
        });
    }

    private void loginUser(String email, String password) {
        mProgressDialog.setTitle("Logging In");
        mProgressDialog.setMessage("Please wait while we check your details");
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    mProgressDialog.dismiss();
                    Intent LoginIntent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(LoginIntent);
                    finish();
                }else{
                    mProgressDialog.hide();
                    Toast.makeText(LoginActivity.this,"There has been some error while logging you in",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
