package model;


import java.util.*;

public class Carte {
    private Map<Lieu, List<Rue>> carte;

    public Carte() {
        this.carte = new HashMap<>();
    }

    public void ajouterLieu(Lieu lieu) {
        carte.putIfAbsent(lieu, new ArrayList<>());
    }

    public void ajouterRue(Rue rue) {
        carte.get(rue.getOrigine()).add(rue);
    }

    public List<Rue> getRues(Lieu lieu) {
        return carte.getOrDefault(lieu, Collections.emptyList());
    }
}