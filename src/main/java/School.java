import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class School {


    public static <E> void showAll(List<E> students) {
        for(E s: students) {
            System.out.println(s);
        }

        System.out.println("----------------");

    }

   // Functionaly this function depend on students , and criterion depend on student, can we make it generic
    public static <E> List<E> getByCriterion(List<E> students, Predicate<E> criterionOfStudent) {
        List<E> rv = new ArrayList<>();
        for(E s: students) {
            if( criterionOfStudent.test(s)) {
                rv.add(s);
            }
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
        showAll(getByCriterion(roster,enthusiastic.negate().and(smartish)));
        List<String> words =List.of("banana","apple","pie","custard","date");
        showAll(getByCriterion(words,s -> s.length() > 4));
        words = new ArrayList<>(words);
        words.sort((s1,s2) -> s2.compareTo(s1));
        System.out.println(words);
        // sorting based on length
        words.sort((s1,s2) -> s1.length() - s2.length());
        //s1.length() -s2.length() can overflow
        // right way to use is integer.compare
        words.sort((s1,s2) -> Integer.compare(s1.length() , s2.length()));
        System.out.println(words);
    }
}