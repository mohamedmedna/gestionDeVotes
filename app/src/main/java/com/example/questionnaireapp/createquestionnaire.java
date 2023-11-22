package com.example.questionnaireapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class createquestionnaire extends AppCompatActivity {


    EditText titre;
    EditText desc;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createquestionnaire);
        titre=findViewById(R.id.titre_input);
        desc=findViewById(R.id.desc_input);
        submit=findViewById(R.id.save_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mabase db=new Mabase(createquestionnaire.this);
                db.addquestion(titre.getText().toString().trim(),desc.getText().toString().trim());
                Intent i1=new Intent(getApplicationContext(),liste_questions.class);
                startActivity(i1);
            }
        });


    }


}