package com.example.tutologin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyPokemonAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<MyPokemonBank> mPokemonList;

    MyPokemonAdapter(ArrayList<MyPokemonBank> mPokemonList){
        this.mPokemonList = (ArrayList<MyPokemonBank>) mPokemonList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.pokemon_bank, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.display(mPokemonList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPokemonList.size();
    }
}
