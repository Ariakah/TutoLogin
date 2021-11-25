package com.example.tutologin;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{

    private TextView mPokemonName;
    private TextView mPokemonType;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        mPokemonName = (TextView)itemView.findViewById(R.id.name);
        mPokemonType = (TextView)itemView.findViewById(R.id.type);
    }

    public void display(MyPokemonBank myPokemonBank) {

        mPokemonName.setText(myPokemonBank.getName());
        mPokemonType.setText(myPokemonBank.getType());
    }
}
