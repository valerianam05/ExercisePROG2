package com.examen;

import java.time.LocalDate;

public class MatchAmical extends Match {
    public MatchAmical(String id, LocalDate date, String endroit, Combattant c1, Combattant c2) {
        super(id, date, endroit, c1, c2);
    }

    @Override
    public void terminer() {
        System.out.println("Match amical terminé. Aucun changement de palmarès.");
    }
}
