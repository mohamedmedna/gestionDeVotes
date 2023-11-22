package com.example.questionnaireapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResponsActivity extends AppCompatActivity {

    TextView Questiontitle;
    Button submitresponse;
    Button listereponses;
    Button retour;
    EditText reponse;

    String titre;
    String idq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respons);
        Questiontitle=findViewById(R.id.repondquestion);
        submitresponse=findViewById(R.id.submitresponse);
        listereponses=findViewById(R.id.listesresponse);
        reponse=findViewById(R.id.reponseedit);


        getIntentdata();

        submitresponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mabase db=new Mabase(ResponsActivity.this);
                db.addreponse(reponse.getText().toString().trim(),idq);
                Intent i1=new Intent(getApplicationContext(),liste_questions.class);
                startActivity(i1);

            }
        });
        listereponses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent i1=new Intent(getApplicationContext(),liste_reponses.class);
                    i1.putExtra("idq",idq);
                    startActivity(i1);
                };


        });


    }
    void getIntentdata(){
        if(getIntent().hasExtra("titre")){
            titre=getIntent().getStringExtra("titre");
            Questiontitle.setText(titre);
            idq=getIntent().getStringExtra("idq");

        }else{
            Toast.makeText( this,"No data", Toast.LENGTH_SHORT).show();
        }
    }
}