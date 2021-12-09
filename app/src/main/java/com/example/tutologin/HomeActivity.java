package com.example.tutologin;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends Activity implements MyPokemonAdapter.Listener {

    private RecyclerView mRecyclerView;
    private ArrayList<MyPokemonBank> mPokemonList;
    private MyPokemonAdapter mAdapter;
    private TextView mHelloText;
    private RecyclerView.LayoutManager mLayoutManager;

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

        mPokemonList.add(new MyPokemonBank("Pikachu", "Electrik", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png"));
        mPokemonList.add(new MyPokemonBank("Dracaufeu", "Feu", "https://www.pokepedia.fr/images/thumb/1/17/Dracaufeu-RFVF.png/1200px-Dracaufeu-RFVF.png"));
        mPokemonList.add(new MyPokemonBank("Miaouss", "Normal", "https://www.pokepedia.fr/images/thumb/b/b8/Miaouss-RFVF.png/250px-Miaouss-RFVF.png"));
        mPokemonList.add(new MyPokemonBank("Mew", "Psy", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/150.png"));

        mAdapter = new MyPokemonAdapter(mPokemonList, this, (MyPokemonAdapter.Listener) this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClickDelete(MyPokemonBank myPokemonBank) {
        int position = mPokemonList.indexOf(myPokemonBank);
        mPokemonList.remove(myPokemonBank);
        mAdapter.notifyItemRemoved(position );
    }

    @Override
    public void onItemClick(MyPokemonBank item) {
        Toast.makeText(
                this,
                "nom=" + item.getName() + ", type=" + item.getType(),
                Toast.LENGTH_SHORT
        ).show();
    }
}