package com.examen;

import java.time.LocalDate;

public class MatchOfficiel extends Match {
    public MatchOfficiel(String id, LocalDate date, String endroit, Combattant c1, Combattant c2) {
        super(id, date, endroit, c1, c2);
    }

    @Override
    public void terminer() {
        if (points1 > points2) {
            combattant1.ajouterVictoire();
            combattant2.ajouterDefaite();
        } else if (points2 > points1) {
            combattant2.ajouterVictoire();
            combattant1.ajouterDefaite();
        } else {
            combattant1.ajouterEgalite();
            combattant2.ajouterEgalite();
        }
    }
}
