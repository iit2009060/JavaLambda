import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// this annotation throw error if we define more than one abstract methods.
@FunctionalInterface
interface CriterionOfStudent {
    boolean test(Student student);
    default CriterionOfStudent negate() {
        return s -> !this.test(s);
    };
    default CriterionOfStudent and(CriterionOfStudent other) {
        return s -> this.test(s) && other.test(s);
    };
}

public class School {


    public static void showAll(List<Student> students) {
        for(Student s: students) {
            if( s.getGrade() > 75) {
                System.out.println(s);
            }
        }

        System.out.println("----------------");

    }


    public static List<Student> getByCriterion(List<Student> students, CriterionOfStudent criterionOfStudent) {
        List<Student> rv = new ArrayList<>();
        for(Student s: students) {
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
        CriterionOfStudent enthusiastic  =  s -> s.getCourses().size() > 3;
        CriterionOfStudent smartish  =  s -> s.getGrade() > 70;
        showAll(getByCriterion(roster,enthusiastic.negate().and(smartish)));


    }
}