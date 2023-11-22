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

public class Myadapter1 extends RecyclerView.Adapter<Myadapter1.MyViewHolder> {
    Context context;
    ArrayList reponse;
    Myadapter1(Context context,ArrayList reponse){
        this.context=context;
        //this.idr=idr;
        this.reponse=reponse;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.row_item1,parent,false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull Myadapter1.MyViewHolder holder, int position) {
       // holder.idrtext.setText(String.valueOf((idr.get(position))));
        holder.reponsetext.setText(String.valueOf(reponse.get(position)));
    }

    @Override
    public int getItemCount() {
        return reponse.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idrtext,reponsetext;
        LinearLayout mainlayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //idrtext=itemView.findViewById(R.id.idr);
            reponsetext=itemView.findViewById(R.id.reponse_txt);
            mainlayout=itemView.findViewById(R.id.mainlayout1);
        }
    }
}
