package com.example.questionnaireapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button button;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1=findViewById(R.id.creer_question_button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getApplicationContext(),createquestionnaire.class);
                startActivity(i1);
            }
        });
        Button b2=findViewById(R.id.liste_questions_button);
        auth=FirebaseAuth.getInstance();
        button=findViewById(R.id.logout);
        user=auth.getCurrentUser();
        if(user==null){
            Intent i=new Intent(getApplicationContext(),Login.class);
            startActivity(i);
            finish();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(getApplicationContext(),liste_questions.class);
                startActivity(i2);
            }
        });
    }
}