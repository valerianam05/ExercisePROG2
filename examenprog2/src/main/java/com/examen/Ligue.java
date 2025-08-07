package com.examen;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Ligue {
    private String nom;
    private List<Combattant> combattants;
    private List<Match> matchs;

    public Ligue(String nom) {
        this.nom = nom;
        this.combattants = new ArrayList<>();
        this.matchs = new ArrayList<>();
    }

    public void ajouterCombattant(Combattant c) {
        combattants.add(c);
    }

    public void ajouterMatch(Match m) {
        matchs.add(m);
    }

    public List<Match> getMatchsDuCombattant(Combattant c) {
        List<Match> result = new ArrayList<>();
        for (Match m : matchs) {
            if (m.getCombattant1().equals(c) || m.getCombattant2().equals(c)) {
                result.add(m);
            }
        }
        return result;
    }
}

