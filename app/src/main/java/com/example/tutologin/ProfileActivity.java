package com.example.tutologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProfileActivity extends AppCompatActivity {

    private ImageView mPokemonUrl;
    private TextView mPokemonName, mPokemonType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mPokemonUrl = findViewById(R.id.profil_pokemon_image);
        mPokemonName = findViewById(R.id.profil_pokemon_name);
        mPokemonType = findViewById(R.id.profil_pokemon_type);

        Intent intent = getIntent();
        String image = intent.getStringExtra(HomeActivity.POKEMON_IMAGE);
        String name = intent.getStringExtra(HomeActivity.POKEMON_NAME);
        String type = intent.getStringExtra(HomeActivity.POKEMON_TYPE);
        Glide.with(this).asBitmap().load(image).into(mPokemonUrl);
        mPokemonName.setText(name);
        mPokemonType.setText(type);
    }
}