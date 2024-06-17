package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Carte;
import model.Lieu;
import model.Rue;

import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcheurService {
    private Carte carte;
    private Lieu positionActuelle;
    private Random random;

    public MarcheurService(Carte carte, Lieu positionInitiale) {
        this.carte = carte;
        this.positionActuelle = positionInitiale;
        this.random = new Random();
    }

    public void marcher() {
        List<Rue> rues = carte.getRues(positionActuelle);
        if (!rues.isEmpty()) {
            Rue prochaineRue = rues.get(random.nextInt(rues.size()));
            positionActuelle = prochaineRue.getDestination();
            System.out.println("Marcher vers: " + positionActuelle);
        } else {
            System.out.println("Aucune rue disponible depuis " + positionActuelle);
        }
    }
}