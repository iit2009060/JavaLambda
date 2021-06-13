package collection;

import superiterable.Student;

import java.util.List;
import java.util.stream.Collectors;

public class Examples {

    public static String  getGrade(Student s) {
        int grade = s.getGrade();
        if(grade > 90) return "A";
        if(grade > 70) return "B";
        if(grade > 50) return "C";
        return "D";

    }

    public static void main(String[] args) {


        List<Student> rosterList = List.of(
                Student.of("Fred",78,"Math","Physics"),
                Student.of("Jim",58,"Art"),
                Student.of("Joan",73, "Art","Journalism"),
                Student.of("Alice",98,"Quantum Mechanics"),
                Student.of("Jimmy", 48 , "History"),
                Student.of("Sheila",89,"Math","Physics","Astro Physics","Quantum mechanics")
        );

        rosterList.stream()
                .collect(Collectors.groupingBy(Examples::getGrade))
                .entrySet().stream()
                .forEach( e -> System.out.println("Student with grade  " +  e.getKey() + "are "  + e.getValue()));


        rosterList.stream()
                .collect(Collectors.groupingBy(Examples::getGrade,Collectors.counting()))
                .entrySet().stream()
                .forEach( e -> System.out.println("There are   " +  e.getValue() + " student with grade "  + e.getKey()));

        rosterList.stream()
                .collect(Collectors.groupingBy(Examples::getGrade,Collectors.mapping(s -> s.getName(),Collectors.joining(","))))
                .entrySet().stream()
                .forEach( e -> System.out.println("There are   " +  e.getValue() + " student with grade "  + e.getKey()));
    }
}
