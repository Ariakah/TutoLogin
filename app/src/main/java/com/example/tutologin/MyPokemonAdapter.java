package com.example.tutologin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyPokemonAdapter extends RecyclerView.Adapter<MyViewHolder>{

    public interface Listener {
        void onClickDelete(MyPokemonBank myPokemonBank);
        void onItemClick(MyPokemonBank item);
    }

    private Listener callback;
    private final Listener listener;

    List<MyPokemonBank> mPokemonList;

    MyPokemonAdapter(List<MyPokemonBank> mPokemonList, Listener callback, Listener listener){
        this.callback = callback;
        this.mPokemonList = mPokemonList;
        this.listener = listener;
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
        holder.display(mPokemonList.get(position), callback, listener);
    }

    @Override
    public int getItemCount() {
        return mPokemonList.size();
    }
}
