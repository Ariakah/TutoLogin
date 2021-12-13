package com.example.tutologin;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MyViewHolder extends RecyclerView.ViewHolder{

    private TextView mPokemonName;
    private TextView mPokemonType;
    private ImageButton mDeleteButton;
    private ImageView mPokemonImage;

    public MyViewHolder(@NonNull View view) {
        super(view);

        mPokemonName = view.findViewById(R.id.pokemonlist_textview_name);
        mPokemonType = view.findViewById(R.id.pokemonlist_textview_type);
        mPokemonImage = view.findViewById((R.id.pokemonlist_textview_image));
        mDeleteButton = view.findViewById(R.id.home_button_delete);
    }

    public void display(MyPokemonBank myPokemonBank, MyPokemonAdapter.Listener callback) {

        Glide.with(itemView.getContext())
                .load(myPokemonBank.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(mPokemonImage);
        mPokemonName.setText(myPokemonBank.getName());
        mPokemonType.setText(myPokemonBank.getType());
        mDeleteButton.setOnClickListener(view -> callback.onClickDelete(myPokemonBank));
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onItemClick(myPokemonBank);
            }
        });
    }
}
