package com.examen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class MatchTest {

    private Combattant c1;
    private Combattant c2;
    @BeforeEach
    public void setup() {
        c1 = new Combattant("1", "Valéria", "Nomentsoa", "Predator", 115.0);
        c2 = new Combattant("2", "Tojosoa", "Kotokely", "Stipe", 112.0);
    }

     @Test
    public void testMatchOfficielVictoire() {
        MatchOfficiel match = new MatchOfficiel("m1", LocalDate.now(), "Las Vegas", c1, c2);
        match.setPoints(30, 27);
        match.terminer();

        assertEquals(1, c1.getVictoires());
        assertEquals(1, c2.getDefaites());
    }

    @Test
    public void testMatchTitreEgalite() {
        MatchTitre match = new MatchTitre("m2", LocalDate.now(), "New York", c1, c2, "Champion des lourds-légers");
        match.setPoints(29, 29);
        match.terminer();

        assertEquals(1, c1.getEgalites());
        assertEquals(1, c2.getEgalites());
        assertTrue(c1.getTitres().isEmpty());
        assertTrue(c2.getTitres().isEmpty());
    }

    @Test
    public void testMatchTitreVictoireAvecTitre() {
        MatchTitre match = new MatchTitre("m3", LocalDate.now(), "Paris", c1, c2, "Champion du monde");
        match.setPoints(30, 28);
        match.terminer();

        assertEquals(1, c1.getVictoires());
        assertEquals(1, c2.getDefaites());
        assertTrue(c1.getTitres().contains("Champion du monde"));
    }

    @Test
    public void testMatchAmicalSansEffet() {
        MatchAmical match = new MatchAmical("m4", LocalDate.now(), "Tokyo", c1, c2);
        match.setPoints(30, 25);
        match.terminer();

        assertEquals(0, c1.getVictoires());
        assertEquals(0, c2.getDefaites());
    }
}

