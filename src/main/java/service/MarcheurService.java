package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Carte;
import model.Lieu;
import model.Rue;

import java.util.*;

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

    public void marcherVers(Lieu destination) {
        Stack<Lieu> pile = new Stack<>();
        Set<Lieu> visites = new HashSet<>();
        pile.push(positionActuelle);
        visites.add(positionActuelle);

        while (!pile.isEmpty()) {
            Lieu lieuCourant = pile.peek();
            if (lieuCourant.equals(destination)) {
                positionActuelle = lieuCourant;
                System.out.println("Arrivé à destination: " + lieuCourant);
                return;
            }

            List<Rue> rues = carte.getRues(lieuCourant);
            List<Rue> ruesNonVisitees = new ArrayList<>();
            for (Rue rue : rues) {
                if (!visites.contains(rue.getDestination())) {
                    ruesNonVisitees.add(rue);
                }
            }

            if (!ruesNonVisitees.isEmpty()) {
                Rue prochaineRue = ruesNonVisitees.get(random.nextInt(ruesNonVisitees.size()));
                Lieu prochainLieu = prochaineRue.getDestination();
                visites.add(prochainLieu);
                pile.push(prochainLieu);
                System.out.println("Marcher vers: " + prochainLieu);
            } else {
                System.out.println("Cul-de-sac à: " + lieuCourant + ", revenir en arrière");
                pile.pop();
            }
        }

        System.out.println("Aucun chemin trouvé vers " + destination);
    }
}
