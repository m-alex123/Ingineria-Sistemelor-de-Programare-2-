package org.example;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args) {

        //2.7.1
        System.out.println("PROBLEMA 2.7.1");

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();
        Set<Integer> zSet = new TreeSet<>();
        List<Integer> xMinusY = new ArrayList<>();
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();

        Random rand = new Random();

        IntStream.range(0, 5).forEach(i -> x.add(rand.nextInt(11)));
        IntStream.range(0, 7).forEach(i -> y.add(rand.nextInt(11)));

        System.out.println("Lista x INAINTE de sortate: " + x);
        System.out.println("Lista y INAINTE de sortare: " + y);

        Collections.sort(x);
        Collections.sort(y);

        System.out.println("Lista x DUPA sortate: " + x);
        System.out.println("Lista y DUPA sortare: " + y);

        System.out.println("x: " + x);
        System.out.println("y: " + y);

        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("a) xPlusY: " + xPlusY);

        zSet.addAll(x);
        zSet.retainAll(y);
        System.out.println("b) zSet: " + zSet);

        xMinusY.addAll(x);
        xMinusY.removeAll(y);
        System.out.println("c) xMinusY: " + xMinusY);

        xPlusYLimitedByP.addAll(xPlusY);
        xPlusYLimitedByP.removeIf(val -> val > p);
        System.out.println("d) xPlusYLimitedByP (p=" + p + "): " + xPlusYLimitedByP);
        System.out.println();
        System.out.println();

        //2.7.2
        System.out.println("PROBLEMA 2.7.2");

        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student("Cosmin", "Alex", "31/2"));
        studenti.add(new Student("Popa", "Maria", "31/1"));
        studenti.add(new Student("Popa", "Marian", "31/2"));
        studenti.add(new Student("Florin", "Darius", "31/1"));
        studenti.add(new Student("Maria", "Ana", "31/2"));

        for (Student s : studenti) {
            for (int i = 0; i < 5; i++) {
                s.adaugaNota(rand.nextInt(7) + 4);
            }
        }

        studenti.sort(Comparator.comparing(Student::getGrupa)
                .thenComparing(Student::getNume)
                .thenComparing(Student::getPrenume));

        System.out.println("Sortare pe grupe si alfabetic");
        studenti.forEach(System.out::println);

        List<Student> integralisti = studenti.stream()
                .filter(Student::esteIntegralist)
                .collect(Collectors.toList());

        List<Student> restantieri = studenti.stream()
                .filter(s -> !s.esteIntegralist())
                .collect(Collectors.toList());

        integralisti.sort((s1, s2) -> Double.compare(s2.medie(), s1.medie()));
        System.out.println();
        System.out.println("Integralisti (dupa medie descrescator)");
        for (Student s : integralisti) {
            System.out.println(s + " | Medie: " + s.medie());
        }

        restantieri.sort(Comparator.comparingInt(Student::nrRestante));
        System.out.println();
        System.out.println(" Restantieri (dupa numar de restante crescator)");
        for (Student s : restantieri) {
            System.out.println(s + " | Restante: " + s.nrRestante());
        }
    }
}




