import java.util.ArrayList;
import java.util.List;
import java.time.Instant;

public class Note {
    private Etudiant etudiant;
    private Examen examen;
    private double valeurInitiale;
    private List<ChangementNote> historiqueChangements;

    public Note(Etudiant etudiant, Examen examen, double valeurInitiale) {
        this.etudiant = etudiant;
        this.examen = examen;
        this.valeurInitiale = valeurInitiale;
        this.historiqueChangements = new ArrayList<>();
    }

    public void addChangement(double nouvelleValeur, Instant instant, String motif) {
        ChangementNote changement = new ChangementNote(nouvelleValeur, instant, motif);
        this.historiqueChangements.add(changement);
        this.historiqueChangements.sort((c1, c2) -> c1.getInstantModification().compareTo(c2.getInstantModification()));
    }

    // Getters
    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Examen getExamen() {
        return examen;
    }

    public double getValeurInitiale() {
        return valeurInitiale;
    }

    public List<ChangementNote> getHistoriqueChangements() {
        return historiqueChangements;
    }
}

