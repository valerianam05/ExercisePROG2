package com.examen;

import java.time.Instant;
public class Examen {
    // Attributs (Caractéristiques)
    private int id; // id (entier)
    private String titre; // titre de l'examen
    private Cours coursRattache; // le cours rattaché (objet Cours)
    private Instant dateHeure; // la date & heure de l'examen (utilisation de Instant pour la précision)
    private double coefficient; // coefficient de l'examen (double pour plus de flexibilité)

    // Constructeur complet
    public Examen(int id, String titre, Cours coursRattache, Instant dateHeure, double coefficient) {
        this.id = id;
        this.titre = titre;
        this.coursRattache = coursRattache;
        this.dateHeure = dateHeure;
        this.coefficient = coefficient;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public Cours getCoursRattache() {
        return coursRattache;
    }

    public Instant getDateHeure() {
        return dateHeure;
    }

    public double getCoefficient() {
        return coefficient;
    }
}


