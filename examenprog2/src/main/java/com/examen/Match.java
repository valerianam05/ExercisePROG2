package com.examen;

import java.time.LocalDate;

public abstract class Match {
    protected String id;
    protected LocalDate date;
    protected String endroit;
    protected Combattant combattant1;
    protected Combattant combattant2;
    protected int points1;
    protected int points2;

    public Match(String id, LocalDate date, String endroit, Combattant c1, Combattant c2) {
        this.id = id;
        this.date = date;
        this.endroit = endroit;
        this.combattant1 = c1;
        this.combattant2 = c2;
    }

    public void setPoints(int p1, int p2) {
        this.points1 = p1;
        this.points2 = p2;
    }

    public abstract void terminer(); 

    public Combattant getCombattant1() {
        return combattant1;
    }

    public Combattant getCombattant2() {
        return combattant2;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", endroit='" + endroit + '\'' +
                ", combattant1=" + combattant1.getNomDeCombattant() +
                ", combattant2=" + combattant2.getNomDeCombattant() +
                ", points1=" + points1 +
                ", points2=" + points2 +
                '}';
    }
}
