package superiterable;

import java.util.List;
import java.util.stream.Stream;

public class UseSuperIterable {

    public static void main(String[] args) {
        SuperIterable<String> sis = new SuperIterable<>(List.of("Fred","Jim","Sheila"));
        List<Student> rosterList = List.of(
                Student.of("Fred",78,"Math","Physics"),
                Student.of("Jim",58,"Art"),
                Student.of("Sheila",89,"Math","Physics","Astro Physics","Quantum mechanics")
        );
        SuperIterable<Student> roster = new SuperIterable<>(rosterList);
      /*  roster.filter(s -> s.getGrade() > 70)
                .map(s -> s.getName() +  "has grade " + s.getGrade())
                .forEvery(s -> System.out.println(" > " + s.length()));*/

        /*System.out.println("---------");
        roster.map(s -> s.getCourses())
                .forEach(System.out::println );

        System.out.println("---------");
        roster.flatmap(s -> new SuperIterable<>(s.getCourses()))
                .distinct()
                .forEach(System.out::println );*/

      /*  rosterList.stream().filter(s -> s.getGrade() > 70)
                .map(s -> s.getName() +  "has grade " + s.getGrade())
                .forEach(s -> System.out.println(" > " + s.length()));

        System.out.println("---------");
        rosterList.stream().map(s -> s.getCourses())
                .forEach(System.out::println );

        System.out.println("---------");
        rosterList.stream().flatMap(s -> (s.getCourses().stream()))
                .distinct()
                .forEach(System.out::println );*/

        roster.peek(s -> System.out.println("SIS peak 1  " + s))
                .filter(s -> s.getGrade() > 70)
                .peek(s -> System.out.println("SIS peak 2  " + s))
                .flatmap(s ->
                        new SuperIterable<>(s.getCourses()).map( c -> "Student "  + s.getName() + "takes " + c)
                )
                .distinct()
                .forEach(System.out::println );
        System.out.println("-----------");

        rosterList.stream().peek(s -> System.out.println("stream peak 1  " + s))
                .filter(s -> s.getGrade() > 70)
                .peek(s -> System.out.println("stream peak 2  " + s))
                .flatMap(s ->
                    s.getCourses().stream().map( c -> "Student "  + s.getName() + "takes " + c)
                )
                .distinct()
                .forEach(System.out::println );

        // Streams are lazy
        Stream<Student> ss = rosterList.stream();
     //   ss.forEach(System.out::println);
       // ss.forEach(System.out::println);  Stream is stateful and lazy

    }
}
