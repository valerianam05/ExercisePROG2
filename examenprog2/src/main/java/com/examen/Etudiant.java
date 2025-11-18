package com.examen;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String email;
    private String numeroDeTelephone;
    private String groupe;
    private Tuteur tuteur;

    public Etudiant(int id, String nom, String prenom, LocalDate dateDeNaissance,
                    String email, String numeroDeTelephone, String groupe, Tuteur tuteur) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.email = email;
        this.numeroDeTelephone = numeroDeTelephone;
        this.groupe = groupe;
        this.tuteur = tuteur;
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

    public String getGroupe() {
        return groupe;
    }

    public Tuteur getTuteur() {
        return tuteur;
    }
}
