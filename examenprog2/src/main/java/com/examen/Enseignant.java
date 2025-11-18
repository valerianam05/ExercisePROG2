package com.examen;

import java.time.LocalDate;

public class Enseignant {
    private int id; // id (entier)
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String email;
    private String numeroDeTelephone;
    private String specialite; [cite_start]// spécialité (par exemple: front-end, back-end...) [cite: 7]

    // Constructeur complet
    public Enseignant(int id, String nom, String prenom, LocalDate dateDeNaissance,
                      String email, String numeroDeTelephone, String specialite) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.email = email;
        this.numeroDeTelephone = numeroDeTelephone;
        this.specialite = specialite;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroDeTelephone() {
        return numeroDeTelephone;
    }

    public String getSpecialite() {
        return specialite;
    }
}
