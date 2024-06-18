import model.*;
import org.junit.Test;
import service.MarcheurService;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class TestMarcheur {

    @Test
    public void testMarcheurService() {

        Lieu hei = new Lieu("HEI");
        Lieu pullman = new Lieu("Pullman");
        Lieu balançoire = new Lieu("Balançoire");
        Lieu esti = new Lieu("ESTI");
        Lieu sekolintsika = new Lieu("Sekolintsika");
        Lieu marais = new Lieu("Marais");
        Lieu boulevarDeLEurope = new Lieu("BoulevarDeLEurope");
        Lieu nexta = new Lieu("Nexta");

        Rue rue1 = new Rue(hei, pullman, "Andriatsihoarana");
        Rue rue2 = new Rue(pullman, balançoire, "Ranaivo");
        Rue rue3 = new Rue(balançoire, esti, "Unnamed");
        Rue rue4 = new Rue(hei, sekolintsika, "Unnamed");
        Rue rue5 = new Rue(sekolintsika, marais, "Unnamed");
        Rue rue6 = new Rue(balançoire, boulevarDeLEurope, "Unnamed");
        Rue rue7 = new Rue(boulevarDeLEurope, esti, "Unnamed");
        Rue rue8 = new Rue(pullman, nexta, "Unnamed");

        Carte carte = new Carte();
        carte.ajouterLieu(hei);
        carte.ajouterLieu(pullman);
        carte.ajouterLieu(balançoire);
        carte.ajouterLieu(esti);
        carte.ajouterLieu(sekolintsika);
        carte.ajouterLieu(marais);
        carte.ajouterLieu(boulevarDeLEurope);
        carte.ajouterLieu(nexta);
        carte.ajouterRue(rue1);
        carte.ajouterRue(rue2);
        carte.ajouterRue(rue3);
        carte.ajouterRue(rue4);
        carte.ajouterRue(rue5);
        carte.ajouterRue(rue6);
        carte.ajouterRue(rue7);
        carte.ajouterRue(rue8);

        MarcheurService marcheur = new MarcheurService(carte, hei);
        marcheur.setRandom(new Random());

        marcheur.marcherVers(esti);

        assertEquals(esti, marcheur.getPositionActuelle());
    }
}
