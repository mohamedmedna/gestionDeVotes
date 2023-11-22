package com.example.questionnaireapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {
    Context context;
    ArrayList idq,titre;

    Myadapter(Context context,ArrayList idq,ArrayList titre){
        this.context=context;
        this.idq=idq;
        this.titre=titre;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
       View view= inflater.inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter.MyViewHolder holder,final int position) {
    holder.idqtext.setText(String.valueOf((idq.get(position))));
    holder.titretext.setText(String.valueOf(titre.get(position)));
    holder.mainlayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(context,ResponsActivity.class);
            intent.putExtra("titre",String.valueOf(titre.get(position)));
            intent.putExtra("idq",String.valueOf(idq.get(position)));
            context.startActivity(intent);

        }
    });
    }

    @Override
    public int getItemCount() {
        return idq.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idqtext,titretext;
        LinearLayout mainlayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idqtext=itemView.findViewById(R.id.idq);
            titretext=itemView.findViewById(R.id.titre_txt);
            mainlayout=itemView.findViewById(R.id.mainlayout);
        }
    }
}
