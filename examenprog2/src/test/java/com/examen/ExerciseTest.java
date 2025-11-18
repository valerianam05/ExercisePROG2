import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ExerciseTest {
    private GestionNotes gestionNotes;
    private List<Note> toutesLesNotes;
    private Etudiant etudiantA;
    private Etudiant etudiantB;
    private Cours prog2;
    private Examen exam1; // Coefficient 2
    private Examen exam2; // Coefficient 3
    private Instant t0_debut;
    private Instant t1_changement;
    private Instant t2_final;
    private Note noteExam1_A;
    private Note noteExam2_A;

    @BeforeEach
    void setUp() {

        t0_debut = Instant.parse("2025-10-01T10:00:00Z");
        t1_changement = Instant.parse("2025-10-05T14:30:00Z");
        t2_final = Instant.parse("2025-10-10T11:00:00Z");

        Tuteur tuteur = new Tuteur(1, "Smith", "John", LocalDate.of(1980, 1, 1), "j.s@tutor.com", "0600000000", "Père");
        Enseignant prof = new Enseignant(10, "Dupont", "Marie", LocalDate.of(1975, 5, 5), "m.d@school.com", "0700000000", "Back-end");

        etudiantA = new Etudiant(100, "Alice", "Durand", LocalDate.of(2005, 3, 15), "a.d@mail.com", "0611111111", "G1", tuteur);
        etudiantB = new Etudiant(101, "Bob", "Martin", LocalDate.of(2004, 8, 20), "b.m@mail.com", "0622222222", "G2", tuteur);

        prog2 = new Cours(200, "PROG2", 6, prof);



        exam1 = new Examen(301, "TP 1", prog2, t0_debut, 2.0);
        exam2 = new Examen(302, "Examen Final", prog2, t0_debut.plusSeconds(3600), 3.0);


        toutesLesNotes = new ArrayList<>();


        noteExam1_A = new Note(etudiantA, exam1, 10.0);
        // Ajout d'un changement: le 5 octobre, la note passe à 11.0
        noteExam1_A.addChangement(11.0, t1_changement, "Correction du QCM");
        toutesLesNotes.add(noteExam1_A);

        noteExam2_A = new Note(etudiantA, exam2, 15.0);
        toutesLesNotes.add(noteExam2_A);

        gestionNotes = new GestionNotes(toutesLesNotes);
    }

    @Test
    void getExamGrade_AvantExamen_DoitRetournerZero() {
        Instant avantExamen = t0_debut.minusSeconds(1);
        double note = gestionNotes.getExamGrade(exam1, etudiantA, avantExamen);
        assertEquals(0.0, note, 0.001);
    }

    @Test
    void getExamGrade_NoteInitiale_DoitRetournerDix() {
        Instant apresExamen_AvantChangement = t0_debut.plusSeconds(3600); // 1h après l'examen
        double note = gestionNotes.getExamGrade(exam1, etudiantA, apresExamen_AvantChangement);
        assertEquals(10.0, note, 0.001);
    }

    @Test
    void getExamGrade_ApresChangement_DoitRetournerOnze() {
        Instant apresChangement = t1_changement.plusSeconds(1);
        double note = gestionNotes.getExamGrade(exam1, etudiantA, apresChangement);
        assertEquals(11.0, note, 0.001);
    }

    @Test
    void getExamGrade_NoteSansChangement_DoitRetournerQuinze() {
        double note = gestionNotes.getExamGrade(exam2, etudiantA, t2_final);
        assertEquals(15.0, note, 0.001);
    }

    @Test
    void getExamGrade_EtudiantNonConcerne_DoitRetournerZero() {
        // Tester avec un étudiant qui n'a pas de note enregistrée
        double note = gestionNotes.getExamGrade(exam1, etudiantB, t2_final);
        assertEquals(0.0, note, 0.001);
    }

    @Test
    void getCourseGrade_NoteFinaleApresChangement_DoitCalculerMoyennePonderee() {

        double noteFinale = gestionNotes.getCourseGrade(prog2, etudiantA, t2_final);
        assertEquals(13.4, noteFinale, 0.001);
    }

    @Test
    void getCourseGrade_NoteFinaleAvantChangement_DoitUtiliserValeursInitiales() {

        double noteFinale = gestionNotes.getCourseGrade(prog2, etudiantA, t0_debut.plusSeconds(3600)); // Juste après l'examen
        assertEquals(13.0, noteFinale, 0.001);
    }

    @Test
    void getCourseGrade_EtudiantNonConcerne_DoitRetournerZero() {
        double noteFinale = gestionNotes.getCourseGrade(prog2, etudiantB, t2_final);
        assertEquals(0.0, noteFinale, 0.001);
    }
}
