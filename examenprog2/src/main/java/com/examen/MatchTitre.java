package com.examen;

import java.time.LocalDate;

public class MatchTitre extends Match {
    private String titre;

    public MatchTitre(String id, LocalDate date, String endroit, Combattant c1, Combattant c2, String titre) {
        super(id, date, endroit, c1, c2);
        this.titre = titre;
    }

    @Override
    public void terminer() {
        if (points1 > points2) {
            combattant1.ajouterVictoire();
            combattant2.ajouterDefaite();
            combattant1.ajouterTitre(titre);
        } else if (points2 > points1) {
            combattant2.ajouterVictoire();
            combattant1.ajouterDefaite();
            combattant2.ajouterTitre(titre);
        } else {
            combattant1.ajouterEgalite();
            combattant2.ajouterEgalite();
        }
    }
}

