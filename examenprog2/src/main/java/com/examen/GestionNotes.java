package com.examen;



import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class GestionNotes {
    private List<Note> toutesLesNotes; // Liste de toutes les notes du système

    public GestionNotes(List<Note> toutesLesNotes) {
        this.toutesLesNotes = toutesLesNotes;
    }

    public double getExamGrade(Examen exam, Etudiant student, Instant t) {
        // 1. Trouver la note spécifique pour cet étudiant et cet examen
        Note note = toutesLesNotes.stream()
                .filter(n -> n.getExamen().equals(exam) && n.getEtudiant().equals(student))
                .findFirst()
                .orElse(null);

        if (note == null) {
            return 0.0; // Aucune note trouvée
        }


        if (note.getExamen().getDateHeure().isAfter(t)) {
            return 0.0; // L'examen n'a pas encore eu lieu ou la note n'est pas encore saisie à cet instant t
        }

        double noteActuelle = note.getValeurInitiale();

        List<ChangementNote> historiqueTrie = new ArrayList<>(note.getHistoriqueChangements());

        historiqueTrie.sort(Comparator.comparing(ChangementNote::getInstantModification));

        for (ChangementNote changement : historiqueTrie) {
            if (!changement.getInstantModification().isAfter(t)) {
                noteActuelle = changement.getNouvelleValeur();
            } else {
                break;
            }
        }

        return noteActuelle;
    }

    public double getCourseGrade(Cours course, Etudiant student, Instant t) {
        double sommeNotesPonderees = 0.0;
        double sommeCoefficients = 0.0;

        // 1. Filtrer toutes les notes pour ce cours
        List<Note> notesDuCours = toutesLesNotes.stream()
                .filter(n -> n.getExamen().getCoursRattache().equals(course) && n.getEtudiant().equals(student))
                .toList();

        for (Note note : notesDuCours) {
            Examen exam = note.getExamen();

            // On s'assure que l'examen a eu lieu avant l'instant t
            if (exam.getDateHeure().isBefore(t) || exam.getDateHeure().equals(t)) {
                // 2. Utiliser getExamGrade pour obtenir la note correcte à l'instant t
                double noteExamen = getExamGrade(exam, student, t);
                double coeff = exam.getCoefficient();

                sommeNotesPonderees += noteExamen * coeff;
                sommeCoefficients += coeff;
            }
        }

        if (sommeCoefficients == 0.0) {
            return 0.0;
        }

        return sommeNotesPonderees / sommeCoefficients;
    }
}
