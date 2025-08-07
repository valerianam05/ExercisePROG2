package com.examen;

import java.util.ArrayList;
import java.util.List;

public class Combattant {
    private String id;
    private String nom;
    private String prenom;
    private String nomDeCombattant;
    private double poids;
    private List<String> titres;

    private int victoires;
    private int defaites;
    private int egalites;

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

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNomDeCombattant() {
        return nomDeCombattant;
    }

    public double getPoids() {
        return poids;
    }

    public List<String> getTitres() {
        return titres;
    }

    public int getVictoires() {
        return victoires;
    }

    public int getDefaites() {
        return defaites;
    }

    public int getEgalites() {
        return egalites;
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

