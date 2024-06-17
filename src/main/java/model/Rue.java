package model;

import lombok.Getter;

@Getter
public class Rue {
    private Lieu origine;
    private Lieu destination;
    private String nom;

    public Rue(Lieu origine, Lieu destination, String nom) {
        this.origine = origine;
        this.destination = destination;
        this.nom = nom;
    }

}