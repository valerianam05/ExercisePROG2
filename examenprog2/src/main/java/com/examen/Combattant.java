package com.examen;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Combattant {
    private String id, nom, prenom, nomDeCombattant;
    private double poids;
    private List<String> titres;

    private int victoires, defaites, egalites;

    public Combattant(String id, String nom, String prenom, String nomDeCombattant, double poids) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.nomDeCombattant = nomDeCombattant;
        this.poids = poids;
        this.titres = new ArrayList<>();
        this.victoires = 0;
        this.defaites = 0;
        this.egalites = 0;
    }

    public void ajouterVictoire() {
        victoires++;
    }

    public void ajouterDefaite() {
        defaites++;
    }

    public void ajouterEgalite() {
        egalites++;
    }

    public void ajouterTitre(String titre) {
        titres.add(titre);
    }

    @Override
    public String toString() {
        return "Combattant {" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nomDeCombattant='" + nomDeCombattant + '\'' +
                ", poids=" + poids +
                ", titres=" + titres +
                ", victoires=" + victoires +
                ", defaites=" + defaites +
                ", egalites=" + egalites +
                '}';
    }
}

