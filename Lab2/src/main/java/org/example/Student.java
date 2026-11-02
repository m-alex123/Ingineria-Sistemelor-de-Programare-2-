package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Student {

    private String nume;
    private String prenume;
    private String grupa;
    private List<Integer> note;

    public Student(String nume, String prenume, String grupa) {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.note = new ArrayList<>();
    }

    public String getNume() { return nume; }
    public String getPrenume() { return prenume; }
    public String getGrupa() { return grupa; }

    public void adaugaNota(int nota) {
        note.add(nota);
    }

    public boolean esteIntegralist() {
        for (int nota : note) {
            if (nota < 5) return false;
        }
        return true;
    }

    public double medie() {
        if (note.isEmpty()) return 0;
        double sum = 0;
        for (int n : note) sum += n;
        return sum / note.size();
    }

    public int nrRestante() {
        int count = 0;
        for (int n : note) {
            if (n < 5) count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("Grupa: %s | %s %s | Note: %s", grupa, nume, prenume, note);
    }
}
