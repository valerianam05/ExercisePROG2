import java.time.LocalDate;

public class Tuteur {
    private int id; // id (entier)
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String email;
    private String numeroDeTelephone;
    private String descriptionLien; [cite_start];

    public Tuteur(int id, String nom, String prenom, LocalDate dateDeNaissance,
                  String email, String numeroDeTelephone, String descriptionLien) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.email = email;
        this.numeroDeTelephone = numeroDeTelephone;
        this.descriptionLien = descriptionLien;
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

    public String getDescriptionLien() {
        return descriptionLien;
    }
}