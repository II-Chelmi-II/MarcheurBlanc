package model;

import lombok.Getter;

@Getter
public class Lieu {
    private String nom;

    public Lieu(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}