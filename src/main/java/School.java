import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


public class School {


    public static void showAll(Iterable<?> students) {
        for( Object s: students) {
            System.out.println(s);
        }

        System.out.println("----------------");

    }

   // Functionaly this function depend on students , and criterion depend on student, can we make it generic
    public static <E> List<E> filter(Iterable<E> students, Predicate<E> criterionOfStudent) {
        List<E> rv = new ArrayList<>();
        for(E s: students) {
            if( criterionOfStudent.test(s)) {
                rv.add(s);
            }
        }
        return rv;
    }

    // define map function which take E as a argument and return F;
    public static <E,F> List<F> map(Iterable<E> students, Function<E,F> criterion) {
        List<F> rv = new ArrayList<>();
        for(E s: students) {
           F f = criterion.apply(s);
           rv.add(f);
        }
        return rv;
    }

    public static void main(String[] args) {
        List<Student> roster = List.of(
                Student.of("Fred",78,"Math","Physics"),
                Student.of("Jim",58,"Art"),
                Student.of("Sheila",89,"Math","Physics","Astro Physics","Quantum mechanics")
        );
        Predicate<Student> enthusiastic  =  s -> s.getCourses().size() > 3;
        Predicate<Student> smartish  =  s -> s.getGrade() > 70;
        showAll(filter(roster,enthusiastic.negate().and(smartish)));
        List<String> words =List.of("banana","apple","pie","custard","date");
        showAll(filter(words,s -> s.length() > 4));
        words = new ArrayList<>(words);
       // words.sort((s1,s2) -> s1.compareTo(s1));
        // converting to lambda shortcut
        words.sort(String::compareTo);
      //  System.out.println(words);
        // sorting based on length
        words.sort((s1,s2) -> s1.length() - s2.length());
        //s1.length() -s2.length() can overflow
        // right way to use is integer.compare
        words.sort((s1,s2) -> Integer.compare(s1.length() , s2.length()));
       // System.out.println(words);


        showAll(map(roster, s -> "Student Called  " + s.getName() + " has grade " + String.valueOf(s.getGrade())));

    }
}