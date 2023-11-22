package com.example.questionnaireapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Vector;

public class liste_questions extends AppCompatActivity {

    private Mabase mabase ;
    RecyclerView recyclerView;
    FloatingActionButton add_button;
    Mabase db;
    ArrayList<String> idq, titre,desc;
    Myadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_questions);
        recyclerView=findViewById(R.id.recyclerview);
        add_button=findViewById(R.id.floatingActionButton);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(liste_questions.this,createquestionnaire.class);
                startActivity(intent);
            }
        });
        db=new Mabase(liste_questions.this);
        titre=new ArrayList<>();
        desc=new ArrayList<>();
        idq=new ArrayList<>();

        showquestions();
        adapter=new Myadapter(liste_questions.this,idq,titre);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(liste_questions.this));
}

void showquestions(){
        Cursor cursor=db.readAllData();
        if(cursor.getCount()==0){
            Toast.makeText(this, "Vous n'avez pas ajoutee une question", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                idq.add(cursor.getString(0));
                titre.add(cursor.getString(1));
                //desc.add(cursor.getString(2));


            }
        }

}


}