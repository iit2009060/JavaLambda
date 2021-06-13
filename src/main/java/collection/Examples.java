package collection;

import superiterable.Student;

import java.util.List;

public class Examples {

    public static void main(String[] args) {
        List<Student> rosterList = List.of(
                Student.of("Fred",78,"Math","Physics"),
                Student.of("Jim",58,"Art"),
                Student.of("Joan",73, "Art","Journalism"),
                Student.of("Alice",98,"Quantum Mechanics"),
                Student.of("Jimmy", 48 , "History"),
                Student.of("Sheila",89,"Math","Physics","Astro Physics","Quantum mechanics")
        );
    }
}
