package superiterable;

import java.util.List;

public class UseSuperIterable {

    public static void main(String[] args) {
        SuperIterable<String> sis = new SuperIterable<>(List.of("Fred","Jim","Sheila"));
        List<Student> rosterList = List.of(
                Student.of("Fred",78,"Math","Physics"),
                Student.of("Jim",58,"Art"),
                Student.of("Sheila",89,"Math","Physics","Astro Physics","Quantum mechanics")
        );
        SuperIterable<Student> roster = new SuperIterable<>(rosterList);
        roster.filter(s -> s.getGrade() > 70)
                .map(s -> s.getName() +  "has grade " + s.getGrade())
                .forEvery(s -> System.out.println(" > " + s.length()));

        System.out.println("---------");
        roster.map(s -> s.getCourses())
                .forEach(System.out::println );

        System.out.println("---------");
        roster.flatmap(s -> new SuperIterable<>(s.getCourses()))
                .distinct()
                .forEach(System.out::println );

        rosterList.stream().filter(s -> s.getGrade() > 70)
                .map(s -> s.getName() +  "has grade " + s.getGrade())
                .forEach(s -> System.out.println(" > " + s.length()));

        System.out.println("---------");
        rosterList.stream().map(s -> s.getCourses())
                .forEach(System.out::println );

        System.out.println("---------");
        rosterList.stream().flatMap(s -> (s.getCourses().stream()))
                .distinct()
                .forEach(System.out::println );

    }
}
