package com.example.questionnaireapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class liste_reponses extends AppCompatActivity {

    private Mabase mabase ;

    RecyclerView recyclerView;

    Mabase db;

    ArrayList<String>  reponse;
    String idq;

    Myadapter1 adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_reponses);
        recyclerView=findViewById(R.id.recyclerview1);
        db=new Mabase(liste_reponses.this);
        reponse=new ArrayList<>();
       // idr=new ArrayList<>();

        showreponses();
        adapter=new Myadapter1(liste_reponses.this,reponse);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(liste_reponses.this));
    }
    void showreponses(){
        if(getIntent().hasExtra("idq")){
            idq=getIntent().getStringExtra("idq");

        }
        Cursor cursor=db.readreponses(idq);
        if(cursor.getCount()==0){
            Toast.makeText(this, "Vous n'avez pas ajoutee une reponse", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
              //  idr.add(cursor.getString(0));
                reponse.add(cursor.getString(1));
                //desc.add(cursor.getString(2));


            }
        }

    }
}