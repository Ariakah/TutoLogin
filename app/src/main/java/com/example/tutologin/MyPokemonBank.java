package com.example.tutologin;

public class MyPokemonBank {

    private String name;
    private String type;

    MyPokemonBank(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName() {return name;}
    public String getType() {return type;}
}
