package com.example.tutologin;

public class MyPokemonBank {

    private String name;
    private String type;
    private String avatarUrl;

    MyPokemonBank(String name, String type, String avatarUrl){
        this.name = name;
        this.type = type;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {return name;}
    public String getType() {return type;}
    public String getAvatarUrl() {return avatarUrl;}
}
