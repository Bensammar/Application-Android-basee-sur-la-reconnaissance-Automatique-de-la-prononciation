package com.example.acer.myapplication;

/**
 * Created by ETS HS on 25/04/2018.
 */



public class user {


    public String nom ;
    public String password;
    public String score;

    public user(String nom, String password) {
        this.nom = nom;
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
