package com.example.tutologin;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends Activity {

    private RecyclerView mRecyclerView;
    private ArrayList<MyPokemonBank> mPokemonList;
    private MyPokemonAdapter mAdapter;
    private TextView mHelloText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mHelloText = findViewById(R.id.home_textview_hello);

        Intent intent = getIntent();
        String login = intent.getStringExtra(MainActivity.LOGIN_DATA);
        mHelloText.setText("Hello " + login);

        mRecyclerView = findViewById(R.id.home_recyclerview_pokemonname);

        mPokemonList = new ArrayList<>();

        mPokemonList.add(new MyPokemonBank("Pikachu", "Electrik"));
        mPokemonList.add(new MyPokemonBank("Dracaufeu", "Feu"));
        mPokemonList.add(new MyPokemonBank("Miaouss", "Normal"));
        mPokemonList.add(new MyPokemonBank("Mew", "Psy"));

        mAdapter = new MyPokemonAdapter(mPokemonList);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setAdapter(mAdapter);
    }
}