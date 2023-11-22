package com.example.questionnaireapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class adduser extends AppCompatActivity {

    TextInputEditText editTextEmail,editTextPassword;
    Button buttonreg;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    Button textView;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            finish();
        }
    }
            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);
        mAuth=FirebaseAuth.getInstance();
        editTextEmail=findViewById(R.id.email);
        editTextPassword=findViewById(R.id.password);
        buttonreg=findViewById(R.id.btn_ajouter);
        progressBar=findViewById(R.id.progressBar);
        textView=findViewById(R.id.LoginNom);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);
                finish();
            }
        });

        buttonreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(view.VISIBLE);
                String email,password;
                email=String.valueOf(editTextEmail.getText());
                password=String.valueOf(editTextPassword.getText());
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(adduser.this,"Entrer votre email ",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(adduser.this,"Entrer votre mot de passe",Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);

                                if (task.isSuccessful()) {
                                    Toast.makeText(adduser.this, "utilisateur creer.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent i=new Intent(getApplicationContext(),Login.class);
                                    startActivity(i);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(adduser.this, "Authentication incorrect.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }
        });


    }
}