package com.examen;
public class ChangementNote {
    private double nouvelleValeur;
    private Instant instantModification;
    private String motif;

    // Constructeur
    public ChangementNote(double nouvelleValeur, Instant instantModification, String motif) {
        this.nouvelleValeur = nouvelleValeur;
        this.instantModification = instantModification;
        this.motif = motif;
    }

    // Getters
    public double getNouvelleValeur() {
        return nouvelleValeur;
    }

    public Instant getInstantModification() {
        return instantModification;
    }

    public String getMotif() {
        return motif;
    }
}



